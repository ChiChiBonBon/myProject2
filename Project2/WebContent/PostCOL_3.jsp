<%@page import="bean01_3.SocialBean_3"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%
response.setContentType("text/html;charset=UTF-8");
response.setHeader("Cache-Control", "no-cache"); // HTTP 1.1
response.setHeader("Pragma", "no-cache"); // HTTP 1.0
response.setDateHeader("Expires", -1); // Prevents caching at the proxy server
%>

<!DOCTYPE html>
<HTML>

<HEAD>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="">
  <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
  <meta name="generator" content="Hugo 0.82.0">
  <TITLE>Post_3</TITLE>

  <!-- <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/dashboard/"> -->
   <!-- Bootstrap core CSS -->
   <link href="./css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom styles for this template -->
  <link href="./css/dashboard.css" rel="stylesheet">
  <!-- fontawesome -->
  <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<TITLE>Post_3</TITLE>
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
td, th {
	border: 2px solid black;
	text-align: center;
}

.s1 {
	width: 550px;
	margin: 10px;
}

.s3 {
	width: 100px;
	float: left;
	text-align: right;
}

* {
	margin: 0px;
	padding: 0px;
}

h1 {
	margin-bottom: 20px;
}

.div {
	border: 5px solid black;
	padding: 30px;
	width: 800px;
	margin: auto;
	margin-top: 30px;
	border-radius: 40px;
	background-color: white;
}

figure {
	border: 3px solid black;
	float: left;
	padding: 10px;
	margin-right: 30px;
	width: 326px;
	font-size: 0.5em;
	margin-bottom: 30px;
}

p {
	line-height: 1.7;
	margin-bottom: 15px;
	text-align: justify;
}

article {
	display: block;
}

thead {
	color: brown;
	text-transform: capitalize;
}
</style>
<script>
	document.createElement("article")
	document.createElement("figure")
</script>
</HEAD>

<BODY >

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
              <a class="nav-link" aria-current="page" href="./dashboard.html">
                <span class="me-1"><i class="fas fa-tachometer-alt"></i></span>
                Dashboard
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="./login_1.jsp">
                <span class="me-1"><i class="fas fa-sign-in-alt"></i></span>
                ??????
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="./Login.jsp">
                <span class="me-1"><i class="fas fa-funnel-dollar"></i></span>
                ??????
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link active" href="./Post_3.jsp">
                <span class="me-1"><i class="far fa-comment-dots"></i></span>
                ??????
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="./Buy_4.html">
                <span class="me-1"><i class="fas fa-dice-d20"></i></span>
                ??????
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="./CourseManagement5.html">
                <span class="me-1"><i class="fas fa-clipboard-list"></i></span>
                ??????
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="./company_6.jsp">
                <span class="me-1"><i class="fas fa-building"></i></span>
                ????????????
              </a>
            </li>
          </ul>
        </div>
      </nav>

      <!-- ?????? -->
      <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
	<jsp:useBean id="socl_bean" class="bean01_3.SocialBean_3" scope="session" />

	<h5>????????????:0113165</h5>
	<H1 ALIGN="CENTER">????????????</H1>
	<br>
	<div></div>
	<article class="div">
		<h2>?????????????????????</h2>
		<figure>
			<img src="images/???????????????_3.png" alt="" title="???!" width="300px">
		</figure>
		<span>
			<p name="article">?????????????????????????????????????????????????????????????????????????????????????????????????????????
				??????????????????????????????13.45???????????????1700??????13.5????????????8000?????????13.55????????????2000?????????13.6????????????2000?????????13.65????????????700?????????13.4????????????1000???????????????13.4???????????????1000?????????????????????????????????????????????????????????????????????13.4???????????????????????????????????????
			</p>
			<p name="article">????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????</p>
		</span>
	</article>
	<br>
	<hr>
	<br>
	<form action="./ProjectServlet_3" method="post">
	
	
	
		<%="<font size='24'><b>?????????</b></font>"%>
				
		<center>

			<div class="s1">
				<label class="s3" for="memo">??????:</label>
				<textarea name="comment" cols="50" rows="5" id="memo"
					placeholder="???????????????"></textarea>
				<INPUT NAME="INSERT" TYPE="SUBMIT" VALUE="??????">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
			    <INPUT NAME="SELECTALL" TYPE="SUBMIT" VALUE="????????????" id="all"> 
				</form>
				<br>
			</div>
				<div id="allfun">
					<% SocialBean_3 bean01= (SocialBean_3)request.getAttribute("qrqr"); %>
					<%
					Date date = new Date();
					SimpleDateFormat da = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String time = da.format(date);
					
					for(int i=0;i<bean01.getDBcomment_num().size();i++){%>
				    <form action="./ProjectServlet_3" method="post" id="form">
					     <input type="hidden" name="delHidden" value="<%=bean01.getDBcomment_num().get(i)%>">
					     
 				   		 <p><%=bean01.getDBcomment_num().get(i) %>???:</p>
 				   		 <br><br><br>
 				   		 
						 <input type="text" name="comment_numDB" value="<%=bean01.getDBcomment_num().get(i) %>" hidden>
						 
 				   		 <p>????????????:</p><p id="000"><%=bean01.getDBcomment().get(i) %></p>
 				   		 <p><input type="text" id="111"  name="commentDB" value="<%=bean01.getDBcomment().get(i)%>">
 				   		 
 				   		 <input type="submit" id="222"  value="????????????" name="UPDATE">
 				   		 </p><br><br><br>
 				  		 <p>????????????:<%=time%></p>
 				  		 
 				  		 <p><input type="button" name="" value="????????????" id="333">
 				  		 <input type="submit" name="DELETE" value="????????????"></p><hr>
					</form>
 				  		 
 				    <%
					   }
 				%>
				</div>
		</center>
		<!--<table class="tb1">
  			  <thead>
				<form action="ProjectServlet_3" method="post">
				
					<input type="hidden" name="send" value="a"> 
					<input type="submit" name="UPDATE" value="????????????">
					
					<input type="hidden" name="send" value="a">
					<input type="submit" name="DELETE" value="????????????">
				</form>
			</thead>
		</table>-->
	
	<script src="./js/bootstrap.bundle.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

	<script>$(function(){
		$('#allfun #111').hide()
		$('#allfun #222').hide()
        let i=3
        $('input#all').on('click',function(){
            $('div#allfun').append('')
            i++
        })
        $('input#send01').on('click',function(){
        	let a= $('textarea#memo').val()
        	if(a===null || a===""){
        		alert("??????")
        		return false
        	}else{
        		return true
        	}
        	
        })
        
		
			$('#allfun #333').on('click',function(){   
				let index = $(this).parent().parent().index()

				console.log(index)
				$('#allfun #000').eq(index).toggle()
				$('#allfun #111').eq(index).toggle()
				$('#allfun #222').eq(index).toggle() 
				
			})
		
        })
        </script>

        </main>
    </div>
  </div>


  
	
</BODY>
</HTML>