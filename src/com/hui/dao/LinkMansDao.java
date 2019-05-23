package com.hui.dao;

import com.hui.domain.LinkMans;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public interface LinkMansDao {
    //查询联系人总数
    int findAllNum(DetachedCriteria detachedCriteria);
    //查询当前页的集合
    List<LinkMans> findAll(DetachedCriteria detachedCriteria,int firstNum,int showNum);
}
