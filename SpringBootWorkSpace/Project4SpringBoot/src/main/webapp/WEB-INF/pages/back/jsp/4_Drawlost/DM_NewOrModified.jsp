<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>股票申購管理</title>

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
                        <h1 class="h3 mb-1 text-gray-800">新增或修改資料</h1>
                    </div>
                    <p class="mb-4"></p>
                    
                    
                    <!-- form -->
                    <div class="border border-secondary rounded bg-white">
                        <form class="p-4">
                            <!-- ID -->
                            <div class="row mb-3">
                                <div class="col-6 form-group row">
                                    <label class="col-sm-2 col-form-label text-primary">股票代碼</label>
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control text-dark" 
                                        placeholder="${bean.stockCode}" readonly >
                                    </div>
                                </div>
                            </div>
                            <hr class="mb-4">
                            <!-- Content -->
                            <div class="row">
                                <div class="col-6 form-group row">
                                    <label class="col-sm-2 col-form-label text-primary">公司名稱</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" placeholder="範例: 台積電" id="stockName" value="${bean.stockName}">
                                        <div id="" class="invalid-feedback">請輸入文字</div>
                                    </div>
                                </div>
                                <div class="col-6 form-group row">
                                    <label class="col-sm-2 col-form-label text-primary">市場別</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" placeholder="範例: 上市" id="marketType" value="${bean.marketType}">
                                        <div id="" class="invalid-feedback">請輸入文字</div>
                                    </div>
                                </div>
                                <div class="col-6 form-group row">
                                    <label class="col-sm-2 col-form-label text-primary">申購狀態</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" placeholder="範例: 申購失敗" id="subscribeStatus" value="${bean.subscribeStatus}">
                                        <div id="" class="invalid-feedback">請輸入文字</div>
                                    </div>
                                </div>
                                <div class="col-6 form-group row">
                                    <label class="col-sm-2 col-form-label text-primary">承銷價</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" placeholder="範例: 168" id="subscribePrice" value="${bean.subscribePrice}">
                                        <div id="" class="invalid-feedback">請輸入數字</div>
                                    </div>
                                </div>
                                <div class="col-6 form-group row">
                                    <label class="col-sm-2 col-form-label text-primary">申購股數</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" placeholder="範例: 1000" id="quantity" value="${bean.quantity}">
                                        <div id="" class="invalid-feedback">請輸入數量</div>
                                    </div>
                                </div>
                                <div class="col-6 form-group row">
                                    <label class="col-sm-2 col-form-label text-primary">開始日</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" placeholder="範例: 2021-07-13" id="startDate" value="${bean.startDate}">
                                        <div id="" class="invalid-feedback">請輸入日期</div>
                                    </div>
                                </div>
                                <div class="col-6 form-group row">
                                    <label class="col-sm-2 col-form-label text-primary">結束日</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" placeholder="範例: 2021-07-13" id="endDate" value="${bean.endDate}">
                                        <div id="" class="invalid-feedback">請輸入日期</div>
                                    </div>
                                </div>
                                <div class="col-6 form-group row">
                                    <label class="col-sm-2 col-form-label text-primary">扣款日</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" placeholder="範例: 2021-07-12" id="deductionDate" value="${bean.deductionDate}">
                                        <div id="" class="invalid-feedback">請輸入日期</div>
                                    </div>
                                </div>
                                <div class="col-6 form-group row">
                                    <label class="col-sm-2 col-form-label text-primary">抽籤日</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" placeholder="範例: 2021-07-13" id="drawDate" value="${bean.drawDate}">
                                        <div id="" class="invalid-feedback">請輸入日期</div>
                                    </div>
                                </div>
                                <div class="col-6 form-group row">
                                    <label class="col-sm-2 col-form-label text-primary">抽籤日</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" placeholder="範例: 2021-07-14" id="refundDate" value="${bean.refundDate}">
                                        <div id="" class="invalid-feedback">請輸入日期</div>
                                    </div>
                                </div>
                                <div class="col-6 form-group row">
                                    <label class="col-sm-2 col-form-label text-primary">撥券日</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" placeholder="範例: 2021-07-13" id="grantSecuritiesDate" value="${bean.grantSecuritiesDate}">
                                        <div id="" class="invalid-feedback">請輸入日期</div>
                                    </div>
                                </div>
                                <div class="col-6 form-group row">
                                    <label class="col-sm-2 col-form-label text-primary">承銷股數</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" placeholder="範例: 3000000" id="totalQuantity" value="${bean.totalQuantity}">
                                        <div id="" class="invalid-feedback">請輸入數量</div>
                                    </div>
                                </div>
                                <div class="col-6 form-group row">
                                    <label class="col-sm-2 col-form-label text-primary">更新時間</label>
                                    <div class="col-sm-9">                           		
                                        <input type="text" class="form-control" placeholder="" readonly id="updateTime" value="<fmt:formatDate value='${bean.updateTime}' pattern='yyyy-MM-dd HH:mm:ss'/>">
                                        <div id="" class="invalid-feedback">請輸入時間</div>
                                    </div>
                                </div>
                                <div class="col-6 form-group row">
                                    <label class="col-sm-2 col-form-label text-primary">備註</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" placeholder="範例: 資料有問題申購失敗，請洽所屬營業員" id="remarks" value="${bean.remarks}">
                                        <div id="" class="invalid-feedback">請輸入文字</div>
                                    </div>
                                </div>
                            </div>

                            <Button type="button" class="btn btn-primary" id="submitButton">送出</button>
                            <input type="reset"  class="btn btn-primary" value="清除">
                        </form>
                    </div>
                    <!-- 返回前頁 Button -->
                    <div class="mt-5 float-right">
                        <a href="<c:url value='/back/drawlots' />" class="btn btn-secondary btn-icon-split">
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
			$("#dashboard").removeClass('active')
            
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
                        xhr.open("PUT", "<c:url value='/back/drawlots/update' />", true);
                        xhr.setRequestHeader("Content-Type", "application/json");
                        var bean = {
                            "stockCode":${bean.stockCode},
                            "stockName":$('#stockName').val(),
                            "marketType":$('#marketType').val(),
                            "subscribeStatus":$('#subscribeStatus').val(),
                            "subscribePrice":$('#subscribePrice').val(),
                            "quantity":$('#quantity').val(),
                            "startDate":$('#startDate').val(),
                            "endDate":$('#endDate').val(),
                            "deductionDate":$('#deductionDate').val(),
                            "drawDate":$('#drawDate').val(),
                            "refundDate":$('#refundDate').val(),
                            "grantSecuritiesDate":$('#grantSecuritiesDate').val(),
                            "totalQuantity":$('#totalQuantity').val(),
                            "updateTime":new Date().getTime(),
                            "remarks":$('#remarks').val()                         
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
                                        location.replace("<c:url value='/back/drawlots' />");   
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

            // Check Number
            $('#income').on('change', function () {
                if (isNaN($('#income').val())) {
                    $('#income').addClass('is-invalid')
                } else {
                    $('#income').removeClass('is-invalid')
                }
            })
            $('#gross_Margin').on('change', function () {
                if (isNaN($('#gross_Margin').val())) {
                    $('#gross_Margin').addClass('is-invalid')
                } else {
                    $('#gross_Margin').removeClass('is-invalid')
                }
            })
            $('#operating_Profit_Ratio').on('change', function () {
                if (isNaN($('#operating_Profit_Ratio').val())) {
                    $('#operating_Profit_Ratio').addClass('is-invalid')
                } else {
                    $('#operating_Profit_Ratio').removeClass('is-invalid')
                }
            })
            $('#net_Income_Margin').on('change', function () {
                if (isNaN($('#net_Income_Margin').val())) {
                    $('#net_Income_Margin').addClass('is-invalid')
                } else {
                    $('#net_Income_Margin').removeClass('is-invalid')
                }
            })
            $('#net_Profit_Margin').on('change', function () {
                if (isNaN($('#net_Profit_Margin').val())) {
                    $('#net_Profit_Margin').addClass('is-invalid')
                } else {
                    $('#net_Profit_Margin').removeClass('is-invalid')
                }
            })
        })

    </script>

</body>

</html>