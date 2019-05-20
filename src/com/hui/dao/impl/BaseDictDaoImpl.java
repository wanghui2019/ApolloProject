package com.hui.dao.impl;

import com.hui.dao.BaseDictDao;
import com.hui.domain.BaseDict;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class BaseDictDaoImpl extends HibernateDaoSupport implements BaseDictDao {

    @Override
    public List<BaseDict> findByCode(String Dict_type_code) {
        return (List<BaseDict>) this.getHibernateTemplate().find("from BaseDict where Dict_type_code=?",Dict_type_code);
    }
}
