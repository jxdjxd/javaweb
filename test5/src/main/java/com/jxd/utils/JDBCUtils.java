package com.jxd.utils;

import java.sql.*;

/**
 * JDBC工具类
 * @author jxd
 * @date 2021/11/23 17:32
 */
public class JDBCUtils {

    /**
     * 获取一个sql connection链接
     * @return sql connection
     * @throws SQLException sql异常
     * @throws ClassNotFoundException 类未找到异常
     */
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3307/test5";
        String username = "root";
        String password = "123456";
        return DriverManager.getConnection(url, username, password);
    }

    /**
     * 关闭数据库资源
     * @param stmt 要释放的Statement对象
     * @param conn 要释放的Connection对象
     */
    public static void release(Statement stmt, Connection conn) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            stmt = null;
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            conn = null;
        }
    }

    /**
     * 关闭数据库资源
     * @param rs 要释放的ResultSet对象
     * @param stmt 要释放的Statement对象
     * @param conn 要释放的Connection对象
     */
    public static void release(ResultSet rs, Statement stmt, Connection conn){
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            rs = null;
        }
        release(stmt, conn);
    }

}
