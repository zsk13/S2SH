<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" >
      </button>
      <a class="navbar-brand" href="#">Brand</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav navbar-right">
      <li><a href="game">猜数字</a></li>
      <li><a href="count">访客统计</a></li>
        <li><a href="book_list">书籍管理</a></li>
        <s:if test="#session.user==null">
        	<li><a href="user_login">登录</a></li>
        	<li><a href="user_register">注册</a></li>
        </s:if>
        <s:else>
        	<li><a>您好，<%=session.getAttribute("user") %></a></li>
        	<li><a href="user_logout">登出</a></li>
        </s:else>
      </ul>
    </div>
  </div>
</nav>