package com.deserts.test;

import com.deserts.bean.User;
import com.deserts.dao.impl.UserDaoImpl;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoImplTest {
    UserDaoImpl dao = new UserDaoImpl();
    @org.junit.jupiter.api.Test
    void queryUserByUsername() {
        User user = dao.queryUserByUsername("deserts");
        System.out.println(user);
    }

    @org.junit.jupiter.api.Test
    void queryUserByUsernameAndPassword() {
        User user = dao.queryUserByUsernameAndPassword("deserts", "073838");
        System.out.println(user);
    }

    @org.junit.jupiter.api.Test
    void saveUser() {
        User user = new User(2,"xuan","123456","xuan@126.com");
        int i = dao.saveUser(user);
        if (i != 0){
            System.out.println("保存成功");
        }else {
            System.out.println("保存失败");
        }
    }
}