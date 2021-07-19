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
					<li><a href="<c:url value='/front/post' />">討論區</a></li>
				</ol>
				<h2>編輯文章</h2>

			</div>
		</section>
		<!-- End Breadcrumbs -->

		<!-- ======= Blog Section ======= -->
		<section id="blog" class="blog">

			<div class="container" data-aos="fade-up">

				<div class="row">

					<div class="col-lg-8 entries">

						<div id="collapseExample">

							<form method="POST" enctype="multipart/form-data" class="p-4"
								id="form">
								<!-- Content -->
								<div class="card card-body">

									<div class="row mb-3" hidden="true">
										<div class="col-6 form-group row">
											<label class="col-sm-2 col-form-label text-primary">文章編號</label>
											<div class="col-sm-4">
												<input type="text" class="form-control text-dark"
													value="${bean.post_num}" id="post_num" readonly>
											</div>
										</div>
									</div>
									<div class="col-10 form-group row">
										<label class="col-sm-2 col-form-label text-danger">發文者</label>
										<div class="col-sm-9">
											<input type="text" class="form-control"
												value="${bean.userid}" id="userid" readonly><br>
										</div>
									</div>
									<div class="col-10 form-group row">
										<label class="col-sm-2 col-form-label text-danger">標題</label>
										<div class="col-sm-9">
											<input type="text" class="form-control" value="${bean.title}"
												id="title"> <span id="resultMsg1"
												style="height: 18px; font-weight: bold;"></span><br>
										</div>
									</div>
									<div class="col-10 form-group row">
										<label class="col-sm-2 col-form-label text-danger">類型</label>
										<div class="col-sm-9">
											<input type="text" class="form-control"
												value="${bean.postType}" id="postType"><span
												id="resultMsg2" style="height: 18px; font-weight: bold;"></span><br>
										</div>
									</div>
									<div class="col-10 form-group row">

										<label class="col-sm-2 col-form-label text-danger">文章內容</label>
										<div class="col-sm-9">
											<textarea class="form-control" rows="8" name="post" id="post">${bean.post}</textarea>
											<span id="resultMsg3"
												style="height: 18px; font-weight: bold;"></span><br>
										</div>
									</div>
									<div class="col-10 form-group row" hidden="true">
										<label class="col-sm-2 col-form-label text-danger">發文時間</label>
										<div class="col-sm-9">
											<input type="text" class="form-control" value="${bean.ptime}"
												id="ptime"><br>
										</div>
									</div>
									<div class="col-10 form-group row">
										<label class="col-sm-2 col-form-label text-danger">圖片</label>
										<div class="col-sm-9">
											<!--  img src="" class="img-thumbnail" alt="" id="ppicture"-->
											<input type="file" class="img-thumbnail"
												value="${bean.postImage}" name="pictureFile"
												id="pictureFile" style="color: #e96b56;" />
										</div>
									</div>
									<br>
									<center>
										<div id="resultMsg4" style="height: 18px; font-weight: bold;"></div>
										<br> <input type="button" class="btn btn-danger"
											id="btnUpd" value="更新文章">&nbsp;&nbsp; <span
											id="btnDel"> <a class="btn btn-danger btn-icon-split ">
												<span class="icon text-white-50"> <i
													class="fas fa-trash"></i>
											</span> <span class="text">刪除文章</span>
												<template id="deleteAll-template">
													<swal-title> 你確定要刪除此文章? </swal-title>
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
								</div>
							</form>
						</div>





					</div>
					<!-- End blog entries list -->

					<!-- Sidebar -->
					<div class="col-lg-4">

						<div class="sidebar">


							<h3 class="sidebar-title">分類</h3>
							<div class="sidebar-item categories">
								<ul>
									<li><a href="#">股票</a></li>
									<li><a href="#">期貨</a></li>
									<li><a href="#">債券</a></li>
									<li><a href="#">指數</a></li>
									<li><a href="#">外匯</a></li>
									<li><a href="#">虛擬貨幣</a></li>
								</ul>
							</div>
							<!-- End sidebar categories-->

							<h3 class="sidebar-title">推薦文章</h3>
							<div class="sidebar-item recent-posts">

								<div class="post-item clearfix">
									<img src="<c:url value='/front/assets/img/(小圖)上漲.jpg' />"
										alt="" style="max-height: 60px;">
									<h4>
										<a href="blog-single.html">全球股市火燙績效爆發 台股基金Top 10出列！</a>
									</h4>
									<time datetime="2021-07-19">2021-07-19</time>
								</div>
								<div class="post-item clearfix">
									<img src="<c:url value='/front/assets/img/(小圖)長榮.png' />"
										alt="" style="max-height: 60px;">
									<h4>
										<a href="blog-single.html">台股下周將挑戰且站穩18000點，挑戰同時將由誰帶領？</a>
									</h4>
									<time datetime="2021-07-18">2021-07-18</time>
								</div>
								<div class="post-item clearfix">
									<img src="<c:url value='/front/assets/img/(小圖)熱門文章.jpg' />"
										alt="" style="max-height: 60px;">
									<h4>
										<a href="blog-single.html">美股走疲台股震盪 分析師：靜待科技股財報</a>
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
			<center>
				<!-- 返回前頁 Button -->
				<div class="mt-5 float-right">
					<a href="<c:url value='/front/post' />"
						class="btn btn-secondary btn-icon-split"> <span
						class="icon text-white-50"> <i class="fas fa-arrow-right"></i>
					</span> <span class="text">返回文章區</span>
					</a>
				</div>
			</center>
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
              $(function () {
                $('#header_post').addClass('active')
              })
            </script>

	<script>
        	const formData = new FormData(document.getElementById('form'));
            var btnDel = document.getElementById("btnDel");
            var btnUpd = document.getElementById("btnUpd");
            
            btnUpd.onclick = function () {
				console.log("修改文章(前端)")
                var post_numValue = document.getElementById('post_num').value;
                var useridValue = document.getElementById('userid').value;
                var titleValue = document.getElementById('title').value;
                var postTypeValue = document.getElementById('postType').value;
                var postValue = document.getElementById('post').value;
                var ptimeValue = document.getElementById('ptime').value;
                
    			var divResult1 = document.getElementById('resultMsg1');
    			var divResult2 = document.getElementById('resultMsg2');
    			var divResult3 = document.getElementById('resultMsg3');
    			var divResult4 = document.getElementById('resultMsg4');
    			var hasError = false;

    			if (!titleValue) {
    				divResult1.innerHTML = "<font color='red' size='4'>標題不得為空</font>";
    				hasError = true;
    			} else {
    				divResult1.innerHTML = "";
    			}
    			if (!postTypeValue) {
    				divResult2.innerHTML = "<font color='red' size='4'>類型不得為空</font>";
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

                var xhr2 = new XMLHttpRequest();
                xhr2.open("PUT", "<c:url value='/front/postedit' />", true);
                var myForm = new FormData();
                
                console.log($("#pictureFile"))
                
                myForm.append("imgFile", $("#pictureFile")[0].files[0])		
				myForm.append("post_num", post_numValue)		
				myForm.append("userid", useridValue)		
				myForm.append("title", titleValue)		
				myForm.append("postType", postTypeValue)		
				myForm.append("post", postValue)
				console.log("myForm="+myForm);
				console.log("imgFile的值="+ $("#pictureFile")[0].files[0]);
				xhr2.send(myForm);

                xhr2.onreadystatechange = function () {
                    // 伺服器請求完成
                    if (xhr2.readyState == 4 && (xhr2.status == 200 || xhr2.status == 201)) {
                        result = JSON.parse(xhr2.responseText);
                        if (result.fail) {
                            divResult4.innerHTML = "<font color='red' >" + result.fail + "</font>";
                            console.log("失敗");
                        } else if (result.success) {
                            divResult4.innerHTML = "<font color='GREEN'>" + result.success + "</font>";
                            Swal.fire({
    							icon : 'success',
    							title : '文章修改成功',
    						// showConfirmButton: false,
    						// timer: 1500
    						})
    						setTimeout(function() {
    							// 自己會載入頁面
    							window.location.href = "<c:url value='/front/post'/>"
    						}, 1500);
                            console.log("成功");
//                             window.location.href = "<c:url value='/post'/>"
                        }
                    }
                }
            };

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
                        xhr3.open("DELETE", "<c:url value='/front/deletepost/" + ${bean.post_num} + "'/>", true);
                        xhr3.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
                        xhr3.send();
                        xhr3.onreadystatechange = function() {
                            if (xhr3.readyState == 4 && (xhr3.status == 200 || xhr3.status == 204)) {
                            	result = JSON.parse(xhr3.responseText);
                                if(result.success){
                                    Swal.fire({
                                        icon: 'success',
                                        title: '文章已成功刪除',
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
                                	window.location.href = "<c:url value='/front/post'/>"
                                },1500);
                               
                            }
                        }        
                    }
                })
            })
            </script>
</body>