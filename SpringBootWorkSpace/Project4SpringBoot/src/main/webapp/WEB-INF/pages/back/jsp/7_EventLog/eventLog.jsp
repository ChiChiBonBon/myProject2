<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>STOCK OVERFLOW</title>

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
                    <div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <h1 class="h3 mb-1 text-gray-800">事件紀錄</h1>
                    </div>
                    <p class="mb-4">這裡提供管理者查閱網站事件，部分資料會需要初始化，基本上會自動匯入，如果發現資料異常或是篩選條件沒有資料，請按鍵按鈕將初始資料匯入資料庫。<button
                            type="button" class="btn btn-secondary btn-sm" id="initData">初始資料匯入</button></p>


                    <!-- 事件篩選 -->
                    <div>
                        <form>
                            <div class="row">

                                <div class="form-group col-4">
                                    <label for="FormControlSelect2">時間</label>
                                    <input id="startDate" type="date" class="form-control" name="startDate"
                                        max="" value="">
                                </div>

                                <%-- <div class="form-group col-2">
                                    <label for="FormControlSelect2">結束時間</label>
                                    <input id="endDate" type="date" class="form-control" name="endDate" min=""
                                        value="">
                                </div> --%>

                                <div class="form-group col-4">
                                    <label for="severityType">嚴重度</label>
                                    <select class="form-control" id="severityType">
                                        <option>all</option> 
                                        <c:forEach items="${severityList}" var="severitybean">        
                                            <option>${severitybean.severityType}</option> 
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="form-group col-4">
                                    <label for="authorityType">使用者類別</label>
                                    <select class="form-control" id="authorityType">
                                        <option>all</option>    
                                        <c:forEach items="${authorityList}" var="authoritybean">        
                                            <option>${authoritybean.authorityType}</option> 
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                        </form>

                    </div>

                    <!-- 篩選按鈕 -->
                    <div class="btn btn-secondary btn-icon-split mb-3 " id="searchButton">

                        <span class="icon text-white-50">
                            <i class="fas fa-search"></i>
                        </span>
                        <span class="text">條件篩選</span>
                    </div>



                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <!-- 更新按鈕 -->
                            <h6 class="m-0 font-weight-bold text-primary">搜尋結果
                                <span href="#" class="btn btn-warning btn-circle btn-sm float-right" id="updateButton">
                                    <i class="fas fa-undo"></i>
                                </span>
                            </h6>
                        </div>

                        <div class="card-body">
                            <div class="table-responsive" id="TableAreaMax">
                                
                            </div>
                        </div>
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
		$(function(){
            // Sidebar
            $("#eventLog, #Event").addClass('active')
            $("#collapseEvent").addClass('show')
            
            // 初始內容
            select_Basic_Tabel()

            // 時間設定
            // let maxData
            // let minDate

            // $('#startDate').on('change', function () {
            //     minDate = $('#startDate').val()
            //     $('#endDate').attr('min', minDate)
            // })
            // $('#endDate').on('change', function () {
            //     maxData = $('#endDate').val()
            //     $('#startDate').attr('max', maxData)
            // })

            // Select Basic Table
            function select_Basic_Tabel() {
                let xhr = new XMLHttpRequest();
                xhr.open("GET", "<c:url value='/back/eventLog/showAllData' />", true);
                xhr.send()
                xhr.onreadystatechange = function() {
                    if (xhr.readyState == 4 && xhr.status == 200) {
                        $('#TableAreaMax').html(showEventAll(xhr.responseText))
                        // $('.tableArea').attr('id', 'dataTable')
                        $('#dataTable').dataTable({"aaSorting": [[0, "desc"]]});        
//                         let scriptsToLoad = [
//                             "<c:url value='/back/vendor/datatables/jquery.dataTables.min.js' />", 
//                             "<c:url value='/back/vendor/datatables/dataTables.bootstrap4.min.js' />",
//                             "<c:url value='/back/js/demo/datatables-demo.js' />"
//                         ]; 

//                         scriptsToLoad.forEach(function(src) {
//                             let script = document.createElement('script');
//                             script.src = src;
//                             script.async = false;
//                             document.body.appendChild(script);
//                         });
                    }
                }
            }

            // 初始化資料
            $('#initData').on('click', function(){
                let xhr = new XMLHttpRequest();
                xhr.open("GET", "<c:url value = '/back/eventLog/initData'/>", true);
                xhr.send();

                xhr.onreadystatechange = function(){
                    if(xhr.readyState == 4 && xhr.status == 200){
                        if(xhr.responseText){
                            Swal.fire({
                                icon: 'success',
                                title: '已成功初始化資料',
                                showConfirmButton: false,
                                timer: 1500
                            })
                        } 
                    }
                }
            })

            // 篩選資料 
            $("#searchButton").on("click", function () {
                
                let startDate = $('#startDate').val();
                let severityType = $('#severityType').val();
                let authorityType = $('#authorityType').val();

                if(startDate == ""){
                    startDate = "all"
                }

                console.log(startDate)
                console.log(severityType)
                console.log(authorityType)
                console.log("===")
                let xhr = new XMLHttpRequest();
                xhr.open("POST", "<c:url value='/back/eventLog/filter' />", true);
                let sendData = "startDate="+startDate  +"&severityType="+severityType  +"&authorityType="+authorityType
                xhr.setRequestHeader('Content-Type', "application/x-www-form-urlencoded");
                xhr.send(sendData)
                xhr.onreadystatechange = function() {
                    if (xhr.readyState == 4 && xhr.status == 200) {
                        $('#TableAreaMax').html(showEventAll(xhr.responseText))
                        $('#dataTable').dataTable({"aaSorting": [[0, "desc"]]});        
//                         let scriptsToLoad = [
//                             "<c:url value='/back/vendor/datatables/jquery.dataTables.min.js' />", 
//                             "<c:url value='/back/vendor/datatables/dataTables.bootstrap4.min.js' />",
//                             "<c:url value='/back/js/demo/datatables-demo.js' />"
//                         ]; 

//                         scriptsToLoad.forEach(function(src) {
//                             let script = document.createElement('script');
//                             script.src = src;
//                             script.async = false;
//                             document.body.appendChild(script);
//                         });
                    }
                }

            })

            // 更新資料
            $("#updateButton").on("click", function () {
                select_Basic_Tabel()
            })

            

            // Event Log
            function showEventAll(text){
                let beans = JSON.parse(text);
                
                let segment = ""

                segment += `<table class="table table-bordered  table-sm" id="dataTable" width="100%" cellspacing="0">`
                segment += 
                    `<thead>
                        <tr>
                            <th width="15%">時間</th>
                            <th width="10%">嚴重度</th>
                            <th width="10%">用戶類別</th>
                            <th width="10%">用戶</th>
                            <th>內容</th>
                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                            <th>時間</th>
                            <th>嚴重度</th>
                            <th>用戶類別</th>
                            <th>用戶</th>
                            <th>內容</th>
                        </tr>
                    </tfoot>`

                segment += `<tbody>`												
                for(let x in beans){
                    let bean = beans[x]
                    let badge = `badge-`+ bean.severity.severityType
                    segment += 
                        `<tr>
                            <td>` + bean.date + `</td>
                            <td><span class="badge badge-pill `+ badge +`">` + bean.severity.severityType + `</span></td>
                            <td>` + bean.authority.authorityType + `</td>
                            <td>` + bean.person + `</td>
                            <td>` + bean.content + `</td>
                        </tr>`
                }
                segment += `</tbody>`
                segment += `</table>`
                return segment;
            }


		})
	</script>


</body>

</html>