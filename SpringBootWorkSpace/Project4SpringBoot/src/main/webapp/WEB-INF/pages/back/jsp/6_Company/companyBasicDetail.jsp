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
                        <span class="text-primary">${bean.company_NikeName}(${bean.stock})</span>
                         
                        
                        <span class="btn btn-danger btn-icon-split float-right">
                            <span class="icon text-white-50">
                                <i class="fas fa-trash"></i>
                            </span>
                            <span class="text">刪除</span>
                            
                        </span>
                        <span class="float-right">&emsp;</span> 
                        <span class="btn btn-warning btn-icon-split float-right " id="update">
                            <span class="icon text-white-50">
                                <i class="fas fa-exclamation-triangle"></i>
                            </span>
                            <span class="text" id="updateArea">修該</span>
                        </span>
                    </h1>
                    
                   
                    <!-- form -->
                    <div class="border border-secondary rounded bg-white">
                        <!-- <h2 id='id'>2330</h2> -->
                        
                        <!-- API -->
                        <div class="justify-content-center d-flex mt-5">
                            <iframe id="Top5"  src="https://s.yimg.com/nb/tw_stock_frontend/scripts/StxChart/StxChart.9d11dfe155.html?sid=${bean.stock}" style="width: 560px; height: 382px; border-width: 0;"></iframe>
                        </div>
                        
                        <!-- 送出資料 Button -->
                        <div class="btn btn-primary btn-icon-split ml-4 my-3" id="updateSend" style="display:none">
                            <span class="icon text-white-50">
                                <i class="fas fa-exclamation-triangle"></i>
                            </span>
                            <span class="text" id="updateArea">送出資料</span>
                        </div>
                        <!-- 詳細資料 -->
                        <form id="formArea" enctype="multipart/form-data">
                            <div class="row text-dark" >
                                <div class="col-4">
                                    <ul class="list-group list-group-flush">
                                    
                                        <li class="list-group-item">出表日期:&emsp; <input class="form-control" type="date" value="${bean.formData}" name="formData" readonly></li>
                                        <li class="list-group-item">公司代號:&emsp; <input class="form-control" type="text" value="${bean.stock}" name="stock" readonly></li>
                                        <li class="list-group-item">公司名稱:&emsp; <input class="form-control read" type="text" placeholder="-----" value="${bean.company_Name}" name="company_Name" readonly> </li>
                                        <li class="list-group-item">公司簡稱:&emsp; <input class="form-control read" type="text" placeholder="-----" value="${bean.company_NikeName}" name="company_NikeName" readonly> </li>
                                        <li class="list-group-item">外國企業註冊地國:&emsp; <input class="form-control read" type="text" placeholder="-----" value="${bean.foreign_Country}" name="foreign_Country" readonly> </li>
                                        <li class="list-group-item">產業別:&emsp; <input class="form-control read" type="text" placeholder="-----" value="${bean.industry_No}" name="industry_No" readonly> </li>
                                        <li class="list-group-item">住址:&emsp; <input class="form-control read" type="text" placeholder="-----" value="${bean.company_Location}" name="company_Location" readonly> </li>
                                        <li class="list-group-item">營利事業統一編號:&emsp; <input class="form-control read" type="text" placeholder="-----" value="${bean.business_Accounting_NO}" name="business_Accounting_NO" readonly> </li>
                                        <li class="list-group-item">董事長:&emsp; <input class="form-control read" type="text" placeholder="-----" value="${bean.chairman_Board}" name="chairman_Board" readonly> </li>
                                        <li class="list-group-item">總經理:&emsp; <input class="form-control read" type="text" placeholder="-----" value="${bean.general_Manager}" name="general_Manager" readonly> </li>
                                        <li class="list-group-item">發言人:&emsp; <input class="form-control read" type="text" placeholder="-----" value="${bean.spokesman}" name="spokesman" readonly> </li>
                                        <li class="list-group-item"> </li>
                                    </ul>
                                </div>
                                <div class="col-4">
                                    <ul class="list-group list-group-flush">
                                        <li class="list-group-item">發言人職稱:&emsp; <input class="form-control read" type="text" placeholder="-----" value="${bean.spokesman_Title}" name="spokesman_Title" readonly> </li>
                                        <li class="list-group-item">代理發言人:&emsp; <input class="form-control read" type="text" placeholder="-----" value="${bean.spokesman_Acting}" name="spokesman_Acting" readonly> </li>
                                        <li class="list-group-item">總機電話:&emsp; <input class="form-control read" type="text" placeholder="-----" value="${bean.telephone}" name="telephone" readonly> </li>
                                        <li class="list-group-item">成立日期:&emsp; <input class="form-control read" type="date" placeholder="-----" value="${bean.establishment_Date}" name="establishment_Date" readonly> </li>
                                        <li class="list-group-item">上市日期:&emsp; <input class="form-control read" type="date" placeholder="-----" value="${bean.appear_Market_Date}" name="appear_Market_Date" readonly> </li>
                                        <li class="list-group-item">普通股每股面額:&emsp; <input class="form-control read" type="text" placeholder="-----" value="${bean.denomination_per_Stock}" name="denomination_per_Stock" readonly> </li>
                                        <li class="list-group-item">實收資本額:&emsp; <input class="form-control read" type="text" placeholder="-----" value="${bean.paid_In_Capital_Amount}" name="paid_In_Capital_Amount" readonly> </li>
                                        <li class="list-group-item">私募股數:&emsp; <input class="form-control read" type="text" placeholder="-----" value="${bean.private_Equity_Stock}" name="private_Equity_Stock" readonly> </li>
                                        <li class="list-group-item">特別股:&emsp; <input class="form-control read" type="text" placeholder="-----" value="${bean.special_Stock}" name="special_Stock" readonly> </li>
                                        <li class="list-group-item">編制財務報表類型:&emsp; <input class="form-control read" type="text" placeholder="-----" value="${bean.financial_Statements_Types}" name="financial_Statements_Types" readonly> </li>
                                        <li class="list-group-item">股票過戶機構:&emsp; <input class="form-control read" type="text" placeholder="-----" value="${bean.transfer_Agency}" name="transfer_Agency" readonly> </li>
                                        <li class="list-group-item"> </li>
                                    </ul>
                                </div>
                                <div class="col-4">
                                    <ul class="list-group list-group-flush">
                                        <li class="list-group-item">過戶電話:&emsp; <input class="form-control read" type="text" placeholder="-----" value="${bean.agency_Telephone}" name="agency_Telephone" readonly> </li>
                                        <li class="list-group-item">過戶地址:&emsp; <input class="form-control read" type="text" placeholder="-----" value="${bean.agency_Location}" name="agency_Location" readonly> </li>
                                        <li class="list-group-item">簽證會計師事務所:&emsp; <input class="form-control read" type="text" placeholder="-----" value="${bean.accounting_Firm}" name="accounting_Firm" readonly> </li>
                                        <li class="list-group-item">簽證會計師1:&emsp; <input class="form-control read" type="text" placeholder="-----" value="${bean.accounting_Person_1}" name="accounting_Person_1" readonly> </li>
                                        <li class="list-group-item">簽證會計師2:&emsp; <input class="form-control read" type="text" placeholder="-----" value="${bean.accounting_Person_2}" name="accounting_Person_2" readonly> </li>
                                        <li class="list-group-item">英文簡稱:&emsp; <input class="form-control read" type="text" placeholder="-----" value="${bean.company_NikeName_EN}" name="company_NikeName_EN" readonly> </li>
                                        <li class="list-group-item">英文通訊地址:&emsp; <input class="form-control read" type="text" placeholder="-----" value="${bean.company_Location_EN}" name="company_Location_EN" readonly> </li>
                                        <li class="list-group-item">傳真機號碼:&emsp; <input class="form-control read" type="text" placeholder="-----" value="${bean.fax_Telephone}" name="fax_Telephone" readonly> </li>
                                        <li class="list-group-item">電子郵件信箱:&emsp; <input class="form-control read" type="text" placeholder="-----" value="${bean.email}" name="email" readonly> </li>
                                        <li class="list-group-item">網址:&emsp; <input class="form-control read" type="text" placeholder="-----" value="${bean.web_Address}" name="web_Address" readonly> </li>
                                        <li class="list-group-item"> </li>
                                    </ul>
                                </div>
                            </div>
                        </form>
                        
                        

                    </div>
                    <!-- 返回前頁 Button -->
                    <div class="mt-5 float-right">
                        <a href="<c:url value='/back/cBasic/Main' />" class="btn btn-secondary btn-icon-split">
                            <span class="icon text-white-50">
                                <i class="fas fa-arrow-right"></i>
                            </span>
                            <span class="text">返回前頁</span>
                        </a>
                    </div>


                </div>
                <!-- /.container-fluid -->

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
            $("#Company_Basic, #CP").addClass('active')
            $("#collapseCP").addClass('show')

            let readonlyBoolean = $('.read').prop("readonly")
            // UpdateCkeck
            $('#update').on('click', function(){
                $('#updateSend').toggle();
                // console.log(readonlyBoolean)
                readonlyBoolean = !readonlyBoolean
                $('.read').prop('readonly', readonlyBoolean)
                
            })

            // Update
            $('#updateSend').on('click', function(){
                console.log("update....")
                let xhr = new XMLHttpRequest();
                xhr.open("POST", "<c:url value='/back/cDetail/Update' />", true); 

                let arrayX = $('#formArea').serializeArray()
                let jsonX = {};

                for(let x in arrayX){
                    let xOb =  arrayX[x]
                    jsonX[xOb.name] = xOb.value
                }

                xhr.setRequestHeader("Content-Type", "application/json");
                xhr.send(JSON.stringify(jsonX))

                xhr.onreadystatechange = function() {
                if (xhr.readyState == 4 && (xhr.status == 200 || xhr.status == 201) ) {

                }} 
            })

          
        })

    </script>

</body>

</html>