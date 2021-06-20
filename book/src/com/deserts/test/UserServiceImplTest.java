package com.deserts.test;

import com.deserts.bean.User;
import com.deserts.service.UserService;
import com.deserts.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {
    UserService service = new UserServiceImpl();
    @Test
    void register() {
        service.register(new User(null, "mango", "654321", "mango@126.com"));
    }

    @Test
    void login() {
        service.login(new User(null, "mango", "654321", "mango@126.com"));
    }

    @Test
    void existsUsername() {
        System.out.println(service.existsUsername("deserts"));
    }
}