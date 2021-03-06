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

<title>postedit</title>

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
					<h1 class="h3 mb-4 text-gray-800">編輯文章</h1>
					<!-- form -->
					<div class="border border-secondary rounded bg-white">
						<form class="p-4" id="form" enctype="multipart/form-data"
							method="put">
							<!-- ID -->
							<div class="row mb-3">
								<div class="col-6 form-group row">
									<label class="col-sm-2 col-form-label text-primary">文章編號</label>
									<div class="col-sm-4">
										<input type="text" class="form-control text-dark"
											value="${bean.post_num}" id="post_num" readonly>
									</div>
								</div>
							</div>
							<hr class="mb-4">
							<!-- Content -->
							<div class="table">
								<div class="col-8 form-group row">
									<label class="col-sm-2 col-form-label text-primary">發文者</label>
									<div class="col-sm-9">
										<input type="text" class="form-control" value="${bean.userid}"
											id="userid" readonly> <br>
									</div>
									<br>
								</div>
								<div class="col-8 form-group row">
									<label class="col-sm-2 col-form-label text-primary">標題</label>
									<div class="col-sm-9">
										<input type="text" class="form-control" value="${bean.title}"
											id="title"><br> <span id="resultMsg1"
											style="height: 18px; font-weight: bold;"></span>

									</div>
									<br>
								</div>
								<div class="col-8 form-group row">
									<label class="col-sm-2 col-form-label text-primary">類型</label>
									<div class="col-sm-9">
										<input type="text" class="form-control"
											value="${bean.postType}" id="postType"><br> <span
											id="resultMsg2" style="height: 18px; font-weight: bold;"></span>

									</div>
								</div>
								<div class="col-8 form-group row">
									<label class="col-sm-2 col-form-label text-primary">文章內容</label>
									<div class="col-sm-9">
										<textarea class="form-control" rows="8" id="post">${bean.post}</textarea>
										<br> <span id="resultMsg3"
											style="height: 18px; font-weight: bold;"></span>

									</div>
								</div>
								<div class="col-8 form-group row">
									<label class="col-sm-2 col-form-label text-primary">發文時間</label>
									<div class="col-sm-9">
										<input type="text" class="form-control" value="${bean.ptime}"
											id="ptime" readonly> <br>
									</div>
								</div>
								<div class="col-8 form-group row">
									<label class="col-sm-2 col-form-label text-primary">圖片</label>
									<div class="col-sm-9">
										<input type="file" class="img-thumbnail" name="pictureFile"
											id="pictureFile" value="${bean.postImage}" /><br>
									</div>
								</div>
							</div>
							<br> <br> <br>
							<center>
							
<!-- 								<span href="#" id="btnUpd"> <a -->
<!-- 									class="btn btn-warning btn-icon-split "> <span -->
<!-- 										class="icon text-white-50"> <i -->
<!-- 											class="fas fa-exclamation-triangle"></i> -->
<!-- 									</span> <span class="text">更新文章</span> -->
<!-- 								</a> -->
<!-- 								</span> -->

								<!-- <input type="button" class="btn btn-primary" value="刪除此文章" id="btnDel"> -->
								
								<div id="resultMsg4" style="height: 18px; font-weight: bold;"></div>
								<br>
								<a class="btn btn-warning btn-icon-split "> <span class="icon text-white-50"> <i
									class="fas fa-exclamation-triangle"></i>
								</span>
								 	<input type="button" class="btn btn-warning" value="更新文章" id="btnUpd">
								</a> &nbsp;&nbsp;
								 
								<span id="btnDel">
								<a class="btn btn-danger btn-icon-split "> 
									<span class="icon text-white-50">
								 		<i class="fas fa-trash"></i>
									</span>
									<span class="text">刪除文章</span>
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
						</form>
					</div>
					<br>
					<hr class="mb-4">
					<p class="mb-4">該文章的所有留言顯示如下，管理者可針對留言個別編輯</p>

					<!-- DataTales Example -->
					<div class="card shadow mb-4">
						<div class="card-header py-3">
							<h6 class="m-0 font-weight-bold text-primary">留言列表</h6>
						</div>
						<div class="card-body">
							<div class="table-responsive">
								<table class="table table-bordered pic" id="dataTable" width="100%"
									cellspacing="0" style="word-wrap: break-word;">
									<thead>
										<tr>
											<th style="width: 2cm;">留言者</th>
											<th style="width: 25cm;">留言內容</th>
											<th style="width: 4cm;">留言時間</th>
											<th style="width: 6cm;">圖片</th>
											<th style="width: 2cm;">編輯</th>
										</tr>
									</thead>
									<tfoot>
										<tr>
											<th>留言者</th>
											<th>留言內容</th>
											<th>留言時間</th>
											<th>圖片</th>
											<th>編輯</th>
										</tr>
									</tfoot>
									<tbody id="dataArea01">

									</tbody>
								</table>
							</div>
						</div>
					</div>
					<!-- 返回前頁 Button -->
					<div class="mt-5 float-right">
						<a href="<c:url value='/post' />"
							class="btn btn-secondary btn-icon-split"> <span
							class="icon text-white-50"> <i class="fas fa-arrow-right"></i>
						</span> <span class="text">返回前頁</span>
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
	
	const formData = new FormData(document.getElementById('form'));
    var btnDel = document.getElementById("btnDel");
    var btnUpd = document.getElementById("btnUpd");

                            window.onload = function () {
                                	
                                //秀出全部留言
                                var xhr0 = new XMLHttpRequest();
                                var url = "<c:url value = '/findBypost_num'/>?";
                                xhr0.open("GET", url + "post_num=" + ${ bean.post_num });
                                xhr0.send();
                                xhr0.onreadystatechange = function () {
                                    if (xhr0.readyState == 4 && xhr0.status == 200) {
                                        var map = JSON.parse(xhr0.responseText);
                                        var segment = ""
                                        var comments = map.comments;
                                        for (var x in comments) {
                                            tmp = "<c:url value='/comedit/' />";
                                            var commentA = comments[x]
                                            segment += "<tr>"
                                            segment += "<td>" + commentA.userid + "</td>"
                                            segment += "<td>" + commentA.comment + "</td>"
                                            segment += "<td>" + commentA.ctime + "</td>"
                                            segment += "<td><img width='240' height='180' src='" + commentA.pictureString + "' ></td>"
                                            segment += "<td><a href='" + tmp + comments[x].comment_num + "'><input type='button' value='編輯留言' id='btnUpd'></a></td>"
                                            segment += "</tr>"
                                        }
                                        console.log(map);

                                        var dataArea01 = document.getElementById("dataArea01");
                                        dataArea01.innerHTML = segment;
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
                                        console.log(segment);
                                        return segment;
                                    }
                                }
                            }
                            
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
                                    xhr2.open("PUT", "<c:url value='/postedit' />", true);
                                    var myForm = new FormData();
                                    
                                    console.log($("#pictureFile"))
                                    
                                    myForm.append("imgFile", $("#pictureFile")[0].files[0])		
									myForm.append("post_num", post_numValue)		
									myForm.append("userid", useridValue)		
									myForm.append("title", titleValue)		
									myForm.append("postType", postTypeValue)		
									myForm.append("post", postValue)
// 									xhr2.setRequestHeader("Content-Type", "multipart/form-data");
									console.log("myForm="+myForm);
									console.log("imgFile的值="+ $("#pictureFile")[0].files[0]);
									xhr2.send(myForm);
//                                     var jsonPost = {
//                                         "post_num": post_numValue,
//                                         "userid": useridValue,
//                                         "title": titleValue,
//                                         "postType": postTypeValue,
//                                         "post": postValue,
//                                         "ptime": ptimeValue,
//                                         "pmimeType": "${bean.pmimeType}"
//                                     }
//                                     xhr2.setRequestHeader("Content-Type", "application/json");
//                                     xhr2.send(JSON.stringify(jsonPost));

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
                        							window.location.href = "<c:url value='/post'/>"
                        						}, 1500);
                                                console.log("成功");
//                                                 window.location.href = "<c:url value='/post'/>"
                                            }
                                        }
                                    }
                                };

//                                 btnDel.addEventListener('click', (e) => {

//                                     var divResult = document.getElementById('resultMsg');

//                                     var result = confirm("確定刪除此筆文章(文章編號:" + ${bean.post_num} + ")?");
//                                     if (result) {
//                                         var xhr3 = new XMLHttpRequest();
//                                         xhr3.open("DELETE", "<c:url value='/deletepost/" + ${bean.post_num} + "'/>", true);
//                                         xhr3.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
//                                         xhr3.send();
//                                         xhr3.onreadystatechange = function () {
//                                             if (xhr3.readyState == 4 && (xhr3.status == 200 || xhr3.status == 204)) {
//                                                 result = JSON.parse(xhr3.responseText);
//                                                 if (result.fail) {
//                                                     divResult.innerHTML = "<font color='red' >"
//                                                         + result.fail + "</font>";
//                                                         console.log("刪除失敗");
//                                                 } else if (result.success) {
//                                                     alert("文章刪除成功");
//                                                     window.location.href = "<c:url value='/post'/>"
//                                                 }
//                                             }

//                                         }
//                                     }
//                                 });

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
                                            xhr3.open("DELETE", "<c:url value='/deletepost/" + ${bean.post_num} + "'/>", true);
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