<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta content="width=device-width, initial-scale=1.0" name="viewport">
	
	<title>STOCK OVERFLOW</title>
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
				<ol class="">
					<li><a href="<c:url value='/front' />">Home</a></li>
					<li><a href="<c:url value='/front/cTable/Main' />">股票選擇器</a></li>
					<li>${bean.company_NikeName}(${bean.stock})</li>
				</ol>
				<h2>${bean.company_NikeName}(${bean.stock})</h2> <!-- ex 台積電(2330) -->
			</div>
		</section><!-- End Breadcrumbs -->

		<!-- 內容 -->
		<div class="container">

			<div class="border border-secondary rounded bg-white">

				<!-- API -->
				<div class="justify-content-center d-flex mt-5">
				<iframe id="Top5"
					src="https://s.yimg.com/nb/tw_stock_frontend/scripts/StxChart/StxChart.9d11dfe155.html?sid=${bean.stock}"
					style="width: 560px; height: 382px; border-width: 0;"></iframe>
				</div>

				<!-- 詳細資料 -->
				<div class="row text-dark">
					<div class="col-4">
						<ul class="list-group list-group-flush">
						<li class="list-group-item">出表日期:&emsp; ${bean.formData} </li>
						<li class="list-group-item">公司代號:&emsp; ${bean.stock} </li>
						<li class="list-group-item">公司名稱:&emsp; ${bean.company_Name} </li>
						<li class="list-group-item">公司簡稱:&emsp; ${bean.company_NikeName} </li>
						<li class="list-group-item">外國企業註冊地國:&emsp; ${bean.foreign_Country} </li>
						<li class="list-group-item">產業別:&emsp; ${bean.industry_No} </li>
						<li class="list-group-item">住址:&emsp; ${bean.company_Location} </li>
						<li class="list-group-item">營利事業統一編號:&emsp; ${bean.business_Accounting_NO} </li>
						<li class="list-group-item">董事長:&emsp; ${bean.chairman_Board} </li>
						<li class="list-group-item">總經理:&emsp; ${bean.general_Manager} </li>
						<li class="list-group-item">發言人:&emsp; ${bean.spokesman} </li>
						<li class="list-group-item"> </li>
						</ul>
					</div>
					<div class="col-4">
						<ul class="list-group list-group-flush">
						<li class="list-group-item">發言人職稱:&emsp; ${bean.spokesman_Title} </li>
						<li class="list-group-item">代理發言人:&emsp; ${bean.spokesman_Acting} </li>
						<li class="list-group-item">總機電話:&emsp; ${bean.telephone} </li>
						<li class="list-group-item">成立日期:&emsp; ${bean.establishment_Date} </li>
						<li class="list-group-item">上市日期:&emsp; ${bean.appear_Market_Date} </li>
						<li class="list-group-item">普通股每股面額:&emsp; ${bean.denomination_per_Stock} </li>
						<li class="list-group-item">實收資本額:&emsp; ${bean.paid_In_Capital_Amount} </li>
						<li class="list-group-item">私募股數:&emsp; ${bean.private_Equity_Stock} </li>
						<li class="list-group-item">特別股:&emsp; ${bean.special_Stock} </li>
						<li class="list-group-item">編制財務報表類型:&emsp; ${bean.financial_Statements_Types} </li>
						<li class="list-group-item">股票過戶機構:&emsp; ${bean.transfer_Agency} </li>
						<li class="list-group-item"> </li>
						</ul>
					</div>
					<div class="col-4">
						<ul class="list-group list-group-flush">
						<li class="list-group-item">過戶電話:&emsp; ${bean.agency_Telephone} </li>
						<li class="list-group-item">過戶地址:&emsp; ${bean.agency_Location} </li>
						<li class="list-group-item">簽證會計師事務所:&emsp; ${bean.accounting_Firm} </li>
						<li class="list-group-item">簽證會計師1:&emsp; ${bean.accounting_Person_1} </li>
						<li class="list-group-item">簽證會計師2:&emsp; ${bean.accounting_Person_2} </li>
						<li class="list-group-item">英文簡稱:&emsp; ${bean.company_NikeName_EN} </li>
						<li class="list-group-item">英文通訊地址:&emsp; ${bean.company_Location_EN} </li>
						<li class="list-group-item">傳真機號碼:&emsp; ${bean.fax_Telephone} </li>
						<li class="list-group-item">電子郵件信箱:&emsp; ${bean.email} </li>
						<li class="list-group-item">網址:&emsp; ${bean.web_Address} </li>
						<li class="list-group-item"> </li>
						</ul>
					</div>


				</div>
			</div>

		</div>




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
	
	<!-- Template Main JS File -->
	<script src="<c:url value='/front/assets/js/main.js' />"></script>
	
	<!-- JQuery -->
  	<script src="<c:url value='/front/assets/js/jquery-3.6.0.slim.js' />"></script>
	
	                       
                        
  <script>
    $(function () {
		// defaule
		$('#header_Company').addClass('active')
		

    })
  </script>

	
</body>
</html>