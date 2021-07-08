<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>會員專區</title>
</head>
<body>
	<h1>會員專區</h1>
	<p>
		<a href="<c:url value='/member/goupadte_1'/>">會員基本資料</a>
	</p>
	<p>
		<a href="<c:url value='/member/gochangepass_1'/> ">更改密碼</a>
	</p>
	<p>
		<a href="<c:url value='/member/godelete_1'/>">刪除會員資料</a>
	</p>

	<form action="logout_1" method="post">
		<div>
			<input type="hidden" name="logout">
		</div>
		<input type="submit" value="登出">
	</form>
</body>
</html>