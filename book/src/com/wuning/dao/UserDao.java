package com.wuning.dao;

import com.wuning.pojo.User;

/**
 * @author wu
 * @date 2020-04-18 10:46
 */
public interface UserDao {

    public User querUserByUsername(String name);

    public User queryUserByUsernameAndPasswrod(String name, String password);

    public int saveUser(User user);
}
