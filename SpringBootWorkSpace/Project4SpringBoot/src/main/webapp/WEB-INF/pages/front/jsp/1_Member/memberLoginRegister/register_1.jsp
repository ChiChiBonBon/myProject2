<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
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
<title>註冊</title>
</head>
<body>
	<div align="center">
		<fieldset style="width: 960px;">
			<legend>會員註冊</legend>
			<form:form method="POST" modelAttribute="member" action="register_1">
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
						<td>帳號：<br>&nbsp;
						</td>
						
						<td width='360'>
							<form:input type="text" path="account" required="required"/><br>&nbsp; 
							<form:errors path='account' cssClass="error" />
						</td>
						
						<td>密碼：<br> 密碼確認：&nbsp;
						</td>
						<td>
							<form:input type="password" id="pass1" path="password" required="required"/><br>&nbsp;
							<input name="password_2" type="password" id="pass2" required="required"> 
							<label id="isSame" style="color: crimson;" for=""></label>
							<form:errors path='password' cssClass="error" />
						</td>
					</tr>
					
					<tr>
						<td>名字：<br>&nbsp;
						</td>
						<td width='360'>
							<form:input type="text" path="name" required="required"/><br>&nbsp;
							<form:errors path='name' cssClass="error" />
						</td>
						
						<td>性別：<br>&nbsp;
						</td>
						<td width='360'>
							<label for="gendermale">男性</label> 
	        					<form:radiobutton id="gendermale" value="male" path="gender" required="required"/>
	        
	        
	        				<label for="genderfemale">女性</label>
	        					<form:radiobutton id="genderfemale" value="female" path="gender" required="required"/>
	        
	        
	        				<label for="genderother">其他</label> 
	        					<form:radiobutton id="genderother" value="other" path="gender" required="required"/>
							<br>&nbsp;
							<form:errors path='gender' cssClass="error" />
						</td>

					</tr>

					<tr>
						<td>電子信箱：<br>&nbsp;
						</td>
						<td>
							<form:input type="email" path="e_mail" required="required"/><br>&nbsp; 
							<form:errors path="e_mail" cssClass="error" />
						</td>
					</tr>
					
					<tr>
						<td colspan='4' align='center'><br>&nbsp; 
							<form:button value="Send">送出</form:button>
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

			</form:form>

		</fieldset>
		<br> <a href="<c:url value='/unmember/gologin_1'/> ">回前頁</a>
	</div>
 <script>
      window.onload = function(){
          document.getElementById("pass2").addEventListener("keyup",function(e){
              //console.log("ketpress");
              let checkString1 = document.getElementById("pass1").value;
              let checkString2 = document.getElementById("pass2").value;
              let checkSame = document.getElementById("isSame");
              
              //window.alert(e);
              console.log("checkString1: " + checkString1);
              console.log("checkString2: " + checkString2);
              if(checkString1 === checkString2){
                  checkSame.innerHTML="密碼相符!";
              }else {
                  checkSame.innerHTML="密碼不相符!";
              }
          });
      }
  </script>
</body>
</html>