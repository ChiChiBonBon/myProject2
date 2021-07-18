<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta content="width=device-width, initial-scale=1.0" name="viewport">
	
	<title>Eterna Bootstrap Template - Index</title>
	<meta content="" name="description">
	<meta content="" name="keywords">
	
	 <!-- Google Fonts -->
	<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">
	
	<!-- Vendor CSS Files -->
	<link href="<c:url value='/front/assets/vendor/animate.css/animate.min.css' />" rel="stylesheet">
	<link href="<c:url value='/front/assets/vendor/bootstrap/css/bootstrap.min.css' />" rel="stylesheet">
	<link href="<c:url value='/front/assets/vendor/bootstrap-icons/bootstrap-icons.css' />" rel="stylesheet">
	<link href="<c:url value='/front/assets/vendor/boxicons/css/boxicons.min.css' />" rel="stylesheet">
	<link href="<c:url value='/front/assets/vendor/glightbox/css/glightbox.min.css' />" rel="stylesheet">
	<link href="<c:url value='/front/assets/vendor/swiper/swiper-bundle.min.css' />" rel="stylesheet">
	
	<link href="<c:url value='/front/assets/css/Order_style.css' />" rel="stylesheet">
	
	
	<!-- Template Main CSS File -->
	<link href="<c:url value='/front/assets/css/style.css' />" rel="stylesheet">
</head>
<body>
	<!-- ======= A01 Top Bar ======= -->
	<%@include file="/WEB-INF/pages/front/jsp/0_Util/TopBar.jsp" %>

	<!-- ======= A02 Header ======= -->
	<%@include file="/WEB-INF/pages/front/jsp/0_Util/Header.jsp" %>
		
	<!-- Main -->
	<main id="main">
	    <!-- ======= Breadcrumbs ======= -->
	    <section id="breadcrumbs" class="breadcrumbs">
	      <div class="container">
	
	        <ol>
	          <li><a href="<c:url value='/front' />">Home</a></li>
	          <li><a href="<c:url value='/front/order' />">股票下單</a></li>
	        </ol>
	        <h2>股票下單</h2>
	        
	      </div>
	    </section><!-- End Breadcrumbs -->
	
		<!-- 內容 -->
		<%  java.util.UUID uuid = java.util.UUID.randomUUID();
          	String order_ID     = uuid.toString();%>
          	
		<div class="container"   style="margin:-34px 100px">
		<!--  
		<h3 id="test">Hi,${user_ID},歡迎使用後台系統!</h3>-->
		
	        <span style="margin:0px 0px ">
          		<iframe id="Kline" src="https://s.yimg.com/nb/tw_stock_frontend/scripts/TaChart/tachart.3de240ea9a.html?sid=2330"   style="width: 650px; height: 430px; border-width: 0; margin:0px -150px -20px 0px"></iframe>
          		<iframe id="Top5"  src="https://s.yimg.com/nb/tw_stock_frontend/scripts/StxChart/StxChart.9d11dfe155.html?sid=2330" style="width: 650px; height: 400px; border-width: 0; margin:0px -300px -30px 80px"></iframe>
	        </span>
	        
			<form action="<c:url value = '/front/order'/>" method="Post" onsubmit="return check_form(this.id);" id="orderForm">
	        <fieldset name="fieldset">
	            <legend></legend>
		        <span>
		          <button name="op1" id="but1" value="證" type="button" class="st_change" onclick="change_border_color(this.id),op1_value(this.id),change_odd(this.id),get_total(this.id)">證券</button>
		          <button name="op1" id="but2" value="期" type="button" class="" onclick="change_border_color(this.id),op1_value(this.id)" disabled>期貨</button>
		          <button name="op1" id="but3" value="選" type="button" class="" onclick="change_border_color(this.id),op1_value(this.id)" disabled>選權</button>
		          <button name="op1" id="but4" value="0" type="button" class="st_change" onclick="change_border_color(this.id),op1_value(this.id),change_odd(this.id),get_total(this.id)">零股</button>
		          <input  name="trans_species" id="trans_species" type="hidden" >
		              
		          <label for="">交易帳號:</label>
		          <select name="stock_ID" id="stock_ID">
		                <option name="input_stock_ID" id="input_stock_ID" value="${stock_ID}" selected>證-${stock_ID} </option>
		          </select>
		  
		          <label for="">標的:</label>
		          <input name="com_name" id="com_name"type="text" size="19" placeholder="商品名稱">
	
		          <!--  
		              <button class="st_lim">現</button>
		              <button>漲</button>
		              <button>跌</button>
		              <button>平</button>
		              <button>市</button> -->
		
		          <label for="">單位:</label>
		          <label for="" id="oneorodd" ></label>
		          <label for="">股</label>
		                 
		          <button name="op2" id="1"  value="買進" type="button" onclick="change_back_color(this.id),op2_value(this.id)" class="st_buy st_change">買進</button>
		          <button name="op2" id="0"  value="賣出" type="button" onclick="change_back_color(this.id),op2_value(this.id)" class="st_sell st_change">賣出</button>
		          <input  name="trans_sellorbuy" id="trans_sellorbuy" type="hidden" >
		        </span>
	        </fieldset>
	      	  
			<fieldset name="fieldset">
		        <legend></legend>
		            <button name="op3" id="but5" value="現股" type="button" class="st_change" onclick="change_border_color(this.id),op3_value(this.id)">現股</button>
		            <button name="op3" id="but6" value="當沖" type="button" class="st_change" onclick="change_border_color(this.id),op3_value(this.id)" disabled>當沖</button>
		            <button name="op3" id="but7" value="融資" type="button" class="st_change" onclick="change_border_color(this.id),op3_value(this.id)" disabled>融資</button>
		            <button name="op3" id="but8" value="融券" type="button" class="st_change" onclick="change_border_color(this.id),op3_value(this.id)" disabled>融券</button>
		            <input  name="trans_way" id="trans_way" type="hidden" >
		              
		            <label for="" >商品代碼:</label>
		            <input name="com_ID" type="text" placeholder="股票代號" id="com_ID" autofocus onchange="get_input(this.id)" size="8">
		            <select name="trans_cond" id="trans_cond" class="st_rod">
		                <option value="ROD" selected>ROD</option>
		                <option value="IOC">IOC</option>
		                <option value="FOK">FOK</option>
		            </select>
		            <label for="">價格:</label>
		            <input name="order_price" id="order_price" type="text" size="5" maxlength="7" onkeyup="get_total(this.id)">
		            <label for="">數量:</label>
		            <input name="input_quant" id="input_quant" type="text" size="4" maxlength="4.5" onkeyup="get_total(this.id)">
		            <input name="order_quant" id="order_quant" type="hidden" >
		            <label for="" >總價:</label>
		            <label id="show_total" for=""></label>
		            <label for="" >新台幣</label>
		            <input name="order_total" id="order_total" type="hidden" >  
		            <input type="button" value="立即下單" class="st_submit" onclick="get_datetime()" id="order_now"  >
		            <input type="reset"  value="清除" id="clear"  onclick="clear(),order_clear(this.id)">
		            <input name="order_ID"     id="order_ID"     type="hidden" value=<%=order_ID%>>
		            <input name="order_date"   id="order_date"   type="hidden" >
		            <input name="order_time"   id="order_time"   type="hidden" >
		            <input name="trans_stats"  id="trans_stats"  type="hidden" value="委託單">
		            <input name="trans_report" id="trans_report" type="hidden" value="委託成功">            
		    </fieldset>	      
			</form>
			
	      <!--  暫時拿掉
		  <div class="content" >
	    	 <div class="header">訂單查詢</div> 
	      		 <iframe src="<c:url value='/order/select' />" width="100%" frameborder="0"> id="select_firame"></iframe>
	 	  </div>
	 	  -->		
			
		</div>
	</main>
	<!-- End #main -->
	
	<!-- ======= A04 Footer ======= -->
	<%@include file="/WEB-INF/pages/front/jsp/0_Util/Footer.jsp" %>


	<!-- script -->
	<!-- Vendor JS Files -->
	<script src="<c:url value='/front/assets/vendor/bootstrap/js/bootstrap.bundle.min.js' />"></script>
	<script src="<c:url value='/front/assets/vendor/glightbox/js/glightbox.min.js' />"></script>
	<script src="<c:url value='/front/assets/vendor/isotope-layout/isotope.pkgd.min.js' />"></script>
	<script src="<c:url value='/front/assets/vendor/php-email-form/validate.js' />"></script>
	<script src="<c:url value='/front/assets/vendor/purecounter/purecounter.js' />"></script>
	<script src="<c:url value='/front/assets/vendor/swiper/swiper-bundle.min.js' />"></script>
	<script src="<c:url value='/front/assets/vendor/waypoints/noframework.waypoints.js' />"></script>
	
	<script src="<c:url value='/back/vendor/jquery/jquery.min.js' />"></script>
	<script src="<c:url value='/back/vendor/jquery-easing/jquery.easing.min.js' />"></script>
	<script src="<c:url value='/back/js/Order.js' />"></script>
	<script src="<c:url value='/back/js/sweetalert2@11.js' />"></script>
	<script type="text/javascript"> 
    	var apiurl = "<c:url value='/getapi' />" + "?"  ; 
	</script>
	

	<!-- Template Main JS File -->
	<script src="<c:url value='/front/assets/js/main.js' />"></script>
	
	<!-- JQuery -->
  	<script src="<c:url value='/front/assets/js/jquery-3.6.0.slim.js' />"></script>
	
	<script type="text/javascript">
		$(function(){
			$('#header_Ordermain').addClass('active')
		})
	</script>
	
</body>
</html>