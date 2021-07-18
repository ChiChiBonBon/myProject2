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
	
	
	<!-- Template Main CSS File -->
	<link href="<c:url value='/front/assets/css/style.css' />" rel="stylesheet">
</head>
<body>
	<!-- ======= A01 Top Bar ======= -->
	<%@include file="/WEB-INF/pages/front/jsp/0_Util/TopBar.jsp" %>

	<!-- ======= A02 Header ======= -->
	<%@include file="/WEB-INF/pages/front/jsp/0_Util/Header.jsp" %>
	
	<!-- ======= A03 Hero Section ======= -->
	<%@include file="/WEB-INF/pages/front/jsp/0_Util/HeroSection.jsp" %>
	
	<!-- 內容 -->
	<main id="main">
		<!-- ======= Featured Section ======= -->
		<section id="featured" class="featured">
			<div class="container">
				<div class="row">
					<div class="col-lg-4">
						<div class="icon-box">
						<i class="bi bi-card-checklist"></i>
						<h3><a href="">Lorem Ipsum</a></h3>
						<p>Voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident</p>
						</div>
					</div>
					<div class="col-lg-4 mt-4 mt-lg-0">
						<div class="icon-box">
						<i class="bi bi-bar-chart"></i>
						<h3><a href="">Dolor Sitema</a></h3>
						<p>Minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat tarad limino ata</p>
						</div>
					</div>
					<div class="col-lg-4 mt-4 mt-lg-0">
						<div class="icon-box">
						<i class="bi bi-binoculars"></i>
						<h3><a href="">Sed ut perspiciatis</a></h3>
						<p>Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur</p>
						</div>
					</div>
				</div>
			</div>
		</section><!-- End Featured Section -->

		<!-- ======= About Section ======= -->
		<section id="about" class="about">
			<div class="container">
				<div class="row">
					<div class="col-lg-6">
						<img src="front/assets/img/about.jpg" class="img-fluid" alt="">
					</div>
					<div class="col-lg-6 pt-4 pt-lg-0 content">
						<h3>Stock Overflow</h3>
						<p class="fst-italic">
						Stack Overflow是一個身為程式設計師的人都知道的問答網站，靈感借鏡於Stock(股票)與Stack(堆疊)有發音近似的感覺，投資人若想得到即時最新且全面的股市資訊，便能查閱Stock Overflow，以利賺錢的股票多到滿出來!!!
						</p>
						<ul>
						<li><i class="bi bi-check-circle"></i> 簡潔而美的風格，呈現需要的資訊，如:市場行情、新聞、圖表…等</li>
						<li><i class="bi bi-check-circle"></i> 可在討論區進行熱門股票討論</li>
						<li><i class="bi bi-check-circle"></i> 近期若有股票申購消息，可使用股票抽籤功能</li>
						<li><i class="bi bi-check-circle"></i> 若有下單需求，可使用快速下單、委託單查詢</li>
						<li><i class="bi bi-check-circle"></i> 會員功能可用區分前台會員使用者、後台管理人員</li>
						<li><i class="bi bi-check-circle"></i> 後台管理人員可以查詢使用紀錄，以及確認目前系統資源狀況</li>
						</ul>

					</div>
				</div>
			</div>
		</section><!-- End About Section -->	

		<!-- ======= Services Section ======= -->
		<section id="services" class="services">
			<div class="container">
				<div class="row">
					<div class="col-lg-2 col-md-6 d-flex align-items-stretch">
						
					</div>

					<div class="col-lg-4 col-md-6 d-flex align-items-stretch mt-4 mt-md-0">
						<div class="icon-box">
						<img src="front/assets/img/person/peko.png" class="img-thumbnail w-25" alt="...">
						<h4><a href="">潘啟勛 (組長)</a></h4>
						<p>會員功能:1.註冊會員 2.修改會員資料 3.刪除會員 4.登入會員 </p>
						</div>
					</div>

					<div class="col-lg-4 col-md-6 d-flex align-items-stretch mt-4 mt-lg-0">
						<div class="icon-box">
						<img src="front/assets/img/person/peko.png" class="img-thumbnail w-25" alt="...">
						<h4><a href="">鄭景文 (技術長)</a></h4>
						<p>股票篩選器: 1.公司基本資料 2.基本面</p>
						<p>事件管理員: 1.事件紀錄 2.系統資源</p>
						</div>
					</div>

					<div class="col-lg-4 col-md-6 d-flex align-items-stretch mt-4">
						<div class="icon-box">
						<img src="front/assets/img/person/peko.png" class="img-thumbnail w-25" alt="...">
						<h4><a href="">孫偉騰</a></h4>
						<p>討論區: 1.管理討論區留言 2.管理者貼文 3.使用者貼文留言</p>
						</div>
					</div>

					<div class="col-lg-4 col-md-6 d-flex align-items-stretch mt-4">
						<div class="icon-box">
						<img src="front/assets/img/person/peko.png" class="img-thumbnail w-25" alt="...">
						<h4><a href="">張啟邦</a></h4>
						<p>申購抽籤: 1.新股申購 2.管理申購數量 3.刪除已截止申購 4.查抽籤結果</p>
						</div>
					</div>

					<div class="col-lg-4 col-md-6 d-flex align-items-stretch mt-4">
						<div class="icon-box">
						<img src="front/assets/img/person/peko.png" class="img-thumbnail w-25" alt="...">
						<h4><a href="">徐振凱</a></h4>
						<p>下單功能: 1.下單2.委託單查詢3.歷史記錄查詢4.庫存損益</p>
						</div>
					</div>
				</div>
			</div>
		</section><!-- End Services Section -->

		<!-- ======= Clients Section ======= -->
		<section id="clients" class="clients">
			<div class="container">
				<div class="section-title">
					<h2>本次技術</h2>
					<p></p>
					</div>

					<div class="clients-slider swiper-container">
						<div class="swiper-wrapper align-items-center">
							<div class="swiper-slide"><img src="front/assets/img/clients/java.png" class="img-fluid" alt=""></div>
							<div class="swiper-slide"><img src="front/assets/img/clients/bootstrap2.jpg" class="img-fluid" alt=""></div>
							<div class="swiper-slide"><img src="front/assets/img/clients/hibernate.jpg" class="img-fluid" alt=""></div>
							<div class="swiper-slide"><img src="front/assets/img/clients/html.png" class="img-fluid" alt=""></div>
							<div class="swiper-slide"><img src="front/assets/img/clients/mssql.jpg" class="img-fluid" alt=""></div>
							<div class="swiper-slide"><img src="front/assets/img/clients/springboot2.png" class="img-fluid" alt=""></div>
							<div class="swiper-slide"><img src="front/assets/img/clients/sweetalert.png" class="img-fluid" alt=""></div>
							<%-- <div class="swiper-slide"><img src="front/assets/img/clients/client-8.png" class="img-fluid" alt=""></div> --%>
						</div>
					<div class="swiper-pagination"></div>
				</div>
			</div>
		</section><!-- End Clients Section -->	
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
	<!-- JQuery -->
  	<script src="<c:url value='/front/assets/js/jquery-3.6.0.slim.js' />"></script>
	<!-- Template Main JS File -->
	<script src="<c:url value='/front/assets/js/main.js' />"></script>
	
	<script type="text/javascript">
		$(function(){
			$('#header_front').addClass('active')
		})
	</script>
	
</body>
</html>