<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>股票申購管理</title>

	<!-- Custom fonts for this template-->
	<link
		href="<c:url value='/back/vendor/fontawesome-free/css/all.min.css' />"
		rel="stylesheet" type="text/css">
	<!-- 文字 -->
	<link
		href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
		rel="stylesheet">


    <!-- Custom styles for this template-->
    <link href="<c:url value='/back/css/sb-admin-2.min.css' />" rel="stylesheet">
    
    <!-- Custom styles for this page -->
    <link href="<c:url value='/back/vendor/datatables/dataTables.bootstrap4.min.css' />" rel="stylesheet">


</head>

<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- A01 Sidebar -->
		<%@include file="/WEB-INF/pages/back/jsp/0_Util/Sidebar.jsp"%>

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">


			<!-- Main Content -->
			<div id="content">

				<!-- A02 Topbar -->
				<%@include file="/WEB-INF/pages/back/jsp/0_Util/Topbar.jsp"%>

				<!-- 內容 -->
				<!-- Begin Page Content -->
				<div class="container-fluid">

					<!-- Page Heading -->
					<div
						class="d-sm-flex align-items-center justify-content-between mb-4">
						<h1 class="h3 mb-1 text-gray-800">抽籤管理</h1>
						<a href="<c:url value='/pa/downloadCsv' />" id="downloadCsv"
							class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
							<i class="fas fa-download fa-sm text-white-50"></i> 產生報表
						</a>
					</div>
					<p class="mb-4">
						資料來源: <a href="https://www.twse.com.tw/zh/page/announcement/publicForm.html">
							公開申購公告-抽籤日程表</a>
					</p>


					<!-- Table -->
					<!-- Table Upolad-->
					<div class="card shadow mb-4">
                        <div class="card-header">
                            <div class="input-group w-50">
                                <a  href="#" class="btn btn-primary btn-icon-split" >
                                    <span class="icon text-white-50">
                                        <i class="fas fa-file-upload"></i>
                                    </span>
                                    <span class="text" id="uploadFile">上傳檔案</span>
                                </a >
                                
                                <form method="POST" enctype="multipart/form-data" id="UploadForm">
                                    <input type="file" class="form-control" id="csvFile" name="csvFile" accept=".json">
                                </form>
                            </div>
                        </div>
                       
                        <!-- Table Content-->
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered tableArea" id="" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>股票代碼</th>
                                            <th>公司名稱</th>
                                            <th>企業商標</th>
                                            <th>市場別</th>
                                            <th>發佈狀態</th>
                                            <th>承銷價</th>
                                            <th>申購股數</th>
                                            <th>開始日</th>
                                            <th>結束日</th>
                                            <th>扣款日</th>
                                            <th>抽籤日</th>
                                            <th>還款日</th>
                                            <th>撥券日</th>
                                            <th>承銷股數</th>
                                            <th>更新時間</th>
                                            <th>備註</th>
                                            <th width="80px">修改 / 刪除</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>
                                    </tbody>
                                    <tfoot>
                                        <tr>
                                            <th>股票代碼</th>
                                            <th>公司名稱</th>
                                            <th>企業商標</th>
                                            <th>市場別</th>
                                            <th>發佈狀態</th>
                                            <th>承銷價</th>
                                            <th>申購股數</th>
                                            <th>開始日</th>
                                            <th>結束日</th>
                                            <th>扣款日</th>
                                            <th>抽籤日</th>
                                            <th>還款日</th>
                                            <th>撥券日</th>
                                            <th>承銷股數</th>
                                            <th>更新時間</th>
                                            <th>備註</th>
                                            <th width="80px">修改 / 刪除</th>
                                        </tr>
                                    </tfoot>
                                    <tbody id='dataArea'>
                                        
                                        
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>  


					<!-- Delete Button -->
					<div class="float-right" id="deleteAll">
						<a class="btn btn-danger btn-icon-split "> <span
							class="icon text-white-50"> <i class="fas fa-trash"></i>
						</span> <span class="text">Delete All Data</span>
							<template id="deleteAll-template">
								<swal-title> 你確定要刪除全部資料? </swal-title>
								<swal-icon type="warning" color="red"></swal-icon>
								<swal-button type="confirm"> 取消 </swal-button>
								<swal-button type="deny"> 刪除全部 </swal-button>
								<swal-param name="allowEscapeKey" value="false" />
								<swal-param name="customClass" value='{ "popup": "my-popup" }' />
							</template>
						</a>
					</div>

				</div>
				<!-- End of Page Content -->

			</div>
			<!-- End of Main Content -->

			<!-- A03 Footer -->
			<%@include file="/WEB-INF/pages/back/jsp/0_Util/Footer.jsp"%>

		</div>
		<!-- End of Content Wrapper -->
        
	</div>
	<!-- End of Page Wrapper -->

	<!-- A04 Scroll to Top Button-->
	<%@include file="/WEB-INF/pages/back/jsp/0_Util/TopButton.jsp"%>

	<!-- A05 Logout Modal-->
	<%@include file="/WEB-INF/pages/back/jsp/0_Util/LogoutModal.jsp"%>

    

	<!-- script -->
	<!-- Bootstrap core JavaScript-->
	<script src="<c:url value='/back/vendor/jquery/jquery.min.js' />"></script>
	<script
		src="<c:url value='/back/vendor/bootstrap/js/bootstrap.bundle.min.js' />"></script>

	<!-- Core plugin JavaScript-->
	<script
		src="<c:url value='/back/vendor/jquery-easing/jquery.easing.min.js' />"></script>

	<!-- Custom scripts for all pages-->
	<script src="<c:url value='/back/js/sb-admin-2.min.js' />"></script>

	<!-- Page level plugins -->
	<script
		src="<c:url value='/back/vendor/datatables/jquery.dataTables.min.js' />"></script>
	<script
		src="<c:url value='/back/vendor/datatables/dataTables.bootstrap4.min.js' />"></script>

	<!-- Page level custom scripts -->
	<script src="<c:url value='/back/js/demo/datatables-demo.js' />"></script>

	<!-- SweetAlert2 -->
	<script src="<c:url value='/back/js/sweetalert2@11.js' />"></script>
	<script>
		$(function(){
			// Sidebar
            $("#Drawlots_Management, #DS").addClass('active')
            $("#collapseDS").addClass('show')
		})
	</script>

</body>

</html>