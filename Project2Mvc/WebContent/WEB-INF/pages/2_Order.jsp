<%@page import="org.springframework.ui.Model"%>
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
  <link href="./css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom styles for this template -->
  <link href="./css/dashboard.css" rel="stylesheet">
  <!-- fontawesome -->
  <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" />
  <link rel="stylesheet" href="./css/Order_style.css">
  

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
    
    <!-- 測試auto -->
    *{
      margin: 0;
      padding: 0;
    }
    .content{
      height: 100vh;
      display: flex;
      flex-direction: column;
    }
    .content .header{
      height: 50px;
      line-height: 50px;
      font-size: 26px;
      text-align: center;
      border-bottom: 2px solid red;
    }
    .content iframe{
      flex: 1;
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
      
      <h2 id="test">Hi,${user_account},歡迎使用快速下單!</h2>
  
      <span>
          <iframe id="Kline" src="https://s.yimg.com/nb/tw_stock_frontend/scripts/TaChart/tachart.3de240ea9a.html?sid=2330"   style="width: 570px; height: 430px; border-width: 0;"></iframe>
          <iframe id="Top5"  src="https://s.yimg.com/nb/tw_stock_frontend/scripts/StxChart/StxChart.9d11dfe155.html?sid=2330" style="width: 560px; height: 380px; border-width: 0;"></iframe>
      </span>
  
      <form action="order/check" method="Post" onsubmit="return check_form(this.id);">
      <fieldset name="fieldset">
          <legend></legend>
          <span>
              <button name="op1" id="but1" value="1" type="button" class="st_change" onclick="change_border_color(this.id),op1_value(this.id),change_odd(this.id),get_total(this.id)">證券</button>
              <!-- 
              <button name="op1" id="but2" value="2" type="button" class="" onclick="change_border_color(this.id),op1_value(this.id)" disabled>期貨</button>
              <button name="op1" id="but3" value="3" type="button" class="" onclick="change_border_color(this.id),op1_value(this.id)" disabled>選權</button> -->
              <button name="op1" id="but4" value="0" type="button" class="st_change" onclick="change_border_color(this.id),op1_value(this.id),change_odd(this.id),get_total(this.id)">零股</button>
              <input  name="trans_species" id="trans_species" type="hidden" >
              
              <label for="">交易帳號:</label>
              <select name="stock_ID" id="stock_ID">
                  <option value="${stock_ID}" selected>證-${stock_ID}</option>
                  <option value="一戶多帳號">期-AAA-BBB-CCC</option>
              </select>
  
              <label for="">標的:</label>
              <input type="text" size="12" value="顯示公司短稱">
              
              <!-- <button class="st_lim">限</button>
              <button>漲</button>
              <button>跌</button>
              <button>平</button>
              <button>市</button> -->
  
              <select name="trans_cond" id="trans_cond" class="st_rod">
                  <option value="ROD" selected>ROD</option>
                  <option value="IOC">IOC</option>
                  <option value="FOK">FOK</option>
              </select>
              <label for="">單位:</label>
              <label id="oneorodd" for="" class="forlab"></label>
              <label for="">股</label>
              <button name="op2" id="1"  value="買進" type="button" onclick="change_back_color(this.id),op2_value(this.id)" class="st_buy st_change">買進</button>
              <button name="op2" id="0"  value="賣出" type="button" onclick="change_back_color(this.id),op2_value(this.id)" class="st_sell st_change">賣出</button>
              <input  name="trans_sellorbuy" id="trans_sellorbuy" type="hidden" >
          </span>
      </fieldset>
  
      <fieldset name="fieldset">
          <legend></legend>
              <button name="op3" id="but5" value="現股" type="button" class="st_change" onclick="change_border_color(this.id),op3_value(this.id)">現股</button>
              <button name="op3" id="but6" value="當沖" type="button" class="st_change" onclick="change_border_color(this.id),op3_value(this.id)"disabled>當沖</button>
              <!--  
              <button name="op3" id="but7" value="2" type="button" class="st_change" onclick="change_border_color(this.id),op3_value(this.id)">融資</button>
              <button name="op3" id="but8" value="3" type="button" class="st_change" onclick="change_border_color(this.id),op3_value(this.id)">融券</button> -->
              <input  name="trans_way" id="trans_way" type="hidden" >
              
              <label for="" >商品代碼:</label>
              <input name="com_ID" type="text" placeholder="股票代號" id="com_ID" autofocus onchange="get_input(this.id)" size="17">
              <label for="">價格:</label>
              <input name="order_price" id="order_price" type="text" size="3" maxlength="7" onchange="get_total(this.id)">
              <label for="">數量:</label>
              <input name="order_quant" id="order_quant" type="text" size="3" maxlength="4" onchange="get_total(this.id)">
              <label for="" >總價:</label>
              <label id="show_total" for=""></label>
              <label for="" >新台幣</label>
              <input name="order_total" id="order_total" type="hidden" >  
              <input type="submit" value="立即下單" class="st_submit" onclick="get_datetime()" id="order_now"  >
              <input type="reset"  value="清除" id="clear" onclick="clear()">
              <input name="order_date"   id="order_date"   type="hidden" >
              <input name="order_time"   id="order_time"   type="hidden" >
              <input name="trans_stats"  id="trans_stats"  type="hidden" value="委託單">
            <input name="trans_report" id="trans_report" type="hidden" value="委託成功">            
      </fieldset>
      </form>
      
      
      
  
	  <div class="content">
    	 <div class="header">訂單查詢</div> 
    		 <!--    <c:url var="selecturl" value="/order/select"/>       -->
      		 <iframe src="<c:url value='/order/select' />" width="100%" frameborder="0"> id="select_firame"></iframe>
 	  </div>
					

      </main>



    </div>
  </div>


  <script src="./js/bootstrap.bundle.min.js"></script>
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <script src="./js/Order.js" async defer></script>


</body>

</html>