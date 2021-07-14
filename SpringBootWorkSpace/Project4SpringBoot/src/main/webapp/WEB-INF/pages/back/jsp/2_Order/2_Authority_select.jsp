<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Select All</title>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.24/css/jquery.dataTables.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" href="<c:url value='/back/css/dashboard.css' />" >
	

</head>
<body>
<!-- 接收所有訂單資料 -->  
     <%
     	String acc_list = (String) session.getAttribute("acc_lists"); 
     %>
     
<!-- DataTable -->  
     <table id="example" class="display" width="100%">
     <thead></thead>
     <tbody></tbody>
     </table>
     
<!-- modal --> 

<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-bs-backdrop="static" data-bs-keyboard="false">
    <div class="modal-dialog">
        <div class="modal-content">
            <div style="text-align:center;">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
                <h4 class="modal-title" id="myModalLabel">修改xxx用戶權限:</h4>
            </div>
            <div class="modal-body">
            	<form action="<c:url value = '/admin/controller/update'/>" method="Get" >
          			<div class="mb-3">
            			<label for="recipient-name" class="col-form-label">用戶權限:</label>
            			<label>
            			    <input type="radio" name="change_auth" id="change_auth" value="停權戶">停權戶 	
                			<input type="radio" name="change_auth" id="change_auth" value="一般戶">一般戶
                			<input type="radio" name="change_auth" id="change_auth" value="信用戶">信用戶
            			</label>
            				
          			</div>
          			<div class="mb-3">
            			<label for="message-text" class="col-form-label">交易額度:</label>
            			<input type="text"   class="form-control" id="change_quota" name="change_quota">
            			<input type="hidden" class="form-control" id="change_ID"    name="change_ID" >
            	
         			</div>
         			 
         			<div class="modal-footer">
                		<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                		<button type="submit" class="btn btn-primary" >確認修改</button>
            		</div>
         			  
       			</form>
            
            </div>
            
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>    

<!-- 傳送要修改的證券帳號 -->

     <form action="<c:url value = '/admin/controller/delete'/>"  method="post" id ="passForm"> 
     	<input id = 'delacc_ID' type = 'hidden' name="delacc_ID"> 
     </form> 
        
<!-- 會員資料送去JS -->
<script type="text/javascript"> 
    var acc_list = <%=acc_list%>  ; 
</script>
 
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.24/js/jquery.dataTables.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<script src="<c:url value='/back/js/Authority_select.js' />" async defer></script>




</body>
</html>