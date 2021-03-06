<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>

<ul class="navbar-nav bg-gradient-dark sidebar sidebar-dark accordion"
	id="accordionSidebar">

	<!-- Sidebar - Brand -->
	<a
		class="sidebar-brand d-flex align-items-center justify-content-center"
		href="index.html">
		<div class="sidebar-brand-icon rotate-n-15">
			<!-- <i class="fas fa-laugh-wink"></i> -->
		</div>
		<div class="sidebar-brand-text mx-3">
			SB Admin <sup>2</sup>
		</div>
	</a>

	<!-- Divider -->
	<hr class="sidebar-divider my-0">

	<!-- Nav Item - Dashboard -->
	<li class="nav-item" id="dashboard"><a class="nav-link" href="<c:url value="/" />">
			<i class="fas fa-fw fa-tachometer-alt"></i> <span>Dashboard</span>
	</a></li>

	<!-- Divider -->
	<hr class="sidebar-divider">

	<!-- Heading -->
	<div class="sidebar-heading">Interface</div>

	<!-- Nav Item - 會員資料 Collapse Menu -->
	<li class="nav-item"><a class="nav-link" href="<c:url value='/back/admin_1/goAdminMember_1' />"> <i
			class="fas fa-user-cog"></i> <span>會員資料</span>
	</a></li>

	<!-- Nav Item - 股票篩選器 Collapse Menu -->
	<li class="nav-item" id="CP">
		<a class="nav-link" href="#" data-toggle="collapse" data-target="#collapseCP"
		aria-expanded="true" aria-controls="collapseCP" >
			<i class="fas fa-building"></i>
			<span>股票篩選器</span>
		</a>
		<div id="collapseCP" class="collapse" aria-labelledby="" data-parent="#accordionSidebar" >
			<div class="bg-white py-2 collapse-inner rounded">
				<!-- <h6 class="collapse-header">Custom Components:</h6> -->
				<a class="collapse-item" href="<c:url value="/back/cBasic/Main" />" id="Company_Basic">公司介紹</a>
				<a class="collapse-item" href="<c:url value="/back/pa/Main" />" id="Company_PA">基本面</a>
			</div>
		</div>
	</li>

	<!-- Nav Item - 下單 Collapse Menu -->
	<li class="nav-item">
			<a class="nav-link" href="#" data-toggle="collapse" data-target="#collapseOD"
				aria-expanded="true" aria-controls="collapseOD" >
				<i class="fas fa-building"></i>
				<span>股票下單</span>
			</a>
			<div id="collapseOD" class="collapse" aria-labelledby="" data-parent="#accordionSidebar" >
				<div class="bg-white py-2 collapse-inner rounded">
					<a class="collapse-item" href="<c:url value='/admin/order' />" id="back_order">代客下單</a>
				</div>
			</div>
	</li>

	<!-- Nav Item - 抽籤 Collapse Menu -->
	<!--<li class="nav-item"><a class="nav-link" href="<c:url value='/back/drawlots' />" > <i
			class="fas fa-vote-yea"></i> <span>抽籤</span>
	</a></li>-->
	
	<li class="nav-item" id="DS">
		<a class="nav-link" href="#" data-toggle="collapse" data-target="#collapseDS"
		aria-expanded="true" aria-controls="collapseDS" >
			<i class="fas fa-building"></i>
			<span>股票抽籤申購管理</span>
		</a>
		<div id="collapseDS" class="collapse" aria-labelledby="" data-parent="#accordionSidebar" >
			<div class="bg-white py-2 collapse-inner rounded">
				<!-- <h6 class="collapse-header">Custom Components:</h6> -->
				<a class="collapse-item" href="<c:url value="/back/drawlots" />" id="Drawlots_Management">抽籤管理</a>
				<a class="collapse-item" href="<c:url value="/back/subscription" />" id="Subscription_Management" >申購管理</a>
			</div>
		</div>
	</li>

	<!-- Nav Item - 討論區 Collapse Menu -->
	<li class="nav-item" id="PostSidebar"><a class="nav-link" href="<c:url value="/post" />" id="PostActive"> <i
			class="fas fa-comments"></i> <span>討論區</span>
	</a></li>

    <!-- Nav Item - 事件管理員 Collapse Menu -->
    <li class="nav-item" id="Event">
         <a class="nav-link" href="#" data-toggle="collapse" data-target="#collapseEvent" aria-expanded="true"
             aria-controls="collapseEvent">
             <i class="fas fa-users-cog"></i>
             <span>事件管理員</span>
         </a>
         <div id="collapseEvent" class="collapse" aria-labelledby="collapseEvent"
             data-parent="#accordionSidebar">
             <div class="bg-white py-2 collapse-inner rounded">
                 <!-- <h6 class="collapse-header">Custom Components:</h6> -->
                 <a class="collapse-item" href="<c:url value='/back/eventLog/Main' />" id="eventLog">事件紀錄</a>
                 <a class="collapse-item" href="<c:url value='/back/systemPerformance/Main' />" id="performance">系統資源</a>
             </div>
         </div>
     </li>

	<!-- Divider -->
	<hr class="sidebar-divider d-none d-md-block">

	<!-- Sidebar Toggler (Sidebar) -->
	<div class="text-center d-none d-md-inline">
		<button class="rounded-circle border-0" id="sidebarToggle"></button>
	</div>

	<!-- Sidebar Message -->
	<!-- <div class="sidebar-card d-none d-lg-flex">
                <img class="sidebar-card-illustration mb-2" src="img/undraw_rocket.svg" alt="...">
                <p class="text-center mb-2"><strong>SB Admin Pro</strong> is packed with premium features, components, and more!</p>
                <a class="btn btn-success btn-sm" href="https://startbootstrap.com/theme/sb-admin-pro">Upgrade to Pro!</a>
            </div> -->

</ul>