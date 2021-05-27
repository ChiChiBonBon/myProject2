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
<!doctype html>
<html lang="en">

<head>
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

</head>

<body >

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
              <a class="nav-link active" href="./Post_3.jsp">
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
      
      
	<h5>文章編號:0113165</h5>
	<H1 ALIGN="CENTER">股市早報</H1>
	<br>
	<div></div>
	<article class="div">
		<h2>永豐金拉抬股價</h2>
		<figure>
			<img src="images/永豐金起飛_3.png" alt="" title="挖!" width="300px">
		</figure>
		<span>
			<p name="article">恭喜今天買永豐金的同學，未來賺錢的機率很高，因為很明顯主力會拉抬股價。
				今天在發布之前主力在13.45元掛賣單約1700張，13.5元掛賣單8000多張，13.55元掛賣單2000多張，13.6元掛賣單2000多張，13.65元掛賣單700多張，13.4元掛買單1000多張，只要13.4元買單低於1000張主力很明顯立即補單，也就是主力刻意控制股價在13.4元吃貨，主力意圖非常明顯。
			</p>
			<p name="article">永豐金是一支很棒的股票，尤其今年特別賺錢，金融類股已經悄悄發動了，推薦這支希望能讓大家荷包滿滿。</p>
		</span>
	</article>
	<br>
	<hr>
	<br>
	<form action="./ProjectServlet_3" method="post">
		<%="<font size='10'><b>留言板</b></font>"%>
				
		<center>

			<div class="s1">
			    
				<label class="s3" for="memo">留言:</label>
				<textarea name="comment" cols="50" rows="5" id="memo"
					placeholder="分享一下吧"></textarea> 
					
				<INPUT NAME="INSERT" TYPE="SUBMIT" VALUE="送出" id="send01">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
			    <INPUT NAME="SELECTALL" TYPE="SUBMIT" VALUE="展開留言" id="all"> 
				<br>
				
				<%-- 
				<%!String str="";%>
				<%
				String nr =  request.getParameter("comment");
				Date date = new Date();
				SimpleDateFormat da = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String time = da.format(date);
				if(nr!="" && nr!=null){
				str += "留&nbsp;&nbsp;言：" + nr + "<br>留言時間：" + time + "<hr>";
				%>
				<%=str%>
				<%
				}
				%>--%>
			</div>
		</center>
		<!-- <table class="tb1">
			<thead>
				<form action="ProjectServlet_3" method="post">
				
					 <input type="hidden" name="send" value="a"> 
					<input type="submit" name="UPDATE" value="修改留言">
					
					  <input type="hidden" name="send" value="a">
					<input type="submit" name="DELETE" value="刪除留言">
				</form>
				</tr>
			</thead>
		</table>-->
	</form>
	
	<script src="./js/bootstrap.bundle.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script>
	$(function(){
        let i=3
         $('input#all').on('click',function(){
        	$('div#allfun').append('')
            i++
        }) 
        $('input#send01').on('click',function(){
        	let a= $('textarea#memo').val()
        	if(a==null || a==""){
        		alert("請輸入內容")
        		return false
        	}else{
        		return true
        	}
        	
        })
        })
        
     </script>
 
      </main>
    </div>
  </div>


  


</body>

</html>