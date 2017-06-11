package com.ssh.filter;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SessionFilter implements Filter {  
  private FilterConfig filterConfig;
  Log logger = LogFactory.getLog(SessionFilter.class);
  @Override
  public void destroy() {
      
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response,
          FilterChain chain) throws IOException, ServletException {
      ServletContext context = filterConfig.getServletContext();
      Map<String, Integer> urlMap = (Map<String, Integer>) context.getAttribute("urlMap");
      String url = ((HttpServletRequest) request).getServletPath();
      logger.info(url + "has been visited");
      if(urlMap.containsKey(url)){
          Integer count = urlMap.get(url);
          urlMap.put(url,count+1);
      }else{
          urlMap.put(url,1);
      }
      context.setAttribute("urlMap", urlMap);
      chain.doFilter(request, response);
  }

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
      this.filterConfig = filterConfig;
  }

}