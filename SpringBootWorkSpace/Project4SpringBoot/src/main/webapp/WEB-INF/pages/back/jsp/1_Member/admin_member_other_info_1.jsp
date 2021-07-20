<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>管理會員中心</title>

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
                
                <div id="member_id_passing" style="display:none;">${id}</div>
                <br><br><br>
                <form>
                    <div class="row justify-content-md-center">
                      <div class="form-group col-md-4">
                        <label for="member_birthday_json">生日</label>
                        <input type="date" class="form-control" id="member_birthday_json" readonly>
                      </div>
                      <div class="form-group col-md-2">
                        <label for="member_gender_json">性別</label>
                        <input type="text" class="form-control" id="member_gender_json" readonly>
                      </div>
                      <div class="form-group col-md-3">
                        <label for="member_job_json">職業</label>
                        <input type="text" class="form-control" id="member_job_json" readonly>
                      </div>
                    </div>
                    
                    <div class="row justify-content-md-center">
                     <div class="form-group col-md-9">
                       <label for="member_address_json">地址</label>
                       <input type="text" class="form-control" id="member_address_json" placeholder="" readonly>
                     </div>
                   </div>

                    <div class="row justify-content-md-center">
                      <div class="form-group col-md-3">
                        <label for="member_cellphone_json">電話</label>
                        <input type="text" class="form-control" id="member_cellphone_json" readonly>
                      </div>
                      <div class="form-group col-md-3">
                        <label for="member_carrier_json">載具</label>
                        <input type="text" class="form-control" id="member_carrier_json" readonly>
                      </div>
                      <div class="form-group col-md-3">
                        <label for="inmember_nickname_jsonputZip">別稱</label>
                        <input type="text" class="form-control" id="member_nickname_json" readonly>
                      </div>
                    </div>
                    
<!--                     <div class="row justify-content-end">
                      <div class="col-3">
                        <button type="submit" class="btn btn-primary">Sign in</button>
                      </div>
                    </div> -->
                </form>
				
                

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
<%--     <script src="<c:url value='/back/vendor/chart.js/Chart.min.js' />"></script> --%>

    <!-- Page level custom scripts -->
<%--     <script src="<c:url value='/back/js/demo/chart-area-demo.js' />"></script> --%>
<%--     <script src="<c:url value='/back/js/demo/chart-pie-demo.js' />"></script> --%>


<!-- 這三行 js 讀不到 所以需要下面來重新渲染 -->

<!-- Page level plugins -->
    <script src="<c:url value='/back/vendor/datatables/jquery.dataTables.min.js' />"></script>
    <script src="<c:url value='/back/vendor/datatables/dataTables.bootstrap4.min.js' />"></script>

    <!-- Page level custom scripts -->
    <script src="<c:url value='/back/js/demo/datatables-demo.js' />"></script>


	<script>

        let id_passing = document.getElementById("member_id_passing").innerHTML
		let dataArea = null;
		window.addEventListener('load', function() {

			dataArea = document.getElementById("dataArea");
			let xhr = new XMLHttpRequest();
			xhr.open('GET', "<c:url value='/back/admin_1/findAdminOtherMemberInfo_1?id=' />" + id_passing, true);
			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4 && xhr.status == 200) {
					console.log(xhr.responseText); 

                    dataArea = JSON.parse(xhr.responseText);
 
                    document.getElementById("member_birthday_json").value = dataArea.birthday;
                    document.getElementById("member_gender_json").value = dataArea.gender;
                    document.getElementById("member_nickname_json").value = dataArea.nickname;
                    document.getElementById("member_cellphone_json").value = dataArea.cellphone;
                    document.getElementById("member_address_json").value = dataArea.address;
/*                     document.getElementById("member_job_json").value = dataArea.jobType_id.job;
 */                    document.getElementById("member_carrier_json").value = dataArea.carrier;
                    


					
		            // /* js 重新渲染 jsp行程順序不一樣 所以用這個方式重新跑一次 */
		            // $('.tabletest').attr('id', 'dataTable')
		            // var scriptsToLoad = [
		            // 	"<c:url value='/back/vendor/datatables/jquery.dataTables.min.js' />", 
		            // 	"<c:url value='/back/vendor/datatables/dataTables.bootstrap4.min.js' />",
		            // 	"<c:url value='/back/js/demo/datatables-demo.js' />"
		            // ]; 
		            // scriptsToLoad.forEach(function(src) {
		            // 	var script = document.createElement('script');
		            // 	script.src = src;
		            // 	script.async = false;
		            // 	document.body.appendChild(script);
		            // });
					
					console.log(dataArea)
				}
			};
			xhr.send();
		});

	</script>


	<script>
		$(function(){
            // Sidebar
            $("#dashboard").addClass('active')
            
		})
	</script>
	

</body>

</html>