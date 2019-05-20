package com.hui.service.impl;

import com.hui.dao.UserDao;
import com.hui.domain.User;
import com.hui.service.UserService;
import com.hui.utils.MD5Utils;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    //注册
    @Override
    public void regist(User user) {
        //保存之前。1加密 2设置状态
        user.setUser_password(MD5Utils.md5(user.getUser_password()));
        user.setUser_state("1");
        userDao.regist(user);
    }
    //登陆
    @Override
    public User login(User user) {
        user.setUser_password(MD5Utils.md5(user.getUser_password()));
        return userDao.login(user);
    }
}
