<%@ page import="tw.comment_3.bean.Comment_board_3" %>
  <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
      <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <%@ page import="java.util.*" %>
          <%@ page import="java.text.SimpleDateFormat" %>

<!doctype html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>3_Post</title>

<!-- <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/dashboard/"> -->
<!-- Bootstrap core CSS -->
<link rel='stylesheet' href="<c:url value='/css/bootstrap.min.css' />"
	type="text/css" />


<!-- Custom styles for this template -->
<link rel='stylesheet' href="<c:url value='/css/dashboard.css' />"
	type="text/css" />

<!-- fontawesome -->
<link rel="stylesheet"
	href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" />

<style>
p {
	display: inline-block;
	font-size: 16px;
}

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

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}

                  td,
                  th {
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

<body>

	<header
		class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
		<a class="navbar-brand col-md-3 col-lg-2 me-0 px-3" href="#">Company
			name</a>
		<button class="navbar-toggler position-absolute d-md-none collapsed"
			type="button" data-bs-toggle="collapse" data-bs-target="#sidebarMenu"
			aria-controls="sidebarMenu" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<input class="form-control form-control-dark w-100" type="text"
			placeholder="Search" aria-label="Search">
		<ul class="navbar-nav px-3">
			<li class="nav-item text-nowrap"><a class="nav-link" href="#">Sign
					out</a></li>
		</ul>
	</header>
	<div></div>
	<div class="container-fluid">
		<div class="row">
			<!-- ?????? -->
			<%@include file="/WEB-INF/pages/0_table.jsp"%>
			<!-- ?????? -->
			<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">


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
				<center>
				<a href = "./3_index"><button type="button">????????????</button></a>
				</center>
				<br>
				<hr>
				<br> <font size='10'><b>?????????</b></font>

				<center>

					<div class="s1">

						<label class="s3" for="memo">??????:</label>
						<textarea name="comment" cols="50" rows="5" id="comment"
							placeholder="???????????????"></textarea>
						<button NAME="INSERT" id="btnIns">??????</button>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<div id="dataArea02"></div>
						<div id="dataArea01"></div>

						<br>

					</div>


				</center>

				

				<script src="./js/bootstrap.bundle.min.js"></script>
				<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
				<script>
//                     var comment_num = ${comment_num};
				window.onload = function () {
					
                    var btnIns = document.getElementById("btnIns");
                    var btnUpd = document.getElementById("btnUpd");
                    
                    //??????????????????
                    var xhr0 = new XMLHttpRequest();
                    var url = "<c:url value = '/commentBoardJSON '/>";
                    xhr0.open("GET", url);
                    xhr0.send();
                    xhr0.onreadystatechange = function () {
                      if (xhr0.readyState == 4 && xhr0.status == 200) {
                        var comments = JSON.parse(xhr0.responseText);
                        var segment = " <form>";
                        for (var x in comments) {
                          tmp = "<c:url value='/updatecomment/' />"; 
                          var commentall = comments[x]
                          segment += "<input type='hidden'>"
                          segment += "<div id='resultMsg' style='height: 18px; font-weight: bold;'></div>"
                          segment += "<p id='comment_num'>" + commentall.comment_num + "???:</p><br><br>"
                          segment += "<input type='text' hidden>"
                          segment += "<p>????????????:</p><p></p>"
                          segment += "<p>" + commentall.comment
                          segment += "</p><br><br>"
//                           segment += "<p>????????????:2020-01-01</p>"
                          segment += "<p><a href='" + tmp + comments[x].comment_num + "'><input type='button' value='????????????' id='btnUpd'></a>"
                          segment += "</p><hr>"
                        }
                        segment += "</form>";
                        var dataArea01 = document.getElementById("dataArea01");
                        dataArea01.innerHTML = segment;
						console.log(segment);
						return segment;
                      }
                    }

                    btnIns.onclick = function () {
                        var btnIns = document.getElementById("btnIns");
                        var btnUpd = document.getElementById("btnUpd");
                        
                        //??????????????????
                        var xhr0 = new XMLHttpRequest();
                        var url = "/Project2Mvc/commentBoardJSON ";
                        xhr0.open("GET", url);
                        xhr0.send();
                      xhr0.onreadystatechange = function () {
                        if (xhr0.readyState == 4 && xhr0.status == 200) {
                          var comments = JSON.parse(xhr0.responseText);
                          var segment = " <form>";
                          for (var x in comments) {
                            tmp = "<c:url value='/updatecomment/' />";
                            var commentall = comments[x]
                            segment += "<input type='hidden'>"
                            segment += "<div id='resultMsg' style='height: 18px; font-weight: bold;'></div>"
                            segment += "<p id='comment_num'>" + commentall.comment_num + "???:</p><br><br>"
                            segment += "<input type='text' hidden>"
                            segment += "<p>????????????:</p><p></p>"
                            segment += "<p>" + commentall.comment
                            segment += "</p><br><br>"
//                             segment += "<p>????????????:2020-01-01</p>"
                            segment += "<p><a href='" + tmp + comments[x].comment_num + "'><input type='button' value='????????????' id='btnUpd'></a>"
                            segment += "</p><hr>"
                          }
                          segment += "</form>";
                          var dataArea01 = document.getElementById("dataArea01");
                          dataArea01.innerHTML = segment;

                          var aa = $('#dataArea01').val();
                          console.log(aa)

                          var comment_numValue = document.getElementById("comment_num").value;
                          var commentValue = document.getElementById("comment").value;
                          var dataArea02 = document.getElementById('dataArea02');
                          var divResult = document.getElementById('resultMsg');

                         
                            if (!commentValue) {
                              div.innerHTML = "<font color='blue' size='-1'>???????????????...</font>";
                              return;
                            }
                            var xhr1 = new XMLHttpRequest();
                            var url = "<c:url value = '/commentBoard2 '/>";
                            xhr1.open("POST", url);
                            var jsonComment = {
                              "comment_num": comment_numValue,
                              "comment": commentValue
                            }
                            xhr1.setRequestHeader("Content-Type", "application/json");
                            xhr1.send(JSON.stringify(jsonComment));

                            xhr1.onreadystatechange = function () {
                              // ?????????????????????
                              if (xhr1.readyState == 4 && (xhr1.status == 200 || xhr1.status == 201)) {
                                result = JSON.parse(xhr1.responseText);
                                if (result.fail) {
                                  divResult.innerHTML = "<font color='red' >" + result.fail + "</font>";
                                } else if (result.success) {
                                  divResult.innerHTML = "<font color='GREEN'>" + result.success + "</font>";
                                  document.location.href="<c:url value='/commentBoard' />";
                                }
                              }
                            }
                          


                        }
                      }

                    }
				}
				</script>            

			</main>
		</div>
	</div>





</body>

</html>