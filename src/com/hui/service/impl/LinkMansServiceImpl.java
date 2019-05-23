package com.hui.service.impl;

import com.hui.dao.LinkMansDao;
import com.hui.domain.LinkMans;
import com.hui.domain.PageBeans;
import com.hui.service.LinkMansService;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public class LinkMansServiceImpl implements LinkMansService {
    private LinkMansDao linkMansDao;

    public void setLinkMansDao(LinkMansDao linkMansDao) {
        this.linkMansDao = linkMansDao;
    }

    public PageBeans<LinkMans> findAll(DetachedCriteria detachedCriteria,int currPage,int showNum){
        PageBeans<LinkMans> pageBeans=new PageBeans<>();
        //压入当前页数
        pageBeans.setCurrPage(currPage);
        //压入一页显示多少
        pageBeans.setShowNum(showNum);
        //查询联系人总数
        int totalNum=linkMansDao.findAllNum(detachedCriteria);
        pageBeans.setTotalNum(totalNum);
        //获取一共多少页
        Double totalPage = Math.ceil((double) totalNum / (double) showNum);
        pageBeans.setTotalPage(totalPage.intValue());
        //获取当前页的第一个
        int firstNum=(currPage-1)*3;
        //获取当前页显示的集合
        List<LinkMans> list=linkMansDao.findAll(detachedCriteria,firstNum,showNum);
        pageBeans.setList(list);
        return pageBeans;
    }
}
