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
	<link rel="stylesheet" href="<c:url value='/css/dashboard.css' />" >
	


</head>
<body>
<!-- 接收所有訂單資料 -->  
     <%
     	String order_list = (String) session.getAttribute("order_list"); 
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
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
                <h4 class="modal-title" id="myModalLabel">修改xxx訂單編號:</h4>
            </div>
            <div class="modal-body">
            	<form action="OrderDAO_Impl" method="POST" >
          			<div class="mb-3">
            			<label for="recipient-name" class="col-form-label">價格:</label>
            			<input type="text" class="form-control" id="change_price" name="change_price">
          			</div>
          			<div class="mb-3">
            			<label for="message-text" class="col-form-label">數量:</label>
            			<input type="text"   class="form-control" id="change_quant" name="change_quant">
            			<input type="hidden" class="form-control" id="change_total" name="change_total">
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

      
     
     
     
<!-- 傳送要修改訂單編號 -->
      
     <form action="delete_order.jsp"  method="post" id ="passForm"> 
     	<input id = 'delorder_ID' type = 'hidden' name="delorder_ID"> 
     </form> 
     
     
     
     
    
<!-- 訂單資料送去JS -->
<script type="text/javascript"> 
    var order_list = ${order_list}  ; 
</script> 
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.24/js/jquery.dataTables.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<script src="<c:url value='/js/select_order.js' />" async defer></script>




</body>
</html>