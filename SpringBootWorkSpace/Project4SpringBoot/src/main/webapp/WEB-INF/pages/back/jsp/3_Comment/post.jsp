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

<title>Post</title>

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
    <style>
        .pic {
            overflow: hidden;
        }

        .pic img {
            transform: scale(1, 1);
            transition: all 1s ease-out;
        }

        .pic img:hover {
            transform: scale(1.2, 1.2);
        }
        
        
        
    </style>
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
					<h1 class="h3 mb-2 text-gray-800">文章管理</h1>
					<br>
					<p class="mb-4">歡迎來到討論區後台管理頁面 !</p>
					<!-- form -->
					<div class="border border-secondary rounded bg-white">
						<form method="POST" enctype="multipart/form-data" class="p-4"
							style="background-color: rgba(230, 230, 230, 0.911);" id="form">
							<!-- Content -->
							<div class="table">
								<h1 class="h3 mb-2 text-gray-800">管理者發文</h1>
								<br>
								<div class="col-8 form-group row" hidden>

									<label class="col-sm-2 col-form-label text-primary">管理者</label>
									<div class="col-sm-9">
										<input type="text" class="form-control" name="userid" value="admin"
											id="userid"><br> <span
											id="resultMsg1" style="height: 18px; font-weight: bold;"></span>
									</div>
									<br>
								</div>
								<div class="col-8 form-group row">
									<label class="col-sm-2 col-form-label text-primary">標題</label>
									<div class="col-sm-9">
										<input type="text" class="form-control" placeholder="管理者發文標題:"
											name="title" id="title"><br> <span
											id="resultMsg2" style="height: 18px; font-weight: bold;"></span>
									</div>
								</div>
								<div class="col-8 form-group row">
									<label class="col-sm-2 col-form-label text-primary">類型</label>
									<div class="col-sm-9">
										<input type="text" class="form-control" value="公告"
											name="postType" id="postType" readonly><br>
									</div>
								</div>
								<div class="col-8 form-group row">

									<label class="col-sm-2 col-form-label text-primary">文章內容</label>
									<div class="col-sm-9">
										<textarea class="form-control" rows="8" name="post" id="post"
											placeholder="在此輸入內容..."></textarea>
										<br> <span id="resultMsg3"
											style="height: 18px; font-weight: bold;"></span>
									</div>
								</div>
								<div style="display: none;" class="col-8 form-group row">
									<label class="col-sm-2 col-form-label text-primary">發文時間</label>
									<div class="col-sm-9">
										<input type="text" class="form-control"
											placeholder="yyyy-MM-dd" name="ptime" id="ptime"><br>
									</div>
								</div>
								<div class="col-8 form-group row">
									<label class="col-sm-2 col-form-label text-primary">圖片</label>
									<div class="col-sm-9">
										<!--  img src="" class="img-thumbnail" alt="" id="ppicture"-->
										<input type="file" class="img-thumbnail" name="pictureFile"
											id="pictureFile" />
									</div>
								</div>
							</div>
							<br> <br> <br>
							<center>
								<div id="resultMsg4" style="height: 18px; font-weight: bold;"></div><br>
								<input type="button" class="btn btn-primary" id="btnIns"
									value="送出">
							</center>
						</form>
					</div>
					<br>
					<hr class="mb-4">
					<p class="mb-4">管理者可以在此頁面尋找所有使用者的發文，點擊按鈕可編輯文章及查看該文章內的所有留言。</p>

					<!-- DataTales Example -->
					<div class="card shadow mb-4">
						<div class="card-header py-3">
							<h6 class="m-0 font-weight-bold text-primary">文章列表</h6>
						</div>
						<div class="card-body">
							<div class="table-responsive">
								<table class="table table-bordered pic" id="dataTable" width="100%"
									cellspacing="0" style="word-wrap: break-word;">
									<thead>
										<tr>
											<th style="width: 2cm;">文章編號</th>
											<th style="width: 2cm;">發文者</th>
											<th>標題</th>
											<th style="width: 4cm;">發文時間</th>
											<th style="width: 6cm;">圖片</th>
											<th style="width: 2cm;">類型</th>
											<th style="width: 2cm;">編輯</th>
										</tr>
									</thead>
									<tfoot>
										<tr>
											<th>文章編號</th>
											<th>發文者</th>
											<th>標題</th>
											<th>發文時間</th>
											<th>圖片</th>
											<th>類型</th>
											<th>編輯</th>
										</tr>
									</tfoot>
									<tbody id="dataArea01">

									</tbody>
								</table>
							</div>
						</div>
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

	<!-- Page level plugins -->
	<%-- <script src="<c:url value='/back/vendor/datatables/jquery.dataTables.min.js' />">
							</script> --%>
	<%-- <script src="<c:url value='/back/vendor/datatables/dataTables.bootstrap4.min.js' />">
								</script> --%>

	<!--     Page level custom scripts -->
	<%-- <script src="<c:url value='/back/js/demo/datatables-demo.js' />">
									</script> --%>



	<script>
	// Sidebar
    $("#PostSidebar,#PostActive").addClass('active')
	
		const formData = new FormData(document.getElementById('form'));
		var btnIns = document.getElementById("btnIns");
		var btnUpd = document.getElementById("btnUpd");

		window.onload = function() {

			//秀出全部文章
			var xhr0 = new XMLHttpRequest();
			var url = "<c:url value = '/showAllPost '/>";
			xhr0.open("GET", url);
			xhr0.send();
			xhr0.onreadystatechange = function() {
				if (xhr0.readyState == 4 && xhr0.status == 200) {
					var map = JSON.parse(xhr0.responseText);
					var segment = ""
					var posts = map.posts;
					for ( var x in posts) {
						tmp = "<c:url value='/postedit/' />";
						var post = posts[x]
						segment += "<tr>"
						segment += "<td>" + post.post_num + "</td>"
						segment += "<td>" + post.userid + "</td>"
						segment += "<td>" + post.title + "</td>"
						segment += "<td>" + post.ptime + "</td>"
						segment += "<td><img width='240' height='180' src='" + post.pictureString + "' ></td>"
						segment += "<td>" + post.postType + "</td>"
						segment += "<td><a href='" + tmp + posts[x].post_num + "'><input type='button' value='編輯文章' id='btnUpd'></a></td>"
						segment += "</tr>"
// 							<a href='" + tmp + posts[x].post_num + "'><input type='button' value='編輯文章' id='btnUpd'></a>
					}

					var dataArea01 = document.getElementById("dataArea01");
					dataArea01.innerHTML = segment;
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
		}

		btnIns.onclick = function() {
			console.log(12365);
			var useridValue = document.getElementById("userid").value;
			var titleValue = document.getElementById("title").value;
			var postTypeValue = document.getElementById("postType").value;
			var postValue = document.getElementById("post").value;
			var divResult1 = document.getElementById('resultMsg1');
			var divResult2 = document.getElementById('resultMsg2');
			var divResult3 = document.getElementById('resultMsg3');
			var divResult4 = document.getElementById('resultMsg4');
			var hasError = false;

			if (!useridValue) {
				divResult1.innerHTML = "<font color='red' size='4'>管理者不得為空</font>";
				hasError = true;
			} else {
				divResult1.innerHTML = "";
			}
			if (!titleValue) {
				divResult2.innerHTML = "<font color='red' size='4'>標題不得為空</font>";
				hasError = true;
			} else {
				divResult2.innerHTML = "";
			}
			if (!postValue) {
				divResult3.innerHTML = "<font color='red' size='4'>文章內容不得為空</font>";
				hasError = true;
			} else {
				divResult3.innerHTML = "";
			}
			if (hasError) {
				return false;
			}
			// 											console.log("ptimeValue="+ptimeValue);
			// 測試用
			// 											var xhr2 = new XMLHttpRequest();
			// 											xhr2.open("POST", "<c:url value='/post/getImgFile'/>");
			// 											//	xhr2.setRequestHeader("Content-Type", "multipart/form-data");
			// 											var myForm = new FormData();
			// 											console.log($("#pictureFile"))
			// 											myForm.append("imgFile", $("#pictureFile")[0].files[0])		
			// 											myForm.append("userid", useridValue)		
			// 											myForm.append("title", titleValue)		
			// 											myForm.append("postType", postTypeValue)		
			// 											myForm.append("post", postValue)		
			// 											myForm.append("ptime", ptimeValue)		
			// 											xhr2.send(myForm);
			//------END------------

			var xhr1 = new XMLHttpRequest();
			var url = "<c:url value = '/postinsert '/>";
			xhr1.open("POST", url);
			var myForm = new FormData();

			console.log($("#pictureFile"))

			myForm.append("imgFile", $("#pictureFile")[0].files[0])
			myForm.append("userid", useridValue)
			myForm.append("title", titleValue)
			myForm.append("postType", postTypeValue)
			myForm.append("post", postValue)
			console.log("myForm=" + myForm);
			console.log("imgFile的值=" + $("#pictureFile")[0].files[0]);

			xhr1.send(myForm);

			xhr1.onreadystatechange = function() {
				// 伺服器請求完成
				if (xhr1.readyState == 4
						&& (xhr1.status == 200 || xhr1.status == 201)) {
					result = JSON.parse(xhr1.responseText);
					if (result.fail) {
						divResult4.innerHTML = "<font color='red' >"
								+ result.fail + "</font>";
						Swal.fire({
							// timer: 1500,
							icon : 'error',
							title : 'Oops...',
							text : '文章發送有問題!',
						// footer: '<a href="">Why do I have this issue?</a>'
						})
					} else if (result.success) {
						divResult4.innerHTML = "<font color='GREEN'>"
								+ result.success + "</font>";
						Swal.fire({
							icon : 'success',
							title : '文章成功送出',
						// showConfirmButton: false,
						// timer: 1500
						})
						setTimeout(function() {
							// 自己會載入頁面
							location.reload();
						}, 1500);
						
// 						document.location.href = "<c:url value='/post' />";
					}
				}
			}
		}
	</script>


</body>

</html>