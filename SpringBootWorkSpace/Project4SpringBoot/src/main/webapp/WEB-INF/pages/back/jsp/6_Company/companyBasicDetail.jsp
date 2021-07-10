<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>CBasicDetail - 公司基本資料(詳細)</title>

    <!-- Custom fonts for this template-->
    <link href="<c:url value='/back/vendor/fontawesome-free/css/all.min.css' />" rel="stylesheet" type="text/css">
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
        <%@include file="/WEB-INF/pages/back/jsp/0_Util/Sidebar.jsp" %>

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">
			
            
            <!-- Main Content -->
            <div id="content">

                <!-- A02 Topbar -->
                <%@include file="/WEB-INF/pages/back/jsp/0_Util/Topbar.jsp" %>
				
				
				<!-- 內容 -->
                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <h1 class="h3 mb-4 text-gray-800">
                        <span class="text-primary">台積電(2330)</span>
                        詳細資料 
                        
                        <span class="btn btn-danger btn-icon-split float-right">
                            <span class="icon text-white-50">
                                <i class="fas fa-trash"></i>
                            </span>
                            <span class="text">刪除資料</span>
                            
                        </span>
                        <span class="float-right">&emsp;</span> 
                        <span class="btn btn-warning btn-icon-split float-right">
                            <span class="icon text-white-50">
                                <i class="fas fa-exclamation-triangle"></i>
                            </span>
                            <span class="text">修該資料</span>
                        </span>
                    </h1>
                    
                   
                    <!-- form -->
                    <div class="border border-secondary rounded bg-white">
                        <!-- <h2 id='id'>2330</h2> -->
                        
                        <!-- API -->
                        <span class="justify-content-center d-flex mt-5">
                            <iframe id="Top5"  src="https://s.yimg.com/nb/tw_stock_frontend/scripts/StxChart/StxChart.9d11dfe155.html?sid=2330" style="width: 560px; height: 382px; border-width: 0;"></iframe>
                        </span>
                        <!-- 詳細資料 -->
                        <div class="row text-dark" style="font-size:13px">
                            <div class="col-4">
                                <ul class="list-group list-group-flush">
                                    <li class="list-group-item">出表日期:&emsp; -----</li>
                                    <li class="list-group-item">公司代號:&emsp; -----</li>
                                    <li class="list-group-item">公司名稱:&emsp; -----</li>
                                    <li class="list-group-item">公司簡稱:&emsp; -----</li>
                                    <li class="list-group-item">外國企業註冊地國:&emsp;-----</li>
                                    <li class="list-group-item">產業別:&emsp; ----- </li>
                                    <li class="list-group-item">住址:&emsp; ----- </li>
                                    <li class="list-group-item">營利事業統一編號:&emsp;----- </li>
                                    <li class="list-group-item">董事長:&emsp; ----- </li>
                                    <li class="list-group-item">總經理:&emsp; ----- </li>
                                    <li class="list-group-item">發言人:&emsp; ----- </li>
                                    <li class="list-group-item"> </li>
                                  </ul>
                            </div>
                            <div class="col-4">
                                <ul class="list-group list-group-flush">
                                    <li class="list-group-item">發言人職稱:&emsp; -----</li>
                                    <li class="list-group-item">代理發言人:&emsp; -----</li>
                                    <li class="list-group-item">總機電話:&emsp; -----</li>
                                    <li class="list-group-item">成立日期:&emsp; -----</li>
                                    <li class="list-group-item">上市日期:&emsp; -----</li>
                                    <li class="list-group-item">普通股每股面額:&emsp; ----- </li>
                                    <li class="list-group-item">實收資本額:&emsp; ----- </li>
                                    <li class="list-group-item">私募股數:&emsp; ----- </li>
                                    <li class="list-group-item">特別股:&emsp; ----- </li>
                                    <li class="list-group-item">編制財務報表類型:&emsp; ----- </li>
                                    <li class="list-group-item">股票過戶機構:&emsp; ----- </li>
                                    <li class="list-group-item"> </li>
                                  </ul>
                            </div>
                            <div class="col-4">
                                <ul class="list-group list-group-flush">
                                    <li class="list-group-item">過戶電話:&emsp; -----</li>
                                    <li class="list-group-item">過戶地址:&emsp; -----</li>
                                    <li class="list-group-item">簽證會計師事務所:&emsp; -----</li>
                                    <li class="list-group-item">簽證會計師1:&emsp; ----- </li>
                                    <li class="list-group-item">簽證會計師2:&emsp; ----- </li>
                                    <li class="list-group-item">英文簡稱:&emsp; ----- </li>
                                    <li class="list-group-item">英文通訊地址:&emsp; ----- </li>
                                    <li class="list-group-item">傳真機號碼:&emsp; ----- </li>
                                    <li class="list-group-item">電子郵件信箱:&emsp; ----- </li>
                                    <li class="list-group-item">網址:&emsp; -----</li>
                                    <li class="list-group-item"> </li>
                                  </ul>
                            </div>
                            

                        </div>

                        
                        

                    </div>
                    <!-- 返回前頁 Button -->
                    <div class="mt-5 float-right">
                        <a href="#" class="btn btn-secondary btn-icon-split">
                            <span class="icon text-white-50">
                                <i class="fas fa-arrow-right"></i>
                            </span>
                            <span class="text">返回前頁</span>
                        </a>
                    </div>


                </div>
                <!-- End of Page Content -->

            </div>
            <!-- End of Main Content -->

            <!-- A03 Footer -->
            <%@include file="/WEB-INF/pages/back/jsp/0_Util/Footer.jsp" %>

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- A04 Scroll to Top Button-->
    <%@include file="/WEB-INF/pages/back/jsp/0_Util/TopButton.jsp" %>

    <!-- A05 Logout Modal-->
    <%@include file="/WEB-INF/pages/back/jsp/0_Util/LogoutModal.jsp" %>



    <!-- script -->
    <!-- Bootstrap core JavaScript-->
    <script src="<c:url value='/back/vendor/jquery/jquery.min.js' />"></script>
    <script src="<c:url value='/back/vendor/bootstrap/js/bootstrap.bundle.min.js' />"></script>

    <!-- Core plugin JavaScript-->
    <script src="<c:url value='/back/vendor/jquery-easing/jquery.easing.min.js' />"></script>

    <!-- Custom scripts for all pages-->
    <script src="<c:url value='/back/js/sb-admin-2.min.js' />"></script>

	<!-- Page level plugins -->
    <script src="<c:url value='/back/vendor/datatables/jquery.dataTables.min.js' />"></script>
    <script src="<c:url value='/back/vendor/datatables/dataTables.bootstrap4.min.js' />"></script>

    <!-- Page level custom scripts -->
    <script src="<c:url value='/back/js/demo/datatables-demo.js' />"></script>

    <!-- SweetAlert2 -->
    <script src="<c:url value='/back/js/sweetalert2@11.js' />"></script>
    <script>
        $(document).ready(function(){
            
            // Sidebar
            $("#dashboard").removeClass('active')
            $("#Company_PA, #CP").addClass('active')
            $("#collapseCP").addClass('show')

            // Select All Data
            var xhr = new XMLHttpRequest();
            xhr.open("GET", "<c:url value='/pa/showAllData' />", true);
            xhr.send()
            xhr.onreadystatechange = function() {
                if (xhr.readyState == 4 && xhr.status == 200) {
                    $('#dataAreaX').html(showAll(xhr.responseText))
                    $('.tableX').attr('id', 'dataTable')
                    
                    // $.getScript("<c:url value='/back/vendor/datatables/jquery.dataTables.min.js' />");
                    // $.getScript("<c:url value='/back/vendor/datatables/dataTables.bootstrap4.min.js' />");
                    // $.getScript("<c:url value='/back/js/demo/datatables-demo.js' />");
                    var scriptsToLoad = [
                        "<c:url value='/back/vendor/datatables/jquery.dataTables.min.js' />", 
                        "<c:url value='/back/vendor/datatables/dataTables.bootstrap4.min.js' />",
                        "<c:url value='/back/js/demo/datatables-demo.js' />"
                    ]; 

                    scriptsToLoad.forEach(function(src) {
                        var script = document.createElement('script');
                        script.src = src;
                        script.async = false;
                        document.body.appendChild(script);
                    });
                }
            }

            
            // Delete Data
            $('tbody').on('click', '#delete', function(){
                var x =  $(this).parent().parent().index()
                var paID = $(".idX")[x].textContent
                console.log(paID)
                Swal.fire({
                    template: '#my-delete'+ paID
                }).then((result)=> {
                    if (result.isDenied) {
                        Swal.fire({
                            title: 'Delete '+ paID + ' Please Wait......'
                        });
                        Swal.showLoading();                         

                        var xhr = new XMLHttpRequest();
                        xhr.open("POST", "<c:url value='/pa/delete' />", true);
                        xhr.setRequestHeader('Content-Type', "application/x-www-form-urlencoded");
                        xhr.send("id="+paID);
                        xhr.onreadystatechange = function() {
                            if (xhr.readyState == 4 && xhr.status == 200) {

                                if(xhr.responseText){
                                    Swal.fire({
                                        icon: 'success',
                                        title: paID + ' has been deleted.',
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
                    }
                })
            })
            
            // Delete All Data
            $('#deleteAll').on('click', function(){
                Swal.fire({
                    template: '#deleteAll-template'
                }).then((result)=> {
                    if (result.isDenied) {
                        Swal.fire({
                            title: 'Upload File Please Wait......'
                        });
                        Swal.showLoading();                         

                        var xhr = new XMLHttpRequest();
                        xhr.open("GET", "<c:url value='/pa/deleteAll' />", true);
                        xhr.send();
                        xhr.onreadystatechange = function() {
                            if (xhr.readyState == 4 && xhr.status == 200) {

                                if(xhr.responseText){
                                    Swal.fire({
                                        icon: 'success',
                                        title: 'All file has been deleted.',
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
                    }
                })
            })

            // Insert Data
            $('#uploadFile').on('click', async function(){    
                var form = $('#UploadForm')[0];
                var data = new FormData(form);        

                console.log(data)
                var xhr1 = new XMLHttpRequest();
                xhr1.open("POST", "<c:url value='/pa/insertData' />", true);

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

            // Update Data
            $('tbody').on('click', '#update', function(){
                var x =  $(this).parent().parent().index()
                var paID = $(".idX")[x].textContent
                console.log(paID)
                Swal.fire({
                    template: '#my-update'+ paID
                }).then((result)=> {
                    if (result.isDenied) {
                        location.replace("<c:url value='/paUpdate/' />" + paID);                       
                    }
                })
            })
            
            function showAll(text){
                var beans = JSON.parse(text);
                var segment = ""

                for(var x in beans){
                    var bean = beans[x]
                    var buttonX =
                        `<span href="#" class="btn btn-warning btn-circle btn-sm" id="update">
                            <i class="fas fa-exclamation-triangle"></i>
                            <template id="my-update`+bean.company_ID+`">
                                <swal-title>
                                你確定要更新` + bean.company_ID +`?
                                </swal-title>
                                <swal-icon type="warning" color="red"></swal-icon>
                                <swal-button type="confirm">
                                取消
                                </swal-button>
                                <swal-button type="deny">
                                更新
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
                            <template id="my-delete`+bean.company_ID+`">
                                <swal-title>
                                你確定要刪除 `+ bean.company_ID +` ?
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
                    segment += "<td class='idX'>" + bean.company_ID + "</td>"
                    segment += "<td>" + bean.company_Name + "</td>"
                    segment += "<td>" + bean.income + "</td>"
                    segment += "<td>" + bean.gross_Margin + "</td>"
                    segment += "<td>" + bean.operating_Profit_Ratio + "</td>"
                    segment += "<td>" + bean.net_Income_Margin + "</td>"
                    segment += "<td>" + bean.net_Profit_Margin + "</td>"
                    segment += "<td>" + buttonX + "</td>"
                    segment += "</tr>"
                }
                return segment;
            }

        })

    </script>

</body>

</html>