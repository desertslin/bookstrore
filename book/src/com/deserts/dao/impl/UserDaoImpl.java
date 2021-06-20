package com.deserts.dao.impl;

import com.deserts.bean.User;
import com.deserts.dao.BaseDao;
import com.deserts.dao.UserDao;

/**
 * @ClassName UserDaoImpl
 * @Description TODO
 * @Author deserts
 * @Date 2020/8/11 18:37
 */
public class UserDaoImpl extends BaseDao<User> implements UserDao {
    @Override
    public User queryUserByUsername(String username) {
        String sql = "select id,username,password,email from bs_user where username = ?";
        User user = queryBean(sql, username);
        return user;
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = "select id,username,password,email from bs_user where username = ? and password = ?";
        User user = queryBean(sql, username, password);
        return user;
    }

    @Override
    public int saveUser(User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        String email = user.getEmail();
        String sql = "insert into bs_user(username,password,email) values(?,?,?)";
        return update(sql, username, password, email);
    }
}
