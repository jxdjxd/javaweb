package com.jxd.dao;

import com.jxd.bean.User;

/**
 * @author jxd
 * @date 2021/11/22 11:18
 */
public interface UserDao{
    /**
     * 通过用户名和密码来查询用户
     * @param user
     * @return sys_user
     */
    public User getUserByUserNameAndPassword(User user);

    /**
     * 用户登录
     * @param user
     * @return boolean
     */
    public boolean insertUser(User user);

}