<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

  <nav id="sidebarMenu" class="col-md-3 col-lg-1 d-md-block bg-light sidebar collapse">
    <div class="position-sticky pt-3">
      <ul class="nav flex-column">
        <li class="nav-item">
          <a class="nav-link" aria-current="page" href="<c:url value='/'/>">
            <span class="me-1"><i class="fas fa-tachometer-alt"></i></span>
            Dashboard
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="<c:url value='/....'/>">
            <span class="me-1"><i class="fas fa-sign-in-alt"></i></span>
            會員
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="<c:url value='/testlogin'/>">
            <span class="me-1"><i class="fas fa-funnel-dollar"></i></span>
            下單
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="<c:url value='/.....'/>">
            <span class="me-1"><i class="far fa-comment-dots"></i></span>
            討論
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="<c:url value='/.....'/>">
            <span class="me-1"><i class="fas fa-dice-d20"></i></span>
            抽籤
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="<c:url value='/.....'/>">
            <span class="me-1"><i class="fas fa-clipboard-list"></i></span>
            課程
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="<c:url value='/company'/>">
            <span class="me-1"><i class="fas fa-building"></i></span>
            公司資料
          </a>
        </li>
      </ul>
    </div>
  </nav>
