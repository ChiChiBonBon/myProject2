<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<!doctype html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="">
  <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
  <meta name="generator" content="Hugo 0.82.0">
  <title>Dashboard</title>

   <!-- <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/dashboard/"> -->
   <!-- Bootstrap core CSS -->
   <link rel='stylesheet' href="<c:url value='/css/bootstrap.min.css' />" type="text/css" /> 
   <!-- Custom styles for this template -->
   <link rel='stylesheet' href="<c:url value='/css/dashboard.css' />" type="text/css" />
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

    .pic{
      position:absolute;
      right:0px;
      bottom:0px
    }
    .Hpic{
      margin-top: 20%;    
      margin-left: 20%;
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
      <!-- ?????? -->
	  <%@include file="/WEB-INF/pages/0_table.jsp" %>

      <!-- ?????? -->
      <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">

        
        

        <div class="Hpic">
          <img src="<c:url value='/images/homepage.png' />" alt="">
        </div>
        




        <div class="pic">
          <img src="<c:url value='/images/pekoHead.png' />" alt="" >
        </div>

        
      </main>
    </div>

  </div>
  

  

  <script src="<c:url value='/js/bootstrap.bundle.min.js' />"></script>

</body>

</html>