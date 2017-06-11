<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>addbook</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
</head>
<body>
	<%@include file="nav.jsp"%>
	<div class="row">
		<%@include file="bookleft.jsp"%>
		<div class="col-md-8">
			<table class="table table-bordered">
				<tr>
					<td>编号</td>
					<td>书名</td>
					<td>价格</td>
					<td>操作</td>
				</tr>
				<s:iterator value="pageBean.list">
					<tr>
						<td class="tocenter"><s:property value="bid" /></td>
						<td class="tocenter"><s:property value="bname" /></td>
						<td class="tocenter"><s:property value="price" /></td>
						<td><a href="book_update?bookId=<s:property value="bid" />"><span class="glyphicon glyphicon-pencil"></span></a>
						<a href="book_delete?bookId=<s:property value="bid" />"><span class="glyphicon glyphicon-remove"></span></a>
						</td>
					</tr>
				</s:iterator>
			</table>
			<tr>
				<td width="13%" class="tocenter">共 ${pageBean.totalPage} 页</td>
				<td width="17%" class="tocenter">共 ${pageBean.allRow} 条记录</td>
				<td width="15%" class="tocenter">当前第 ${pageBean.currentPage}页</td>
				<td colspan="4" width="55%" class="tocenter"><s:if
						test="%{pageBean.currentPage == 1}">
				第一页&nbsp;&nbsp;&nbsp;&nbsp;上一页&nbsp;&nbsp;&nbsp;&nbsp;
				</s:if> <s:else>
						<a href="book_list?page=1">第一页&nbsp;&nbsp;&nbsp;&nbsp;</a>
						<a
							href="book_list?page=<s:property value="%{pageBean.currentPage-1}"/>">上一页&nbsp;&nbsp;&nbsp;&nbsp;</a>
					</s:else> <s:if test="%{pageBean.currentPage != pageBean.totalPage}">
						<a
							href="book_list?page=<s:property value="%{pageBean.currentPage+1}"/>">下一页&nbsp;&nbsp;&nbsp;&nbsp;</a>
						<a href="book_list?page=<s:property value="pageBean.totalPage"/>">最后一页</a>
					</s:if> <s:else>下一页&nbsp;&nbsp;&nbsp;&nbsp; 最后一页</s:else></td>
			</tr>
		</div>

	</div>

</body>
</html>
