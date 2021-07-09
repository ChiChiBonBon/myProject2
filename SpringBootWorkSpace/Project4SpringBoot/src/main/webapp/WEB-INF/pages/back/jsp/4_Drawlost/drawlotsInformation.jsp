<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>股票申購</title>

<!-- Custom fonts for this template-->
<link
	href="<c:url value='/back/vendor/fontawesome-free/css/all.min.css' />"
	rel="stylesheet" type="text/css">
<!-- 文字 -->
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="<c:url value='/back/css/sb-admin-2.min.css' />"
	rel="stylesheet">

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
						<h1 class="h3 mb-1 text-gray-800">申購資訊</h1>
						<a href="<c:url value='/pa/downloadCsv' />" id="downloadCsv"
							class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
							<i class="fas fa-download fa-sm text-white-50"></i> 報表產生
						</a>
					</div>
					<p class="mb-4">
						資料來源: <a
							href="https://www.twse.com.tw/zh/page/announcement/publicForm.html">
							臺灣證卷交易所-公開申購公告-抽籤日程表</a> <br> 可以將資料匯入進來，目前未檢查資料真偽，以後更新。
						2021/6/30
					</p>


					<!-- Table -->
					<!-- Table Upolad-->
					<div class="card shadow mb-4">
						<div class="card-header">
							<div class="input-group w-50">
								<a href="#" class="btn btn-primary btn-icon-split"> <span
									class="icon text-white-50"> <i
										class="fas fa-file-upload"></i>
								</span> <span class="text" id="uploadFile">檔案全部更新</span>
								</a>
							</div>
						</div>

						<!-- Table Content-->
						<div class="card-body">
							<div class="table-responsive">
								<table class="table table-bordered tableX" id="" width="100%"
									cellspacing="0">
									<thead>
										<tr>
											<th class="sorting_disabled dt-head-center dt-body-center"
												rowspan="1" colspan="1"
												style="width: 28.8125px; min-width: 28.8125px;">序號</th>
											<th class="sorting_disabled dt-head-center dt-body-center"
												rowspan="1" colspan="1"
												style="width: 52.625px; min-width: 52.625px;">抽籤日期</th>
											<th class="sorting_disabled dt-head-center dt-body-center"
												rowspan="1" colspan="1"
												style="width: 28.8125px; min-width: 28.8125px;">證券名稱</th>
											<th class="sorting_disabled dt-head-center dt-body-center"
												rowspan="1" colspan="1"
												style="width: 43.7188px; min-width: 43.7188px;">證券代號</th>
											<th class="sorting_disabled dt-head-center dt-body-center"
												rowspan="1" colspan="1"
												style="width: 28.8125px; min-width: 28.8125px;">發行市場</th>
											<th class="sorting_disabled dt-head-center dt-body-center"
												rowspan="1" colspan="1"
												style="width: 52.625px; min-width: 52.625px;">申購開始日</th>
											<th class="sorting_disabled dt-head-center dt-body-center"
												rowspan="1" colspan="1"
												style="width: 52.625px; min-width: 52.625px;">申購結束日</th>
											<th class="sorting_disabled dt-head-center dt-body-right"
												rowspan="1" colspan="1"
												style="width: 53.7344px; min-width: 53.7344px;">承銷股數</th>
											<th class="sorting_disabled dt-head-center dt-body-right"
												rowspan="1" colspan="1"
												style="width: 53.7344px; min-width: 53.7344px;">實際承銷股數</th>
											<th class="sorting_disabled dt-head-center dt-body-right"
												rowspan="1" colspan="1"
												style="width: 37.875px; min-width: 37.875px;">承銷價(元)</th>
											<th class="sorting_disabled dt-head-center dt-body-right"
												rowspan="1" colspan="1"
												style="width: 37.375px; min-width: 37.375px;">實際承銷價(元)</th>
											<th class="sorting_disabled dt-head-center dt-body-center"
												rowspan="1" colspan="1"
												style="width: 52.625px; min-width: 52.625px;">撥券日期(上市、上櫃日期)</th>
											<th class="sorting_disabled dt-head-center dt-body-center"
												rowspan="1" colspan="1"
												style="width: 28.3125px; min-width: 28.3125px;">主辦券商</th>
											<th class="sorting_disabled dt-head-center dt-body-center"
												rowspan="1" colspan="1"
												style="width: 37.875px; min-width: 37.875px;">申購股數</th>
											<th class="sorting_disabled dt-head-center dt-body-right"
												rowspan="1" colspan="1"
												style="width: 70.4219px; min-width: 70.4219px;">總承銷金額(元)</th>
											<th class="sorting_disabled dt-head-center dt-body-right"
												rowspan="1" colspan="1"
												style="width: 42.0938px; min-width: 42.0938px;">總合格件</th>
											<th class="sorting_disabled dt-head-center dt-body-right"
												rowspan="1" colspan="1"
												style="width: 33.0312px; min-width: 33.0312px;">中籤率(%)</th>
											<th class="sorting_disabled dt-head-center dt-body-center"
												rowspan="1" colspan="1"
												style="width: 28.8906px; min-width: 28.8906px;">取消公開抽籤</th>
										</tr>
									</thead>
									<tfoot>
										<tr>
											<th class="sorting_disabled dt-head-center dt-body-center"
												rowspan="1" colspan="1"
												style="width: 28.8125px; min-width: 28.8125px;">序號</th>
											<th class="sorting_disabled dt-head-center dt-body-center"
												rowspan="1" colspan="1"
												style="width: 52.625px; min-width: 52.625px;">抽籤日期</th>
											<th class="sorting_disabled dt-head-center dt-body-center"
												rowspan="1" colspan="1"
												style="width: 28.8125px; min-width: 28.8125px;">證券名稱</th>
											<th class="sorting_disabled dt-head-center dt-body-center"
												rowspan="1" colspan="1"
												style="width: 43.7188px; min-width: 43.7188px;">證券代號</th>
											<th class="sorting_disabled dt-head-center dt-body-center"
												rowspan="1" colspan="1"
												style="width: 28.8125px; min-width: 28.8125px;">發行市場</th>
											<th class="sorting_disabled dt-head-center dt-body-center"
												rowspan="1" colspan="1"
												style="width: 52.625px; min-width: 52.625px;">申購開始日</th>
											<th class="sorting_disabled dt-head-center dt-body-center"
												rowspan="1" colspan="1"
												style="width: 52.625px; min-width: 52.625px;">申購結束日</th>
											<th class="sorting_disabled dt-head-center dt-body-right"
												rowspan="1" colspan="1"
												style="width: 53.7344px; min-width: 53.7344px;">承銷股數</th>
											<th class="sorting_disabled dt-head-center dt-body-right"
												rowspan="1" colspan="1"
												style="width: 53.7344px; min-width: 53.7344px;">實際承銷股數</th>
											<th class="sorting_disabled dt-head-center dt-body-right"
												rowspan="1" colspan="1"
												style="width: 37.875px; min-width: 37.875px;">承銷價(元)</th>
											<th class="sorting_disabled dt-head-center dt-body-right"
												rowspan="1" colspan="1"
												style="width: 37.375px; min-width: 37.375px;">實際承銷價(元)</th>
											<th class="sorting_disabled dt-head-center dt-body-center"
												rowspan="1" colspan="1"
												style="width: 52.625px; min-width: 52.625px;">撥券日期(上市、上櫃日期)</th>
											<th class="sorting_disabled dt-head-center dt-body-center"
												rowspan="1" colspan="1"
												style="width: 28.3125px; min-width: 28.3125px;">主辦券商</th>
											<th class="sorting_disabled dt-head-center dt-body-center"
												rowspan="1" colspan="1"
												style="width: 37.875px; min-width: 37.875px;">申購股數</th>
											<th class="sorting_disabled dt-head-center dt-body-right"
												rowspan="1" colspan="1"
												style="width: 70.4219px; min-width: 70.4219px;">總承銷金額(元)</th>
											<th class="sorting_disabled dt-head-center dt-body-right"
												rowspan="1" colspan="1"
												style="width: 42.0938px; min-width: 42.0938px;">總合格件</th>
											<th class="sorting_disabled dt-head-center dt-body-right"
												rowspan="1" colspan="1"
												style="width: 33.0312px; min-width: 33.0312px;">中籤率(%)</th>
											<th class="sorting_disabled dt-head-center dt-body-center"
												rowspan="1" colspan="1"
												style="width: 28.8906px; min-width: 28.8906px;">取消公開抽籤</th>
										</tr>
									</tfoot>
									<tbody id="dataAreaX">
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
	<%--     <script src="<c:url value='/back/vendor/chart.js/Chart.min.js' />"></script> --%>

	<!-- Page level custom scripts -->
	<%--     <script src="<c:url value='/back/js/demo/chart-area-demo.js' />"></script> --%>
	<%--     <script src="<c:url value='/back/js/demo/chart-pie-demo.js' />"></script> --%>
	<script>
		$(function() {
			// Sidebar
			$("#dashboard").addClass('active')
		})
	</script>


</body>

</html>