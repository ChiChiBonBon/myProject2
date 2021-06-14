<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="formData" method="POST" enctype="multipart/form-data">
		
		 帳號<input type="text"  name="account" value="Guest" size="6"><br>
		 密碼<input type="password"  name="pwd" maxlength="6"><br>
		 意見<textarea name="memo"  cols="30" rows="10"></textarea>
		 
		<br>
		<label for="" class="t1">性別:</label>
		<input type="radio" name="gen"  value="male">    <label for="man">男</label>
		<input type="radio" name="gen"  value="female"><label for="female">女</label>
		
		 <div class="st1">
		    <label for="" class="t1">興趣:</label>
		    <label>
		        <input type="checkbox" name="hobby"  value="sport">運動
		    </label>
		    <label>
		        <input type="checkbox" name="hobby"  value="movie">電影
		    </label>
		    <label>
		        <input type="checkbox" name="hobby"  value="travel">旅遊
		    </label>
		 </div>
		 
		 
		 <div class="st1">
		    <label for="" class="t1">縣市:</label>
		    <select name="city" multiple>
		        <option value="A01">台北市</option>
		        <option value="A02">新竹市</option>
		        <option value="A03" selected>苗栗國</option>
		    </select>
		 </div>
		 
		<div class="st1">
		      <label for="" class="t1">上傳:</label>
		      <input type="file" name="upload">
		</div>
		
		<input type="submit" value="送出">
		<input type="reset"  value="清除">
	</form>

</body>
</html>