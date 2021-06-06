<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Dashboard Template · Bootstrap v5.0</title>

<!-- <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/dashboard/"> -->
<!-- Bootstrap core CSS -->
<link href="./css/bootstrap.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="./css/dashboard.css" rel="stylesheet">
<!-- fontawesome -->
<link rel="stylesheet"
	href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" />

<style>
p {
	display: inline-block;
}

.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	user-select: none;
}

#sidebarMenu a:hover {
	color: blue;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}
</style>


</head>

<body>

	<header
		class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
		<a class="navbar-brand col-md-3 col-lg-2 me-0 px-3" href="#">Company
			name</a>
		<button class="navbar-toggler position-absolute d-md-none collapsed"
			type="button" data-bs-toggle="collapse" data-bs-target="#sidebarMenu"
			aria-controls="sidebarMenu" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<input class="form-control form-control-dark w-100" type="text"
			placeholder="Search" aria-label="Search">
		<ul class="navbar-nav px-3">
			<li class="nav-item text-nowrap"><a class="nav-link" href="#">Sign
					out</a></li>
		</ul>
	</header>
	<div></div>
	<div class="container-fluid">
		<div class="row">
			<nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
				<div class="position-sticky pt-3">
					<ul class="nav flex-column">
						<li class="nav-item">
							<a class="nav-link" aria-current="page" href="./0_dashboard.html">
								<span class="me-1"><i class="fas fa-tachometer-alt"></i></span>
								Dashboard
							</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="./login_1.jsp">
								<span class="me-1"><i class="fas fa-sign-in-alt"></i></span>
								會員
							</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="./Login.jsp">
								<span class="me-1"><i class="fas fa-funnel-dollar"></i></span>
								下單
							</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="./Post_3.jsp">
								<span class="me-1"><i class="far fa-comment-dots"></i></span>
								討論
							</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="./Buy_4.html">
								<span class="me-1"><i class="fas fa-dice-d20"></i></span>
								抽籤
							</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="./CourseManagement5.html">
								<span class="me-1"><i class="fas fa-clipboard-list"></i></span>
								課程
							</a>
						</li>
						<li class="nav-item">
							<a class="nav-link active" href="./6_company.jsp">
								<span class="me-1"><i class="fas fa-building"></i></span>
								公司資料
							</a>
						</li>
					</ul>
				</div>
			</nav>

			<!-- 內容 -->
			<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
				<jsp:useBean id="TableBean_6" class="jdbc_6.TableBean_6"
					scope="request" />
				<div class="container">
					<form action="./MainServlet_6" method="POST">
						<div class="item_CRUD mt-5">
							<div class="btn-group" role="group"
								aria-label="Basic radio toggle button group">
								<input type="radio" class="btn-check" name="whichOne"
									id="select" autocomplete="off" value="select"> <label
									class="btn btn-outline-primary" for="select">查詢資料</label> <input
									type="radio" class="btn-check" name="whichOne" id="insert"
									autocomplete="off" value="insert"> <label
									class="btn btn-outline-primary" for="insert">新增資料</label> <input
									type="radio" class="btn-check" name="whichOne" id="update"
									autocomplete="off" value="update"> <label
									class="btn btn-outline-primary" for="update">更新資料</label> <input
									type="radio" class="btn-check" name="whichOne" id="delete"
									autocomplete="off" value="delete"> <label
									class="btn btn-outline-primary" for="delete">刪除資料</label>
							</div>
						</div>
						<div class="content mt-5 col-6">
							<div class="col mb-5" id="searchData">
								<label for="" class="form-label">查詢資料</label> <input type="text"
									class="form-control" id="search" placeholder="統一編號"
									name="search_business_NO" onfocus="this.placeholder=''"
									onblur="this.placeholder='統一編號'">
							</div>
							<div class="mb-5">
								<p>查詢結果:</p>
								<p id="answer">
									"<%=request.getAttribute("result")%>"
								</p>
							</div>
							<hr>


							<div id="formData">
								<div class="row row-cols-1 row-cols-lg-2">
									<div class="col mb-3">
										<label for="" class="form-label">統一編號</label> 
                    <input
											type="text" class="form-control" id="business_Accounting_NO" placeholder=""
											name="business_Accounting_NO"
											value="<jsp:getProperty name="TableBean_6" property="business_Accounting_NO" />">
									</div>
									<div class="col mb-3">
										<label for="" class="form-label">公司名稱</label> 
                    <input
											type="text" class="form-control" id="company_Name" placeholder=""
											name="company_Name"
											value="<jsp:getProperty name="TableBean_6" property="company_Name" />">
									</div>
									<div class="col mb-3">
										<label for="" class="form-label">資本總額(登記資本額)</label> 
                    <input
											type="text" class="form-control" id="capital_Stock_Amount" placeholder=""
											name="capital_Stock_Amount"
											value="<jsp:getProperty name="TableBean_6" property="s_capital_Stock_Amount" />">
									</div>
									<div class="col mb-3">
										<label for="" class="form-label">代表人姓名</label> 
                    <input
											type="text" class="form-control" id="responsible_Name" placeholder=""
											name="responsible_Name"
											value="<jsp:getProperty name="TableBean_6" property="responsible_Name" />">
									</div>
								</div>
								<div class="row row-cols-1 row-cols-lg-1">
									<div class="col mb-3">
                  <label for="" class="form-label">公司所在地</label>
                  <input type="text" class="form-control" id="company_Location" placeholder="" name="company_Location"
                    value="<jsp:getProperty name="TableBean_6" property="company_Location" />">
                </div>
								</div>
							</div>

							<button type="submit" class="btn btn-primary" id="submit">Submit</button>
						</div>
					</form>


				</div>
			</main>



		</div>
	</div>


	<script src="./js/bootstrap.bundle.min.js"></script>
	<script src="./js/jquery-3.6.0.js"></script>
	<script src="./js/company_6.js"></script>
	<script>
      $(function () {
		$('#formData').hide()  
        $('#<%=request.getAttribute("checkOption")%>').prop('checked', true)

        // insert、update 失敗
        if ("<%=request.getAttribute("beanErr")%>" == "error") {
				$('#formData').show()
        		$('#searchData').hide()
			}else if("<%=request.getAttribute("beanErr")%>" == "correct"){
				$('#formData').hide()
				$('#searchData').hide()
      		}else if("<%=request.getAttribute("beanErr")%>" == "correctData"){
				$('#formData').show()
        		$('#searchData').hide()
      		}
		})
	</script>



</body>

</html>