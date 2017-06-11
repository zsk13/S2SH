<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
  Object gametimeObj = session.getAttribute("gametime");
  Object guesstimeObj = session.getAttribute("guesstime");
  Object largeObj = session.getAttribute("large");
  Object lastnumObj = session.getAttribute("lastnum");
  int gametime = 0;
  int guesstime = 0;
  int large = 0;
  int lastnum = 0;
  if (gametimeObj != null)
    gametime = (int) gametimeObj;
  if (guesstimeObj != null)
    guesstime = (int) guesstimeObj;
  if (largeObj != null)
    large = (int) largeObj;

  if (lastnumObj != null)
    lastnum = (int) lastnumObj;
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>game</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
</head>
<body>
 <%@include file="nav.jsp"%>
 <div style="text-align:center">
	<c:if test="${guesstime==0}">
        	猜数字游戏开始。
    </c:if>
	<c:if test="${guesstime>0}">
		<c:choose>
			<c:when test="${large == 1}">
        偏大了。
    </c:when>
			<c:when test="${large == -1}">
        偏小了。
    </c:when>
			<c:otherwise>
       对了。
    </c:otherwise>
		</c:choose>
	</c:if>
	<c:if test="${guesstime>0 }">
		你已经猜了<%=guesstime%>次
	</c:if>
	本游戏共开了<%=gametime%>局
	<a href="game">新游戏</a>
	<br>
	<form action="guess" method="post">
		请填写1~100的数值。<input type="text" name="gnum">
		<c:if test="${lastnum>0}">
		你上次猜的是<%=lastnum%>
		</c:if>
		<input type="submit" value="提交" />
	</form>
	</div>
</body>
</html>