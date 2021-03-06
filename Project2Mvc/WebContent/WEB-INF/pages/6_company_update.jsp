<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Company</title>

    <!-- <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/dashboard/"> -->
    <!-- Bootstrap core CSS -->
    <link rel='stylesheet' href="<c:url value='/css/bootstrap.min.css' />" type="text/css" /> 
    <!-- Custom styles for this template -->
    <link rel='stylesheet' href="<c:url value='/css/dashboard.css' />" type="text/css" />
    <!-- fontawesome -->
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" />

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

        @media (min-width : 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }
    </style>


</head>

<body>

    <header class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
        <a class="navbar-brand col-md-3 col-lg-2 me-0 px-3" href="#">Company
            name</a>
        <button class="navbar-toggler position-absolute d-md-none collapsed" type="button"
            data-bs-toggle="collapse" data-bs-target="#sidebarMenu" aria-controls="sidebarMenu"
            aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <input class="form-control form-control-dark w-100" type="text" placeholder="Search"
            aria-label="Search">
        <ul class="navbar-nav px-3">
            <li class="nav-item text-nowrap"><a class="nav-link" href="#">Sign
                    out</a></li>
        </ul>
    </header>
    <div></div>
    <div class="container-fluid">
        <div class="row">
            <!-- ?????? -->
			<%@include file="/WEB-INF/pages/0_table.jsp" %>

            <!-- ???????????? -->
            <main class="col-md-9 ms-sm-auto col-lg-11 px-md-4">
                <div class="container mt-5">
                    <!-- Table one -->
                    <!-- ?????? -->
                    <c:url var="addUrl" value="/companyUpdate"/>
                    <form:form action="${addUrl}" method="POST" modelAttribute="bean">
                        <div id="formData">
                            <div class="row row-cols-1 row-cols-lg-2">
                                <div class="col mb-3">
                                    <label for="" class="form-label">????????????</label>
                                    <form:input type="text" class="form-control" id="business_Accounting_NO"
                                        placeholder="" path="business_Accounting_NO" value=""
                                        property="business_Accounting_NO"></form:input>
                                </div>
                                <div class="col mb-3">
                                    <label for="" class="form-label">????????????</label>
                                    <form:input type="text" class="form-control" id="company_Name" placeholder=""
                                        path="company_Name" value="" property="company_Name"></form:input>
                                </div>
                                <div class="col mb-3">
                                    <label for="" class="form-label">????????????(???????????????)</label>
                                    <form:input type="text" class="form-control" id="capital_Stock_Amount"
                                        placeholder="" path="capital_Stock_Amount" value=""
                                        property="s_capital_Stock_Amount"></form:input>
                                </div>
                                <div class="col mb-3">
                                    <label for="" class="form-label">???????????????</label>
                                    <form:input type="text" class="form-control" id="responsible_Name" placeholder=""
                                        path="responsible_Name" value="" property="responsible_Name"></form:input>
                                </div>
                            </div>
                            <div class="row row-cols-1 row-cols-lg-1">
                                <div class="col mb-3">
                                    <label for="" class="form-label">???????????????</label>
                                    <form:input type="text" class="form-control" id="company_Location" placeholder=""
                                        path="company_Location" value="" property="company_Location"></form:input>
                                </div>
                            </div>
                        </div>

                        <!-- ?????? -->
                        <div class="item_CRUD mt-5 row">
                            <div class="col-4"></div>
                            <div class="col-2 d-grid">
                                <form:button value="Send" class="btn btn-outline-primary" id="select">????????????
                                </form:button>
                            </div>
                            <div class="col-2 d-grid">
                                
                                <a href="<c:url value='/company' />"><button type="button" class="btn btn-outline-secondary" id="insert">????????????</button></a>
                                
                            </div>
                        </div>
                    </form:form>
                </div>
            </main>
        </div>
    </div>

    
    
    
    <script src="<c:url value='/js/bootstrap.bundle.min.js' />"></script>
    <script src="<c:url value='/js/jquery-3.6.0.js' />"></script>
    <script src="<c:url value='/js/company_6.js' />"></script>
    <script>
        $(function () {

            

        })
    </script>



</body>

</html>