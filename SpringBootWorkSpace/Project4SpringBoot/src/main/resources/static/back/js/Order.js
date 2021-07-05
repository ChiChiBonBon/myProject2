//取動態輸入值+改iframe.scr屬性
function get_input(input) {
    var com_ID = document.getElementById(input).value;
  
    let Kline = document.getElementById("Kline");
    Kline.src ="https://s.yimg.com/nb/tw_stock_frontend/scripts/TaChart/tachart.3de240ea9a.html?sid=" + com_ID ;

    let Top5  = document.getElementById("Top5");
    Top5.src  = "https://s.yimg.com/nb/tw_stock_frontend/scripts/StxChart/StxChart.9d11dfe155.html?sid=" +com_ID ;
}

//取客戶證券號+option的value跟innerText

function get_stock_ID(input) {
    var stock_ID = document.getElementById(input).value;
	document.getElementById('input_stock_ID').value = stock_ID;
	document.getElementById('input_stock_ID').innerText = "證-" + stock_ID;
}


//選取外框樣式
function change_border_color(input){
    var but_ID    = document.getElementById(input).id;    //return值for表單,會用到,先留著
    var but_value = document.getElementById(input).value; //return值for表單,會用到,先留著
    var but_name  = document.getElementById(input).name;  //取得option區塊

    for (let i = 0; i <document.getElementsByName(but_name).length; i++) {
         document.getElementsByName(but_name)[i].removeAttribute('class');
         document.getElementsByName(but_name)[i].setAttribute('class','st_change ');  
     
    }
         document.getElementById(input).setAttribute('class','st_onclick_color');
}


//買賣背景樣式,不要問我也不知道怎麼寫出來的
function change_back_color(input) {
    var but_ID    = document.getElementById(input).id;
    var but_name  = document.getElementById(input).name;
    var but_value = document.getElementById(input).id;
    
    for (let i = 0; i <document.getElementsByName(but_name).length; i++) {
        document.getElementsByName(but_name)[i].removeAttribute('class');
        if(but_value==0){
            document.getElementsByName(but_name)[i].setAttribute('class','st_sell st_change');
        }else{
            document.getElementsByName(but_name)[i].setAttribute('class','st_buy st_change');
        }
    }
        
       if (but_value==1) {
           document.getElementById(but_ID).setAttribute('class','st_buy st_change st_ckeck_buy');
       } else {
           document.getElementById(but_ID).setAttribute('class','st_sell st_change st_ckeck_sell');
       }
       
} 


//計算總價錢,放入hidden,並顯示總價
function get_total(input) {
    var P = document.getElementById('order_price').value;
    var Q = document.getElementById('order_quant').value;
    var N = document.getElementById('oneorodd').innerText;
    var order_total = document.getElementById('order_total').value= P*Q*N;
    document.getElementById('show_total' ).innerText = order_total.toLocaleString();
	document.getElementById('order_total').value = order_total;   
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

//取得時間和日期
 function get_datetime() {
     var now = new Date();
     var now_year = now.getFullYear();
     var now_mon  = now.getMonth()+1;
     var now_day  = now.getDate();

     var now_hr   = now.getHours();
     var now_min  = now.getMinutes();
     var now_sec  = now.getSeconds();
     
     if(now_mon<10){
          now_mon = '0'+now_mon;
     }

     if(now_day<10){
          now_day = '0'+now_day;
     }
     
     if(now_hr<10){
          now_hr = '0'+now_hr;
     }

     if(now_min<10){
          now_min= '0'+now_min;
     }
     
     if(now_sec<10){
          now_sec= '0'+now_sec;
     }
     
     

     var now_date  = now_year +"/"+ now_mon +"/"+ now_day ;
     var now_time  = now_hr +":" +now_min +":"+now_sec ;

     document.getElementById('order_date').value = now_date ;
     document.getElementById('order_time').value = now_time ;

 }
 
//整股零股改值
function change_odd(input){
	var check = document.getElementById(input).value
	
	if(check == 1){
		document.getElementById('oneorodd').innerText = 1000 ;
	}else{
		document.getElementById('oneorodd').innerText = 1;
	} 

        	
}
 

//確認頁面,取消按鈕
function cancel_order(input){
	Swal.fire(
                "交易取消", //標題 
                "將重新回到下單頁面", 
                "error" //圖示(可省略) success/info/warning/error/question
                //圖示範例：https://sweetalert2.github.io/#icons
            );
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





 



