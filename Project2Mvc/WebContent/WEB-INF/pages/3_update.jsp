<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>3_update</title>

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

				<div align='center'>
					<h2>????????????</h2>
					<div id='resultMsg' style="height: 18px; font-weight: bold;"></div>
					<fieldset style='display: inline-block; width: 820px;'>
						<legend>???????????????</legend>
						<table border='1'>
							<tr height='60'>
								<td><input type="hidden" name="id" id='comment_numb'><br></td>
								<td>??????:<label id='comment_numa'></label><br>
								</td>
							</tr>
							<tr height='60'>
								<td></td>
								<td width='820px'>??????: <input width type="text" name="name"
									id='comment'><label id='commenta'></label><br>
								</td>
							</tr>
							<tr height='50'>
								<td colspan='3' align='center'>
									<button id='btnUpd'>??????</button>
									<button id='btnDel'>??????</button>
								</td>
							</tr>
						</table>
					</fieldset>


				</div>


			</main>
		</div>
	</div>

	<script src="<c:url value='/js/bootstrap.bundle.min.js' />"></script>
	<script src="<c:url value='/js/jquery-3.6.0.js' />"></script>
	<script src="<c:url value='/js/company_6.js' />"></script>
	<script>
                                var comment_num = ${ comment_num };
                                window.onload = function () {
                                    var divResult = document.getElementById('resultMsg');		
                                    var comment_numb = document.getElementById('comment_numb');
                                    var comment_numa = document.getElementById('comment_numa');
                                    var comment = document.getElementById('comment');
                                            comment_numb.value = '${ comment_num }';
                                            comment_numa.innerHTML = '${ comment_num }';
                                            comment.value = '${bean.comment}';
                                    
                                    
                                    
                                    var btnUpd = document.getElementById("btnUpd");
                                    var btnDel = document.getElementById("btnDel");

                                    btnDel.addEventListener('click', (e) => {
                                        var result = confirm("????????????????????????(??????:" + comment_numb.value + ")?");
                                        if (result) {
                                            var xhr3 = new XMLHttpRequest();
                                            xhr3.open("DELETE", "<c:url value='/commentBoardDEL/" + comment_num + "'/>", true);
                                            xhr3.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
                                            xhr3.send();
                                            xhr3.onreadystatechange = function () {
                                                if (xhr3.readyState == 4 && (xhr3.status == 200 || xhr3.status == 204)) {
                                                    result = JSON.parse(xhr3.responseText);
                                                    if (result.fail) {
                                                        divResult.innerHTML = "<font color='red' >"
                                                            + result.fail + "</font>";
                                                    } else if (result.success) {
                                                        alert("????????????");
                                                        window.location.href = "<c:url value='/commentBoard'/>"
                                                    }
                                                }

                                            }
                                        }
                                    });

                                    btnUpd.onclick = function () {
                                    	var comment_numbValue = document.getElementById('comment_numb').value;
                                    	var commentValue = document.getElementById('comment').value;
                                    	var commentaValue = document.getElementById('commenta').value;
                                    	
                                        if (!commentValue) {
                                        	commentaValue.innerHTML = "<font color='blue' size='-1'>???????????????...</font>";
                                            return;
                                        }
                                        var xhr2 = new XMLHttpRequest();
                                        xhr2.open("PUT", "<c:url value='/updatecomment/"+comment_num+ "'/>", true);
                                        var jsonComment = {
                                            "comment_num": comment_numbValue,
                                            "comment": commentValue
                                        }
                                        xhr2.setRequestHeader("Content-Type", "application/json");
                                        xhr2.send(JSON.stringify(jsonComment));

                                        xhr2.onreadystatechange = function () {
                                            // ?????????????????????
                                            if (xhr2.readyState == 4 && (xhr2.status == 200 || xhr2.status == 201)) {
                                                result = JSON.parse(xhr2.responseText);
                                                if (result.fail) {
                                                    divResult.innerHTML = "<font color='red' >" + result.fail + "</font>";
                                                } else if (result.success) {
                                                    divResult.innerHTML = "<font color='GREEN'>" + result.success + "</font>";
                                                    window.location.href = "<c:url value='/commentBoard'/>"
                                                }
                                            }
                                        }
                                    };

                                }

                            </script>







</body>

</html>