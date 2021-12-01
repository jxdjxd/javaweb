package com.jxd.dao;

import com.jxd.bean.User;
import org.junit.Test;

/**
 * @author jxd
 * @date 2021/11/23 19:16
 */
public class TestUserDao {

    @Test
    public void testInsert(){
        User testUser = new User("testUser", "123456");
        UserDao userDao = new UserDao();
        System.out.println(userDao.insert(testUser));
    }
}
