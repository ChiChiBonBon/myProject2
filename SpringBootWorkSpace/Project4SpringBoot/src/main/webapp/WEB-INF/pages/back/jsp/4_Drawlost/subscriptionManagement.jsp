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
<link href="<c:url value='/back/css/sb-admin-2.min.css' />"
	rel="stylesheet">

<!-- Custom styles for this page -->
<link
	href="<c:url value='/back/vendor/datatables/dataTables.bootstrap4.min.css' />"
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
						<h1 class="h3 mb-1 text-gray-800">申購管理</h1>
						<a href="<c:url value='/pa/downloadCsv' />" id="downloadCsv"
							class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
							<i class="fas fa-download fa-sm text-white-50"></i> 產生報表
						</a>
					</div>

					<!-- Table -->
					<!-- Table Upolad-->
					<div class="card shadow mb-4">
						<div class="card-header">
							<div class="input-group w-50">
								

							</div>
						</div>

						<!-- Table Content-->
						<div class="card-body">
							<div class="table-responsive">
								<table class="table table-bordered tableArea" id="" width="100%"
									cellspacing="0">
									<thead>
										<tr>
											<th>證券戶號</th>
											<th>客戶名稱</th>
<!-- 											<th>身份證字號</th> -->
<!-- 											<th>密碼</th> -->
											<th>申購的股票</th>
											<th>申購價格</th>
											<th>申購股數</th>
											<th>交割戶餘額</th>
											<th>是否可抽籤</th>
											<th>有無中籤</th>
											<th>流程狀態</th>
											<th>申購時間</th>
											<th>備註</th>
											<th width="80px">修改 / 刪除</th>
										</tr>
									</thead>
									<tfoot>
										<tr>
											<th>證券戶號</th>
											<th>客戶名稱</th>
<!-- 											<th>身份證字號</th> -->
<!-- 											<th>密碼</th> -->
											<th>申購的股票</th>
											<th>申購價格</th>
											<th>申購股數</th>
											<th>交割戶餘額</th>
											<th>是否可抽籤</th>
											<th>有無中籤</th>
											<th>流程狀態</th>
											<th>申購時間</th>
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
		$(function() {
			// Sidebar
			$("#Subscription_Management, #DS").addClass('active')
			$("#collapseDS").addClass('show')

			// Select All Data
			var xhr = new XMLHttpRequest();
			xhr.open("GET", "<c:url value='/back/subscription/selectAll' />",
					true);
			xhr.send()
			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4 && xhr.status == 200) {
					$('#dataArea').html(showAll(xhr.responseText))
					$('.tableArea').attr('id', 'dataTable')

					// $.getScript("<c:url value='/back/vendor/datatables/jquery.dataTables.min.js' />");
					// $.getScript("<c:url value='/back/vendor/datatables/dataTables.bootstrap4.min.js' />");
					// $.getScript("<c:url value='/back/js/demo/datatables-demo.js' />");
					var scriptsToLoad = [
							"<c:url value='/back/vendor/datatables/jquery.dataTables.min.js' />",
							"<c:url value='/back/vendor/datatables/dataTables.bootstrap4.min.js' />",
							"<c:url value='/back/js/demo/datatables-demo.js' />" ];

					scriptsToLoad.forEach(function(src) {
						var script = document.createElement('script');
						script.src = src;
						script.async = false;
						document.body.appendChild(script);
					});
				}
			}
			
			 // Update Data
            $('tbody').on('click', '#update', function () {
                var x = $(this).parent().parent().index()
                var paID = $(".idX")[x].textContent
                console.log(paID)
                Swal.fire({
                    template: '#my-update' + paID
                }).then((result) => {
                    if (result.isDenied) {
                        location.replace("<c:url value='/back/subscription/update/' />" + paID);
                    }
                })
            })
			
			function showAll(text) {
                var beans = JSON.parse(text);
                var segment = ""

                for (var x in beans) {
                    var bean = beans[x]
                    var buttonX =
                        `<span href="#" class="btn btn-warning btn-circle btn-sm" id="update">
        <i class="fas fa-exclamation-triangle"></i>
        <template id="my-update`+ bean.securitiesAccountID + `">
            <swal-title>
            你確定要修改` + bean.securitiesAccountID + `?
            </swal-title>
            <swal-icon type="warning" color="red"></swal-icon>
            <swal-button type="confirm">
            取消
            </swal-button>
            <swal-button type="deny">
            修改
            </swal-button>
            <swal-param name="allowEscapeKey" value="false" />
            <swal-param
            name="customClass"
            value='{ "popup": "my-popup" }' />
        </template>
    </span>
    &nbsp;&nbsp;
    <span" class="btn btn-danger btn-circle btn-sm" id="delete">
        <i class="fas fa-trash"></i>
        <template id="my-delete`+ bean.securitiesAccountID + `">
            <swal-title>
            你確定要刪除 `+ bean.securitiesAccountID + ` ?
            </swal-title>
            <swal-icon type="warning" color="red"></swal-icon>
            <swal-button type="confirm">
            取消
            </swal-button>
            <swal-button type="deny">
            刪除
            </swal-button>
            <swal-param name="allowEscapeKey" value="false" />
            <swal-param
            name="customClass"
            value='{ "popup": "my-popup" }' />
        </template>
    </span>`



                    segment += "<tr>"
                    segment += "<td class='idX'>" + bean.securitiesAccountID + "</td>"
                    segment += "<td>" + bean.customerName + "</td>"
                    //segment += "<td>" + bean.companyLogo + "</td>"
                    //segment += "<td>" + bean.identityNumber + "</td>"
                    //segment += "<td>" + bean.password + "</td>"
                    segment += "<td>" + bean.stockCode + "</td>"
                    segment += "<td>" + bean.stockPrice + "</td>"
                    segment += "<td>" + bean.stockQuantity + "</td>"
                    segment += "<td>" + bean.banlance + "</td>"       
                    segment += "<td>" + bean.drawable + "</td>"
                    segment += "<td>" + bean.drawStatus + "</td>"
                    segment += "<td>" + bean.processStatus + "</td>"
                    segment += "<td>" + bean.subscriptionTime + "</td>"
                    segment += "<td>" + bean.remarks + "</td>"
                    segment += "<td>" + buttonX + "</td>"
                    segment += "</tr>"
                }
                return segment;
            }
			
			// Delete Data
            $('tbody').on('click', '#delete', function () {
                var x = $(this).parent().parent().index()
                var paID = $(".idX")[x].textContent
                console.log(paID)
                Swal.fire({
                    template: '#my-delete' + paID
                }).then((result) => {
                    if (result.isDenied) {
                        Swal.fire({
                            title: 'Delete ' + paID + ' Please Wait......'
                        });
                        Swal.showLoading();

                        var xhr = new XMLHttpRequest();
                        xhr.open("POST", "<c:url value='/back/subscription/delete' />", true);
                        xhr.setRequestHeader('Content-Type', "application/x-www-form-urlencoded");
                        xhr.send("id=" + paID);
                        xhr.onreadystatechange = function () {
                            if (xhr.readyState == 4 && xhr.status == 200) {

                                if (xhr.responseText) {
                                    Swal.fire({
                                        icon: 'success',
                                        title: paID + ' has been deleted.',
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
                                    location.reload();
                                }, 1500);

                            }
                        }
                    }
                })
            })
			
			function numberWithCommas(x) {
                return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
            }

		})
	</script>

</body>

</html>