package com.ssh.listener;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyContextListener implements ServletContextListener{

  @Override
  public void contextDestroyed(ServletContextEvent arg0) {
      
  }

  @Override
  public void contextInitialized(ServletContextEvent arg0) {
      ServletContext context = arg0.getServletContext();
      Map<String, Integer> urlMap = new LinkedHashMap<String, Integer>();
      context.setAttribute("urlMap", urlMap);
  }

}
