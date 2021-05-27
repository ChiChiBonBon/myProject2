<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="./Logout_1" method="post" name="myform">
		<div>
			<input type="hidden" name="logout">
		</div>
	</form>

	<script>
		document.myform.submit();
	</script>


</body>
</html>