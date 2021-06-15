<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>myFormformJsp</title>
</head>
<body>

	
	<c:url var="addUrl" value="/formPrint" />
    <form:form action="${addUrl}" method="POST" modelAttribute="myBeanX">
		帳號: 	<form:input type="text" path="id"/>
		密碼: 	<form:input type="password" path="str" /> 
		
			<br>
			<input type="submit" value="送出"  />
			<input type="reset" value="清除"  />
	</form:form>

</body>
</html>