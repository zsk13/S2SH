package com.ssh.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ssh.model.Product;
import com.ssh.model.User;
import com.ssh.service.UserService;

public class UserAction extends ActionSupport  implements ModelDriven<User>{
  private User user = new User();
  private UserService userService;
  public void setUserService(UserService userService) {
    this.userService = userService;
  }
  
  public User getModel() {
    return user;
  }
  
  public String register(){
    if(user.getUsername()==null||user.getPassword()==null){
      this.addActionError("不能为空");
      return INPUT;
    }
    boolean exist = userService.exist(user);
    if(exist){
      this.addActionError("用户名已存在");
      return INPUT;
    }else{
      userService.create(user);
      return SUCCESS;
    }
  }
  
  public String login(){
    if(user.getUsername()==null||user.getPassword()==null){
      this.addActionError("不能为空");
      return INPUT;
    }
    ActionContext actionContext = ActionContext.getContext();
    Map session = actionContext.getSession();
    boolean succ = userService.login(user);
    if(succ){
      session.put("user", user.getUsername());
      return SUCCESS;
    }else{
      this.addActionError("用户名密码错误");
      return INPUT;
    }
  }
  public String logout(){
    ActionContext actionContext = ActionContext.getContext();
    Map session = actionContext.getSession();
    session.remove("user");
    return SUCCESS;
  }
}
