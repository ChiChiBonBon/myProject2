<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta content="width=device-width, initial-scale=1.0" name="viewport">
	
	<title>STOCK OVERFLOW</title>
	<meta content="" name="description">
	<meta content="" name="keywords">
	
	 <!-- Google Fonts -->
	<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">
	
	<!-- Vendor CSS Files -->
	<link href="<c:url value='/front/assets/vendor/animate.css/animate.min.css' />" rel="stylesheet">
	<link href="<c:url value='/front/assets/vendor/bootstrap/css/bootstrap.min.css' />" rel="stylesheet">
	<link href="<c:url value='/front/assets/vendor/bootstrap-icons/bootstrap-icons.css' />" rel="stylesheet">
	<link href="<c:url value='/front/assets/vendor/boxicons/css/boxicons.min.css' />" rel="stylesheet">
	<link href="<c:url value='/front/assets/vendor/glightbox/css/glightbox.min.css' />" rel="stylesheet">
	<link href="<c:url value='/front/assets/vendor/swiper/swiper-bundle.min.css' />" rel="stylesheet">
	
	<!-- Back Table styles-->
	<link href="<c:url value='/front/assets/css/tableStyle.css' />" rel="stylesheet">
	<link href="<c:url value='/back/vendor/datatables/dataTables.bootstrap4.min.css' />" rel="stylesheet">

	<!-- Template Main CSS File -->
	<link href="<c:url value='/front/assets/css/style.css' />" rel="stylesheet">

</head>
<body>
	<!-- ======= A00 Cookie ======= -->
	<%@include file="/WEB-INF/pages/front/jsp/0_Util/Cookie.jsp" %>

	<!-- ======= A01 Top Bar ======= -->
	<%@include file="/WEB-INF/pages/front/jsp/0_Util/TopBar.jsp" %>

	<!-- ======= A02 Header ======= -->
	<%@include file="/WEB-INF/pages/front/jsp/0_Util/Header.jsp" %>
		
	<!-- Main -->
	<main id="main">
    <!-- ======= Breadcrumbs ======= -->
    <section id="breadcrumbs" class="breadcrumbs">
      <div class="container">

        <ol>
          <li><a href="<c:url value='/front' />">Home</a></li>
          <li><a href="<c:url value='/front/cTable/Main' />">???????????????</a></li>
        </ol>
        <h2>???????????????</h2>

      </div>
    </section><!-- End Breadcrumbs -->

    <!-- ?????? -->
    <div class="container">

		<!-- Table -->
		<div class="card shadow mb-4">
			<!-- Table Button-->
			<div class="card-header py-3 row m-0">
				<button type="button" class="btn btn-primary col-1 mr-2 tableButton" id="BasicButton">??????</button>
				<button type="button" class="btn btn-secondary col-1 mr-2 tableButton" id="PAButton">????????? </button>
			</div>
			<!-- Table Content -->
			<div class="card-body">
				<div class="table-responsive" id="TableAreaMax">
					
				</div>
			</div>

		</div>




    </div>
	</main>
	<!-- End #main -->
	
	<!-- ======= A04 Footer ======= -->
	<%@include file="/WEB-INF/pages/front/jsp/0_Util/Footer.jsp" %>


	<!-- script -->
	<!-- Vendor JS Files -->
	<script src="<c:url value='/front/assets/vendor/bootstrap/js/bootstrap.bundle.min.js' />"></script>
	<script src="<c:url value='/front/assets/vendor/glightbox/js/glightbox.min.js' />"></script>
	<script src="<c:url value='/front/assets/vendor/isotope-layout/isotope.pkgd.min.js' />"></script>
	<script src="<c:url value='/front/assets/vendor/php-email-form/validate.js' />"></script>
	<script src="<c:url value='/front/assets/vendor/purecounter/purecounter.js' />"></script>
	<script src="<c:url value='/front/assets/vendor/swiper/swiper-bundle.min.js' />"></script>
	<script src="<c:url value='/front/assets/vendor/waypoints/noframework.waypoints.js' />"></script>
	
	<!-- Template Main JS File -->
	<script src="<c:url value='/front/assets/js/main.js' />"></script>
	
	<!-- JQuery -->
  	<script src="<c:url value='/front/assets/js/jquery-3.6.0.slim.js' />"></script>
	
	<!-- Table Table JS -->
	<script src="<c:url value='/back/vendor/datatables/jquery.dataTables.min.js' />"></script>
	<script src="<c:url value='/back/vendor/datatables/dataTables.bootstrap4.min.js' />"></script>
	<script src="<c:url value='/back/js/demo/datatables-demo.js' />"></script>
	                       
                        
  <script>
    $(function () {
		// defaule
		$('#header_Company').addClass('active')
		// ????????????
		select_Basic_Tabel()

		// Table ???????????? - ??????
		$('#BasicButton').on('click', function () {
			$('.tableButton').removeClass('btn-primary')
			$('.tableButton').addClass('btn-secondary')

			// main
			$('#BasicButton').removeClass('btn-secondary')
			$('#BasicButton').addClass('btn-primary')

			select_Basic_Tabel()
			
		})

		// Table ???????????? - ?????????
		$('#PAButton').on('click', function () {
			$('.tableButton').removeClass('btn-primary')
			$('.tableButton').addClass('btn-secondary')

			//main
			$('#PAButton').removeClass('btn-secondary')
			$('#PAButton').addClass('btn-primary')

			select_PA_Table()
		})


		// Select Basic Table
		function select_Basic_Tabel() {
			let xhr = new XMLHttpRequest();
			xhr.open("GET", "<c:url value='/back/cBasic/showAllData' />", true);
			xhr.send()
			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4 && xhr.status == 200) {
					$('#TableAreaMax').html(showBasicAll(xhr.responseText))
					// $('.tableArea').attr('id', 'dataTable')
							
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
		}

		// Select PA Table
		function select_PA_Table() {
            var xhr = new XMLHttpRequest();
            xhr.open("GET", "<c:url value='/back/pa/showAllData' />", true);
            xhr.send()
            xhr.onreadystatechange = function() {
                if (xhr.readyState == 4 && xhr.status == 200) {
                    $('#TableAreaMax').html(showPAall(xhr.responseText))
                    // $('.tableArea').attr('id', 'dataTable')
                    
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
		}	

		// Basic Table
		function showBasicAll(text){
			let beans = JSON.parse(text);
			let segment = ""

			segment += `<table class="table table-bordered tableArea" id="dataTable" width="100%" cellspacing="0">`
			segment += 
				`<thead>
					<tr>
						<th>??????</th>
						<th width="80px">????????????</th>
						<th>????????????</th>
						<th>???????????????</th>
						<th>???????????????</th>
						<th>???????????????</th>
					</tr>
				</thead>
				<tfoot>
					<tr>
						<th>??????</th>
						<th>????????????</th>
						<th>????????????</th>
						<th>???????????????</th>
						<th>???????????????</th>
						<th>???????????????</th>
					</tr>
				</tfoot>`

			segment += `<tbody>`												
			for(let x in beans){
				let bean = beans[x]
				let updateUrl = `<c:url value = "/front/cTableDetail/Main/" />` + bean.stock
				let detailStockX = `<a href=`+ updateUrl +` class='idX' >` + bean.stock + `</a>`

				segment += "<tr class='trX'>"
				segment += "<td >" + detailStockX + "</td>"
				segment += "<td>" + bean.business_Accounting_NO + "</td>"
				segment += "<td>" + bean.company_Name + "</td>"
				segment += "<td>" + bean.capital_Stock_Amount + "</td>"
				segment += "<td>" + bean.responsible_Name + "</td>"
				segment += "<td>" + bean.company_Location + "</td>"
				segment += "</tr>"
			}
			segment += `</tbody>`
			segment += `</table>`
			return segment;
		}
		
		// Profit Analysis Table
		function showPAall(text){
			var beans = JSON.parse(text);
			var segment = ""

			segment += `<table class="table table-bordered tableArea" id="dataTable" width="100%" cellspacing="0">`
			segment += 
				`<thead>
					<tr>
						<th>????????????</th>
						<th>????????????</th>
						<th>????????????(??????)</th>
						<th>?????????(%)</th>
						<th>???????????????(%)</th>
						<th>???????????????(%)</th>
						<th>???????????????(%)</th>
					</tr>
				</thead>
				<tfoot>
					<tr>
						<th>????????????</th>
						<th>????????????</th>
						<th>????????????(??????)</th>
						<th>?????????(%)</th>
						<th>???????????????(%)</th>
						<th>???????????????(%)</th>
						<th>???????????????(%)</th>
					</tr>
				</tfoot>`
			segment +=  `<tbody>`


			for(var x in beans){
				var bean = beans[x]

				let updateUrl = `<c:url value = "/front/cTableDetail/Main/" />` + bean.company_ID
				let detailStockX = `<a href=`+ updateUrl +` class='idX' >` + bean.company_ID + `</a>`
				segment += "<tr>"
				segment += "<td class='idX'>" + detailStockX + "</td>"
				segment += "<td>" + bean.company_Name + "</td>"
				segment += "<td>" + bean.income + "</td>"
				segment += "<td>" + bean.gross_Margin + "</td>"
				segment += "<td>" + bean.operating_Profit_Ratio + "</td>"
				segment += "<td>" + bean.net_Income_Margin + "</td>"
				segment += "<td>" + bean.net_Profit_Margin + "</td>"
				segment += "</tr>"
			}
			segment +=  `</tbody>`
			segment += `</table>`
			return segment;
		}

    })
  </script>

	
</body>
</html>