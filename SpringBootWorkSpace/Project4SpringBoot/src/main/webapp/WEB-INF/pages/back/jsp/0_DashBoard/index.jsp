<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>STOCK OVERFLOW</title>

    <!-- Custom fonts for this template-->
    <link href="<c:url value='/back/vendor/fontawesome-free/css/all.min.css' />" rel="stylesheet" type="text/css">
    <!-- 文字 -->
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Vendor CSS Files -->
	<link href="<c:url value='/front/assets/vendor/animate.css/animate.min.css' />" rel="stylesheet">
	<link href="<c:url value='/front/assets/vendor/bootstrap/css/bootstrap.min.css' />" rel="stylesheet">
	<link href="<c:url value='/front/assets/vendor/bootstrap-icons/bootstrap-icons.css' />" rel="stylesheet">
	<link href="<c:url value='/front/assets/vendor/boxicons/css/boxicons.min.css' />" rel="stylesheet">
	<link href="<c:url value='/front/assets/vendor/glightbox/css/glightbox.min.css' />" rel="stylesheet">
	<link href="<c:url value='/front/assets/vendor/swiper/swiper-bundle.min.css' />" rel="stylesheet">
    <!-- Template Main CSS File -->
	<link href="<c:url value='/front/assets/css/style.css' />" rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="<c:url value='/back/css/sb-admin-2.min.css' />" rel="stylesheet">
    <style>
        .pic{
        position:absolute;
        right:0px;
        bottom:0px
        }
        .Hpic{
        margin-top: 5%;    
        margin-left: 20%;
        }
  </style>
</head>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- A01 Sidebar -->
        <%@include file="/WEB-INF/pages/back/jsp/0_Util/Sidebar.jsp" %>

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- A02 Topbar -->
                <%@include file="/WEB-INF/pages/back/jsp/0_Util/Topbar.jsp" %>
				
                <!-- 內容 -->
                <!-- Begin Page Content -->
                <div class="container-fluid">
                    <%-- 標題 --%>
                    <div class="Hpic mb-5">
                        <img src="back/img/index/homepage.png" >
                    </div>
                    <%-- 功能 --%>
                    <!-- ======= Featured Section ======= -->
                    <section id="featured" class="featured">
                        <div class="row">
                            <div class="col-lg-2">
                                <div class="icon-box">
                                <i class="bi bi-person-circle"></i>
                                <h3><a href="">會員資料</a></h3>
                                <p>
                                1. 使用者 - 可以查閱資料 <br>
                                2. 管理者 - 可以對資料CRUD <br>
                                3. 管理者 - 可以上傳資料進行更新  <br>
                                4. 管理者 - 可以利用API 自動更新資料<br>
                                5. 管理者 - 可以下載資料<br>
                                </p>
                                </div>
                            </div>
                            <div class="col-lg-2">
                                <div class="icon-box">
                                <i class="bi bi-card-checklist"></i>
                                <h3><a href="">股票選擇器</a></h3>
                                <p>
                                1. 使用者 - 可以查閱資料 <br>
                                2. 管理者 - 可以對資料CRUD <br>
                                3. 管理者 - 可以上傳資料進行更新  <br>
                                4. 管理者 - 可以利用API 自動更新資料<br>
                                5. 管理者 - 可以下載資料<br>
                                </p>
                                </div>
                            </div>
                            <div class="col-lg-2 mt-4 mt-lg-0">
                                <div class="icon-box">
                                <i class="bi bi-bar-chart"></i>
                                <h3><a href="">股票交易</a></h3>
                                <p>Minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat tarad limino ata</p>
                                </div>
                            </div>
                            <div class="col-lg-2 mt-4 mt-lg-0">
                                <div class="icon-box">
                                <i class="bi bi-archive"></i>
                                <h3><a href="">申購與抽籤</a></h3>
                                <p>
                                1.後台發佈抽籤資料 <br>
                                2.前台載入抽籤資訊  <br>
                                3.前台發出、取消申購請求  <br>
                                4.後台收到、被取消申購請求 <br>
                                5.管理員人工審核交割戶存款  <br>
                                6.前台申購狀態成功與否  <br>
                                </p>
                                </div>
                            </div>
                            <div class="col-lg-2 mt-4 mt-lg-0">
                                <div class="icon-box">
                                <i class="bi bi-chat-dots"></i>
                                <h3><a href="">股市討論區</a></h3>
                                <p>
                                1.前台使用者針對個人文章 留言CRUD <br>
                                2.後台管理者全部文章CRUD <br>
                                3.後台管理者全部留言RD <br>
                                4.前後台圖片上傳處理 <br>
                                5.前台分類查詢 <br>
                                </p>
                                </div>
                            </div>
                            <div class="col-lg-2 mt-4 mt-lg-0">
                                <div class="icon-box">
                                <i class="bi bi-info-circle"></i>
                                <h3><a href="">事件管理員</a></h3>
                                <p>
                                1. 後台管理者 - 可以查閱事件紀錄<br>
                                2. 後台管理者 - 可以查看本機資源(CPU、記憶體、磁碟容量) <br>
                                </p>
                                </div>
                            </div>
                        </div>
                    </section><!-- End Featured Section -->

                    <%-- Peko --%>
                    <div class="pic">
                        <img src="back/img/index/pekoHead.png" >
                    </div>
                    
                </div>
                <!-- End of Page Content -->

            </div>
            <!-- End of Main Content -->

            <!-- A03 Footer -->
            <%@include file="/WEB-INF/pages/back/jsp/0_Util/Footer.jsp" %>

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- A04 Scroll to Top Button-->
    <%@include file="/WEB-INF/pages/back/jsp/0_Util/TopButton.jsp" %>

    <!-- A05 Logout Modal-->
    <%@include file="/WEB-INF/pages/back/jsp/0_Util/LogoutModal.jsp" %>



    <!-- script -->
    <!-- Bootstrap core JavaScript-->
    <script src="<c:url value='/back/vendor/jquery/jquery.min.js' />"></script>
    <script src="<c:url value='/back/vendor/bootstrap/js/bootstrap.bundle.min.js' />"></script>

    <!-- Core plugin JavaScript-->
    <script src="<c:url value='/back/vendor/jquery-easing/jquery.easing.min.js' />"></script>

    <!-- Custom scripts for all pages-->
    <script src="<c:url value='/back/js/sb-admin-2.min.js' />"></script>

    <!-- Page level plugins -->
<%--     <script src="<c:url value='/back/vendor/chart.js/Chart.min.js' />"></script> --%>

    <!-- Page level custom scripts -->
<%--     <script src="<c:url value='/back/js/demo/chart-area-demo.js' />"></script> --%>
<%--     <script src="<c:url value='/back/js/demo/chart-pie-demo.js' />"></script> --%>
	<script>
		$(function(){
            // Sidebar
            $("#dashboard").addClass('active')
		})
	</script>


</body>

</html>