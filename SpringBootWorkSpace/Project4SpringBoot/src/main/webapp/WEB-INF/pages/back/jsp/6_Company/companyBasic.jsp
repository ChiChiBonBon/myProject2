<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>CBasic - 基本面</title>

	<!-- Custom fonts for this template-->
	<link
		href="<c:url value='/back/vendor/fontawesome-free/css/all.min.css' />"
		rel="stylesheet" type="text/css">
	<!-- 文字 -->
	<link
		href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
		rel="stylesheet">


    <!-- Custom styles for this template-->
    <link href="<c:url value='/back/css/sb-admin-2.min.css' />" rel="stylesheet">
    
    <!-- Custom styles for this page -->
    <link href="<c:url value='/back/vendor/datatables/dataTables.bootstrap4.min.css' />" rel="stylesheet">


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
						<h1 class="h3 mb-1 text-gray-800">Company</h1>
						<a href="<c:url value='/pa/downloadCsv' />" id="downloadCsv"
							class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
							<i class="fas fa-download fa-sm text-white-50"></i> Generate
							Report
						</a>
					</div>
					<p class="mb-4">
						資料來源: <a href="https://mops.twse.com.tw/mops/web/t163sb06">
							公開資料觀測站</a> <br> 可以將資料匯入進來，目前未檢查資料真偽，以後更新。 2021/6/30
					</p>


					<!-- Table -->
					<!-- Table Upolad-->
					<div class="card shadow mb-4">
                        <div class="card-header">
                            <div class="input-group w-50">
                                <a  href="#" class="btn btn-primary btn-icon-split" >
                                    <span class="icon text-white-50">
                                        <i class="fas fa-file-upload"></i>
                                    </span>
                                    <span class="text" id="uploadFile">上傳檔案</span>
                                </a >
                                
                                <form method="POST" enctype="multipart/form-data" id="UploadForm">
                                    <input type="file" class="form-control" id="csvFile" name="csvFile" accept=".json">
                                </form>
                            </div>
                        </div>
                       
                        <!-- Table Content-->
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered tableArea" id="" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>代碼</th>
                                            <th width="80px">統一編號</th>
                                            <th>公司名稱</th>
                                            <th>登記資本額</th>
                                            <th>代表人姓名</th>
                                            <th>公司所在地</th>
                                            <th width="80px">更新 / 刪除</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>代碼</th>
                                            <th>統一編號</th>
                                            <th>公司名稱</th>
                                            <th>登記資本額</th>
                                            <th>代表人姓名</th>
                                            <th>公司所在地</th>
                                            <th>更新 / 刪除</th>
                                        </tr>
                                    </tfoot>
                                    <tbody id='dataArea'>
                                        
                                        
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>  


					<!-- Delete Button -->
					<div class="float-right" id="deleteAll">
						<a class="btn btn-danger btn-icon-split "> <span
							class="icon text-white-50"> <i class="fas fa-trash"></i>
						</span> <span class="text">Delete All Data</span>
							<template id="deleteAll-template">
								<swal-title> 你確定要刪除全部資料? </swal-title>
								<swal-icon type="warning" color="red"></swal-icon>
								<swal-button type="confirm"> 取消 </swal-button>
								<swal-button type="deny"> 刪除全部 </swal-button>
								<swal-param name="allowEscapeKey" value="false" />
								<swal-param name="customClass" value='{ "popup": "my-popup" }' />
							</template>
						</a>
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
		$(function(){
			// Sidebar
            $("#Company_Basic, #CP").addClass('active')
            $("#collapseCP").addClass('show')

            // Select All Data
            let xhr = new XMLHttpRequest();
            xhr.open("GET", "<c:url value='/back/cBasic/showAllData' />", true);
            xhr.send()
            xhr.onreadystatechange = function() {
                if (xhr.readyState == 4 && xhr.status == 200) {
                    $('#dataArea').html(showAll(xhr.responseText))
                    $('.tableArea').attr('id', 'dataTable')
                           
                    let scriptsToLoad = [
                        "<c:url value='/back/vendor/datatables/jquery.dataTables.min.js' />", 
                        "<c:url value='/back/vendor/datatables/dataTables.bootstrap4.min.js' />",
                        "<c:url value='/back/js/demo/datatables-demo.js' />"
                    ]; 

                    scriptsToLoad.forEach(function(src) {
                        let script = document.createElement('script');
                        script.src = src;
                        script.async = false;
                        document.body.appendChild(script);
                    });
                }
            }

			// Insert Data
            $('#uploadFile').on('click', async function(){    
                let form = $('#UploadForm')[0];
                let data = new FormData(form);        

                console.log(data)
                let xhr1 = new XMLHttpRequest();
                xhr1.open("POST", "<c:url value='/back/cBasic/insertData' />", true);

                xhr1.send(data);


                Swal.fire({
                    // timer: 2000,
                    title: 'Upload File Please Wait......'
                });
                Swal.showLoading(); 

                xhr1.onreadystatechange = function() {
                    if (xhr1.readyState == 4 && xhr1.status == 200) {
                        console.log("success")

                        if(xhr.responseText){
                            Swal.fire({
                                icon: 'success',
                                title: 'All file has been Insert.',
                                // showConfirmButton: false,
                                // timer: 1500
                            })
                        }else{
                            Swal.fire({
                                // timer: 1500,
                                icon: 'error',
                                title: 'Oops...',
                                text: 'Something went wrong!',
                                // footer: '<a href="">Why do I have this issue?</a>'
                            })
                        } 
                        setTimeout(function(){
                            location.reload();
                        },1500);
                    }
                }

            })

            // Delete Data
            $('tbody').on('click', '#delete', function(){
                var x =  $(this).parent().parent().index()
                var paID = $(".idX")[x].textContent
                console.log(paID)
                // Swal.fire({
                //     template: '#my-delete'+ paID
                // }).then((result)=> {
                //     if (result.isDenied) {
                //         Swal.fire({
                //             title: 'Delete '+ paID + ' Please Wait......'
                //         });
                //         Swal.showLoading();                         

                //         var xhr = new XMLHttpRequest();
                //         xhr.open("POST", "<c:url value='/pa/delete' />", true);
                //         xhr.setRequestHeader('Content-Type', "application/x-www-form-urlencoded");
                //         xhr.send("id="+paID);
                //         xhr.onreadystatechange = function() {
                //             if (xhr.readyState == 4 && xhr.status == 200) {

                //                 if(xhr.responseText){
                //                     Swal.fire({
                //                         icon: 'success',
                //                         title: paID + ' has been deleted.',
                //                         // showConfirmButton: false,
                //                         // timer: 1500
                //                     })
                //                 }else{
                //                     Swal.fire({
                //                         // timer: 1500,
                //                         icon: 'error',
                //                         title: 'Oops...',
                //                         text: 'Something went wrong!',
                //                         // footer: '<a href="">Why do I have this issue?</a>'
                //                     })
                //                 } 
                //                 setTimeout(function(){
                //                     location.reload();
                //                 },1500);
                               
                //             }
                //         }    
                //     }
                // })
            })

            // Update Data
            $('tbody').on('click', '#update', function(){
                let x =  $(this).parent().parent().index()
                let paID = $(".idX")[x].textContent
                let updateContent = document.getElementsByClassName("trX")[x]
                console.log(paID)
                
                let xhr = new XMLHttpRequest();
                xhr.open("PUT", "<c:url value='/back/cBasic/Update/' />" + paID, true);
                xhr.send();
                xhr.onreadystatechange = function() {
                    if (xhr.readyState == 4 && xhr.status == 200) {
                        console.log("OK")
                        updateContent.innerHTML = showOne(xhr.responseText)
                        
                    }   
                }

            })


            function showAll(text){
                let beans = JSON.parse(text);
                let segment = ""

                for(let x in beans){
                    let bean = beans[x]
                    let buttonX =
                        `<!-- Auto update -->
                        <span href="#" class="btn btn-warning btn-circle btn-sm" id="update">
                            <i class="fas fa-undo"></i>
                        </span>
                        &nbsp;&nbsp;
                        <!-- delete -->
                        <span" class="btn btn-danger btn-circle btn-sm" id="delete">
                            <i class="fas fa-trash"></i>
                            <template id="my-delete`+bean.stock+`">
                                <swal-title>
                                你確定要刪除 `+ bean.stock +` ?
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

                    let updateUrl = `<c:url value = "/back/cDetail/Main/" />` + bean.stock
                    let updateX = `<a href=`+ updateUrl +` class='idX' >` + bean.stock + `</a>`

                    segment += "<tr class='trX'>"
                    segment += "<td >" + updateX + "</td>"
                    segment += "<td>" + bean.business_Accounting_NO + "</td>"
                    segment += "<td>" + bean.company_Name + "</td>"
                    segment += "<td>" + bean.capital_Stock_Amount + "</td>"
                    segment += "<td>" + bean.responsible_Name + "</td>"
                    segment += "<td>" + bean.company_Location + "</td>"
                    segment += "<td>" + buttonX + "</td>"
                    segment += "</tr>"
                }
                return segment;
            }

            function showOne(text){
                let bean = JSON.parse(text);
                let segment = ""
                let buttonX =
                        `<!-- Auto update -->
                        <span href="#" class="btn btn-warning btn-circle btn-sm" id="update">
                            <i class="fas fa-undo"></i>
                        </span>
                        &nbsp;&nbsp;
                        <!-- delete -->
                        <span" class="btn btn-danger btn-circle btn-sm" id="delete">
                            <i class="fas fa-trash"></i>
                            <template id="my-delete`+bean.stock+`">
                                <swal-title>
                                你確定要刪除 `+ bean.stock +` ?
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

                let updateUrl = `<c:url value = "/back/cDetail/Main/" />` + bean.stock
                let updateX = `<a href=`+ updateUrl +` class='idX' >` + bean.stock + `</a>`
                                segment += "<td >" + updateX + "</td>"
                
                segment += "<td>" + bean.business_Accounting_NO + "</td>"
                segment += "<td>" + bean.company_Name + "</td>"
                segment += "<td>" + bean.capital_Stock_Amount + "</td>"
                segment += "<td>" + bean.responsible_Name + "</td>"
                segment += "<td>" + bean.company_Location + "</td>"
                segment += "<td>" + buttonX + "</td>"

                return segment;
            }

		})
	</script>

</body>

</html>