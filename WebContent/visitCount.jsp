<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
  Object count = session.getAttribute("count");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>visitCount</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
</head>
<body>
 <%@include file="nav.jsp"%>
 <div style="text-align:center">
<table  class="table table-bordered" width="60%" border="1">
        <tr>
        	<th>序号</th>
            <th>url</th>
            <th>访问次数</th>
        </tr>
        <c:forEach items="${applicationScope.urlMap}" var="entry" varStatus="status">
        <tr>
        	<td>${status.index + 1}</td>  
            <td>${entry.key }</td>
            <td>${entry.value }</td>
        </tr>
        </c:forEach>
    </table>
在线人数：<%=count%>
</div>
</body>
</html>