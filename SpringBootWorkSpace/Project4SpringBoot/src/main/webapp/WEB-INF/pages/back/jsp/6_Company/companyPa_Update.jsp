<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>PA Update - 基本面</title>

    <!-- Custom fonts for this template-->
    <link href="<c:url value='/back/vendor/fontawesome-free/css/all.min.css' />" rel="stylesheet" type="text/css">
    <!-- 文字 -->
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="<c:url value='/back/css/sb-admin-2.min.css' />" rel="stylesheet">

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
                    <div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <h1 class="h3 mb-1 text-gray-800">Update Data</h1>
                    </div>
                    <p class="mb-4"></p>
                    
                    
                    <!-- form -->
                    <div class="border border-secondary rounded bg-white">
                        <form class="p-4">
                            <!-- ID -->
                            <div class="row mb-3">
                                <div class="col-6 form-group row">
                                    <label class="col-sm-2 col-form-label text-primary">公司名稱</label>
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control text-dark" 
                                        placeholder="${bean.company_Name}(${bean.company_ID})" readonly >
                                    </div>
                                </div>
                            </div>
                            <hr class="mb-4">
                            <!-- Content -->
                            <div class="row">
                                <div class="col-6 form-group row">
                                    <label class="col-sm-2 col-form-label text-primary">營業收入<br>(百萬元)</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" placeholder="範例: 120.5" id="income" value="${bean.income}">
                                    </div>
                                </div>
                                <div class="col-6 form-group row">
                                    <label class="col-sm-2 col-form-label text-primary">毛利率(%)</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control"  id="gross_Margin" value="${bean.gross_Margin}">
                                    </div>
                                </div>
                                <div class="col-6 form-group row">
                                    <label class="col-sm-2 col-form-label text-primary">營業利益率(%)</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" placeholder="範例: 20.12" id="operating_Profit_Ratio" value="${bean.gross_Margin}">
                                    </div>
                                </div>
                                <div class="col-6 form-group row">
                                    <label class="col-sm-2 col-form-label text-primary">稅前純益率(%)</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" placeholder="範例: -20.12" id="net_Income_Margin" value="${bean.gross_Margin}">
                                    </div>
                                </div>
                                <div class="col-6 form-group row">
                                    <label class="col-sm-2 col-form-label text-primary">稅後純益率(%)</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" placeholder="範例: 20.12" id="net_Profit_Margin" value="${bean.gross_Margin}">
                                    </div>
                                </div>
                            </div>

                            <Button type="button" class="btn btn-primary" id="submitButton">送出</button>
                            <input type="reset"  class="btn btn-primary" value="清除">
                        </form>
                    </div>
                    <!-- 返回前頁 Button -->
                    <div class="mt-5 float-right">
                        <a href="<c:url value='/pa' />" class="btn btn-secondary btn-icon-split">
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

    <!-- SweetAlert2 -->
    <script src="<c:url value='/back/js/sweetalert2@11.js' />"></script>
    <script>
        $(document).ready(function(){
            
            // Sidebar
            $("#Company_PA, #CP").addClass('active')
            $("#collapseCP").addClass('show')

            // confirm
            $('#submitButton').on('click', function(){
                Swal.fire({
                    title: 'Are you sure?',
                    text: "You won't be able to revert this!",
                    icon: 'warning',
                    showCancelButton: true,
                    confirmButtonColor: '#3085d6',
                    cancelButtonColor: '#d33',
                    confirmButtonText: 'Yes, update it!'
                    }).then((result) => {
                    if (result.isConfirmed) {
                        Swal.fire({
                            title: 'Upload File Please Wait......'
                        });
                        Swal.showLoading();

                        var xhr = new XMLHttpRequest();
                        xhr.open("PUT", "<c:url value='/paUpdate' />", true);
                        xhr.setRequestHeader("Content-Type", "application/json");
                        var bean = {
                            "company_ID" :   ${bean.company_ID},
                            "company_Name" : "${bean.company_Name}",
                            "income" :       $('#income').val(),
                            "gross_Margin" : $('#gross_Margin').val(),
                            "operating_Profit_Ratio" :  $('#operating_Profit_Ratio').val(),
                            "net_Income_Margin" :       $('#net_Income_Margin').val(),
                            "net_Profit_Margin" :       $('#net_Profit_Margin').val()
                        }
                        // console.log(JSON.stringify(bean))
                        xhr.send(JSON.stringify(bean));
                        xhr.onreadystatechange = function() {
                            if (xhr.readyState == 4 && xhr.status == 200) {
                                if(xhr.responseText){
                                    Swal.fire(
                                        'Update!',
                                        'Your file has been update.',
                                        'success'
                                    )
                                    setTimeout(function(){
                                        location.replace("<c:url value='/pa' />");   
                                    },1500);
                                }else{
                                    Swal.fire({
                                        // timer: 1500,
                                        icon: 'error',
                                        title: 'Oops...',
                                        text: 'Something went wrong!',
                                        // footer: '<a href="">Why do I have this issue?</a>'
                                    })
                                }
                            }

                            if (xhr.readyState == 4 && xhr.status != 200) {
                                Swal.fire({
                                    // timer: 1500,
                                    icon: 'error',
                                    title: 'Oops...',
                                    text: 'Something went wrong!',
                                    // footer: '<a href="">Why do I have this issue?</a>'
                                })
                            }

                        }
                        
                        

                    }
                })
            })

        })

    </script>

</body>

</html>