package com.wuning.service.impl;

import com.wuning.dao.UserDao;
import com.wuning.dao.impl.UserDaoImpl;
import com.wuning.pojo.User;
import com.wuning.service.UserService;

/**
 * @author wu
 * @date 2020-04-18 15:22
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao=new UserDaoImpl();
    @Override
    public void registUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
     return userDao.queryUserByUsernameAndPasswrod(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean existUsername(String username) {
       if (userDao.querUserByUsername(username)==null){
           return false;
       }
        return true;
    }
}
