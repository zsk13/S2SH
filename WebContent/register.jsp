<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>register</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
</head>
<body>

 <%@include file="nav.jsp"%>

<div style = "text-align:center">
<s:form action="user_register" namespace="/" method="post" theme="simple">
  <div class="form-group">
    <label>用户名</label>
    <s:textfield name="username"/>
  </div>
  <div class="form-group">
    <label>密码</label>
    <s:password name="password"/>
  </div>
  <button type="submit" class="btn btn-default">注册</button>
</s:form>
		<s:actionerror />
</div>
</body>
</html>