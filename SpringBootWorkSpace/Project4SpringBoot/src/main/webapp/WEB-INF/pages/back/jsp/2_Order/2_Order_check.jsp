<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>

<!doctype html>
<html lang="en">

<head>

  <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Dashboard</title>

    <!-- Custom fonts for this template-->
    <link href="<c:url value='/back/vendor/fontawesome-free/css/all.min.css' />" rel="stylesheet" type="text/css">
    <!-- 文字 -->
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="<c:url value='/back/css/sb-admin-2.min.css' />" rel="stylesheet">

</head>

<body>
	<!-- Page Wrapper -->
    <div id="wrapper">

        <!-- A01 Sidebar -->
        <%@include file="/WEB-INF/pages/back/jsp/0_Util/Sidebar.jsp" %>

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

        <!-- Main Content -->
        <div id="content">

                <!-- A02 Topbar -->
                <%@include file="/WEB-INF/pages/back/jsp/0_Util/Topbar.jsp" %>
				
                <!-- 內容 -->
                <!-- Begin Page Content -->
                <div class="container-fluid">
                
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
                
                
                



            </div>
            <!-- End of Page Content -->

            </div>
            <!-- End of Main Content -->

            <!-- A03 Footer -->
            <%@include file="/WEB-INF/pages/back/jsp/0_Util/Footer.jsp" %>

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- A04 Scroll to Top Button-->
    <%@include file="/WEB-INF/pages/back/jsp/0_Util/TopButton.jsp" %>

    <!-- A05 Logout Modal-->
    <%@include file="/WEB-INF/pages/back/jsp/0_Util/LogoutModal.jsp" %>


    <!-- script -->
    <script src="<c:url value='/back/js/Order.js' />" async defer></script>
    
    <!-- Bootstrap core JavaScript-->
    <script src="<c:url value='/back/vendor/jquery/jquery.min.js' />"></script>
    <script src="<c:url value='/back/vendor/bootstrap/js/bootstrap.bundle.min.js' />"></script>

    <!-- Core plugin JavaScript-->
    <script src="<c:url value='/back/vendor/jquery-easing/jquery.easing.min.js' />"></script>

    <!-- Custom scripts for all pages-->
    <script src="<c:url value='/back/js/sb-admin-2.min.js' />"></script>

    <!-- Page level plugins -->
<%-- <script src="<c:url value='/back/vendor/chart.js/Chart.min.js' />"></script> --%>

    <!-- Page level custom scripts -->
<%-- <script src="<c:url value='/back/js/demo/chart-area-demo.js' />"></script> --%>
<%-- <script src="<c:url value='/back/js/demo/chart-pie-demo.js' />"></script>  --%>


</body>

</html>