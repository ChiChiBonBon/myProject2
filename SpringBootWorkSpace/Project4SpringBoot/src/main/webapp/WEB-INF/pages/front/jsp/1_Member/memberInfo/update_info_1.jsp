<%@page import="tw.front.a01_Member.model.MemberBean"%>
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
	<%
	HttpSession session_1 = request.getSession();
	MemberBean bean = (MemberBean) session_1.getAttribute("member_info");
	%>
	<div align="center">
		<fieldset style="width: 960px;">
			<legend>會員資料</legend>
			<form:form method="POST" modelAttribute="member" enctype='multipart/form-data' action="update_member_1">
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
							<form:input type="text" path="account" value="<%=bean.getAccount()%>" required="required"/><br>&nbsp; 
							<form:errors path='name' cssClass="error" />
						</td>
						
						<td>名字：<br> &nbsp;
						</td>
						<td>
							<form:input type="text" path="name" value="<%=bean.getName()%>" required="required"/><br>&nbsp;
							<form:errors path='password' cssClass="error" />
						</td>
					</tr>
					
					
					<tr>
						<td>出生日期：<br>&nbsp;
						</td>
						<td width='360'>
							<form:input type="date" path="birthday" value="<%=bean.getBirthday()%>"/><br>&nbsp;
							<form:errors path='birthday' cssClass="error" />
						</td>
						
						<td>別稱：<br>&nbsp;
						</td>
						<td width='360'>
							<form:input type="text" path="nickname" value="<%=bean.getNickname()%>"/><br>&nbsp;
							<form:errors path='nickname' cssClass="error" />
						</td>
					</tr>


					<tr>
						<td>性別：<br>&nbsp;
						</td>
						<td width='360'>
							<label for="gendermale">男性</label> 
	        					<form:radiobutton id="male" value="male" path="gender" required="required"/>
	        
	        
	        				<label for="genderfemale">女性</label>
	        					<form:radiobutton id="female" value="female" path="gender" required="required"/>
	        
	        
	        				<label for="genderother">其他</label> 
	        					<form:radiobutton id="other" value="other" path="gender" required="required"/>
							<br>&nbsp;
							<form:errors path='gender' cssClass="error" />
						</td>
					
						<td>電子信箱：<br>&nbsp;
						</td>
						<td>
							<form:input type="email" path="e_mail" value="<%=bean.getE_mail()%>" required="required"/><br>&nbsp; 
							<form:errors path="e_mail" cssClass="error" />
						</td>
					</tr>
					
					
					<tr>
						<td>手機：<br>&nbsp;
						</td>
						<td width='360'>
							<form:input type="text" path="cellphone" value="<%=bean.getCellphone()%>"/><br>&nbsp;
							<form:errors path='cellphone' cssClass="error" />
						</td>
						
						<td>地址：<br>&nbsp;
						</td>
						<td width='360'>
							<form:input type="text" path="address" value="<%=bean.getAddress()%>"/><br>&nbsp;
							<form:errors path='address' cssClass="error" />
						</td>
					</tr>
					
					
					<tr>
						<td>職業：<br>&nbsp;
						</td>
						
						<td width='360'>
							<form:select path="job" id="job">
							<form:option value="農牧業"/>農牧業
							<form:option value="漁業"/>漁業
							<form:option value="木材森林業"/>木材森林業
							<form:option value="礦業採石業"/>礦業採石業
							<form:option value="交通運輸業"/>交通運輸業
							<form:option value="餐旅業"/>餐旅業
							<form:option value="建築工程業"/>建築工程業
							<form:option value="製造業"/>製造業
							<form:option value="新聞廣告業"/>新聞廣告業
							<form:option value="衛生保健"/>衛生保健
							<form:option value="娛樂業"/>娛樂業
							<form:option value="文教機關"/>文教機關
							<form:option value="宗教團體"/>宗教團體
							<form:option value="公共事業"/>公共事業
							<form:option value="一般商業"/>一般商業
							<form:option value="服務業"/>服務業
							<form:option value="家庭管理"/>家庭管理
							<form:option value="資訊業"/>資訊業
							<form:option value="治安人員"/>治安人員
							<form:option value="軍人"/>軍人
							<form:option value="運動人員"/>運動人員
							<form:option value="學生"/>學生
							<form:option value="其他"/>其他
							</form:select><br>&nbsp;
						
							<form:errors path='job' cssClass="error" />
						</td>
						
						<td>載具：<br>&nbsp;
						</td>
						<td width='360'>
							<form:input type="text" path="carrier" value="<%=bean.getCarrier()%>"/><br>&nbsp;
							<form:errors path='carrier' cssClass="error" />
						</td>
					</tr>
					
					
					<tr>
						<td>頭貼上傳：<br>&nbsp;
						</td>
						<td width='360'>
							<form:input type="file" path="memberImage"/><br>&nbsp;
							<form:errors path='memberImage' cssClass="error" />
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
		<br> <a href="<c:url value='/member/gomembermenu_1'/> ">回前頁</a>
	</div>
	
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <script>
		$(function() {
			$("#<%=bean.getGender()%>").prop('checked', true)
			$("#job").val("<%=bean.getJob()%>");
		})	
  </script>
</body>
</html>