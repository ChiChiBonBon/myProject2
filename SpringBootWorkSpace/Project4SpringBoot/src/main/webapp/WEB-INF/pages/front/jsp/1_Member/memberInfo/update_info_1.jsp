<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
    <style type="text/css">
    span.error {
     color: red;
     display: inline-block;
     font-size: 10pt;
    }
    </style>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

    <title>會員基本資料</title>
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
        <h2>會員資料</h2>

      </div>
    </section>
  <!-- End Breadcrumbs -->

  <!-- 內容 -->
        <div class="container">


           <form:form class="row g-4" method="POST" modelAttribute="member" action="update_member_1" enctype='multipart/form-data'>
           
               <div class="col-6 md-2">
                 <label for="account_check" class="form-label">註冊帳號</label>
                 <form:input class="form-control" id="account_check" type="text" path="account" onchange="check_account(this)" required="required" value="${memberinfo.getAccount()}"/>
                 <div class="valid-feedback">
                     Looks good!
                 </div>
                 <div id="validationServerUsernameFeedback" class="invalid-feedback">
                     已被註冊
                 </div>
                 <form:errors path='account' cssClass="error" />
               </div>
               
               
               <script>
                   function check_account(input) { 
                    
                      var xhttp = new XMLHttpRequest();  // Ajax
                      xhttp.onreadystatechange = function() {
                      console.log(this);
                        if (this.readyState == 4 && this.status == 200) {
                          let acc_check = document.getElementById("account_check")
                          acc_check.innerHTML = this.responseText;
                          console.log(xhttp.responseText);
                          
                          /* 假如不正確 不給使用commit鍵 */
                          let d = document.getElementById("commitAndsned");
                          if (this.responseText == 1) {
                           acc_check.className = "form-control is-valid";
                           d.disabled = false;
                          } else {
                           acc_check.className = "form-control is-invalid";
                           d.disabled = true;
                          }
                          
                        }
                      };
                      
                      let account = document.getElementById("account_check").value;
                      xhttp.open("GET", "<c:url value='/front/unmember/gocheck_account?account=' />" + account, true);
                      xhttp.send();
                      }
               </script>
               
               
               <div class="col-4 md-2">
                 <label for="" class="form-label">輸入名字</label>
                 <form:input class="form-control" type="text" path="name" onchange="valid_after_onchange(this)" required="required" value="${memberinfo.getName()}"/>
                 <form:errors path='name' cssClass="error"/>
               </div>
               
               
               <div class="col-2 md-2">
                 <label for="" class="form-label">輸入別稱</label>
                 <form:input class="form-control" type="text" path="nickname" onchange="valid_after_onchange(this)" value="${memberinfo.getNickname()}"/>
                 <form:errors path='nickname' cssClass="error"/>
               </div>
               
               
               
               <div class="col-3 md-2">
                 <label for="" class="form-label">出生日期</label>
                 <form:input class="form-control" type="date" path="birthday" onchange="valid_after_onchange(this)" value="${memberinfo.getBirthday()}"/>
                 <form:errors path='birthday' cssClass="error"/>
               </div>
               
               
               <div class="col-3 md-2">
                 <label for="" class="form-label">選擇性別</label>
                 <form:select class="form-select" path="gender" required="required" onchange="valid_after_onchange(this)">
                   <form:options items="${gender_map}"/>
                 </form:select>
                 <form:errors path='gender' cssClass="error"/>
               </div>
               
               
               <div class="col-3 md-2">
                 <label for="job" class="form-label">選擇職業</label>
                 <!-- paht 這邊顯示的是 Memberbean 物件中的 jobType_id（是MemberJobs）的 job_id -->
                 <form:select id="job" class="form-select" path="jobType_id.job_id" onchange="valid_after_onchange(this)">
                   <form:options items="${job_list}" itemLabel="job"  itemValue="job_id" />
                 </form:select>
                 <form:errors path='jobType_id' cssClass="error"/>
               </div>
               
               
               <div class="col-3 md-2">
                 <label for="" class="form-label">聯絡電話</label>
                 <form:input id="phone_check" class="form-control" type="text" path="cellphone" onchange="valid_after_onchange(this)" value="${memberinfo.getCellphone()}"/>
                 <form:errors path='cellphone' cssClass="error"/>
               </div>
               
               
               <script>
                   function check_phone(input) { 
                    
                      var xhttp = new XMLHttpRequest();  // Ajax
                      xhttp.onreadystatechange = function() {
                      console.log(this);
                        if (this.readyState == 4 && this.status == 200) {
                          let phone_check = document.getElementById("phone_check")
                          phone_check.innerHTML = this.responseText;
                          console.log(xhttp.responseText);
                          
                          /* 假如不正確 不給使用commit鍵 */
                          let d = document.getElementById("commitAndsned");
                          if (this.responseText == 1) {
                           phone_check.className = "form-control is-valid";
                           d.disabled = false;
                          } else {
                           phone_check.className = "form-control is-invalid";
                           d.disabled = true;
                          }
                          
                        }
                      };
                      
                      let account = document.getElementById("phone_check").value;
                      xhttp.open("GET", "<c:url value='/front/unmember/gocheck_account?account=' />" + cellphone, true);
                      xhttp.send();
                      }
               </script>
               
               
               <div class="col-6 mb-2">
                 <label for="email_check" class="form-label">電子信箱</label>
                 <form:input id="email_check" class="form-control" type="email" path="e_mail" onchange="check_email(this)" required="required" value="${memberinfo.getE_mail()}"/>
                 <div class="valid-feedback">
                     Looks good!
                 </div>
                 <div id="validationServerUsernameFeedback" class="invalid-feedback">
                     已被註冊
                 </div>
                 <form:errors path="e_mail" cssClass="error"/>
               </div>


               <script>
                   function check_email(input) { 
                    
                      var xhttp = new XMLHttpRequest();  // Ajax
                      xhttp.onreadystatechange = function() {
                      console.log(this);
                        if (this.readyState == 4 && this.status == 200) {
                          let email_check = document.getElementById("email_check");
                          email_check.innerHTML = this.responseText;
                          console.log(xhttp.responseText);
                          
                          /* 假如不正確 不給使用commit鍵 */
                          let d = document.getElementById("commitAndsned");
                          if (this.responseText == 1) {    
                           email_check.className = "form-control is-valid";
                           d.disabled = false;
                          } else {
                           email_check.className = "form-control is-invalid";
                           d.disabled = true;
                          }
                          
                        }
                      };
                      
                      let email = document.getElementById("email_check").value;
                      xhttp.open("GET", "<c:url value='/front/unmember/gocheck_email?email=' />"
                                 + email, true);
                      xhttp.send();
                   }
               </script>
               
               
               <div class="col-6 mb-2">
                 <label for="" class="form-label">輸入地址</label>
                 <form:input id="" class="form-control" type="text" path="address" onchange="valid_after_onchange(this)" value="${memberinfo.getAddress()}"/>
                 <form:errors path='address' cssClass="error"/>
               </div>



               <div class="col-3 md-2">
                 <label for="" class="form-label">手機載具</label>
                 <form:input id="" class="form-control" type="text" path="carrier" onchange="valid_after_onchange(this)" value="${memberinfo.getCarrier()}"/>
                 <form:errors path='carrier' cssClass="error"/>
               </div>
               
               
               <div class="col-3 md-2">
                 <label for="" class="form-label">上傳頭貼</label>
                 <form:input id="" class="form-control" type="file" path="memberImage" onchange="valid_after_onchange(this)"/>
                 <form:errors path='memberImage' cssClass="error"/>
               </div>


               
               <div class="col-12">
                   <label for="" class="form-label"></label>
                   <form:button style="width: 200px" class="btn btn-primary" id="commitAndsned" value="send">更新資料</form:button>
               </div>
               
           </form:form>





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
          
        function valid_after_onchange(tag) {
            tag.className = "form-control is-valid";
        }
    </script>

</body>
</html>