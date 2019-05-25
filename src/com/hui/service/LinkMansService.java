package com.hui.service;

import com.hui.domain.LinkMans;
import com.hui.domain.PageBeans;
import org.hibernate.criterion.DetachedCriteria;

public interface LinkMansService {
    //分页查询联系人
    PageBeans<LinkMans> findAll(DetachedCriteria detachedCriteria, int currPage, int showNum);
    //保存联系人
    void save(LinkMans linkMans);
    //根据id查询联系人
    LinkMans findByID(long lkm_id);
    //删除联系人
    void delete(LinkMans linkMans);
    //更新联系人信息
    void update(LinkMans linkMans);
}
