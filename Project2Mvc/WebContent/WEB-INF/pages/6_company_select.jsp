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
        <link href="./css/bootstrap.min.css" rel="stylesheet">
        <!-- Custom styles for this template -->
        <link href="./css/dashboard.css" rel="stylesheet">
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
                <nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
                    <div class="position-sticky pt-3">
                        <ul class="nav flex-column">
                            <li class="nav-item">
                                <a class="nav-link" aria-current="page" href="./0_dashboard.html">
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
                                <a class="nav-link" href="./CourseManagement5.html">
                                    <span class="me-1"><i class="fas fa-clipboard-list"></i></span>
                                    課程
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link active" href="./company">
                                    <span class="me-1"><i class="fas fa-building"></i></span>
                                    公司資料
                                </a>
                            </li>
                        </ul>
                    </div>
                </nav>

                <!-- 選項內容 -->
                <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
                    <div class="container">           
                        <div class="item_CRUD mt-5 row">
                            <div class="col-2 d-grid">
                                <button type="button" class="btn btn-outline-primary" id="select">查詢資料
                                </button>
                            </div>
                            <div class="col-8">
                                <input type="text" class="form-control" id="search" placeholder="統一編號" onfocus="this.placeholder=''" onblur="this.placeholder='統一編號'" value="${cAcc}">
                            </div>
                            <div class="col-2 d-grid">
                                
                                <a href="./companyInsertController"><button type="button" class="btn btn-outline-primary" id="insert">新增資料</button></a>
                                
                            </div>
                        </div>
                        <!-- 分隔線 -->
                        <div class="mt-5">
                            <p>查詢結果:</p>
                            <p id="answer"></p>
                        </div>
                        <hr>
                        <!-- 資料內容 -->
                        <div class="content mt-5 row">
                            
                            <div class="col-12"  id="dataArea"></div>
                            
                        </div>
                    </div>
                </main>



            </div>
        </div>


        <script src="./js/bootstrap.bundle.min.js"></script>
        <script src="./js/jquery-3.6.0.js"></script>
        <!-- <script src="./js/company_6.js"></script> -->
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
                            $('#dataArea').html('<h2>無該筆資料</h2>') 
                            $('#dataArea').css({'color': 'red'}) 
                        }
                    }
                    }else{
                       $('#dataArea').html('<h2>請重新輸入統一編號</h2>') 
                       $('#dataArea').css({'color': 'red'}) 
                    }
                  
                    

                })

                $("#dataArea").on('click', "#delete", function(){
                    var x = $(this).parent().parent().index()
                    var y = $('.Accounting_NO:eq('+ x +')').text()
                    console.log(y)
                    var confirmAnswer = confirm("Are you sure want to delete 統一編號: "+ y +"?");
                    
                    if(confirmAnswer){
                        var xhr =  new XMLHttpRequest();
                        var url = './companyController/' + y
                        

                    }
                })

                $("#dataArea").on('click', "#update", function(){
                    var x = $(this).parent().parent().index()
                    var y = $('.Accounting_NO:eq('+ x +')').text()
                    console.log(y)
                    var confirmAnswer = confirm("Are you sure want to update 統一編號: "+ y +"?");
                    window.location.href = "./companyUpdateController/" + y
                    

                })

                function selectDataAll(text){
                    var json = JSON.parse(text);
                    var jsonData = '<table class="table table-striped" >';
                        jsonData += '<thead> <tr>'
                        jsonData += '<th scope="col">統一編號</th>'   
                        jsonData += '<th scope="col">公司名稱</th>'   
                        jsonData += '<th scope="col">資本總額</th>'   
                        jsonData += '<th scope="col">代表人姓名</th>'   
                        jsonData += '<th scope="col">公司所在地</th>'   
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
                    var jsonData = '<table class="table table-striped">';
                        jsonData += '<thead> <tr>'
                        jsonData += '<th scope="col">統一編號</th>'   
                        jsonData += '<th scope="col">公司名稱</th>'   
                        jsonData += '<th scope="col">資本總額</th>'   
                        jsonData += '<th scope="col">代表人姓名</th>'   
                        jsonData += '<th scope="col">公司所在地</th>'   
                        jsonData += '<th scope="col">Udpate</th>'   
                        jsonData += '<th scope="col">Delete</th>'   
                        jsonData +=  "</tr></thead>"                   
                        
                        
                        jsonData += "<tr>"
                        jsonData += '<th scope="row">' + company.business_Accounting_NO + '</th>'
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