package com.jxd.service;

import com.jxd.bean.User;

/**
 * @author jxd
 * @date 2021/11/22 10:40
 */
public interface UserService {
    public User login(User user);
    public boolean regist(User user);
}
