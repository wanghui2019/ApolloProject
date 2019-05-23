package com.hui.domain;

import java.util.HashSet;
import java.util.Set;

public class Customer {
    private Long cust_id;   //自增
    private String cust_name;  //张三
//    private String cust_source;
//    private String cust_industry;
//    private String cust_level;
    private String cust_phone;  //电话
    private String cust_mobile;  //电话

    private String cust_image;

    //关联联系人
    private Set<LinkMans> linkMans=new HashSet<>();

    public Set<LinkMans> getLinkMans() {
        return linkMans;
    }

    public void setLinkMans(Set<LinkMans> linkMans) {
        this.linkMans = linkMans;
    }

    public String getCust_image() {
        return cust_image;
    }

    public void setCust_image(String cust_image) {
        this.cust_image = cust_image;
    }

    //主键对象
    private BaseDict basesource;  //dict_id=22
    private BaseDict baseindustry; //dict_id=32
    private BaseDict baselevel;   //dict_id=1

    public BaseDict getBasesource() {
        return basesource;
    }

    public void setBasesource(BaseDict basesource) {
        this.basesource = basesource;
    }

    public BaseDict getBaseindustry() {
        return baseindustry;
    }

    public void setBaseindustry(BaseDict baseindustry) {
        this.baseindustry = baseindustry;
    }

    public BaseDict getBaselevel() {
        return baselevel;
    }

    public void setBaselevel(BaseDict baselevel) {
        this.baselevel = baselevel;
    }

    public Long getCust_id() {
        return cust_id;
    }

    public void setCust_id(Long cust_id) {
        this.cust_id = cust_id;
    }

    public String getCust_name() {
        return cust_name;
    }

    public void setCust_name(String cust_name) {
        this.cust_name = cust_name;
    }


    public String getCust_phone() {
        return cust_phone;
    }

    public void setCust_phone(String cust_phone) {
        this.cust_phone = cust_phone;
    }

    public String getCust_mobile() {
        return cust_mobile;
    }

    public void setCust_mobile(String cust_mobile) {
        this.cust_mobile = cust_mobile;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cust_id=" + cust_id +
                ", cust_name='" + cust_name + '\'' +
                ", cust_phone='" + cust_phone + '\'' +
                ", cust_mobile='" + cust_mobile + '\'' +
                ", cust_image='" + cust_image + '\'' +
                ", basesource=" + basesource +
                ", baseindustry=" + baseindustry +
                ", baselevel=" + baselevel +
                '}';
    }
}
