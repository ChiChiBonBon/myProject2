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
<title>更改密碼</title>
</head>
<body>
	<div align="center">
		<fieldset style="width: 960px;">
			<legend>更改密碼</legend>
			<form method="POST" action="change_pass_1">
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
							原密碼：<br>&nbsp;
						</td>
						<td width='360'>
							<input type="password" name="orgin_pass_1" required><br>&nbsp;
							<form:errors path='password' cssClass="error"/>
						</td>
					</tr>
					
					<tr>
						<td>
							新密碼：<br>&nbsp;
						</td>
						<td width='360'>
							<input id="pass1" type="password" name="new_pass_1" required><br>&nbsp;
							<form:errors path='password' cssClass="error" /> 
						</td>
						
						<td>
							確認新密碼：：<br>&nbsp;
						</td>
						<td width='360'>
							<input id="pass2" type="password" name="che_new_pass_1" required> <br>&nbsp;
							<label id="isSame" style="color: crimson;" for=""></label>
							<form:errors path='password' cssClass="error" /> 
						</td>
					</tr>

					<tr>
						<td colspan='4'><br>&nbsp; 
							<input id="submitButtion" type="submit" value="更改">
						</td>
					</tr>
					

					<tr>
						<td colspan='4'><br>&nbsp;
							<a href="<c:url value='/member/gomembermenu_1'/>">回會員專區</a>
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
	<script>
		window.onload = function() {
			document.getElementById("pass2")
					.addEventListener(
							"keyup",
							function(e) {
								//console.log("ketpress");
								let checkString1 = document
										.getElementById("pass1").value;
								let checkString2 = document
										.getElementById("pass2").value;
								let checkSame = document
										.getElementById("isSame");

								//window.alert(e);
								console.log("checkString1: " + checkString1);
								console.log("checkString2: " + checkString2);
								if (checkString1 === checkString2) {
									checkSame.innerHTML = "密碼相符!";
								} else {
									checkSame.innerHTML = "密碼不相符!";
								}
							});
		}
	</script>
</body>
</html>