<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
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
            <button class="navbar-toggler position-absolute d-md-none collapsed" type="button" data-bs-toggle="collapse"
                data-bs-target="#sidebarMenu" aria-controls="sidebarMenu" aria-expanded="false"
                aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <input class="form-control form-control-dark w-100" type="text" placeholder="Search" aria-label="Search">
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
                    <div class="container">           
                        <div class="item_CRUD mt-5 row">
                            <div class="col-2 d-grid">
                                <button type="button" class="btn btn-outline-primary" id="select">????????????
                                </button>
                            </div>
                            <div class="col-8">
                                <input type="text" class="form-control" id="search" placeholder="????????????" onfocus="this.placeholder=''" onblur="this.placeholder='????????????'" value="${cAcc}">
                            </div>
                            <div class="col-2 d-grid">
                                
                                <a href="./companyInsertController"><button type="button" class="btn btn-outline-primary" id="insert">????????????</button></a>
                                
                            </div>
                        </div>
                        <!-- ????????? -->
                        <div class="mt-5">
                            <p>????????????:</p>
                            <p id="answer"></p>
                        </div>
                        <hr>
                        <!-- ???????????? -->
                        <div class="content mt-5 row">
                            
                            <div class="col-12"  id="dataArea"></div>
                            
                        </div>
                    </div>
                </main>



            </div>
        </div>


	    <script src="<c:url value='/js/bootstrap.bundle.min.js' />"></script>
	    <script src="<c:url value='/js/jquery-3.6.0.js' />"></script>
<%--     <script src="<c:url value='/js/company_6.js' />"></script> --%>
        <script>
            $(function () {

                $("#select").on('click', function(){
                    var aa = $('#search').val();
                    var xhr =  new XMLHttpRequest();
                    var url = './companyController/'
                    $("#search").val("");          
                    if(aa == ""){
                        console.log(url)
                        xhr.open("GET", url);
                        xhr.send();
                        xhr.onreadystatechange = function(){
                        if( xhr.readyState == 4 && xhr.status == 200 ){
                            $('#dataArea').html(selectDataAll(xhr.responseText)) 
                        }

                    }
                    }else if( !isNaN(aa)){
                        url = url + aa;
                        console.log(url)
                        xhr.open("GET", url);
                        xhr.send();
                        xhr.onreadystatechange = function(){
                        if( xhr.readyState == 4 && xhr.status == 200 ){
                            $('#dataArea').html(selectData(xhr.responseText)) 
                        }
                        if(xhr.responseText == ""){
                            $('#dataArea').html('<h2>???????????????</h2>') 
                            $('#dataArea').css({'color': 'red'}) 
                        }
                    }
                    }else{
                       $('#dataArea').html('<h2>???????????????????????????</h2>') 
                       $('#dataArea').css({'color': 'red'}) 
                    }
                  
                    

                })

                $("#dataArea").on('click', "#delete", function(){
                    var x = $(this).parent().parent().index()
                    var y = $('.Accounting_NO:eq('+ x +')').text()
                    console.log(y)
                    var confirmAnswer = confirm("Are you sure want to delete ????????????: "+ y +"?");
                    
                    if(confirmAnswer){
                        var xhr =  new XMLHttpRequest();
                        var url = "<c:url value='/companyController/'/>" + y
                        xhr.open("DELETE", url);
                        xhr.send();
                        xhr.onreadystatechange = function(){
                            if( xhr.readyState == 4 && xhr.status == 200 ){
                                $('#dataArea').html(selectDataAll(xhr.responseText)) 
                            }
                        }
                    }
                })

                $("#dataArea").on('click', "#update", function(){
                    var x = $(this).parent().parent().index()
                    var y = $('.Accounting_NO:eq('+ x +')').text()
                    console.log(x)
                    console.log(y)
                    var confirmAnswer = confirm("Are you sure want to update ????????????: "+ y +"?");
                    
                    if(confirmAnswer){
                        window.location.href = "<c:url value='/companyUpdateController/'/>" + y
                    }
                    
                    

                })

                function selectDataAll(text){
                    var json = JSON.parse(text);
                    var jsonData = '<table class="table table-striped" >';
                        jsonData += '<thead> <tr>'
                        jsonData += '<th scope="col">????????????</th>'   
                        jsonData += '<th scope="col">????????????</th>'   
                        jsonData += '<th scope="col">????????????</th>'   
                        jsonData += '<th scope="col">???????????????</th>'   
                        jsonData += '<th scope="col">???????????????</th>'   
                        jsonData += '<th scope="col">Udpate</th>'   
                        jsonData += '<th scope="col">Delete</th>'   
                        jsonData +=  "</tr></thead>"                   
                        
                        jsonData += "<tbody>"
                        for(var x in json){
                            var company = json[x]
                            jsonData += "<tr>"
                            jsonData += '<th scope="row" class="Accounting_NO">' + company.business_Accounting_NO + '</th>'
                            jsonData += '<th scope="row">' + company.company_Name + '</th>'
                            jsonData += '<th scope="row">' + company.capital_Stock_Amount + '</th>'
                            jsonData += '<th scope="row">' + company.responsible_Name + '</th>'
                            jsonData += '<th scope="row">' + company.company_Location + '</th>'
                            jsonData += '<th ><button style="border: none;" id="update"><i  class="fas fa-edit" style="font-size: 1.5em;"></i></button></th>'
                            jsonData += '<th ><button style="border: none;" id="delete"><i  class="fas fa-trash-alt" style="font-size: 1.5em;"></i></button></th>'   
                            jsonData += "</th>"
                        }
                        jsonData += "</tbody>"
                        jsonData += "</table>"
                    return jsonData;
                }

                function selectData(text){
                    var company = JSON.parse(text);
                    var jsonData = '<table class="table table-striped" >';
                        jsonData += '<thead> <tr>'
                        jsonData += '<th scope="col">????????????</th>'   
                        jsonData += '<th scope="col">????????????</th>'   
                        jsonData += '<th scope="col">????????????</th>'   
                        jsonData += '<th scope="col">???????????????</th>'   
                        jsonData += '<th scope="col">???????????????</th>'   
                        jsonData += '<th scope="col">Udpate</th>'   
                        jsonData += '<th scope="col">Delete</th>'   
                        jsonData +=  "</tr></thead>"                   
                        
                        
                        jsonData += "<tr>"
                        jsonData += '<th scope="row" class="Accounting_NO">' + company.business_Accounting_NO + '</th>'
                        jsonData += '<th scope="row">' + company.company_Name + '</th>'
                        jsonData += '<th scope="row">' + company.capital_Stock_Amount + '</th>'
                        jsonData += '<th scope="row">' + company.responsible_Name + '</th>'
                        jsonData += '<th scope="row">' + company.company_Location + '</th>'
                        jsonData += '<td><button style="border: none;" id="update"><i class="fas fa-edit" style="font-size: 1.5em;"></i></button></td>'
                        jsonData += '<td><button style="border: none;" id="delete"><i class="fas fa-trash-alt" style="font-size: 1.5em;"></i></button></td>'   
                        jsonData += "</tr>"
                        
                        jsonData += "</tbody>"
                        jsonData += "</table>"
                    return jsonData;
                } 

            })
        </script>



    </body>

    </html>