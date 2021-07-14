//取動態輸入客戶證券號+option的value跟innerText

function get_stock_ID(input) {
    var stock_ID = document.getElementById(input).value;
	document.getElementById('input_stock_ID').value = stock_ID;
	document.getElementById('input_stock_ID').innerText = "證-" + stock_ID;
}


//將options給予對應值,放入hidden
function op1_value(input) {
    document.getElementById('trans_species').value = document.getElementById(input).value;  
}

function op2_value(input) {
    document.getElementById('trans_sellorbuy').value = document.getElementById(input).value;  
}

function op3_value(input) {
    document.getElementById('trans_way').value = document.getElementById(input).value;  
}


//確認頁面,取消按鈕
function cancel_order(input){
      alert("該筆交易已取消,重回下單頁面")
}


//確認欄位格式
function check_form(input){
	var check_rule = /^[0-9]*[1-9][0-9]*$/;
	var check_rule2 = /^[0-9]+(.[0-9]{2})?$/;
	
	if(!check_rule.test(document.getElementById('com_ID').value)){
		alert("請填入正確'股票代碼',格式:數字(0~9)且不可為空白");
		document.getElementById('com_ID').focus();
		return false ;
	}
	
	if(!check_rule2.test(document.getElementById('order_price').value)){
		alert("請填入正確'價格',格式:整數或小數點兩位(xx.xx)且不可為空白");
		document.getElementById('order_price').focus();
		return false ;
	}
	
	if(!check_rule.test(document.getElementById('order_quant').value)){
		alert("請填入正確'數量',格式:數字(0~9)且不可為空白");
		document.getElementById('order_quant').focus();
		return false ;
	}
	
}





 



