<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

    <title>Message</title>
    <meta content="" name="description">
    <meta content="" name="keywords">

    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

    <!-- Vendor CSS Files -->
    <link href="<c:url value='/front/assets/vendor/animate.css/animate.min.css' />" rel="stylesheet">
    <link href="<c:url value='/front/assets/vendor/bootstrap/css/bootstrap.min.css' />" rel="stylesheet">
    <link href="<c:url value='/front/assets/vendor/bootstrap-icons/bootstrap-icons.css' />"rel="stylesheet">
    <link href="<c:url value='/front/assets/vendor/boxicons/css/boxicons.min.css' />" rel="stylesheet">
    <link href="<c:url value='/front/assets/vendor/glightbox/css/glightbox.min.css' />" rel="stylesheet">
    <link href="<c:url value='/front/assets/vendor/swiper/swiper-bundle.min.css' />" rel="stylesheet">

    <!-- Template Main CSS File -->
    <link href="<c:url value='/front/assets/css/style.css' />" rel="stylesheet">
</head>
<body>
    <!-- ======= A01 Top Bar ======= -->
    <%@include file="/WEB-INF/pages/front/jsp/0_Util/TopBar.jsp"%>

    <!-- ======= A02 Header ======= -->
    <%@include file="/WEB-INF/pages/front/jsp/0_Util/Header.jsp"%>

    <!-- Main -->
    <main id="main">
    <!-- ======= Breadcrumbs ======= -->
    <section id="breadcrumbs" class="breadcrumbs">
      <div class="container">

        <ol>
         <li><a href="<c:url value='/front' />">Home</a></li>
         <li>會員</li>
        </ol>
        <h2>通知</h2>

      </div>
    </section>
  <!-- End Breadcrumbs -->

  <!-- 內容 -->
        <div class="container">


        <div class='fs-3 fst-italic fw-bold'>${Message}</div>
        <br>
        <hr>
        <a href="<c:url value='/front/unmember/gologin_1'/> " class='fs-5'>回會員登入</a> 


        </div>
    </main>
    <!-- End #main -->

    <!-- ======= A04 Footer ======= -->
    <%@include file="/WEB-INF/pages/front/jsp/0_Util/Footer.jsp"%>


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
    
    <!-- SweetAlert2 -->
    <script src="<c:url value='/front/assets/js/sweetalert2@11.js' />"></script>

    <script type="text/javascript">
        $(function(){
         $('#header_About').addClass('active')
        })
    </script>

</body>
</html>