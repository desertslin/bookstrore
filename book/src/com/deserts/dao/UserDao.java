package com.deserts.dao;

import com.deserts.bean.User;

/**
 * @ClassName UserDao
 * @Description TODO
 * @Author deserts
 * @Date 2020/8/11 18:26
 */
public interface UserDao {
    /**
     * 通过用户名查询用户，若为null则查询失败
     * @param username
     * @return 如果返回 null,说明没有这个用户。
     */
    public User queryUserByUsername(String username);

    /**
     * 通过用户名和密码查询用户，若为null则查询失败
     * @param username
     * @param password
     * @return 如果返回 null,说明没有这个用户。
     */
    public User queryUserByUsernameAndPassword(String username,String password);

    /**
     * 保存用户
     * @param user
     * @return 如果返回-1,说明保存失败。
     */
    public int saveUser(User user);

}
