<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
			<link
				href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
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

			<!-- Custom styles for this page -->
			<link href="<c:url value='/back/vendor/datatables/dataTables.bootstrap4.min.css' />" rel="stylesheet">
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
									<li>抽籤與申購</li>
								</ol>
								<h2>股票申購公告資訊</h2>

							</div>
						</section>
						<!-- End Breadcrumbs -->

						<!-- 內容 -->
						<div class="container">

							<!-- Table Content-->
							<!-- Table -->
							<div class="card shadow mb-4">
								<div class="card-header py-3 row m-0">
								</div>
								<div class="card-body">
									<div class="table-responsive">
										<table class="table table-bordered tableArea" id="" width="150%"
											cellspacing="0">
											<thead>
												<tr>
													<th>股票代碼</th>
													<th>公司名稱</th>
													<th>市場別</th>
													<th>申購狀態</th>
													<th>承銷價</th>
													<th>申購股數</th>
													<th>開始日</th>
													<th>結束日</th>
													<th>扣款日</th>
													<th>抽籤日</th>
													<th>還款日</th>
													<th>撥券日</th>
													<th>承銷股數</th>
													<th>備註</th>
												</tr>
											</thead>
											<tfoot>
												<tr>
													<th>股票代碼</th>
													<th>公司名稱</th>
													<th>市場別</th>
													<th>申購狀態</th>
													<th>承銷價</th>
													<th>申購股數</th>
													<th>開始日</th>
													<th>結束日</th>
													<th>扣款日</th>
													<th>抽籤日</th>
													<th>還款日</th>
													<th>撥券日</th>
													<th>承銷股數</th>
													<th>備註</th>
												</tr>
											</tfoot>
											<tbody id='dataArea'>


											</tbody>
										</table>
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
						<script
							src="<c:url value='/front/assets/vendor/bootstrap/js/bootstrap.bundle.min.js' />"></script>
						<script src="<c:url value='/front/assets/vendor/glightbox/js/glightbox.min.js' />"></script>
						<script
							src="<c:url value='/front/assets/vendor/isotope-layout/isotope.pkgd.min.js' />"></script>
						<script src="<c:url value='/front/assets/vendor/php-email-form/validate.js' />"></script>
						<script src="<c:url value='/front/assets/vendor/purecounter/purecounter.js' />"></script>
						<script src="<c:url value='/front/assets/vendor/swiper/swiper-bundle.min.js' />"></script>
						<script
							src="<c:url value='/front/assets/vendor/waypoints/noframework.waypoints.js' />"></script>

						<!-- Template Main JS File -->
						<script src="<c:url value='/front/assets/js/main.js' />"></script>

						<!-- JQuery -->
						<script src="<c:url value='/front/assets/js/jquery-3.6.0.slim.js' />"></script>

						<!-- Page level plugins -->
						<script src="<c:url value='/back/vendor/datatables/jquery.dataTables.min.js' />"></script>
						<script src="<c:url value='/back/vendor/datatables/dataTables.bootstrap4.min.js' />"></script>

						<!-- Page level custom scripts -->
						<script src="<c:url value='/back/js/demo/datatables-demo.js' />"></script>
						<script src="<c:url value='/back/js/sweetalert2@11.js' />"></script>

						<script type="text/javascript">
							$(function () {
								$('#header_DrawlotsSubscription').addClass('active')
							})
						</script>

						<script>
							$(function () {

								// Select All Data
								var xhr = new XMLHttpRequest();
								xhr.open("GET", "<c:url value='/back/drawlots/selectAll' />", true);
								xhr.send()
								xhr.onreadystatechange = function () {
									if (xhr.readyState == 4 && xhr.status == 200) {
										$('#dataArea').html(showAll(xhr.responseText))
										$('.tableArea').attr('id', 'dataTable')

										var scriptsToLoad = [
											"<c:url value='/back/vendor/datatables/jquery.dataTables.min.js' />",
											"<c:url value='/back/vendor/datatables/dataTables.bootstrap4.min.js' />",
											"<c:url value='/back/js/demo/datatables-demo.js' />"
										];

										scriptsToLoad.forEach(function (src) {
											var script = document.createElement('script');
											script.src = src;
											script.async = false;
											document.body.appendChild(script);
										});

										subscribableUrl();


									}
								}




								function showAll(text) {
									var beans = JSON.parse(text);
									var segment = ""

									for (var x in beans) {
										var bean = beans[x]

										segment += "<tr>"
										segment += "<td class='idX'>" + bean.stockCode + "</td>"
										segment += "<td id='subscriptionStockCode'>" + bean.stockName + "</td>"
										segment += "<td>" + bean.marketType + "</td>"
										segment += "<td class='subscribeStatus'>" + bean.subscribeStatus + "</td>"
										segment += "<td>" + bean.subscribePrice + "</td>"
										segment += "<td>" + numberWithCommas(bean.quantity) + "</td>"
										segment += "<td>" + bean.startDate + "</td>"
										segment += "<td>" + bean.endDate + "</td>"
										segment += "<td>" + bean.deductionDate + "</td>"
										segment += "<td>" + bean.drawDate + "</td>"
										segment += "<td>" + bean.refundDate + "</td>"
										segment += "<td>" + bean.grantSecuritiesDate + "</td>"
										segment += "<td>" + numberWithCommas(bean.totalQuantity) + "</td>"
										segment += "<td>" + bean.remarks + "</td>"
										segment += "</tr>"
									}
									return segment;
								}

								function numberWithCommas(x) {
									return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
								}

								function subscribableUrl() {
									let subscribeStatusTagCount = document.getElementsByClassName('subscribeStatus').length;

									for (let i = 0; i < subscribeStatusTagCount; i++) {
										if (document.getElementsByClassName('subscribeStatus')[i].innerHTML == '可申購') {
											document.getElementsByClassName('subscribeStatus')[i].innerHTML = '<center><input name type="button" class="btn btn-primary" value="申購" onClick="buttionStateChange(this)" ></center>';
											//console.log(document.getElementsByClassName('subscribeStatus')[i].firstChild.firstChild.setAttribute('id',));
											//console.log($('.subscribeStatus')[i].firstChild.firstChild.setAttribute('name','Jason'));
										}
									}


									// $("#dataTable tbody").on("click", ".btn", function () {
									// 	//獲取行
									// 	var row = $("table#dataTable tr").index($(this).closest("tr"));
									// 	//取得某列的值,eq(0)開始
									// 	var subscriptionStockCode = $("table#dataTable").find("tr").eq(row).find("td").eq(0).text();
									// 	//套sweet
									// 	swal.fire({
									// 		title: '確定申購此筆交易嗎?',
									// 		text: '股票代碼:' + subscriptionStockCode,
									// 		icon: 'warning',
									// 		showCancelButton: true,
									// 		cancelButtonText: "取消",
									// 		cancelButtonColor: '#ADADAD',
									// 		confirmButtonText: '確定',
									// 		confirmButtonColor: '#FF5151',
									// 	}).then((result) => {
									// 		if (result.isConfirmed) {
									// 			document.getElementById('subscriptionStockCode').value = subscriptionStockCode;
									// 			Swal.fire({
									// 				icon: 'success',
									// 				title: '申購完成！',
									// 				position: 'absolute; top:50%; left:50%',
									// 				showConfirmButton: false,
									// 				timer: 1500
									// 			})


									// 		} else {
									// 			//document.getElementById('passForm').reset();
									// 		}
									// 	})
									// });
								}
							});



							// $("#dataTable tbody").on("click", "#statusButton", function () {
							// 	//獲取行
							// 	var row = $("table#dataTable tr").index($(this).closest("tr"));
							// 	//取得某列的值,eq(0)開始
							// 	var subscriptionStockCode = $("table#dataTable").find("tr").eq(row).find("td").eq(0).text();
							// 	//套sweet
							// 	swal.fire({
							// 		title: '確定申購此筆交易嗎?',
							// 		text: '股票代碼:' + subscriptionStockCode,
							// 		icon: 'warning',
							// 		showCancelButton: true,
							// 		cancelButtonText: "取消",
							// 		cancelButtonColor: '#ADADAD',
							// 		confirmButtonText: '確定',
							// 		confirmButtonColor: '#FF5151',
							// 	}).then((result) => {
							// 		if (result.isConfirmed) {
							// 			document.getElementById('subscriptionStockCode').value = subscriptionStockCode;
							// 			Swal.fire({
							// 				icon: 'success',
							// 				title: '申購完成！',
							// 				position: 'absolute; top:50%; left:50%',
							// 				showConfirmButton: false,
							// 				timer: 1500
							// 			})


							// 		} else {
							// 			//document.getElementById('passForm').reset();
							// 		}
							// 	})
							// });

							function buttionStateChange(rowPosition) {
								
								var row = $("table#dataTable tr").index($(rowPosition).closest("tr"));
								var subscriptionStockCode = $("table#dataTable").find("tr").eq(row).find("td").eq(0).text();

								if ($(rowPosition).hasClass('btn-primary')) {
									$(rowPosition).removeClass('btn-primary');
									$(rowPosition).addClass('btn-success');
									$(rowPosition).val('取消');

									//console.log(rowPosition)

									swal.fire({
										title: '確定申購此筆交易嗎?',
										text: '股票代碼:' + subscriptionStockCode,
										icon: 'warning',
										showCancelButton: true,
										cancelButtonText: "取消",
										cancelButtonColor: '#ADADAD',
										confirmButtonText: '確定',
										confirmButtonColor: '#FF5151',
									}).then((result) => {
										if (result.isConfirmed) {
											document.getElementById('subscriptionStockCode').value = subscriptionStockCode;
											Swal.fire({
												icon: 'success',
												title: '申購完成！',
												position: 'absolute; top:50%; left:50%',
												showConfirmButton: false,
												timer: 1500
											})


										} else {
											//document.getElementById('passForm').reset();
										}
									});
								} else {
									$(rowPosition).removeClass('btn-success');
									$(rowPosition).addClass('btn-primary');
									$(rowPosition).val('申購');

									swal.fire({
										title: '確定取消此筆申購嗎?',
										text: '股票代碼:' + subscriptionStockCode,
										icon: 'warning',
										showCancelButton: true,
										cancelButtonText: "取消",
										cancelButtonColor: '#ADADAD',
										confirmButtonText: '確定',
										confirmButtonColor: '#FF5151',
									}).then((result) => {
										if (result.isConfirmed) {
											document.getElementById('subscriptionStockCode').value = subscriptionStockCode;
											Swal.fire({
												icon: 'success',
												title: '取消完成！',
												position: 'absolute; top:50%; left:50%',
												showConfirmButton: false,
												timer: 1500
											})


										} else {
											//document.getElementById('passForm').reset();
										}
									});
								}
							}
						</script>

		</body>

		</html>