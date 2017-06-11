package com.ssh.service;

import org.springframework.transaction.annotation.Transactional;

import com.ssh.dao.UserDao;
import com.ssh.model.User;
import com.ssh.utils.EncryptInfo;

@Transactional
public class UserService {
  private UserDao userDao;

  public void setUserDao(UserDao userDao) {
    this.userDao = userDao;
  }



  public void create(User user) {
    user.setPassword(EncryptInfo.getEncrypyInfo(user.getPassword()));
    userDao.save(user);
  }

  public boolean login(User user) {
    User dbUser  = userDao.find(user.getUsername());
    if(dbUser==null){
      return false;
    }else{
      if(dbUser.getPassword().equals(EncryptInfo.getEncrypyInfo(user.getPassword()))){
        return true;
      }else{
        return false;
      }
      
    }
    

  }
  public boolean exist(User user){
    User dbUser = userDao.find(user.getUsername());
    if(dbUser==null){
      return false;
    }else{
      return true;
    }
  }
}
