package com.ssh.dao;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.ssh.model.User;

public class UserDao extends HibernateDaoSupport {
  public void create(User user) {
    this.getHibernateTemplate().save(user);
  }
  public User find(String username){
    String hql= "from User u where u.username=?" ;
    List userList =  this.getHibernateTemplate().find(hql, new String[]{username});
    if(userList==null || userList.size()==0){
      return null;
    }else{
      return (User)userList.get(0);
    }
  }
  
  public void save(User user){
    this.getHibernateTemplate().save(user);
  }
}
