<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

    <title>刪除帳號</title>
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
         <li>會員中心</li>
        </ol>
        <h2>刪除帳號</h2>

      </div>
    </section>
  <!-- End Breadcrumbs -->

  <!-- 內容 -->
        <div class="container">

           <form method="POST" action="delete_membership_1">

            <div class="mb-3">
             <label for="password_input" class="form-label">輸入密碼</label>
             <input style="width: 500px" type="password" name="password_del_1" class="form-control" id="pass1" placeholder="新密碼" required>
            </div>
            
             <div class="mb-4">
              <label for="password_input" class="form-label">確認密碼</label>              
              <input style="width: 500px" type="password" name="password_del_che_1" class="form-control" id="pass2" placeholder="再次輸入新密碼" required>
              <div class="valid-feedback">
                  Looks good!
              </div>
              <div id="validationServerUsernameFeedback" class="invalid-feedback">
                  輸入密碼不一樣
             </div>
            </div>

            <div>
             <button style="width: 200px" class="btn btn-primary" id="commitAndsned" type="submit">刪除帳號</button>
            </div>

           </form>
        
            <!-- 看是否有錯誤訊息由後端傳入 -->
           <div id="message" style="display: none">${message}</div>
           <script>
               let m;
               m = document.getElementById("message").innerText;
               console.log(m);
               let respond_pass1 = document.getElementById("pass1");
               let respond_pass2 = document.getElementById("pass2");
               if (m == "請輸入正確的確認密碼" || m == "輸入錯誤密碼") {
                /* 改變class 和 裡面的文字 */
                   respond_pass1.setAttribute("placeholder", m);
                   respond_pass1.className = "form-control is-invalid";
                   
                   respond_pass2.setAttribute("placeholder", m);
                   respond_pass2.className = "form-control is-invalid";
          
               } else {
                respond_pass1.className = "form-control";
                respond_pass2.classNmae = "form-control";
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
        
        
         /* 確認密碼否一樣 */
        function checkPassIsSame(e) {
       //console.log("ketpress");
       let checkString1 = document.getElementById("pass1");
       let checkString2 = document.getElementById("pass2");

       //window.alert(e);
       console.log("checkString1: " + checkString1);
       console.log("checkString2: " + checkString2);
       /* 如果密碼不一樣 submit button 的 tag 後面加上disabled = true */
       /* 假如密碼一樣 就改回disabled = false */
       let c;
       c = document.getElementById("commitAndsned");
     
       if (checkString1.value === checkString2.value) {
        checkString1.className = "form-select is-valid";
        checkString2.className = "form-select is-valid";
        c.disabled = false;
       } else {
        checkString1.className = "form-control is-invalid";
        checkString2.className = "form-control is-invalid";
        c.disabled = true;
       }
      }
     
      window.onload = function() {
       document.getElementById("pass1").addEventListener("keyup",
         checkPassIsSame);
       document.getElementById("pass2").addEventListener("keyup",
         checkPassIsSame);
      }

    </script>

</body>
</html>