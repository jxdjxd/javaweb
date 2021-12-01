package com.jxd.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author jxd
 * @date 2021/11/22 11:06
 */
public class DBUtils {

    private static ComboPooledDataSource dataSource = null;
    private static Connection conn = null;

    //MySQL8的配置
//    private static final String DRIVERCLASS = "com.mysql.cj.jdbc.Driver";
//    private static final String URL = "jdbc:mysql://localhost:3307/jdbc?"
//            + "useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

    //MySQL5的配置
    private static final String DRIVERCLASS = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3307/jdbc";

    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";

    /**
     * 初始化c3p0,加载它的配置文件
     */
    public static void init() {
        // 自动加载配置文件
        try {
            dataSource = new ComboPooledDataSource();
        } catch (Exception e) {
            // 自动加载配置文件出错，用备用的配置
            dataSource = new ComboPooledDataSource();
            try {
                dataSource.setDriverClass(DRIVERCLASS);
            } catch (Exception e1) {
                System.out.println("c3p0采用备用配置时注册驱动发生错误");
                e1.printStackTrace();
            }
            dataSource.setJdbcUrl(URL);
            dataSource.setUser(USERNAME);
            dataSource.setPassword(PASSWORD);
            dataSource.setMinPoolSize(10);
            dataSource.setAcquireIncrement(5);
            dataSource.setMaxAdministrativeTaskTime(20);
        }
    }

    /**
     * 获取一个数据库连接对象
     * @return Connection
     */
    public static Connection getConnection() {
        if (dataSource == null) {
            init();
        }
        try {
            return dataSource.getConnection();
        } catch (Exception e) {
            return reserveGetConnection();
        }
    }

    /**
     * 获取一个数据库连接(备用)
     * @return Connection
     */
    public static Connection reserveGetConnection() {
        try {
            Class.forName(DRIVERCLASS);
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("reserveGetConnection方法中注册驱动失败");
        }
        return conn;
    }

    /**
     * 释放数据库连接
     * @param conn 要释放的数据库连接对象
     */
    public static void releaseConnection(Connection conn) {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("JDBCUtils中的releaseConnection方法有问题");
        }
    }

    /**
     * 关闭Connection对象和PreparedStatement对象
     * @param conn 要关闭的Connection对象
     * @param ps 要关闭的PreparedStatement对象
     */
    public static void closeConnAndPs(Connection conn, PreparedStatement ps) {
        try {
            if(conn!=null){
                conn.close();
            }
            if(ps!=null){
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
