<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

    <title>會員登入</title>
    <meta content="" name="description">
    <meta content="" name="keywords">

    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

    <!-- Vendor CSS Files -->
    <link href="<c:url value='/front/assets/vendor/animate.css/animate.min.css' />" rel="stylesheet">
    <link href="<c:url value='/front/assets/vendor/bootstrap/css/bootstrap.min.css' />" rel="stylesheet">
    <link href="<c:url value='/front/assets/vendor/bootstrap-icons/bootstrap-icons.css' />"rel="stylesheet">
    <link href="<c:url value='/front/assets/vendor/boxicons/css/boxicons.min.css' />" rel="stylesheet">
    <link href="<c:url value='/front/assets/vendor/glightbox/css/glightbox.min.css' />" rel="stylesheet">
    <link href="<c:url value='/front/assets/vendor/swiper/swiper-bundle.min.css' />" rel="stylesheet">

    <!-- Template Main CSS File -->
    <link href="<c:url value='/front/assets/css/style.css' />" rel="stylesheet">
</head>
<body>
    <!-- ======= A01 Top Bar ======= -->
    <%@include file="/WEB-INF/pages/front/jsp/0_Util/TopBar.jsp"%>

    <!-- ======= A02 Header ======= -->
    <%@include file="/WEB-INF/pages/front/jsp/0_Util/Header.jsp"%>

    <!-- Main -->
    <main id="main">
    <!-- ======= Breadcrumbs ======= -->
    <section id="breadcrumbs" class="breadcrumbs">
      <div class="container">

        <ol>
         <li><a href="<c:url value='/front' />">Home</a></li>
         <li>會員</li>
        </ol>
        <h2>會員登入</h2>

      </div>
    </section>
  <!-- End Breadcrumbs -->

  <!-- 內容 -->
        <div class="container">


           <h1>會員登入</h1>
           <br>
           <form method="POST" action="login_1">

            <div class="mb-3">
             <label for="account_input" class="form-label">Account</label>
             <input style="width: 500px" type="text" name="account_1" class="form-control is-invalid" id="account_input" aria-describedby="emailHelp" placeholder="請輸入帳號或電子郵件" required>
             <div id="" class="form-text">We'll never share your email with anyone else.</div>
            </div>

            <div class="mb-3">
             <label for="password_input" class="form-label">Password</label>
             <input style="width: 500px" type="password" name="password_1" class="form-control" id="password_input" placeholder="密碼" required>
            </div>

            <div class="mb-3">
             <a class="large" href="">忘記密碼？</a>
            </div>

            <span>
             <button style="width: 200px" class="btn btn-primary" type="submit">登入</button>
            </span>&nbsp;&nbsp;&nbsp;&nbsp;

           
            <span>
             <a style="width: 200px" class="btn btn-success" href="<c:url value='/front/unmember/goregister_1'/>" onclick="miss_required()">建立新帳號</a>
            </span>
            
           </form>
        
            <!-- 看是否有錯誤訊息由後端傳入 -->
           <div id="message" style="display: none">${message}</div>
           <script>
               let m;
               m = document.getElementById("message").innerText;
               console.log(m);
               let respond_acc = document.getElementById("account_input");
               let respond_pass = document.getElementById("password_input");
               if (m == "請輸入正確帳號密碼") {
               	/* 改變class 和 裡面的文字 */
                   respond_acc.setAttribute("placeholder", m);
                   respond_acc.className = "form-control is-invalid";
                   
                   respond_pass.setAttribute("placeholder", m);
                   respond_pass.className = "form-control is-invalid";
          
               } else {
               	respond_acc.className = "form-control";
               	respond_pass.classNmae = "form-control";
               }
           </script>



        </div>
    </main>
    <!-- End #main -->

    <!-- ======= A04 Footer ======= -->
    <%@include file="/WEB-INF/pages/front/jsp/0_Util/Footer.jsp"%>


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
    
    <!-- SweetAlert2 -->
    <script src="<c:url value='/front/assets/js/sweetalert2@11.js' />"></script>

    <script type="text/javascript">
		$(function(){
			$('#header_About').addClass('active')
		})
		
/* 		function miss_required() {
            let respond_acc = document.getElementById("account_input");
            let respond_pass = document.getElementById("password_input");
            respond_acc.setAttribute("required", false);
            respond_pass.setAttribute("required", false);
		} */
		
    </script>

</body>
</html>