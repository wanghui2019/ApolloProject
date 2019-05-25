package com.hui.dao;

import com.hui.domain.LinkMans;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public interface LinkMansDao {
    //查询联系人总数
    int findAllNum(DetachedCriteria detachedCriteria);
    //查询当前页的集合
    List<LinkMans> findAll(DetachedCriteria detachedCriteria,int firstNum,int showNum);
    //保存联系人
    void save(LinkMans linkMans);
    //根据id查询联系人
    LinkMans findByID(Long lkm_id);
    //删除联系人
    void delete(LinkMans linkMans);
    //更新联系人信息
    void update(LinkMans linkMans);
}
