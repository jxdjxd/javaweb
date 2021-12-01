package com.jxd.dao;

import com.jxd.bean.User;
import com.jxd.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 用户Dao
 * @author jxd
 * @date 2021/11/23 17:39
 */
public class UserDao {

    /**
     * 添加用户
     * @param user 要添加到数据库中的用户
     * @return 如果插入成功，返回true，否则返回false
     */
    public boolean insert(User user) {
        Connection conn = null;
        PreparedStatement stmt = null;
        String sql = "insert into user(username, password) values(?,?)";
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());

            int resultNum = stmt.executeUpdate();
            if (resultNum > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(stmt, conn);
        }
        return false;
    }

    /**
     * 查找用户
     * @param user 要查询的User对象
     * @return 如果能查询出来，返回查询出来的User对象，否则返回null
     */
    public User find(User user) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM user WHERE username=? and password=?";
        try {
            conn = JDBCUtils.getConnection();

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());

            rs = stmt.executeQuery();

            while (rs.next()) {
                User u = new User();
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                return u;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs, stmt, conn);
        }
        return null;
    }

}
