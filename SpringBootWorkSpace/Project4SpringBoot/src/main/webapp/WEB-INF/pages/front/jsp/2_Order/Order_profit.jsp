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
	
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.24/css/jquery.dataTables.css">
	<link rel="stylesheet" href="<c:url value = '/back/css/Order_select.css'/>">
	
	<link href="<c:url value='/front/assets/css/tableStyle.css' />" rel="stylesheet">
	<link href="<c:url value='/back/vendor/datatables/dataTables.bootstrap4.min.css' />" rel="stylesheet">
	
	
	<!-- Template Main CSS File -->
	<link href="<c:url value='/front/assets/css/style.css' />" rel="stylesheet">
</head>
<body>
	<!-- ======= A00 Cookie ======= -->
	<%@include file="/WEB-INF/pages/front/jsp/0_Util/Cookie.jsp" %>

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
	          <li><a href="<c:url value='/front/profit/select' />">????????????</a></li>
	        </ol>
	        <h2>????????????</h2>
	        
	      </div>
	    </section><!-- End Breadcrumbs -->
	
		<!-- ?????? -->
		<div class="container">

<!-- ????????? -->
	 <div class="content"  style="margin:-45px 0px" >
    	 <div class="header">????????????</div> 
      		 <iframe src="<c:url value='/profit/select' />" width="100%" frameborder="0"> id="select_firame"></iframe>
 	 </div>
		
		
			
<!-- ????????? -->	
		</div>	      
	</main>
	
	<!-- End #main -->
	
	<!-- ======= A04 Footer ======= -->
	<%@include file="/WEB-INF/pages/front/jsp/0_Util/Footer.jsp" %>


	<!-- script -->
	<script type="text/javascript"> 
    	var profit_lists = ${profit_lists}  ; 
	</script>
	<script type="text/javascript"> 
    	var apiurl = "<c:url value='/getapi' />" + "?"  ; 
	</script>
	
	
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
	<script src="<c:url value='/back/js/Profit_select.js' />" async defer></script>
	<script src="<c:url value='/back/js/sweetalert2@11.js' />"></script>
	

	<!-- Template Main JS File -->
	<script src="<c:url value='/front/assets/js/main.js' />"></script>
	
	<!-- JQuery -->
  	<script src="<c:url value='/front/assets/js/jquery-3.6.0.slim.js' />"></script>
	
	<script type="text/javascript">
		$(function(){
			$('#header_Profit').addClass('active')
		})
	</script>
	
</body>
</html>