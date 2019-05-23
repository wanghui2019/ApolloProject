package com.hui.action;

import com.hui.domain.LinkMans;
import com.hui.domain.PageBeans;
import com.hui.service.LinkMansService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.hibernate.criterion.DetachedCriteria;

public class LinkMansAction extends ActionSupport implements ModelDriven<LinkMans> {
    private LinkMans linkMans=new LinkMans();

    @Override
    public LinkMans getModel() {
        return linkMans;
    }

    private int currPage=1;

    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }

    private int showNum=3;

    public void setShowNum(int showNum) {
        this.showNum = showNum;
    }

    private LinkMansService linkMansService;

    public void setLinkMansService(LinkMansService linkMansService) {
        this.linkMansService = linkMansService;
    }

    public String findAll(){
        DetachedCriteria detachedCriteria=DetachedCriteria.forClass(LinkMans.class);
        //查找联系人
        PageBeans<LinkMans> pageBeans=linkMansService.findAll(detachedCriteria,currPage,showNum);
        System.out.println(pageBeans.toString());
        //压入值栈
        ActionContext.getContext().getValueStack().push(pageBeans);
        return "findSuccess";
    }
}
