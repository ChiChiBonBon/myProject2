<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<style type="text/css">
span.error {
	color: red;
	display: inline-block;
	font-size: 10pt;
}
</style>
<meta charset="UTF-8">
<title>刪除帳號</title>
</head>
<body>
	<div align="center">
		<fieldset style="width: 960px;">
			<legend>請輸入確認密碼來刪除帳號</legend>
			<form method="POST" action="delete_membership_1">
				<Table>
<%-- 					<c:choose>
						<c:when test='${place.placeId == null}'>
							<tr>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
							</tr>
						</c:when>
						<c:otherwise>
							<tr>
								<td>編號：<br>&nbsp;
								</td>
								<td><form:hidden path='placeId' /> ${place.placeId}<br>&nbsp;
								</td>
							</tr>
						</c:otherwise>
					</c:choose> --%>
					<tr>
						<td>
							密碼：<br>&nbsp;
						</td>
						<td width='360'>
							<input type="password" name="password_del_1" required><br>&nbsp;
							<form:errors path='password' cssClass="error"/>
						</td>
					</tr>
					
					<tr>
						<td>
							確認密碼：<br>&nbsp;
						</td>
						<td width='360'>
							<input type="password" name="password_del_che_1" required><br>&nbsp;
							<form:errors path='password' cssClass="error" /> 
						</td>
					</tr>

					<tr>
						<td colspan='4'><br>&nbsp; 
							<input type="submit" value="刪除">
						</td>
					</tr>
					
				</Table>	
				    <!-- 看是否有錯誤訊息由後端傳入 -->		
		        	<%
		        	String str = (String) request.getAttribute("message");
		        	if (str != null) {%>
		        	
		        	<p style="color: crimson;">
		        	<%= str%>
		        	</p>
		        	
		        	<%}%>
			</form>

		</fieldset>
	</div>
</body>
</html>