<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" --%>
		<%@page import="java.util.ArrayList" %>
			<%@page import="bean_5.Course" %>
				<%@page import="java.util.List" %>
					<jsp:useBean id="course" class="bean_5.Course" scope="session" />
					<!DOCTYPE html>

					<html lang="en">

					<head>
						<meta charset="UTF-8">
						<meta name="viewport" content="width=device-width, initial-scale=1">
						<meta name="description" content="">
						<meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
						<meta name="generator" content="Hugo 0.82.0">
						<title>CourseManagement</title>
						<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.24/css/jquery.dataTables.css">
						<link rel="stylesheet" type="text/css" href="./chibon_5/style.css">
						<link href="./css/bootstrap.min.css" rel="stylesheet">
						<link rel="stylesheet" type="text/css"
							href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
					
						<link href="./css/dashboard.css" rel="stylesheet">
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
					  <a class="nav-link" href="./Post_3.jsp">
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
					  <a class="nav-link active" href="./CourseManagement5.html">
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
						<div>
							<button onclick="setActionCodeInsert();" id="insert" class="btn btn-info btn-sm"
								data-toggle="modal" data-target="#myModal">新增</button>
						</div>
						<table id="table_id" class="display">
							<thead>
								<tr>
									<th>操作</th>
									<th>課程編號</th>
									<th>講師姓名</th>
									<th>課程主題</th>
									<th>場次日期</th>
									<th>上課時間</th>
									<th>收費</th>
									<th>名額</th>
									<th>分類</th>
									<th>授課方式</th>
									<th>地區</th>
									<th>備註</th>
								</tr>
							</thead>
							<tbody>

								<% List<Course> courseList = (List<Course>) session.getAttribute("Courses");
										%>
										<% if(courseList !=null){ %>
											<!--<c:forEach var="item" items="${courseList}">-->
											<% for(Course c:courseList){ %>
												<tr>
													<td>
														<div class="operation">
															<button onclick="setActionCodeUpdate(this);"
																class="btn btn-info btn-sm update" data-toggle="modal"
																data-target="#myModal">修改</button>
															<br>
															<button onclick="setActionCodeDelete(this);"
																class="btn btn-info btn-sm delete">刪除</button>
														</div>
													</td>
													<!-- 
				<td>${item.courseID}</td>
				<td>${item.teacherName}</td>
				<td>${item.courseOutline}</td>
				<td>${item.courseDate}</td>
				<td>${item.courseTime}</td>
				<td>${item.fee}</td>
				<td>${item.quota}</td>
				<td>${item.classification}</td>
				<td>${item.teachingMethod}</td>
				<td>${item.area}</td>
				<td>${item.comment}</td>
				 -->

													<td class="courseIdSet">
														<%= c.getCourseID() %>
													</td>
													<td>
														<%= c.getTeacherName() %>
													</td>
													<td>
														<%= c.getCourseOutline() %>
													</td>
													<td>
														<%= c.getCourseDate() %>
													</td>
													<td>
														<%= c.getCourseTime() %>
													</td>
													<td>
														<%= c.getFee().setScale(0) %>
													</td>
													<td>
														<%= c.getQuota() %>
													</td>
													<td>
														<%= c.getClassification() %>
													</td>
													<td>
														<%= c.getTeachingMethod() %>
													</td>
													<td>
														<%= c.getArea() %>
													</td>
													<td>
														<%= c.getComment() %>
													</td>
												</tr>
												<!--</c:forEach>-->
												<% } %>
													<% } else { %>

														<% } %>
							</tbody>
						</table>

						<!-- 模态框（Modal） -->
						<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
							aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-hidden="true"></button>
										<h4 class="modal-title" id="myModalLabel">新增/修改視窗</h4>
									</div>
									<div class="modal-body">
										<!--在这里添加一些文本-->
										<form action="./CourseServlet" method="post" onsubmit="return check();">

											<table id="insertOrAlter">
												<tr>
													<td><label>課程編號</label> <input type="text" name="courseID"
															placeholder="課程編號" value=""></td>
													<td><label>講師姓名</label> <input type="text" name="teacherName"
															placeholder="講師姓名" value=""></td>
												</tr>
												<tr>
													<td><label>課程大綱</label><input type="text" name="courseOutline"
															placeholder="課程大綱" value=""></td>
													<td><label>場次日期</label> <input type="date" name="courseDate"
															placeholder="場次日期" value=""></td>
												</tr>
												<tr>
													<td><label>上課時間</label> <input type="text" name="courseTime"
															placeholder="上課時間" pattern="([01]?[0-9]|2[0-3]):[0-5][0-9]"
															id="24h" value=""></td>
													<td><label>費用</label><input type="text" name="fee" placeholder="費用"
															value=""></td>
												</tr>
												<tr>
													<td><label>開課名額</label><input type="text" name="quota"
															placeholder="開課名額" value=""></td>
													<td><label>分類</label><input type="text" name="classification"
															placeholder="分類" value=""></td>
												</tr>
												<tr>
													<td><label>授課方式</label> <input type="text" name="teachingMethod"
															placeholder="授課方式" value=""></td>
													<td><label>上課地區</label> <input type="text" name="area"
															placeholder="上課地區" value=""></td>
												</tr>
												<tr>
													<td><label>備註</label><input type="text" name="comment"
															placeholder="備註" value="">
												</tr>
											</table>

											<input id="actionCode1" type="hidden" name="actionCode" value="null">

											<div class="modal-footer">
												<button type="button" class="btn btn-default"
													data-dismiss="modal">關閉</button>
												<button type="submit" class="btn btn-primary">送出</button>
											</div>

										</form>


									</div>
								</div>
								<!-- /.modal-content -->
							</div>
							<!-- /.modal -->
						</div>
						<form id="FormSubmiter" action="./CourseServlet" method="post" hidden>
							<input id="actionCode2" type="hidden" name="actionCode" value="null">
							<input type="text" name="deleteCourseID" value="null" id="deletecourseID">;
							<input id="autoSubmiter" type="submit">
						</form>
					</main>



				</div>
			  </div>
			
			
			  <script src="./js/bootstrap.bundle.min.js"></script>
			  <script type="text/javascript" charset="utf8" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
				<%-- <script type="text/javascript" charset="utf8" src="./js/bootstrap.min.js"></script> --%>
				<script type="text/javascript" charset="utf8"
							src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
				<script type="text/javascript" charset="utf8" src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
				<script type="text/javascript" charset="utf8"
							src="https://cdn.datatables.net/1.10.24/js/jquery.dataTables.js"></script>
				<script type="text/javascript" charset="utf8" src="./chibon_5/main.js"></script>
					</body>

					</html>