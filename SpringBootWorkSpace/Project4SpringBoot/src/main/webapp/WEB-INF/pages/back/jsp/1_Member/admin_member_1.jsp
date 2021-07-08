
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>管理會員中心</title>

    <!-- Custom fonts for this template-->
    <link href="<c:url value='/back/vendor/fontawesome-free/css/all.min.css' />" rel="stylesheet" type="text/css">
    <!-- 文字 -->
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="<c:url value='/back/css/sb-admin-2.min.css' />" rel="stylesheet">

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
                
                
<%--                 <a href="<c:url value='/unmember/goAdminMember_1'/>">測試抓取Json資料 之後再改</a>
 --%>                
                
                <div class="container-fluid">
                
                	<div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">所有會員資料</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered tabletest" id="" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>帳號</th>
                                            <th>證卷號</th>
                                            <th>生日</th>
                                            <th>性別</th>
                                            <th>Email</th>
                                            <th>綽號</th>
                                            <th>電話</th>
                                            <th>地址</th>
                                            <th>工作</th>
                                            <th>載具</th>
                                            <th>額度</th>
                                            <th>權限</th>
                                            <th>註冊時間</th>
                                            <th>會員狀態</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>帳號</th>
                                            <th>證卷號</th>
                                            <th>生日</th>
                                            <th>性別</th>
                                            <th>Email</th>
                                            <th>綽號</th>
                                            <th>電話</th>
                                            <th>地址</th>
                                            <th>工作</th>
                                            <th>載具</th>
                                            <th>額度</th>
                                            <th>權限</th>
                                            <th>註冊時間</th>
                                            <th>會員狀態</th>
                                        </tr>
                                    </tfoot>
                                    
                                    <tbody>
                                    	
                                    	<c:forEach var="bean" items="${AllMember}">
                                    	<tr>
   											<td>${bean.getAccount()}</td>
   											<td>${bean.getMember_stock_ID()}</td>
   											<td>${bean.getBirthday()}</td>
   											<td>${bean.getGender()}</td>
   											<td>${bean.getE_mail()}</td>
   											<td>${bean.getNickname()}</td>
   											<td>${bean.getCellphone()}</td>
   											<td>${bean.getAddress()}</td>
   											<td>${bean.getJob()}</td>
   											<td>${bean.getCarrier()}</td>
   											<td>${bean.getMember_quote()}</td>
   											<td>${bean.getMember_auth()}</td>
   											<td>${bean.getRegistertime()}</td>
   											<td>${bean.getMember_status()}</td>
   										</tr>
										</c:forEach>	
                 
                                    </tbody>
                                </table>
                            </div>
                        </div>
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


<!-- 這三行 js 讀不到 所以需要下面來重新渲染 -->

<%-- 	<!-- Page level plugins -->
    <script src="<c:url value='/back/vendor/datatables/jquery.dataTables.min.js' />"></script>
    <script src="<c:url value='/back/vendor/datatables/dataTables.bootstrap4.min.js' />"></script>

    <!-- Page level custom scripts -->
    <script src="<c:url value='/back/js/demo/datatables-demo.js' />"></script> --%>


 	<script>
		$(function(){
            // Sidebar
            $("#dashboard").addClass('active')
            
            /* js 重新渲染 jsp行程順序不一樣 所以用這個方式重新跑一次 */
            $('.tabletest').attr('id', 'dataTable')
            var scriptsToLoad = [
            	"<c:url value='/back/vendor/datatables/jquery.dataTables.min.js' />", 
            	"<c:url value='/back/vendor/datatables/dataTables.bootstrap4.min.js' />",
            	"<c:url value='/back/js/demo/datatables-demo.js' />"
            ]; 
            scriptsToLoad.forEach(function(src) {
            	var script = document.createElement('script');
            	script.src = src;
            	script.async = false;
            	document.body.appendChild(script);
            });
		})
	</script>
	

</body>

</html>