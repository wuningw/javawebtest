package com.wuning.test;

import com.wuning.dao.UserDao;
import com.wuning.dao.impl.UserDaoImpl;
import com.wuning.pojo.User;
import org.junit.Test;

public class UserDaoTest {
    UserDao userDao = new UserDaoImpl();

    @Test
    public void querUserByUsername() {

        if (userDao.querUserByUsername("admin1") == null) {
            System.out.println("用户名可用");
        } else {
            System.out.println("用户名存在");
        }
    }

    @Test
    public void queryUserByUsernameAndPasswrod() {
        UserDaoImpl userDao = new UserDaoImpl();
        if (userDao.queryUserByUsernameAndPasswrod("admin1", "amdin1") == null) {
            System.out.println("用户名或密码错误");
        } else {
            System.out.println("登录成功");
        }
    }

    @Test
    public void saveUser() {
        System.out.println(userDao.saveUser(new User(null, "wuning", "122343", "1232454@qq.com")));
    }
}