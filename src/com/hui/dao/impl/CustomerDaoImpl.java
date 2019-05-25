package com.hui.dao.impl;

import com.hui.dao.CustomerDao;
import com.hui.domain.Customer;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {

    @Override
    public void save(Customer customer) {
        this.getHibernateTemplate().save(customer);
    }

    @Override
    public int getCustomerNum(DetachedCriteria detachedCriteria) {
        //detachedCriteria来查询总数的条件设置
        detachedCriteria.setProjection(Projections.rowCount());
        //运用模版查询
        List<Long> list = (List<Long>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
        //只要list有数据，将值返回
        if (list.size()>0){
            return list.get(0).intValue();
        }
        return 0;
    }

    @Override
    public List<Customer> getList(DetachedCriteria detachedCriteria, int firstNum, int showNum) {
        //由于是用的一个detachedCriteria对象，所以这里要先清空上次查询的条件信息
        detachedCriteria.setProjection(null);
        //分页查询
        List<Customer> list = (List<Customer>) this.getHibernateTemplate().findByCriteria(detachedCriteria, firstNum, showNum);
        return list;
    }

    @Override
    public Customer findByID(Long cust_id) {
        return this.getHibernateTemplate().get(Customer.class,cust_id);
    }

    @Override
    public void delete(Customer customer) {
        this.getHibernateTemplate().delete(customer);
    }

    @Override
    public void update(Customer customer) {
        this.getHibernateTemplate().update(customer);
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> list = (List<Customer>) this.getHibernateTemplate().find("from Customer");
        return list;
    }
}
