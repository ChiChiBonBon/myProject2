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

			<!-- use Modal-->
			<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
			<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
			<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
										<li>抽籤與申購</li>
									</ol>
									<h2>股票申購公告資訊</h2>
									<div>
										<p>
										<h3>觀迎 證券用戶 ${userStockID} !!!</h3>
										<input id="userStockID" type="hidden" value="${userStockID}">
										<input id="userName" type="hidden" value="${userName}">
										</p>
									</div>

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
														<th class="remark" >備註</th>
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

						<p style="line-height:3px;">&nbsp;</p>
						<div style="margin-left: 25px;" id="divDescription" class="panel panel-default">
							<div class="panel-heading">申購注意事項：</div>
							<div class="panel-body">
								<ol>
									<li>傳送時間：本公司網路申購委託或取消每日以pm2:00為截止時點，pm2:00之後的申購納入次交易日資料，次日am10:00更新交易所回覆訊息。</li>
									<li>中籤查詢：抽籤日中午12:00後公佈 (視交易所轉檔作業而定)。</li>
									<li>申購帳號：自2010/10/18起，在股票申購平台上即可委託您在凱基證券開立的所有有效電子帳戶，在此提醒您，在委託申購送出前請務必確認申購帳號是否正確，以確保您的權益。
									</li>
									<li>申購人經向證券經紀商委託申購，申購後不得撤回或更改委託書、中籤後不能放棄認購及要求退還價款，申購前請審慎評估。</li>
									<li>同種股票，每一申購人僅能向一家證券經紀商辦理申購，重複申購即視為不合格件。</li>
									<li>申購人於<span
											style="color:#f00;">扣款日凌晨0點前</span>，確認交割帳戶中的存款餘額應有a.有價證券申購處理費(20元/件)b.認購價款(承銷價X股數)c.中籤通知郵寄工本費(50元/件)之合計金額供銀行執行扣款，否則為不合格件。
									</li>
									<li>申購人在同一日辦理二件（含）以上承銷案件之預扣價款者，應以各承銷案件之有價證券申購處理費、認購價款及中籤通知郵寄工本費之合計總額為準，否則均為不合格件。
									</li>
									<li>證券經紀商將於公開抽籤日次一營業日辦理退還未中籤（含不合格件）之申購人之預扣價款（無息退回中籤通知郵寄工本費及認購價款），但申購處理費不予退回。
									</li>
									<li>申購狀態說明
										<br><span style="font-weight:bold;">空白</span>：未達申購起日或未申購。
										<br><span style="font-weight:bold;">委託申購預約單</span>：按下【申購】按鈕進行申購，申購資料尚未傳送至交易所。
										<br><span style="font-weight:bold;">申購處理中</span>：已將申購資料傳送至交易所。
										<br><span style="font-weight:bold;">申購傳送成功</span>：交易所成功接單，委託成功。
										<br><span style="font-weight:bold;">申購期間已過</span>：已過申購迄日。
										<br><span style="font-weight:bold;">申購失敗</span>：申購資料有問題，請洽所屬營業員。
										<br><span style="font-weight:bold;">中籤</span>：此次申購已中籤。
										<br><span style="font-weight:bold;">未中籤</span>：此次申購未中籤。
									</li>
									<li>備註：撤銷→承銷商取消申購案件；修改→可能調整承銷價格與承銷股數的股票。</li>
									<li>TDR股票申購中籤及圈購獲配售之投資人需至證券商完成簽署「外國企業來台上市(上櫃)有價證券風險預告書」後始得賣出。且外國企業來臺第二上市（櫃）因上市(櫃)標準、資訊揭露內容與國內企業上市（櫃）仍有差異，提醒投資人應注意買賣TDR之風險。
									</li>
								</ol>
							</div>
						</div>
						
						<!-- 模态框（Modal） -->
						<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
							aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<h4 class="modal-title" style="left: 15px;">申購失敗原因</h4>
										<button type="button" class="bootbox-close-button close" data-dismiss="modal" aria-hidden="true">×</button>
									</div>
									<div class="modal-body">
										<div class="bootbox-body">
											<table style="border-style: dotted;border-color: coral;border: 3px;">
												<tbody>
													<tr>
														<th colspan="2" style="text-align:center;">證券戶號:</th>
														<td>${userStockID}</td>
													</tr>
													<tr>
														<th colspan="2" style="text-align:center;">股票代碼/名稱</th>
														<td id="a"></td>
													</tr>
													<tr>
														<th colspan="2" style="text-align:center;">承銷價格</th>
														<td id="b"></td>
													</tr>
													<tr>
														<th colspan="2" style="text-align:center;">申購股數</th>
														<td id="c"></td>
													</tr>
													<tr>
														<th colspan="2" style="text-align:center;">申購狀態</th>
														<td>申購失敗</td>
													</tr>
													<tr>
														<th colspan="2" style="text-align:center;">錯誤訊息說明</th>
														<td>申購資料有問題，請洽所屬營業員</td>
													</tr>
												</tbody>
											</table>
										</div>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-success" data-dismiss="modal">確定</button>
										<!-- <button data-bb-handler="success" type="button" class="btn btn-success">確定</button> -->
									</div>
								</div><!-- /.modal-content -->
							</div><!-- /.modal -->
						</div>

						<!-- <div id="myModal" class="bootbox modal fade in" tabindex="-1" role="dialog"
							style="display: block; padding-right: 16px;" aria-hidden="false">
							<div class="modal-backdrop fade in" style="height: 475px;"></div>
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header"><button type="button" class="bootbox-close-button close"
											data-dismiss="modal" aria-hidden="true">×</button>
										<h4 class="modal-title">申購失敗原因</h4>
									</div>
									<div class="modal-body">
										<div class="bootbox-body">
											<table class="tbl_order_fail_detail">
												<tbody>
													<tr>
														<th colspan="2" style="text-align:center;">證券戶號:${userStockID}
														</th>
													</tr>
													<tr>
														<th>股票代碼/名稱</th>
														<td>4976<br>佳凌</td>
													</tr>
													<tr>
														<th>承銷價格</th>
														<td>61</td>
													</tr>
													<tr>
														<th>申購股數</th>
														<td>1,000</td>
													</tr>
													<tr>
														<th>申購狀態</th>
														<td>申購失敗</td>
													</tr>
													<tr>
														<th>錯誤訊息說明</th>
														<td>申購資料有問題，請洽所屬營業員</td>
													</tr>
												</tbody>
											</table>
										</div>
									</div>
									<div class="modal-footer"><button data-bb-handler="success" type="button"
											class="btn btn-success">確定</button></div>
								</div>
							</div>
						</div> -->

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
							<script
								src="<c:url value='/back/vendor/datatables/dataTables.bootstrap4.min.js' />"></script>

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

											$('#dataTable').dataTable({ "aaSorting": [[6, "desc"]] });

											// var scriptsToLoad = [
											// 	"<c:url value='/back/vendor/datatables/jquery.dataTables.min.js' />",
											// 	"<c:url value='/back/vendor/datatables/dataTables.bootstrap4.min.js' />",
											// 	"<c:url value='/back/js/demo/datatables-demo.js' />"
											// ];

											// scriptsToLoad.forEach(function (src) {
											// 	var script = document.createElement('script');
											// 	script.src = src;
											// 	script.async = false;
											// 	document.body.appendChild(script);
											// });

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
											}
										}
									}
								});

								function buttionStateChange(rowPosition) {

									var row = $("table#dataTable tr").index($(rowPosition).closest("tr"));
									var subscriptionStockCode = $("table#dataTable").find("tr").eq(row).find("td").eq(0).text();
									var stockPrice = $("table#dataTable").find("tr").eq(row).find("td").eq(4).text();
									var stockQuantity = $("table#dataTable").find("tr").eq(row).find("td").eq(5).text();
									var userStockID = $("#userStockID").val();
									var userName = $("#userName").val();
									var remarks = $("table#dataTable").find("tr").eq(row).find("td").eq(13).text();
									var subscriptionStatus = $("table#dataTable").find("tr").eq(row).find("td").eq(3);

									//alert(userStockID);

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
											}
										});

										var xhr = new XMLHttpRequest();
										var subscriptionTime = new Date().getTime();

										xhr.open("Post", "<c:url value='/front/userView/insertOrupdate' />", true);
										xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
										//console.log("securitiesAccountID="+null+"&stockCode="+subscriptionStockCode+"&stockPrice="+stockPrice+"&stockQuantity="+stockQuantity.replace(",","")+"&subscriptionTime="+subscriptionTime);
										xhr.send("securitiesAccountID=" + userStockID + "&stockCode=" + subscriptionStockCode + "&stockPrice=" + stockPrice + "&stockQuantity=" + stockQuantity.replace(",", "") + "&subscriptionTime=" + subscriptionTime + "&userName=" + userName);
										xhr.onreadystatechange = function () {
											if (xhr.readyState == 4 && xhr.status == 200) {

												if (xhr.responseText) {
													Swal.fire({
														icon: 'success',
														title: 'All file has been deleted.',
														// showConfirmButton: false,
														// timer: 1500
													})
												} else {
													Swal.fire({
														// timer: 1500,
														icon: 'error',
														title: 'Oops...',
														text: 'Something went wrong!',
														// footer: '<a href="">Why do I have this issue?</a>'
													})
												}
												setTimeout(function () {
													//location.reload();
												}, 1500);

											}
										}
									} else if($(rowPosition).hasClass('btn-success')) {
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
											}
										});

										var xhr = new XMLHttpRequest();
										var subscriptionTime = new Date().getTime();

										xhr.open("Post", "<c:url value='/front/userView/delete' />", true);
										xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");



										//console.log("securitiesAccountID="+null+"&stockCode="+subscriptionStockCode+"&stockPrice="+stockPrice+"&stockQuantity="+stockQuantity.replace(",","")+"&subscriptionTime="+subscriptionTime);
										xhr.send("securitiesAccountID=" + userStockID + "&stockCode=" + subscriptionStockCode + "&stockPrice=" + stockPrice + "&stockQuantity=" + stockQuantity.replace(",", "") + "&subscriptionTime=" + subscriptionTime + "&userName=" + userName);
										xhr.onreadystatechange = function () {
											if (xhr.readyState == 4 && xhr.status == 200) {

												if (xhr.responseText) {
													Swal.fire({
														icon: 'success',
														title: 'All file has been deleted.',
														// showConfirmButton: false,
														// timer: 1500
													})
												} else {
													Swal.fire({
														// timer: 1500,
														icon: 'error',
														title: 'Oops...',
														text: 'Something went wrong!',
														// footer: '<a href="">Why do I have this issue?</a>'
													})
												}
												setTimeout(function () {
													//location.reload();
												}, 1500);

											}
										}
									}
								}

								function ShowFailData(rowPosition){
									var row = $("table#dataTable tr").index($(rowPosition).closest("tr"));
									var subscriptionStockCode = $("table#dataTable").find("tr").eq(row).find("td").eq(0).text();
									var stockPrice = $("table#dataTable").find("tr").eq(row).find("td").eq(4).text();
									var stockQuantity = $("table#dataTable").find("tr").eq(row).find("td").eq(5).text();
									var userStockID = $("#userStockID").val();
									var userName = $("#userName").val();
									var stockName =  $("table#dataTable").find("tr").eq(row).find("td").eq(1).text();

									$('#a').val(subscriptionStockCode+"/"+stockName);
									$('#b').val(stockPrice);
									$('#c').val(stockQuantity);

								}

								// function ShowOrderFailDetail() {

								// 	var htmlOrderFailDesc =
								// 		"<table class='tbl_order_fail_detail'>" +
								// 		"<tr><th colspan='2' style='text-align:center;'>帳號:"  + "-"  + "</th></tr>" +
								// 		"<tr><th>股票代碼/名稱</th><td>"  + "<br>" + "</td></tr>" +
								// 		"<tr><th>承銷價格</th><td>" + "</td></tr>" +
								// 		"<tr><th>申購股數</th><td>"  + "</td></tr>" +
								// 		"<tr><th>申購狀態</th><td>" +  "</td></tr>" +
								// 		"<tr><th>錯誤訊息說明</th><td>" +  "</td></tr>" +
								// 		"</table>";

								// 	bootbox.dialog({
								// 		title: "申購失敗原因",
								// 		message: htmlOrderFailDesc,
								// 		buttons: {
								// 			success: {
								// 				label: "確定",
								// 				className: "btn-success",
								// 				callback: function () {
								// 					return;
								// 				}
								// 			}
								// 		}
								// 	});
								// }
							</script>
		</body>

		</html>