package com.hui.action;

import com.hui.domain.Customer;
import com.hui.domain.LinkMans;
import com.hui.domain.PageBeans;
import com.hui.service.CustomerService;
import com.hui.service.LinkMansService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public class LinkMansAction extends ActionSupport implements ModelDriven<LinkMans> {
    private LinkMans linkMans=new LinkMans();

    @Override
    public LinkMans getModel() {
        return linkMans;
    }

    private CustomerService customerService;

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
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
    //保存联系人
    public String save(){
        linkMansService.save(linkMans);
        return "saveSuccess";
    }
    //删除联系人
    public String delete(){
        //先查询，再删除
        linkMans = linkMansService.findByID(linkMans.getLkm_id());
        if (linkMans!=null){
            linkMansService.delete(linkMans);
        }
        return "deleteSuccess";
    }
    //联系人数据回显
    public String edit(){
        //查询所有客户
        List<Customer> list = customerService.findAll();
        //压到值栈里
        ActionContext.getContext().getValueStack().set("list",list);
        //先查询，再回显
        linkMans = linkMansService.findByID(linkMans.getLkm_id());
        ActionContext.getContext().getValueStack().push(linkMans);
        return "editSuccess";
    }

    //保存修改的数据
    public String update(){
        linkMansService.update(linkMans);
        return "updateSuccess";
    }
}
