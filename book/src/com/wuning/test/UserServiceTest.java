package com.wuning.test;

import com.wuning.pojo.User;
import com.wuning.service.UserService;
import com.wuning.service.impl.UserServiceImpl;
import org.junit.Test;

public class UserServiceTest {
    UserService userService = new UserServiceImpl();

    @Test
    public void registUser() {
        userService.registUser(new User(null, "ti87u", "183434", "1098328@qq.com"));

    }

    @Test
    public void login() {
        System.out.println( userService.login(new User(null, "admin1", "amdin1", null)) );
    }

    @Test
    public void existUsername() {
        if(userService.existUsername("tiuu1")){
            System.out.println("用户名存在");
        }else{
            System.out.println("用户名可用");
        }
    }
}