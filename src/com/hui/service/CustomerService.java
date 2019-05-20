package com.hui.service;

import com.hui.domain.Customer;
import com.hui.domain.PageBeans;
import org.hibernate.criterion.DetachedCriteria;

public interface CustomerService {
    //保存用户
    void save(Customer customer);
    //通过分页查找用户
    PageBeans<Customer> findByPage(DetachedCriteria detachedCriteria, int currPage, int showNum);
    //通过id查询用户
    Customer findByID(Long cust_id);
    //删除客户
    void delete(Customer customer);
    //更新数据
    void update(Customer customer);
}
