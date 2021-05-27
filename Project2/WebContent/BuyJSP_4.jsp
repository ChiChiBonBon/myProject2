<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="bean_4.BuyBeam_4" %>


 
<!doctype html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="">
  <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
  <meta name="generator" content="Hugo 0.82.0">
  <title>Dashboard Template · Bootstrap v5.0</title>

  <!-- <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/dashboard/"> -->
  <!-- Bootstrap core CSS -->
  <link href="./css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom styles for this template -->
  <link href="./css/dashboard.css" rel="stylesheet">
  <!-- fontawesome -->
  <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" />

  <style>
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

    @media (min-width: 768px) {
      .bd-placeholder-img-lg {
        font-size: 3.5rem;
      }
    }
  </style>


</head>

<body>

  <header class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
    <a class="navbar-brand col-md-3 col-lg-2 me-0 px-3" href="#">Company name</a>
    <button class="navbar-toggler position-absolute d-md-none collapsed" type="button" data-bs-toggle="collapse"
      data-bs-target="#sidebarMenu" aria-controls="sidebarMenu" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <input class="form-control form-control-dark w-100" type="text" placeholder="Search" aria-label="Search">
    <ul class="navbar-nav px-3">
      <li class="nav-item text-nowrap">
        <a class="nav-link" href="#">Sign out</a>
      </li>
    </ul>
  </header>
  <div></div>
  <div class="container-fluid">
    <div class="row">
      <nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
        <div class="position-sticky pt-3">
          <ul class="nav flex-column">
            <li class="nav-item">
              <a class="nav-link" aria-current="page" href="./dashboard.html">
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
              <a class="nav-link active" href="./Buy_4.html">
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
              <a class="nav-link" href="./company_6.jsp">
                <span class="me-1"><i class="fas fa-building"></i></span>
                公司資料
              </a>
            </li>
          </ul>
        </div>
      </nav>

      <!-- 內容 -->
      <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
	<table class="table">
		<tr>
			<td>股票代號</td>
			<td>股票名稱</td>
			<td>開賣日期</td>
			<td>停售日期</td>
			<td>數量</td>
			<td>價格</td>
		</tr>
	
	<%  ArrayList<BuyBeam_4> beanList = (ArrayList) session.getAttribute("bean");
		
		for( BuyBeam_4 x : beanList ){ %>

			<tr>
				<td><%=x.getStock_id() %></td>
				<td><%=x.getStock_name() %></td>
				<td><%=x.getSub_start() %></td>
				<td><%=x.getSub_end() %></td>
				<td><%=x.getSub_quantity() %></td>
				<td><%=x.getSub_price() %></td>
			</tr>
			
		<% } %>
	</table>
	
		
	
		
	      </main>



    </div>
  </div>


  <script src="./js/bootstrap.bundle.min.js"></script>
</body>
</html>