<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>check login and go to order</title>
</head> 
<body>
	 
    <form action="<c:url value = '/order/controller/delete'/>" method="POST">
    	<%
    		request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");	
    	%>
    	<% 
    		String delorder_ID = request.getParameter("delorder_ID");
        	out.println("欲刪除訂單編號:"+ delorder_ID +"<br>");
        	out.println("-------------------------"+"<br>");
    	%>
        	<input type="submit"  value="確認" onclick="get_datetime()" class="st_submit">
			<input  name="delorder_ID" id="delorder_ID" type="hidden" value ="<%= delorder_ID   %>">
    </form>
    <button id="delete_order" onclick="cancel_order(this.id)"> 取消</button>
    

<script src="<c:url value = '/back/js/Order.js'/>" async defer></script>
<script src="<c:url value='/back/js/sweetalert2@11.js' />"></script>
</body>
</html>