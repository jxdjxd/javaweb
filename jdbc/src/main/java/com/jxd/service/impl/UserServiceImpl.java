package com.jxd.service.impl;

import com.jxd.bean.User;
import com.jxd.dao.UserDao;
import com.jxd.dao.impl.UserDaoImpl;
import com.jxd.service.UserService;

/**
 * @author jxd
 * @date 2021/11/22 10:40
 */
public class UserServiceImpl implements UserService {
    private UserDao ud = new UserDaoImpl();
    @Override
    public User login(User user) {
        return ud.getUserByUserNameAndPassword(user);
    }

    @Override
    public boolean regist(User user) {
        return ud.insertUser(user);
    }

}
