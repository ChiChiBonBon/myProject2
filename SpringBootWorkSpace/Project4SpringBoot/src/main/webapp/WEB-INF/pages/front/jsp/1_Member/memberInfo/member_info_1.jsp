<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

    <title>會員資料</title>
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
        <h2>會員首頁</h2>

      </div>
    </section>
  <!-- End Breadcrumbs -->

  <!-- 內容 -->
        <div class="container">


            <ul class="nav flex-column nav-tabs">
            
                <li class="nav-item col-2 mb-2">
                  <a class="nav-link fs-5" id="id_member_info" href="<c:url value='/front/member_up/goupdate_1'/>">會員基本資料</a>
                </li>
                
                <li class="nav-item col-2 mb-2">
                  <a class="nav-link fs-5" id="id_member_cha" href="<c:url value='/front/member/gochangepass_1'/> ">更改密碼</a>
                </li>
                
                <li class="nav-item col-2 mb-4">
                  <a class="nav-link fs-5" id="id_member_del" href="<c:url value='/front/member/godelete_1'/>">刪除會員資料</a>
                </li>
                
                <li class="nav-item col-2 mb-4">
                    <form action="logout_1" method="post">
                        <div>
                            <input type="hidden" name="logout">
                        </div>
                       &nbsp;&nbsp;&nbsp;&nbsp;<button style="width: 100px" class="btn btn-outline-danger" type="submit">登出</button>
                   </form>
                </li>
                
            </ul>
        </div>
        
        

            <script>
                function change_text_big () {
                	console.log(this);
                	this.className += " fs-4";
                	/* 顏色變成橘色 */
                	this.setAttribute("style", "color: #fd7e14")
                }
                function change_text_back (tag) {
                	this.className = "nav-link fs-5";
                	/* 顏色變回原本 */
                	this.setAttribute("style", "color:")
                }
                
                let info = document.getElementById('id_member_info');
                let cha = document.getElementById('id_member_cha');
                let del = document.getElementById('id_member_del');
                
                let list = [info, cha, del];
                for (let i=0; i<list.length; i++) {
                   list[i].addEventListener('mouseenter', change_text_big);
                   list[i].addEventListener('mouseleave', change_text_back);
                }
            </script>
            
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
  
/*   function miss_required() {
            let respond_acc = document.getElementById("account_input");
            let respond_pass = document.getElementById("password_input");
            respond_acc.setAttribute("required", false);
            respond_pass.setAttribute("required", false);
  } */




    </script>

</body>
</html>