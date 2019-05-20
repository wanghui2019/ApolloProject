package com.hui.action;

import com.hui.domain.User;
import com.hui.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User> {
    private User user=new User();

    @Override
    public User getModel() {
        return user;
    }

    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    //用户注册
    public String regist(){
        //user里是有提交上来的数据,但userService还不能使用，因为是空的，必须在Spring的配置文件里注入
        userService.regist(user);
        return LOGIN;
    }

    //用户登陆
    public String login(){
        User isUser=userService.login(user);
        //判断返回的isUser是user还是null
        if (isUser!=null){
            ActionContext.getContext().getSession().put("isUser",isUser);
            return SUCCESS;
        }else {
            this.addActionError("用户名或者密码错误！");
            return LOGIN;
        }
    }
}
