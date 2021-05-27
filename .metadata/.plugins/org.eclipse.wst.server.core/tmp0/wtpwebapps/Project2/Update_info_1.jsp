<%@page import="projectVO_1.ProjectBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="">
  <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
  <meta name="generator" content="Hugo 0.82.0">


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
<title>會員基本資料</title>
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
        <a class="nav-link" href="./logout_1.jsp">Sign out</a>
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
              <a class="nav-link active" href="./login_1.jsp">
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


	      <%
	      /* 判斷是否有Login_1.java 執行過後cookie: cookie_id */
	      /* 假如沒有cookie, cookie=null 回到登入畫面 */
	      /* 預設check_id=true 當有cookie_id存在 更改check_id=false */
	      /* 所以當check_id=true 程式就會倒回登入畫面 */
	      Cookie[] cookies = request.getCookies();
	      int i = 0;
	      String string;
	      boolean check_id = true;
	      if (cookies != null) {
	      	for (Cookie c : cookies) {
	      		string = cookies[i].getName();
	      		System.out.println("Update_info_1 cookie check:" + string);
	      		System.out.println("Update_info_1 time:" + i);
	      		i += 1;
	      		if (string.equals("cookie_id")) {
	      	check_id = false;
	      	break;
	      		}
	      	}
	      }
	      if (cookies == null) {
	      	response.sendRedirect("login_1.jsp");
	      	return;
	      }
	      if (check_id) {
	      	response.sendRedirect("login_1.jsp");
	      	return;
	      }
	      %>
	      
	      <%
	      HttpSession session_1 = request.getSession();
	      ProjectBean bean = (ProjectBean) session_1.getAttribute("member_info");
	      %>
		  <br>
          <h1>會員基本資料</h1>
          
          <form action="./Update_info_1" method="post">
            <p>
          		帳號：<input type="text" name="account_1" value="<%=bean.getAccount()%>"
          			required>
          	</p>
          	<p>
          		名字：<input type="text" name="name_1" value="<%=bean.getName()%>"
          			required>
          	</p>
          	<p>
          		出生日期：<input type="date" name="birthday_1"
          			value="<%=bean.getBirthday()%>">
          	</p>
          	<p>
          		別稱：<input type="text" name="nickname_1"
          			value="<%=bean.getNickname()%>">
          	</p>


            <p>
            	性別：
            	<label for="male">男性</label> 
            	<input type="radio"
            		name="gender_1" id="male" value="male" required>
            
           
            	<label for="female">女性</label> 
            	<input type="radio"
            		name="gender_1" id="female" value="female" required>
            
            
            	<label for="other">其他</label>
            	 <input type="radio"
            		name="gender_1" id="other" value="other" required>
            </p>


            <p>
            	電子信箱：<input type="email" name="email_1" value="<%=bean.getE_mail()%>"
            		required>
            </p>
            <p>
            	手機：<input type="text" name="cellphone_1" value="<%=bean.getCellphone()%>">
            </p>
            <p>
            	地址：<input type="text" name="address_1" value="<%=bean.getAddress()%>">
            </p>


            <label for="job">職業：</label> 
            <select name="job_1" id="job">
            	<option value="農牧業">農牧業</option>
            	<option value="漁業">漁業</option>
            	<option value="木材森林業">木材森林業</option>
            	<option value="礦業採石業">礦業採石業</option>
            	<option value="交通運輸業">交通運輸業</option>
            	<option value="餐旅業">餐旅業</option>
            	<option value="建築工程業">建築工程業</option>
            	<option value="製造業">製造業</option>
            	<option value="新聞廣告業">新聞廣告業</option>
            	<option value="衛生保健">衛生保健</option>
            	<option value="娛樂業">娛樂業</option>
            	<option value="文教機關">文教機關</option>
            	<option value="宗教團體">宗教團體</option>
            	<option value="公共事業">公共事業</option>
            	<option value="一般商業">一般商業</option>
            	<option value="服務業">服務業</option>
            	<option value="家庭管理">家庭管理</option>
            	<option value="資訊業">資訊業</option>
            	<option value="治安人員">治安人員</option>
            	<option value="軍人">軍人</option>
            	<option value="運動人員">運動人員</option>
            	<option value="學生">學生</option>
            	<option value="其他">其他</option>
            </select>
			<br>
			<br>

            <p>
            	載具：<input type="text" name="carrier_1" value="<%=bean.getCarrier()%>">
            </p>
            <input type="submit" value="更改">
            
            <!-- 看是否有錯誤訊息由後端傳入 -->		
		    <%
		    String str = (String) request.getAttribute("message");
		    if (str != null) {%>
		    
		    <p style="color: crimson;">
		    	<%= str%>
		    </p>
		    
		    <%}%>
		
		  </form>
		

      </main>


    </div>
  </div>


  <script src="./js/bootstrap.bundle.min.js"></script>

  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

  <script>
		$(function() {
			$("#<%=bean.getGender()%>").prop('checked', true)
			$("#job").val("<%=bean.getJob()%>");
		})	
  </script>
	

</body>
</html>