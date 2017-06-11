package com.ssh.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class SessionListener implements HttpSessionListener {
  Log logger = LogFactory.getLog(SessionListener.class);
  static int count = 0;
  public void sessionCreated(HttpSessionEvent se) {
    
    ++count;
    logger.info("one visit now total: "+count);
    se.getSession().setAttribute("count", count);
  }


  public void sessionDestroyed(HttpSessionEvent se) {
    --count;
    logger.info("one leave now total: "+count);
    se.getSession().setAttribute("count", count);
  }

}
