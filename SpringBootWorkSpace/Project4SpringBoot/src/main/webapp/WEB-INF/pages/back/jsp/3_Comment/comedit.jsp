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

<title>commentedit</title>

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
					<h1 class="h3 mb-4 text-gray-800">編輯留言</h1>
					<center>
						<span id='resultMsg' style="height: 18px; font-weight: bold;"></span>
					</center>
					<!-- form -->
					<div class="border border-secondary rounded bg-white">
						<form class="p-4" id="form">
							<!-- ID -->
							<div class="col-8 form-group row">
								<label class="col-sm-2 col-form-label text-primary">留言者</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" value="${bean.userid}"
										id="userid" readonly>
								</div>
							</div>

							<div class="col-8 form-group row">
								<label class="col-sm-2 col-form-label text-primary">留言內容</label>
								<div class="col-sm-9">
									<textarea class="form-control" rows="3" id="comment" readonly>${bean.comment}</textarea>
								</div>
							</div>
							<div class="col-8 form-group row">
								<label class="col-sm-2 col-form-label text-primary">留言時間</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" value="${bean.ctime}"
										id="ctime" readonly>
								</div>
							</div>
							<div class="col-8 form-group row" hidden>
								<label class="col-sm-2 col-form-label text-primary">圖片</label>
								<div class="col-sm-9">
									<!--<img src="" class="img-thumbnail" alt="" id="cpicture"> -->
									<input type="file" class="img-thumbnail" name="pictureFile"
										id="pictureFile" />
								</div>
							</div>
					</div>
					<br> <br> <br>
					<center>
								<span id="btnDel">
								<a class="btn btn-danger btn-icon-split "> 
									<span class="icon text-white-50">
								 		<i class="fas fa-trash"></i>
									</span>
									<span class="text">刪除留言</span>
										<template id="deleteAll-template">
											<swal-title> 你確定要刪除此留言? </swal-title>
											<swal-icon type="warning" color="red"></swal-icon>
											<swal-button type="confirm"> 取消 </swal-button>
											<swal-button type="deny"> 刪除 </swal-button>
											<swal-param name="allowEscapeKey" value="false" />
											<swal-param name="customClass"
												value='{ "popup": "my-popup" }' />
										</template>
								</a>
								</span>
					</center>
					</form>
					<!-- 返回前頁 Button -->
					<div class="mt-5 float-right">
						<a href="<c:url value='/post' />"
							class="btn btn-secondary btn-icon-split"> <span
							class="icon text-white-50"> <i class="fas fa-arrow-right"></i>
						</span> <span class="text">返回文章區</span>
						</a>
					</div>



				</div>
				<!-- /.container-fluid -->

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

	<!-- SweetAlert2 -->
	<script src="<c:url value='/back/js/sweetalert2@11.js' />"></script>

	<script>
	// Sidebar
	$("#PostSidebar,#PostActive").addClass('active')
        var btnDel = document.getElementById("btnDel");
        var divResult = document.getElementById('resultMsg');

    $('#btnDel').on('click', function(){
        Swal.fire({
            template: '#deleteAll-template'
        }).then((result)=> {
            if (result.isDenied) {
                Swal.fire({
                    title: 'Upload File Please Wait......'
                });
                Swal.showLoading();                         

                var xhr3 = new XMLHttpRequest();
                xhr3.open("DELETE", "<c:url value='/deletecomment/" + ${bean.comment_num} + "'/>", true);
                xhr3.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
                xhr3.send();
                xhr3.onreadystatechange = function() {
                    if (xhr3.readyState == 4 && (xhr3.status == 200 || xhr3.status == 204)) {
                    	result = JSON.parse(xhr3.responseText);
                        if(result.success){
                            Swal.fire({
                                icon: 'success',
                                title: '留言已成功刪除',
                                // showConfirmButton: false,
                                // timer: 1500
                            })
                        }else{
                            Swal.fire({
                                // timer: 1500,
                                icon: 'error',
                                title: 'Oops...',
                                text: '刪除時發生問題!',
                                // footer: '<a href="">Why do I have this issue?</a>'
                            })
                        } 
                        setTimeout(function(){
                        	window.location.href = "<c:url value='/post'/>"
                        },1500);
                       
                    }
                }        
            }
        })
    })
    </script>

</body>

</html>