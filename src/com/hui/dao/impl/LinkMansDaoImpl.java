package com.hui.dao.impl;

import com.hui.dao.LinkMansDao;
import com.hui.domain.LinkMans;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class LinkMansDaoImpl extends HibernateDaoSupport implements LinkMansDao {

    @Override
    public int findAllNum(DetachedCriteria detachedCriteria) {
        detachedCriteria.setProjection(Projections.rowCount());
        List<Long> list = (List<Long>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
        if (list.size()>0){
            return list.get(0).intValue();
        }
        return 0;
    }

    @Override
    public List<LinkMans> findAll(DetachedCriteria detachedCriteria, int firstNum, int showNum) {
        detachedCriteria.setProjection(null);
        List<LinkMans> list = (List<LinkMans>) this.getHibernateTemplate().findByCriteria(detachedCriteria, firstNum, showNum);
        return list;
    }
}
