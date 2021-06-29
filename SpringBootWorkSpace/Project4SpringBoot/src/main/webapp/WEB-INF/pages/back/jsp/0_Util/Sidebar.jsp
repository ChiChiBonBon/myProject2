<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<li class="nav-item active"><a class="nav-link" href="index.html">
			<i class="fas fa-fw fa-tachometer-alt"></i> <span>Dashboard</span>
	</a></li>

	<!-- Divider -->
	<hr class="sidebar-divider">

	<!-- Heading -->
	<div class="sidebar-heading">Interface</div>

	<!-- Nav Item - 會員資料 Collapse Menu -->
	<li class="nav-item"><a class="nav-link" href="#"> <i
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
				<a class="collapse-item" href="cp_Company.html" id="Company_Ba">公司介紹</a>
				<a class="collapse-item" href="cards.html" id="Company_PA">基本面</a>
			</div>
		</div>
	</li>

	<!-- Nav Item - 下單 Collapse Menu -->
	<li class="nav-item"><a class="nav-link" href="#"> <i
			class="fas fa-money-bill-wave"></i> <span>下單</span>
	</a></li>

	<!-- Nav Item - 抽籤 Collapse Menu -->
	<li class="nav-item"><a class="nav-link" href="#"> <i
			class="fas fa-vote-yea"></i> <span>抽籤</span>
	</a></li>

	<!-- Nav Item - 討論區 Collapse Menu -->
	<li class="nav-item"><a class="nav-link" href="#"> <i
			class="fas fa-comments"></i> <span>討論區</span>
	</a></li>



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