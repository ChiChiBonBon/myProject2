<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>

<!doctype html>
<html lang="en">

<head>

  <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Dashboard</title>

    <!-- Custom fonts for this template-->
    <link href="<c:url value='/back/vendor/fontawesome-free/css/all.min.css' />" rel="stylesheet" type="text/css">
    <!-- 文字 -->
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="<c:url value='/back/css/sb-admin-2.min.css' />" rel="stylesheet">
    <link rel="stylesheet" href="<c:url value = '/back/css/Order_style.css'/>">
    

</head>

<body>
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
      <h2 id="test">Hi,${emp_ID},歡迎使用後台系統!</h2>
      

      <form action="<c:url value = '/admin/authority'/>" method="Post" onsubmit="return check_form(this.id);">
      <fieldset name="fieldset">
          <legend></legend>
             <div>
      			  <label for="" >客戶權限查詢:</label>
      			  <input name="stock_ID" type="text" placeholder="請輸入證券帳號" id="stock_ID" autofocus onchange="get_stock_ID(this.id)" size="17">
      			  <input type="submit" value="查詢" class="st_submit">		
      		 </div>
      </fieldset>
      </form>
      
      
      
  
	  <div class="content" >
    	 <div class="header">查詢結果</div> 
      		 <iframe src="<c:url value='/admin/account/select' />" width="100%" frameborder="0"> id="select_firame"></iframe>
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
    <script src="<c:url value='/back/js/Account.js' />"></script>
    
    <!-- Bootstrap core JavaScript-->
    <script src="<c:url value='/back/vendor/jquery/jquery.min.js' />"></script>
    <script src="<c:url value='/back/vendor/bootstrap/js/bootstrap.bundle.min.js' />"></script>

    <!-- Core plugin JavaScript-->
    <script src="<c:url value='/back/vendor/jquery-easing/jquery.easing.min.js' />"></script>

    <!-- Custom scripts for all pages-->
    <script src="<c:url value='/back/js/sb-admin-2.min.js' />"></script>

    <!-- Page level plugins -->
<%-- <script src="<c:url value='/back/vendor/chart.js/Chart.min.js' />"></script> --%>

    <!-- Page level custom scripts -->
<%-- <script src="<c:url value='/back/js/demo/chart-area-demo.js' />"></script> --%>
<%-- <script src="<c:url value='/back/js/demo/chart-pie-demo.js' />"></script>  --%>


</body>

</html>