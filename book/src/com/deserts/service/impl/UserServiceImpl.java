package com.deserts.service.impl;

import com.deserts.bean.User;
import com.deserts.dao.impl.UserDaoImpl;
import com.deserts.service.UserService;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author deserts
 * @Date 2020/8/11 19:25
 */
public class UserServiceImpl implements UserService {
    private UserDaoImpl dao = new UserDaoImpl();
    @Override
    public void register(User user) {
       dao.saveUser(user);
    }

    @Override
    public User login(User user) {
        User user1 = dao.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
        return user1;
    }

    @Override
    public boolean existsUsername(String username) {
        return dao.queryUserByUsername(username) != null;
    }
}
