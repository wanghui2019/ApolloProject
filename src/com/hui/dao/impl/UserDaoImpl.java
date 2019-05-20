package com.hui.dao.impl;

import com.hui.dao.UserDao;
import com.hui.domain.User;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
    @Override
    public void regist(User user) {
        this.getHibernateTemplate().save(user);
    }

    @Override
    public User login(User user) {
        //根据user查询数据库
        String sql="from User where user_name=? and user_password=?";
        List<User> list= (List<User>) this.getHibernateTemplate().find(
                sql,user.getUser_code(),user.getUser_password());
        //判断list集合里是否有元素
        if (list.size()>0){
            return list.get(0);
        }else {
            return null;
        }
    }


}
