package com.hui.service;

import com.hui.domain.LinkMans;
import com.hui.domain.PageBeans;
import org.hibernate.criterion.DetachedCriteria;

public interface LinkMansService {
    PageBeans<LinkMans> findAll(DetachedCriteria detachedCriteria, int currPage, int showNum);
}
