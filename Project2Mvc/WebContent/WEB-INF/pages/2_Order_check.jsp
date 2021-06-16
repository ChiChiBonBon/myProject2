<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
  <link href="<c:url value='/css/bootstrap.min.css' />" rel="stylesheet">
  <!-- Custom styles for this template -->
  <link href="<c:url value='/css/dashboard.css' />" rel="stylesheet">
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
              <a class="nav-link" aria-current="page" href="#">
                <span class="me-1"><i class="fas fa-tachometer-alt"></i></span>
                Dashboard
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">
                <span class="me-1"><i class="fas fa-sign-in-alt"></i></span>
                Login
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">
                <span class="me-1"><i class="fas fa-funnel-dollar"></i></span>
                下單
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">
                <span class="me-1"><i class="far fa-comment-dots"></i></span>
                討論
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">
                <span class="me-1"><i class="fas fa-dice-d20"></i></span>
                抽籤
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">
                <span class="me-1"><i class="fas fa-clipboard-list"></i></span>
                課程
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">
                <span class="me-1"><i class="fas fa-building"></i></span>
                公司資料
              </a>
            </li>
          </ul>
        </div>
      </nav>

      <!-- 內容 -->
      <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
      	<!-- 修改指定路徑到CRUD -->
        <form action="<c:url value = '/order/controller/insert'/>" method="POST">
          <%
            request.setCharacterEncoding("UTF-8");
            response.setContentType("text/html; charset=UTF-8");
          %>
          
          <% 
            java.util.UUID uuid = java.util.UUID.randomUUID();
            String order_ID     = uuid.toString();
          
            String stock_ID        = request.getParameter("stock_ID"       );
            String com_ID          = request.getParameter("com_ID"         );
            String order_price     = request.getParameter("order_price"    ); 
            String order_quant     = request.getParameter("order_quant"    );
            String order_total     = request.getParameter("order_total"    );
            String order_date      = request.getParameter("order_date"     );
            String order_time      = request.getParameter("order_time"     );
            String trans_cond      = request.getParameter("trans_cond"     );
            String trans_way       = request.getParameter("trans_way"      );
            String trans_sellorbuy = request.getParameter("trans_sellorbuy");
            String trans_stats     = request.getParameter("trans_stats"    );
            String trans_report    = request.getParameter("trans_report"   );
           %>
            
           <% 
              out.println("訂單明細"                   +"<br>");
              out.println("------------------------"+"<br>");
              out.println("下單編號:"  +order_ID       +"<br>");
         	  out.println("證券帳號:"  +stock_ID       +"<br>");
         	  out.println("股票代號:"  +com_ID         +"<br>");
         	  out.println("下單價格:"  +order_price    +"<br>");
         	  out.println("下單數量:"  +order_quant    +"<br>");
         	  out.println("交易金額:"  +order_total    +"<br>");
        	  out.println("下單日期:"  +order_date     +"<br>");
       	      out.println("下單時間:"  +order_time     +"<br>");
              out.println("交易條件:"  +trans_cond     +"<br>");
	          out.println("交易方式:"  +trans_way      +"<br>");
	          out.println("交易選項:"  +trans_sellorbuy+"<br>");
	          out.println("下單狀態:"  +trans_stats    +"<br>");
          	//out.println("下單回報:"  +trans_report    +"<br>");
              out.println("-------------------------"+"<br>");
           %>
            
              <input type="submit"  value="確認" onclick="get_datetime()" class="st_submit">
              <input  name="order_ID"        id="order_ID"        type="hidden" value ="<%= order_ID       %>">
              <input  name="stock_ID"        id="stock_ID"        type="hidden" value ="<%= stock_ID       %>">
              <input  name="com_ID"          id="com_ID"          type="hidden" value ="<%= com_ID         %>">
              <input  name="order_price"     id="order_price"     type="hidden" value ="<%= order_price    %>">
              <input  name="order_quant"     id="order_quant"     type="hidden" value ="<%= order_quant    %>">
              <input  name="order_total"     id="order_total"     type="hidden" value ="<%= order_total    %>">
              <input  name="order_date"      id="order_date"      type="hidden" value ="<%= order_date     %>">
              <input  name="order_time"      id="order_time"      type="hidden" value ="<%= order_time     %>">
              <input  name="trans_cond"      id="trans_cond"      type="hidden" value ="<%= trans_cond     %>">
              <input  name="trans_way"       id="trans_way"       type="hidden" value ="<%= trans_way      %>">
              <input  name="trans_sellorbuy" id="trans_sellorbuy" type="hidden" value ="<%= trans_sellorbuy%>">
              <input  name="trans_stats"     id="trans_stats"     type="hidden" value ="<%= trans_stats    %>">
              <input  name="trans_report"    id="trans_report"    type="hidden" value ="<%= trans_report   %>">
        </form>
        
        <button id="delete_order" onclick="cancel_order(this.id),history.back()"> 取消</button>

      </main>



    </div>
  </div>

  <script src="<c:url value='/js/bootstrap.bundle.min.js' />"></script>
  <script src="<c:url value='/js/Order.js' />" async defer></script>
  

</body>

</html>