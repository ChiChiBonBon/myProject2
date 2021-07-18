<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
  
  <!-- ======= A02 Header ======= -->
  <header id="header" class="d-flex align-items-center">
    <div class="container d-flex justify-content-between align-items-center">

      <div class="logo">
        <h1><a href="index.html">STOCK OVERFLOW</a></h1>
        <!-- Uncomment below if you prefer to use an image logo -->
        <!-- <a href="index.html"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->
      </div>

      <nav id="navbar" class="navbar fw-bolder ">
        <ul>
          <li><a id="header_front" class="fs-6" href="<c:url value='/front' />">首頁</a></li>
          <li><a id="header_About" class="fs-6" href="<c:url value='/front/unmember/gologin_1' />">會員登入</a></li>
          <li><a id="header_Company" class="fs-6" href="<c:url value='/front/cTable/Main' />">股票選擇器</a></li>
          <li><a class="fs-6" href="<c:url value='#' />">下單</a></li>
          <li><a class="fs-6" id="header_DrawlotsSubscription" href="<c:url value='/front/guestView' />">抽籤與申購</a></li>
          <li><a class="fs-6" href="<c:url value='#' />">留言區</a></li>
          <%-- <li><a href="contact.html">Contact</a></li> --%>
        </ul>
        <i class="bi bi-list mobile-nav-toggle"></i>
      </nav><!-- .navbar -->
	
    </div>
    <span>
    	<div class=""> 
        <span class="mr-2 d-none d-lg-inline text-gray-600 small ">Douglas McGee</span> 
        <img class="rounded-circle me-4" src="<c:url value='/front/assets/img/person/aaa.jpg' />" height="50 ">
		  </div> <!-- Dropdown - User Information -->	
    </span>
  </header><!-- End Header -->