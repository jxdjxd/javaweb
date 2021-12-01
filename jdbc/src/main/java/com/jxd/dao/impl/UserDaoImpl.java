package com.jxd.dao.impl;

import com.jxd.bean.User;
import com.jxd.dao.BaseDao;
import com.jxd.dao.UserDao;

public class UserDaoImpl extends BaseDao<User> implements UserDao {

    @Override
    public User getUserByUserNameAndPassword(User user) {
        String sql = "select * from User where username=? and password=?";
        User u = (User)this.getBean(sql, user.getUsername(), user.getPassword());
        return u;
    }

    public int getMaxId(){
        return super.getMaxId("id", "User");
    }

    /**
     * 传入的user只需要有name、password、email属性即可
     */
    @Override
    public boolean insertUser(User user) {

        String sql = "insert into User(id, username, password, email, birthday) values(?,?,?,?,?)";
        int id = this.getMaxId()+1;

        int count = this.update(sql, id, user.getUsername(), user.getPassword(),user.getEmail(), user.getBirthday());
        if(count == 1){
            return true;
        }else{
            return false;
        }
    }

}