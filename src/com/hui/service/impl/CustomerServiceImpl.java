package com.hui.service.impl;

import com.hui.dao.CustomerDao;
import com.hui.domain.Customer;
import com.hui.domain.PageBeans;
import com.hui.service.CustomerService;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class CustomerServiceImpl implements CustomerService {
    private CustomerDao customerDao;

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public void save(Customer customer) {
        customerDao.save(customer);
    }

    @Override
    public PageBeans<Customer> findByPage(DetachedCriteria detachedCriteria, int currPage, int showNum) {
        //自己创建，没有交给Spring来管理
        PageBeans<Customer> pageBeans=new PageBeans<>();
        //1.封装当前页
        pageBeans.setCurrPage(currPage);
        //2.封装一页显示的数量
        pageBeans.setShowNum(showNum);
        //封装共多少个用户
        int totalNum= customerDao.getCustomerNum(detachedCriteria);
        pageBeans.setTotalNum(totalNum);

        //封装共多少页
        Double totalPage = Math.ceil((double) totalNum / (double) showNum);
        pageBeans.setTotalPage(totalPage.intValue());

        //封装list集合
        /*
        firstNum:每一页中的第一个数
         */
        int firstNum=(currPage-1)*3;
        List<Customer> list=customerDao.getList(detachedCriteria,firstNum,showNum);
        pageBeans.setList(list);

        return pageBeans;
    }

    @Override
    public Customer findByID(Long cust_id) {
        return customerDao.findByID(cust_id);
    }

    @Override
    public void delete(Customer customer) {
        customerDao.delete(customer);
    }

    @Override
    public void update(Customer customer) {
        customerDao.update(customer);
    }

}
