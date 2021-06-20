package com.deserts.service;

import com.deserts.bean.User;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author deserts
 * @Date 2020/8/11 19:23
 */
public interface UserService {
    /**
     * 注册用户
     * @param user
     */
    public void register(User user);

    /**
     * 用户登录
     * @param user
     * @return
     */
    public User login(User user);

    /**
     * 检查用户名是否存在
     * @param username
     * @return
     */
    public boolean existsUsername(String username);
}
