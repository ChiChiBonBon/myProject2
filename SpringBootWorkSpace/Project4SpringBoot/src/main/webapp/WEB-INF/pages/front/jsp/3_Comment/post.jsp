<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>STOCK OVERFLOW</title>
<meta content="" name="description">
<meta content="" name="keywords">

<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
	rel="stylesheet">

<!-- Vendor CSS Files -->
<link
	href="<c:url value='/front/assets/vendor/animate.css/animate.min.css' />"
	rel="stylesheet">
<link
	href="<c:url value='/front/assets/vendor/bootstrap/css/bootstrap.min.css' />"
	rel="stylesheet">
<link
	href="<c:url value='/front/assets/vendor/bootstrap-icons/bootstrap-icons.css' />"
	rel="stylesheet">
<link
	href="<c:url value='/front/assets/vendor/boxicons/css/boxicons.min.css' />"
	rel="stylesheet">
<link
	href="<c:url value='/front/assets/vendor/glightbox/css/glightbox.min.css' />"
	rel="stylesheet">
<link
	href="<c:url value='/front/assets/vendor/swiper/swiper-bundle.min.css' />"
	rel="stylesheet">

<!-- Template Main CSS File -->
<link href="<c:url value='/front/assets/css/styleforComment.css' />"
	rel="stylesheet">
<style>
.ellipsis {
	overflow: hidden;
	white-space: nowrap;
	text-overflow: ellipsis;
	display: -webkit-box;
	-webkit-line-clamp: 10;
	-webkit-box-orient: vertical;
	white-space: normal;
}
</style>
</head>

<body>

	<!-- ======= A01 Top Bar ======= -->
	<%@include file="/WEB-INF/pages/front/jsp/0_Util/TopBar.jsp"%>

	<!-- ======= A02 Header ======= -->
	<%@include file="/WEB-INF/pages/front/jsp/0_Util/Header.jsp"%>

	<!-- Main -->
	<main id="main">
		<!-- ======= Breadcrumbs ======= -->
		<section id="breadcrumbs" class="breadcrumbs">
			<div class="container">

				<ol>
					<li><a href="<c:url value='/front' />">Home</a></li>
					<li><a href="<c:url value='/front/post' />">?????????</a></li>
				</ol>
				<h2>?????????</h2>

			</div>
		</section>
		<!-- End Breadcrumbs -->

		<!-- ======= Blog Section ======= -->
		<section id="blog" class="blog">

			<div class="container" data-aos="fade-up">
				<h1>???????????????????????????~~</h1>
				<br>
				<div class="row">

					<div class="col-lg-8 entries">
						<a class="btn btn-danger" data-bs-toggle="collapse"
							href="#collapseExample" role="button" aria-expanded="false"
							aria-controls="collapseExample"> ?????????????????????~ </a><br> <br>
						<div class="collapse" id="collapseExample">

							<form method="POST" enctype="multipart/form-data" class="p-4"
								id="form">
								<!-- Content -->
								<div class="card card-body">
									<div class="col-10 form-group row">
										<label class="col-sm-2 col-form-label text-danger">?????????</label>
										<div class="col-sm-9">
											<input type="text" class="form-control" name="title"
												value="${userid}" id="userid" readonly> <br>
										</div>
									</div>
									<div class="col-10 form-group row">
										<label class="col-sm-2 col-form-label text-danger">??????</label>
										<div class="col-sm-9">
											<input type="text" class="form-control" placeholder="????????????:"
												name="title" id="title"> <span id="resultMsg1"
												style="height: 18px; font-weight: bold;"></span><br>
										</div>
									</div>
									<div class="col-10 form-group row">
										<label class="col-sm-2 col-form-label text-danger">??????</label>
										<div class="col-sm-9">
											<input type="text" class="form-control" placeholder="???:??????"
												name="postType" id="postType"><span id="resultMsg2"
												style="height: 18px; font-weight: bold;"></span><br>
										</div>
									</div>
									<div class="col-10 form-group row">

										<label class="col-sm-2 col-form-label text-danger">????????????</label>
										<div class="col-sm-9">
											<textarea class="form-control" rows="8" name="post" id="post"
												placeholder="??????????????????..."></textarea>
											<span id="resultMsg3"
												style="height: 18px; font-weight: bold;"></span><br>
										</div>
									</div>
									<div class="col-10 form-group row">
										<label class="col-sm-2 col-form-label text-danger">??????</label>
										<div class="col-sm-9">
											<!--  img src="" class="img-thumbnail" alt="" id="ppicture"-->
											<input type="file" class="img-thumbnail" name="pictureFile"
												id="pictureFile" style="color: #e96b56;" />
										</div>
									</div>
									<br>
									<center>
										<div id="resultMsg4" style="height: 18px; font-weight: bold;"></div>
										<br> <input type="button" class="btn btn-danger"
											id="btnIns" value="????????????">&nbsp;&nbsp;
											<input type="button" class="btn btn-danger"
											id="key" value="????????????">
									</center>
								</div>
							</form>
						</div>

						<div id="dataArea01"></div>


					</div>
					<!-- End blog entries list -->

					<!-- Sidebar -->
					<div class="col-lg-4">

						<div class="sidebar">


							<h3 class="sidebar-title">??????</h3>
							<div class="sidebar-item categories">
								<ul>
									<li><a class="stock">??????</a></li>
									<li><a class="stock">??????</a></li>
									<li><a class="stock">??????</a></li>
									<li><a class="stock">??????</a></li>
									<li><a class="stock">??????</a></li>
									<li><a class="stock">????????????</a></li>
								</ul>
							</div>
							<!-- End sidebar categories-->

							<h3 class="sidebar-title">????????????</h3>
							<div class="sidebar-item recent-posts">

								<div class="post-item clearfix">
									<img src="<c:url value='/front/assets/img/(??????)??????.jpg' />"
										alt="" style="max-height: 60px;">
									<h4>
										<a href="blog-single.html">?????????????????????????????? ????????????Top 10?????????</a>
									</h4>
									<time datetime="2021-07-19">2021-07-19</time>
								</div>
								<div class="post-item clearfix">
									<img src="<c:url value='/front/assets/img/(??????)??????.png' />"
										alt="" style="max-height: 60px;">
									<h4>
										<a href="blog-single.html">??????????????????????????????18000????????????????????????????????????</a>
									</h4>
									<time datetime="2021-07-18">2021-07-18</time>
								</div>
								<div class="post-item clearfix">
									<img src="<c:url value='/front/assets/img/(??????)????????????.jpg' />"
										alt="" style="max-height: 60px;">
									<h4>
										<a href="blog-single.html">???????????????????????? ?????????????????????????????????</a>
									</h4>
									<time datetime="2021-07-18">2021-07-18</time>
								</div>

							</div>
							<!-- End sidebar recent posts-->

						</div>
						<!-- End sidebar -->

					</div>
					<!-- End blog sidebar -->

				</div>

			</div>
		</section>
		<!-- End Blog Section -->

	</main>

	<!-- End #main -->

	<!-- ======= A04 Footer ======= -->
	<%@include file="/WEB-INF/pages/front/jsp/0_Util/Footer.jsp"%>

	<!-- script -->
	<!-- Vendor JS Files -->
	<script
		src="<c:url value='/front/assets/vendor/bootstrap/js/bootstrap.bundle.min.js' />"></script>
	<script
		src="<c:url value='/front/assets/vendor/glightbox/js/glightbox.min.js' />"></script>
	<script
		src="<c:url value='/front/assets/vendor/isotope-layout/isotope.pkgd.min.js' />"></script>
	<script
		src="<c:url value='/front/assets/vendor/php-email-form/validate.js' />"></script>
	<script
		src="<c:url value='/front/assets/vendor/purecounter/purecounter.js' />"></script>
	<script
		src="<c:url value='/front/assets/vendor/swiper/swiper-bundle.min.js' />"></script>
	<script
		src="<c:url value='/front/assets/vendor/waypoints/noframework.waypoints.js' />"></script>
	<!-- Template Main JS File -->
	<script src="<c:url value='/front/assets/js/main.js' />"></script>

	<!-- JQuery -->
	<script src="<c:url value='/front/assets/js/jquery-3.6.0.slim.js' />"></script>

	<!-- SweetAlert2 -->
	<script src="<c:url value='/back/js/sweetalert2@11.js' />"></script>

	<script type="text/javascript">
		$(function() {
			$('#header_post').addClass('active')
		})
	</script>

	<script>
		const formData = new FormData(document.getElementById('form'));
		var btnIns = document.getElementById("btnIns");
		var btnUpd = document.getElementById("btnUpd");
		var btnSingle = document.getElementById("btnSingle");
		var forumCon = document.getElementById("forumCon");
		var dataArea01 = document.getElementById("dataArea01");
		var key = document.getElementById("key");

		function unpackForContent(text) {
			let content = JSON.parse(text);
			return content;
		}
		
		
		
		key.onclick = function(){
			let content = 
				"???????????????19?????????????????????????????????????????????????????????????????????2609??????????????????????????????????????????????????????????????????????????????????????????196.5???????????????20???????????????12????????????????????????????????????????????????\n\n"+ 

				"??????????????????????????????????????????????????????????????????????????????16???????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????193???????????????????????????196.5??????\n\n"+

				"?????????????????????????????? 2615 ??????????????????????????????????????? 2603 ?????????????????????21???????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????293???????????????????????????297???????????????186????????????\n\n"+

				"?????????????????????????????????????????????????????????????????????????????????????????? 8 ????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????";
							
				
				
			document.getElementById("title").value = "????????????????????? ?????????????????????????????????????????????";
			document.getElementById("postType").value = "??????";
			document.getElementById("post").value = content;
				
				
		}

		window.onload = function() {
			//??????????????????
			var xhr0 = new XMLHttpRequest();
			var url = "<c:url value = '/front/showAllPost '/>";
			xhr0.open("GET", url);
			xhr0.onreadystatechange = function() {
				if (xhr0.readyState == 4 && xhr0.status == 200) {
					console.log(xhr0.responseText);
					dataArea01.innerHTML = showData(xhr0.responseText);
				}
			}
			xhr0.send();

			$('.stock')
					.on(
							'click',
							function() {
								let index = $(this).parent().index();
								console.log(index)
								let stockValue = $('.stock')[index].textContent;
								console.log(stockValue)

								let xhr2 = new XMLHttpRequest();
								xhr2.open('GET',
										"<c:url value='/queryBypostType' />?postType="
												+ stockValue);
								xhr2.send();
								xhr2.onreadystatechange = function() {
									if (xhr2.readyState == 4
											&& xhr2.status == 200) {
										console.log(JSON
												.parse(xhr2.responseText));
										console.log(15644456);
										console
												.log(showData(xhr2.responseText))
										dataArea01.innerHTML = showData(xhr2.responseText);
									}
								}
							})

		}
		// ????????????-------------------------------------------------
		//         		query.addEventListener('click', function() {
		//         			let rname = restname.value;
		//         			if (!rname) {
		//         				alert('?????????????????????????????????????????????')
		//         				return;
		//         			}
		//         			let xhr2 = new XMLHttpRequest();
		//         			xhr2.open('GET', "<c:url value='/queryByName' />?rname=" + rname);
		//         			xhr2.send();
		//         			xhr2.onreadystatechange = function() {
		//         				if (xhr2.readyState == 4 && xhr2.status == 200) {
		//         						dataArea.innerHTML = showData(xhr2.responseText);
		//         				}
		//         			}

		//         		})
		//         		------------------------------------------------------------

		function showData(textObj) {
			console.log(123126321213)
			var map = JSON.parse(textObj);
			var segment = ""
			var posts = map.posts;
				
			for ( var x in posts) {
				tmp = "<c:url value='/front/singlepost/' />";
				tmp1 = "<c:url value='/front/postedit/' />";
				var post = posts[x]

				//=================================================================================
				var stringData = post.post;
				// ????????????replace??????post.post??????????????? ?????????????????????\n??????HTML?????????????????????<br/>
				// ??????????????????HTML??????
				var newData = stringData.replace(new RegExp('\n', 'g'),
						'<br />');
				//=================================================================================

				console.log(stringData);
				segment += "<article class='entry' style = 'background-color: rgb(255, 239, 221);' >"
				if(post.userid=="${userid}"){
					console.log("==OK")
					segment += "<span><a href='" + tmp1 + posts[x].post_num + "'><button style='float: right;opacity: 0.7;'><i class='bi bi-pen'></i></button></a></span>"
				}else{
					console.log("==not")
					segment += "<span><a href='" + tmp1 + posts[x].post_num + "'><button style='float: right;opacity: 0.7;'hidden><i class='bi bi-pen'></i></button></a></span>"
				}
				segment += "<div class='entry-img' style='text-align: center;'><br>"
				segment += "<img src='" + post.pictureString + "' class='img-fluid'></div>"
				segment += "<h2 class='entry-title'><a href='" + tmp + posts[x].post_num + "'>"
						+ post.title + "</a></h2>"
				segment += "<div class='entry-meta'><ul><li class='d-flex align-items-center'><i class='bi bi-person'></i>"
				segment += "<a href='blog-single.html'>" + post.userid
						+ "</a></li>"
				segment += "<li class='d-flex align-items-center'><i class='bi bi-clock'></i>"
						+ post.ptime + "</li></ul></div>"
				//                       segment += "<li class='d-flex align-items-center'><i class='bi bi-chat-dots'></i>" + posts.length() + "?????????</li></ul></div>"
				segment += "<div class='entry-content'><p class='ellipsis'>"
						+ newData + "</p>"
				segment += "<div class='read-more'><a href='" + tmp + posts[x].post_num + "'>????????????</a></div></div></article>"
				
					
			}
			return segment;
			
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

			if (!titleValue) {
				divResult1.innerHTML = "<font color='red' size='4'>??????????????????</font>";
				hasError = true;
			} else {
				divResult1.innerHTML = "";
			}
			if (!postTypeValue) {
				divResult2.innerHTML = "<font color='red' size='4'>??????????????????</font>";
				hasError = true;
			} else {
				divResult2.innerHTML = "";
			}
			if (!postValue) {
				divResult3.innerHTML = "<font color='red' size='4'>????????????????????????</font>";
				hasError = true;
			} else {
				divResult3.innerHTML = "";
			}
			if (hasError) {
				return false;
			}

			var xhr1 = new XMLHttpRequest();
			var url = "<c:url value='/front/postinsert' />";
			xhr1.open("POST", url);
			var myForm = new FormData();

			console.log($("#pictureFile"))

			myForm.append("imgFile", $("#pictureFile")[0].files[0])
			myForm.append("userid", useridValue)
			myForm.append("title", titleValue)
			myForm.append("postType", postTypeValue)
			myForm.append("post", postValue)
			// 											myForm.append("ptime", ptimeValue)	
			// 											xhr1.setRequestHeader("Content-Type", "multipart/form-data");
			console.log("myForm=" + myForm);
			console.log("imgFile??????=" + $("#pictureFile")[0].files[0]);
			// 											if($("#pictureFile")[0].files[0]!=null){
			xhr1.send(myForm);
			// 												console.log("?????????")
			// 											} else{
			// 												alert("????????????");
			// 											}
			xhr1.onreadystatechange = function() {
				// ?????????????????????
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
							text : '?????????????????????!',
						// footer: '<a href="">Why do I have this issue?</a>'
						})
					} else if (result.success) {
						divResult4.innerHTML = "<font color='GREEN'>"
								+ result.success + "</font>";
						Swal.fire({
							icon : 'success',
							title : '??????????????????',
						// showConfirmButton: false,
						// timer: 1500
						})
						setTimeout(function() {
							// ?????????????????????
							location.reload();
						}, 1500);

					}
				}
			}
		}
	</script>
</body>

</html>