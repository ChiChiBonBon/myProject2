<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
		<%@page import="java.util.ArrayList" %>
			<%@page import="tw.course_5.bean.*" %>
				<%@page import="java.util.List" %>
					<jsp:useBean id="course" class="tw.course_5.bean.Course_5" scope="session" />
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
						<link rel="stylesheet" type="text/css" href="<c:url value='/css/course_5.css'/>">
						<link href="<c:url value='/css/bootstrap.min.css'/>" rel="stylesheet">
						<link rel="stylesheet" type="text/css"
							href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
					
						<link href="<c:url value='/css/dashboard.css'/>" rel="stylesheet">
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
							<!-- ?????? -->
							<%@include file="/WEB-INF/pages/0_table.jsp" %>
            				<!-- ???????????? -->
							  <main class="col-md-9 ms-sm-auto col-lg-11 px-md-4">
						<div>
							<button onclick="setActionCodeInsert();" id="insert" class="btn btn-info btn-sm"
								data-toggle="modal" data-target="#myModal">??????</button>
						</div>
						<table id="table_id" class="display">
							<thead>
								<tr>
									<th>??????</th>
									<th>????????????</th>
									<th>????????????</th>
									<th>????????????</th>
									<th>????????????</th>
									<th>????????????</th>
									<th>??????</th>
									<th>??????</th>
									<th>??????</th>
									<th>????????????</th>
									<th>??????</th>
									<th>??????</th>
								</tr>
							</thead>
							<tbody>
										
											<c:if test="${courseResultSet != null}">
											<c:forEach var="item" items="${courseResultSet}">
										
												<tr>
													<td>
														<div class="operation">
															<button onclick="setActionCodeUpdate(this);"
																class="btn btn-info btn-sm update" data-toggle="modal"
																data-target="#myModal">??????</button>
															<br>
															<button onclick="setActionCodeDelete(this);"
																class="btn btn-info btn-sm delete">??????</button>
														</div>
													</td>
													 
													<td class="courseIdSet">${item.courseID}</td>
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
													</c:forEach>
													</c:if>
							</tbody>
						</table>

						<!-- ????????????Modal??? -->
						<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
							aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-hidden="true"></button>
										<h4 class="modal-title" id="myModalLabel">??????/????????????</h4>
									</div>
									<div class="modal-body">
										<!--???????????????????????????-->
										<form action="courseController/updateControllerMethod" method="post" onsubmit="return check();">

											<table id="insertOrAlter">
												<tr>
													<td><label path="courseID">????????????</label> <input path="courseID" type="text"
															placeholder="????????????" value=""/></td>
													<td><label path="teacherName">????????????</label> <input type="text" path="teacherName"
															placeholder="????????????" value=""/></td>
												</tr>
												<tr>
													<td><label path="courseOutline">????????????</label><input type="text" path="courseOutline"
															placeholder="????????????" value=""/></td>
													<td><label path="courseDate">????????????</label> <input type="date" path="courseDate"
															placeholder="????????????" value=""/></td>
												</tr>
												<tr>
													<td><label path="courseTime">????????????</label> <input type="text" path="courseTime"
															placeholder="????????????" pattern="([01]?[0-9]|2[0-3]):[0-5][0-9]"
															id="24h" value=""/></td>
													<td><label path="fee">??????</label><input type="text" path="fee" placeholder="??????"
															value=""/></td>
												</tr>
												<tr>
													<td><label path="quota">????????????</label><input type="text" path="quota"
															placeholder="????????????" value=""/></td>
													<td><label path="classification">??????</label><input type="text" path="classification"
															placeholder="??????" value=""/></td>
												</tr>
												<tr>
													<td><label path="teachingMethod">????????????</label> <input type="text" path="teachingMethod"
															placeholder="????????????" value=""/></td>
													<td><label path="area">????????????</label> <input type="text" path="area"
															placeholder="????????????" value=""/></td>
												</tr>
												<tr>
													<td><label path="comment">??????</label><input type="text" path="comment"
															placeholder="??????" value=""/>
												</tr>
											</table>

											<input id="actionCode1" type="hidden" name="actionCode" value="null">

											<div class="modal-footer">
												<button type="button" class="btn btn-default"
													data-dismiss="modal">??????</button>
												<button type="submit" class="btn btn-primary">??????</form>
											</div>
										</form>
									</div>
								</div>
								<!-- /.modal-content -->
							</div>
							<!-- /.modal -->
						</div>
						<form id="FormSubmiter" action="<c:url value='/deleteControllerMethod'/>" method="post" hidden>
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
				<script type="text/javascript" charset="utf8" src="<c:url value='/js/course_5.js'/>"></script>
					</body>

					</html>