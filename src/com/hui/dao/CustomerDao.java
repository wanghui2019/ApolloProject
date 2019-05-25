package com.hui.dao;

import com.hui.domain.Customer;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public interface CustomerDao {
    //保存用户
    void save(Customer customer);
    //获取总的用户数
    int getCustomerNum(DetachedCriteria detachedCriteria);
    //获取该页的集合对象
    List<Customer> getList(DetachedCriteria detachedCriteria, int firstNum, int showNum);
    //根据id查询用户信息
    Customer findByID(Long cust_id);
    //删除客户
    void delete(Customer customer);
    //更新客户
    void update(Customer customer);

    List<Customer> findAll();
}
