<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
<title>會員註冊</title>
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
        <a class="nav-link" href="#">Hello There</a>
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

		<br>
		<h1>會員註冊</h1>
		<form action="./Register_1" method="post">
		
	        <p>
	        	帳號：<input type="text" name="account_1" required>
	        </p>
	        <p>
	        	密碼：<input type="password" name="password_1" id="pass1" required>
	        </p>
	        <p>
	        	密碼確認：<input type="password" name="password_2" id="pass2" required>
	        	<br>
		        <label id="isSame" style="color: crimson;" for=""></label>
	        </p>
	        
	        
	        <p>
	        	名字：<input type="text" name="name_1" required>
	        </p>
	        
	        <p>
	        	性別：
	        
	        	<label for="gendermale">男性</label> <input type="radio"
	        		name="gender_1" id="gendermale" value="male" required>
	        
	        
	        	<label for="genderfemale">女性</label> <input type="radio"
	        		name="gender_1" id="genderfemale" value="female" required>
	        
	        
	        	<label for="genderother">其他</label> <input type="radio"
	        		name="gender_1" id="genderother" value="other" required>
	        
	        </p>
	        
	        <p>
	        	電子信箱：<input type="email" name="email_1" required>
	        </p>
	        <input type="submit" value="送出">
	        
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
  
  <script>
      window.onload = function(){
          document.getElementById("pass2").addEventListener("keyup",function(e){
              //console.log("ketpress");
              let checkString1 = document.getElementById("pass1").value;
              let checkString2 = document.getElementById("pass2").value;
              let checkSame = document.getElementById("isSame");
              
              //window.alert(e);
              console.log("checkString1: " + checkString1);
              console.log("checkString2: " + checkString2);
              if(checkString1 === checkString2){
                  checkSame.innerHTML="密碼相符!";
              }else {
                  checkSame.innerHTML="密碼不相符!";
              }
          });
      }
  </script>


</body>
</html>