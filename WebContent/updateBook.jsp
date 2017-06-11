<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>updatebook</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
</head>
<body>
	<%@include file="nav.jsp"%>
	<div class="row">
		<%@include file="bookleft.jsp"%>
		<div class="col-md-8">
			<div style="text-align: center">
				<s:form action="book_update" namespace="/" method="post"
					theme="simple">
					<div class="form-group">
						<label>书籍名称</label>
						<s:textfield name="bname" value="%{book.bname}"/>
					</div>
					<div class="form-group">
						<label>书籍价格</label>
						<s:textfield name="price" value="%{book.price}"/>
					</div>
					<s:hidden id="bid" name="bid" value="%{#request.bookId}"/>
					<button type="submit" class="btn btn-default">修改</button>
				</s:form>
				<s:actionerror />
			</div>
		</div>
	</div>

</body>
</html>