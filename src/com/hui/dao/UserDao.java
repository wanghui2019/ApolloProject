package com.hui.dao;

import com.hui.domain.User;

public interface UserDao {
    //用户注册
    void regist(User user);
    //用户登陆
    User login(User user);
}
