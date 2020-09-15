package com.wuning.dao.impl;

import com.wuning.dao.UserDao;
import com.wuning.dao.impl.BaseDao;
import com.wuning.pojo.User;

/**
 * @author wu
 * @date 2020-04-18 10:54
 */
public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User querUserByUsername(String username) {
        String sql = "select `id`,`username`,`password`,`eamil` from `t_user` where username = ?";

        return queryForone(User.class, sql, username);

    }

    @Override
    public User queryUserByUsernameAndPasswrod(String username, String password) {
        String sql = "select id,username,password,eamil from t_user where username = ? and password=? ";
        return queryForone(User.class, sql, username, password);
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into t_user(`username`,`password`,`eamil`) values(?,?,?)";
        return update(sql, user.getUsername(), user.getPassword(), user.getEamil());
    }
}
