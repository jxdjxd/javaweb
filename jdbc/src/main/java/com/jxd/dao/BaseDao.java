package com.jxd.dao;

import com.jxd.utils.DBUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * 基本Dao范型类，提供基本的sql操作方法能力，供其他Dao类继承
 * @author jxd
 * @date 2021/11/22 11:02
 */
public class BaseDao<T> {

    private QueryRunner runner = new QueryRunner();

    //获取实际的Type值
    private Class<T> type;

    @SuppressWarnings("unchecked")
    public BaseDao() {
        ParameterizedType superclass = (ParameterizedType) this.getClass()
                .getGenericSuperclass();
        type = (Class<T>) superclass.getActualTypeArguments()[0];
    }

    /**
     * 从数据库中查询一个对象
     * @param sql 查询的sql语句
     * @param params 查询的参数
     * @return 根据查询结果封装成的对象
     */
    public T getBean(String sql, Object... params) {
        Connection conn = DBUtils.getConnection();
        T query = null;
        try {
            query = runner.query(conn, sql, new BeanHandler<>(type), params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.releaseConnection(conn);
        }
        return query;
    }

    /**
     * 从数据库中查询多个对象
     * @param sql 查询的sql语句
     * @param params 查询参数
     * @return 根据查询结果封装成的对象列表
     */
    public List<T> getBeanList(String sql, Object... params) {
        Connection conn = DBUtils.getConnection();
        List<T> query = null;
        try {
            query = runner
                    .query(conn, sql, new BeanListHandler<>(type), params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.releaseConnection(conn);
        }

        return query;
    }

    /**
     * 执行增删改查sql
     *
     * @param sql 执行的sql语句
     * @param params 参数
     * @return sql语句执行影响的行数
     */
    public int update(String sql, Object... params) {
        Connection conn = DBUtils.getConnection();

        int count = 0;
        try {
            count = runner.update(conn, sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.releaseConnection(conn);
        }
        return count;
    }

    /**
     * 获取数据库指定表中当前指定的id字段的最大值
     * @param fieldName 字段名
     * @param tableName 表名
     * @return 执行表中指定字段(id)的最大值
     */
    public int getMaxId(String fieldName,String tableName) {
        Connection conn = DBUtils.getConnection();
        PreparedStatement prd = null;
        ResultSet rs = null;
        int maxId = 0;
        try {
            String sql = "select max("+fieldName+") from "+ tableName;
            prd = conn.prepareStatement(sql);
            rs = prd.executeQuery(sql);
            while(rs.next()){
                maxId = rs.getInt("MAX("+ fieldName + ")");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maxId;
    }
}
