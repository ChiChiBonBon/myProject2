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

<!-- 所有的<th>標籤都會有以下 -->
    <style>
     th {
     text-align: center;
     }
    </style>
    
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
                
                
             
				<div id="dataArea"></div> 
                
                

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
		
		let dataArea = null;
		window.addEventListener('load', function() {

			dataArea = document.getElementById("dataArea");
			let xhr = new XMLHttpRequest();
			xhr.open('GET', "<c:url value='/back/admin_1/findAdminAllMember_1' />", true);
			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4 && xhr.status == 200) {
					console.log(xhr.responseText);
					dataArea.innerHTML = showData(xhr.responseText);
					
					
		            /* js 重新渲染 jsp行程順序不一樣 所以用這個方式重新跑一次 */
		            $('.tabletest').attr('id', 'dataTable')
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
					
		            
					console.log(dataArea)
				}
			};
			xhr.send();
		});
		
		function showData(textObj) {

			let obj = JSON.parse(textObj);
			let size = obj.size;
			let members = obj.list;

			let segment = `<div class="container-fluid">
			
								<div class="card shadow mb-4">
									<div class="card-header py-3">
										<h6 class="m-0 font-weight-bold text-primary float-left">所有會員資料</h6>
										
										<button class="btn btn-info float-right" onclick="update_info()" id="update_butten" >修改資料</button>
										
									</div>
									<div class="card-body">
										<div class="table-responsive">
											<table class="table table-bordered tabletest" id="" width="100%" cellspacing="0">`;
											
	    	    segment += `                	 <thead>
													<tr>
														<th>帳號</th>
														<th>證卷號</th>
														<th>Email</th>
														<th>額度</th>
														<th>權限</th>
														<th>其他個資</th>
														<th>註冊時間</th>
														<th>會員狀態</th>
													</tr>
												</thead>
												<tfoot>
													<tr>
														<th>帳號</th>
														<th>證卷號</th>
														<th>Email</th>
														<th>額度</th>
														<th>權限</th>
														<th>其他個資</th>	
														<th>註冊時間</th>
														<th>會員狀態</th>
													</tr>
												</tfoot>
												
												<tbody>`;


				for (n = 0; n < members.length; n++) {
					let member = members[n];
					let path_memberid = member.id;
					
					/* 其他個資超連結 */
					let member_other_info_path = `<c:url value = "/back/admin_1/goAdminMemberOtherInfo_1?id=" />` + path_memberid;
					let member_other_info = `<a href=` + member_other_info_path + `>` + "其他個資" + `</a>`;
					
					
					segment += `				<tr>`
					segment += 						"<th hidden id='member_idForfinal_update'>" + member.id + "</th>";
					segment += 						"<th>" + member.account + "</th>";
					segment += 						"<th width=150px>" + member.member_stock_ID + "</th>";
					segment += 						"<th>" + member.e_mail + "</th>";
					
					segment += 						"<th width=150px name='member_member_quote'>" + 
														 member.member_quote + 
													"</th>";
					
					
					segment += 						"<th width=100px name='member_member_auth'>" +
														member.member_auth +
													"</th>";
					
					segment += 						"<th width=100px>" + member_other_info + "</th>";
					
					/* 換時間格式 */
					var date_fromat = new Date(member.registertime)
					segment += 						"<th width=250px>" + date_fromat.toLocaleString() + "</th>";
					
					
					
					segment += 						"<th width=150px name='member_member_status'>" +
														member.member_status +
													"</th>";
													
					segment += `							
												</tr>`;
				}
			segment += `						</tbody>
			
											</table>
										</div>
									</div>
								</div>`

			return segment;
		}
		
	</script>
    
    <script>
    /* 變換修改模式和修改完成模式 */
    	let mode = "unedit"
    	let final_member_quote = "";
    	let final_member_auth = "";
    	let final_member_status = "";
    	
    	function update_info() {
    		if (mode == "unedit") {
    			/* 換模式 把<th> 標籤中 input 換掉或放回去*/
    			let member_quote = document.getElementsByName("member_member_quote");
        		console.log(typeof(member_quote), member_quote);
        		for (let Quote of member_quote) {
        			Quote.innerHTML = "<input class='form-control form-control-sm' value='" + Quote.innerText +  "'>" ;
        		}
        		
        		/* 換模式 把<th> 標籤中 input 換掉或放回去*/
        		let member_auth = document.getElementsByName("member_member_auth");
        		for (let Auth of member_auth) {
        			
        			segment = "";
        			if (Auth.innerText == "一般戶") {
						segment += 	"<option value='一般戶' selected>一般戶</option>"
					} else {
						segment += 	"<option value='一般戶' >一般戶</option>"
					}
					if (Auth.innerText == "信用戶") {
						segment += 	"<option value='信用戶' selected>信用戶</option>"
					} else {
						segment += 	"<option value='信用戶' >信用戶</option>"
					}
					if (Auth.innerText == "停權戶") {
						segment += 	"<option value='停權戶' selected>停權戶</option>"
					} else {
						segment += 	"<option value='停權戶' >停權戶</option>"
					}
					segment += "</select></lable>";
					
					Auth.innerHTML = 					"<label for='auth_select'>" + 
															"<select id='auth_select' class='form-control form-control-sm'>" +
															segment;
        		}
        		
        		/* 換模式 把<th> 標籤中 input 換掉或放回去*/
        		let member_status = document.getElementsByName("member_member_status");
        		for (let Status of member_status) {
        			
        			segment = "";
        			if (Status.innerText == "unactivated") {
						segment += 	"<option value='unactivated' selected>unactivated</option>"
					} else {
						segment += 	"<option value='unactivated' >unactivated</option>"
					}
					if (Status.innerText == "activated") {
						segment += 	"<option value='activated' selected>activated</option>"
					} else {
						segment += 	"<option value='activated' >activated</option>"
					}
					if (Status.innerText == "activated") {
						segment += 	"<option value='deleted' selected>deleted</option>"
					} else {
						segment += 	"<option value='deleted' >deleted</option>"
					}
					segment += "</select></lable>";
					
        			Status.innerHTML = 					"<label for='status_select'>" + 
															"<select id='status_select' class='form-control form-control-sm'>" +
															segment;
        		}
        		
        		c = document.getElementById("update_butten");
        		c.className = "btn btn-danger float-right";
        		c.innerText = "修改完成";
        		mode = "edit";
    		
        		
    		} else if (mode == "edit") {
    			/* 換模式 把<th> 標籤中 input 換掉或放回去*/
    			let member_quote = document.getElementsByName("member_member_quote");
        		console.log(typeof(member_quote), member_quote);
        		for (let Quote of member_quote) {
        			Quote.innerHTML = Quote.children[0].value;
        			final_member_quote = Quote.innerHTML;
        			console.log("final_member_quote" + final_member_quote);
        		}
        		
        		/* 換模式 把<th> 標籤中 input 換掉或放回去*/
        		let member_auth = document.getElementsByName("member_member_auth");
        		for (let Auth of member_auth) {
        			/* select 包成很多層 要寫很多層才能抓到資料 */
        			Auth.innerHTML = Auth.children[0].children[0].selectedOptions[0].value;
        			final_member_auth = Status.innerHTML;
        			console.log("final_member_auth" + final_member_auth);
        		}
        		
        		/* 換模式 把<th> 標籤中 input 換掉或放回去*/
        		let member_status = document.getElementsByName("member_member_status");
        		for (let Status of member_status) {
        			/* select 包成很多層 要寫很多層才能抓到資料 */
        			Status.innerHTML = Status.children[0].children[0].selectedOptions[0].value;
        			final_member_status = Status.innerHTML;
        			console.log("final_member_status" + final_member_status);
        		}
        		
        		c = document.getElementById("update_butten");
        		c.className = "btn btn-success float-right";
        		c.innerText = "修改資料";
        		mode = "unedit";
        		
        		
        		let xhrUpdateAjax = new XMLHttpRequest();
        		xhrUpdateAjax.open("POST", "<c:url value='/back/admin_1/saveAdminMemberInfo_1' />", true);
        		xhrUpdateAjax.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        		
        		final_member_id = document.getElementById("member_idForfinal_update");
        		let content = "";
        		content += "member_id" + final_member_id;
        		content += "&member_quote=" + final_member_quote;
        		content += "&member_auth=" + final_member_auth;
        		content += "&member_status=" + final_member_status;
        		xhrUpdateAjax.send(content);
        		

        		xhr1.onreadystatechange = function() {
        		if (xhr1.readyState == 4 && (xhr1.status == 200 || xhr1.status == 201) ) {
					result = JSON.parse(xhr1.responseText);
        		}
        		} 
        		
    		}
    	}
    		
    </script>

	<script>
		$(function(){
            // Sidebar
            $("#dashboard").addClass('active')
            
		})
	</script>
	

</body>

</html>