<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
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
				<h2>${bean.title}</h2>

			</div>
		</section>
		<!-- End Breadcrumbs -->

		<!-- ======= Blog Single Section ======= -->
		<section id="blog" class="blog">
			<div class="container" data-aos="fade-up">

				<div class="row">

					<div class="col-lg-8 entries">

						<article class="entry entry-single"
							style="background-color: rgb(255, 239, 221);">

							<div hidden>
								<input id="post_num" value="${bean.post_num}">
							</div>

							<div class="entry-img" style="text-align: center;">
								<br> <img src="${bean.pictureString}" alt=""
									class="img-fluid">
							</div>

							<h2 class="entry-title">
								<a href="">${bean.title}</a>
							</h2>

							<div class="entry-meta">
								<div class="entry-footer">
									<i class="bi bi-tags"></i>
									<ul class="tags">
										<li><a href="#">${bean.postType}</a></li>
									</ul>
								</div>
								<br>
								<ul>
									<li class="d-flex align-items-center"><i
										class="bi bi-person"></i> <a href="">${bean.userid}</a></li>
									<li class="d-flex align-items-center"><i
										class="bi bi-clock"></i>${bean.ptime}</time></li>
								</ul>
							</div>

							<div class="entry-content">
								<p>${bean.post}</p>

							</div>


						</article>
						<!-- End blog entry -->

						<div class="blog-comments">

							<article class="entry entry-single">
								<div>
									<form method="POST" enctype="multipart/form-data" class="p-4"
										id="form">
										<!-- Content -->
										<div>
											<div class="col-15 form-group row" hidden>

												<label class="col-sm-2 col-form-label text-danger">留言者</label>
												<div class="col-sm-9">
													<input class="form-control" name="userid" id="userid"></input>
													<br>
												</div>
											</div>
											<div class="col-15 form-group row">

												<label class="col-sm-2 col-form-label text-danger">留言內容</label>
												<div class="col-sm-9">
													<textarea class="form-control" rows="5" name="comment"
														id="comment" placeholder="分享一下你的看法吧 !"></textarea>
													<br> <span id="resultMsg1"
														style="height: 18px; font-weight: bold;"></span>
												</div>
											</div>
											<div class="col-15 form-group row">
												<label class="col-sm-2 col-form-label text-danger">圖片</label>
												<div class="col-sm-9">
													<!--  img src="" class="img-thumbnail" alt="" id="ppicture"-->
													<input type="file" class="img-thumbnail" name="pictureFile"
														id="pictureFile" style="color: #e96b56;" />
												</div>
											</div>
											<br>
											<div style="text-align: right;">
												<div id="resultMsg" style="height: 18px; font-weight: bold;"></div>
												<br> <input type="button" class="btn btn-danger"
													id="btnIns" value="發布留言">
											</div>
										</div>
									</form>
								</div>
							</article>

							<div id="dataArea01"></div>

						</div>
						<!-- End blog comments -->

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
		</section>
		<!-- End Blog Single Section -->

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

	<script>
                            const formData = new FormData(document.getElementById('form'));
                            var btnDel = document.getElementById("btnDel");
                            var btnUpd = document.getElementById("btnUpd");
                            var btnIns = document.getElementById("btnIns");

                            //秀出全部留言
                            var xhr0 = new XMLHttpRequest();
                            var url = "<c:url value = '/front/findBypost_num'/>?";
                            xhr0.open("GET", url + "post_num=" + ${ bean.post_num });
                            xhr0.send();
                            xhr0.onreadystatechange = function () {
                                if (xhr0.readyState == 4 && xhr0.status == 200) {
                                    var map = JSON.parse(xhr0.responseText);
                                    var segment = ""
                                    var comments = map.comments;
                                    for (var x in comments) {
                                        tmp = "<c:url value='/front/comedit/' />";
                                        var commentA = comments[x]
                                        
                                        segment += "<div class='comment'><span><a href='" + tmp + comments[x].comment_num + "'><button style='float: right;opacity: 0.7;'><i class='bi bi-pen'></i></button></a></span>"
                                        segment += "<div class='d-flex'>"   
                                        segment += "<div class='comment-img'><svg xmlns='http://www.w3.org/2000/svg' width='60' height='60' fill='currentColor' class='bi bi-person-fill' viewBox='0 0 16 16'>"  
                                        segment += "<path d='M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H3zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z' /></svg></div>"  
                                        segment += "<div><h5><a href=''>" + commentA.userid + "</a></h5>"  
                                        segment += "<time>" + commentA.ctime + "</time>"  
                                        segment += "<img width='300px' src='" + commentA.pictureString + "' class='img-fluid'>"   
                                        segment += "<p>" + commentA.comment + "</p>"   
                                        segment += "</div></div></div><hr>"
                                    console.log("測試"+commentA.ctime);
                                    }
                                    console.log("map="+map);
                                    var dataArea01 = document.getElementById("dataArea01");
                                    dataArea01.innerHTML = segment;
                                    return segment;
                                }
                                
                            }

                            btnIns.onclick = function () {
                                console.log(12365);
                                
                                var useridValue = document.getElementById("userid").value;
                                var post_numValue = document.getElementById("post_num").value;
                                var commentValue = document.getElementById("comment").value;
                                var divResult1 = document.getElementById('resultMsg1');
                                var divResult = document.getElementById('resultMsg');
                                var hasError = false;
								console.log(post_numValue);
                                if (!commentValue) {
                                  divResult1.innerHTML = "<font color='red' size='4'>留言內容不得為空</font>";
                                  hasError = true;
                                } else {
                                  divResult1.innerHTML = "";
                                }
                                if (hasError) {
                                  return false;
                                }

                                var xhr1 = new XMLHttpRequest();
                                var url = "<c:url value='/front/commentinsert' />";
                                xhr1.open("POST", url);
                                var myForm = new FormData();

                                console.log($("#pictureFile"))

                                myForm.append("imgFile", $("#pictureFile")[0].files[0])
                                myForm.append("post_num", post_numValue)
                                myForm.append("userid", useridValue)
                                myForm.append("comment", commentValue)
                                console.log("myForm=" + myForm);
                                console.log("imgFile的值=" + $("#pictureFile")[0].files[0]);
                                xhr1.send(myForm);

                                xhr1.onreadystatechange = function () {
                                  // 伺服器請求完成
                                  if (xhr1.readyState == 4
                                    && (xhr1.status == 200 || xhr1.status == 201)) {
                                    result = JSON.parse(xhr1.responseText);
                                    if (result.fail) {
                						divResult.innerHTML = "<font color='red' >"
                								+ result.fail + "</font>";
                						Swal.fire({
                							// timer: 1500,
                							icon : 'error',
                							title : 'Oops...',
                							text : '留言發送有問題!',
                						// footer: '<a href="">Why do I have this issue?</a>'
                						})
                					} else if (result.success) {
                						divResult.innerHTML = "<font color='GREEN'>"
                								+ result.success + "</font>";
                						Swal.fire({
                							icon : 'success',
                							title : '留言成功送出',
                						})
                						setTimeout(function() {
                							// 自己會載入頁面
                							location.reload();
                						}, 1500);
                						
                					  }			
                                  }
                                }
                              }

                        </script>
</body>

</html>