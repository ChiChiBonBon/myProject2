window.onload = function() {
	//預設買進+整券+現股+單位顯示
	document.getElementById("1").onclick();    //買進
	document.getElementById("but1").onclick(); //整券
	document.getElementById("but5").onclick(); //現股
};


//取stock_ID +套option>>value + innerText
function get_stock_ID(input) {
    var stock_ID = document.getElementById(input).value;
	document.getElementById('input_stock_ID').value = stock_ID;
	document.getElementById('input_stock_ID').innerText = "證-" + stock_ID;
}


//AJAX非同步請求+依照 com_ID 套現價+公司短稱
function get_input(input) {
	//取得動態輸入com_ID+改iframe.scr屬性
	var com_ID = document.getElementById(input).value;

	let Kline = document.getElementById("Kline");
	Kline.src = "https://s.yimg.com/nb/tw_stock_frontend/scripts/TaChart/tachart.3de240ea9a.html?sid=" + com_ID;

	let Top5 = document.getElementById("Top5");
	Top5.src = "https://s.yimg.com/nb/tw_stock_frontend/scripts/StxChart/StxChart.9d11dfe155.html?sid=" + com_ID;

	//AJAX非同步請求,送出com_ID,測試路徑位置>> alert(apiurl + "com_ID=" + com_ID)
	var xhr = new XMLHttpRequest();
	xhr.open("Get", apiurl + "com_ID=" + com_ID , true);
	//+"&time="+ new Date().getTime()
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send();

	//請求後,伺服器是否有回應
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200) {
				var type = xhr.getResponseHeader("Content-Type");

				if (type.indexOf("application/json") === 0) {
					var json = JSON.parse(xhr.responseText);
					//抓現價失敗,重新執行請求
					if(json.z =="-"){
						xhr.open("Get", apiurl + "com_ID=" + com_ID , true);
						xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
						xhr.send();	
					}
				}
			}
			else {
				Swal.fire({
						  icon: 'error',
						  title: '查詢失敗',
						  text: '查無此商品代號,重新輸入!',
						  confirmButtonText: '確定', 
			 			  confirmButtonColor:'#FF5151',
						}).then((result) =>{
								if (result.isConfirmed){
									document.getElementById('orderForm').reset();	
									document.getElementById('com_ID').autofocus;
									let Kline = document.getElementById("Kline");
									Kline.src = "https://s.yimg.com/nb/tw_stock_frontend/scripts/TaChart/tachart.3de240ea9a.html?sid=2330";
									let Top5 = document.getElementById("Top5");
									Top5.src = "https://s.yimg.com/nb/tw_stock_frontend/scripts/StxChart/StxChart.9d11dfe155.html?sid=2330";	
								}		
						   })	
						
						
						
				
				//alert("發生錯誤1: " + xhr.status + ", " + xhr.responseText);
			}
		}
	}

	//請求完成,要執行的動作
	xhr.onload = function() {
		var json = JSON.parse(xhr.responseText);

		//套股票名稱
		document.getElementById("com_name").value = json.n;

		//套現價錢+小數兩位 抓到z用z ,若無則用y
		if(json.z == "-"){
			var test = (json.y).toString();
			var check = /([0-9]+\.[0-9]{2})[0-9]*/;
			var price = test.replace(check, "$1");
			document.getElementById("order_price").value = price;
		}else{
			var test = (json.z).toString();
			var check = /([0-9]+\.[0-9]{2})[0-9]*/;
			var price = test.replace(check, "$1");
			document.getElementById("order_price").value = price;
		}
		
	}
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


//整股零股改值
function change_odd(input){
	var check = document.getElementById(input).value
	
	if(check == "0"){
		document.getElementById('oneorodd').value = 1;
		document.getElementById('oneorodd').innerText = 1;
	}else{
		document.getElementById('oneorodd').value = 1000 ;
		document.getElementById('oneorodd').innerText = 1000 ;
	}      	
}


//計算總價錢,放入hidden,並顯示總價
function get_total(input) {
	//input參數值
    var P = document.getElementById('order_price').value;
    var Q = document.getElementById('input_quant').value;
    var N = document.getElementById('oneorodd').innerText;
	//實際送出股數
	document.getElementById('order_quant').value = Q * N;
	//實際送出總價 
    var order_total = document.getElementById('order_total').value= Math.round(P*Q*N);
    document.getElementById('show_total' ).innerText = order_total.toLocaleString();
	document.getElementById('order_total').value = order_total;  
}


//將options對應value,放入hidden
//證期選零
function op1_value(input) {
    document.getElementById('trans_species').value = document.getElementById(input).value;  
}
//買賣
function op2_value(input) {
    document.getElementById('trans_sellorbuy').value = document.getElementById(input).value;  
}
//現沖資券
function op3_value(input) {
    document.getElementById('trans_way').value = document.getElementById(input).value;  
}


//取得時間和日期 + 確認訂單資料 +套sweetalert
 function get_datetime() {
	 //日期
     var now = new Date();
     var now_year = now.getFullYear();
     var now_mon  = now.getMonth()+1;
     var now_day  = now.getDate();

	 //時間
     var now_hr   = now.getHours();
     var now_min  = now.getMinutes();
     var now_sec  = now.getSeconds();

     //指定格式
     if(now_mon<10){now_mon = '0'+now_mon;}
     if(now_day<10){now_day = '0'+now_day;}
     if(now_hr <10){now_hr  = '0'+now_hr ;}
     if(now_min<10){now_min = '0'+now_min;}
     if(now_sec<10){now_sec = '0'+now_sec;}

	//格式輸出 時間+日期
     var now_date  = now_year +"/"+ now_mon +"/"+ now_day ;
     var now_time  = now_hr +":" +now_min +":"+now_sec ;

     document.getElementById('order_date').value = now_date ;
     document.getElementById('order_time').value = now_time ;

	 document.getElementById('orderForm').onsubmit();
}

//等待3秒
function wait_insert(){
	var order = document.getElementById('orderForm');
    order.submit();
}


//確認欄位格式
function check_form(input){
	var check_rule = /^[0-9]*[1-9][0-9]*$/;
	var check_rule2 = /^[0-9]+(.[0-9]{2})?$/;
	
	if(!check_rule.test(document.getElementById('com_ID').value)){
		Swal.fire({
  				   icon:  "warning",
				   title: "請填入正確股票代碼!",
				   text:  "格式:整數(0~9)組成,且不可為空白",
		})
		document.getElementById('com_ID').focus();
		return false ;
	}
	
	if(!check_rule2.test(document.getElementById('order_price').value)){
		Swal.fire({
  				   icon:  "warning",
				   title: "請填入正確價格!",
				   text:  "格式:整數或小數點兩位(xxx.xx)且不可為空白",
		})
		document.getElementById('order_price').focus();
		return false ;
	}
	
	if(!check_rule.test(document.getElementById('input_quant').value)){
		Swal.fire({
  				   icon:  "warning",
				   title: "請填入正確數量!",
				   text:  "格式:整數(0~9)組成,且不可為空白",
		})
		document.getElementById('input_quant').focus();
		return false ;
	}
	
	//確認資料沒問題 + sweeet alert
	swal.fire({ 
			     icon:  'info',
				 title: '下單明細', 
				 html: "<div  style='text-align:left;font-size: 20px'>" + "<hr style='background-color:#272727; height:2px; border:none;'>" + 
			            '證券帳號:' + document.getElementById('input_stock_ID' ).value + '<br/>' + "<hr style='background-color:#272727; height:2px; border:none;'>" +
						'商品代號:' + document.getElementById('com_ID'         ).value + '<br/>' +
						'商品名稱:' + document.getElementById('com_name'       ).value + '<br/>' +
						'下單價格:' + format_with_regex(document.getElementById('order_price').value) + '<br/>' +
						'下單數量:' + format_with_regex(document.getElementById('order_quant').value) + '<br/>' +
						'下單總價:' + format_with_regex(document.getElementById('order_total').value) + '<br/>' + "<hr style='background-color:#272727; height:2px; border:none;'>" +
					//'下單日期:' + document.getElementById('order_date'     ).value + '<br/>' +
					//'下單時間:' + document.getElementById('order_time'     ).value + '<br/>' +
						'交易條件:' + document.getElementById('trans_cond'     ).value + '<br/>' +
						'交易方式:' + document.getElementById('trans_way'      ).value + '<br/>' +
						'交易選項:' + document.getElementById('trans_sellorbuy').value + '<br/>' +  "<hr style='background-color:#272727; height:2px; border:none;'>" +
					//'交易狀態:' + document.getElementById('trans_stats'    ).value + '<br/>' + 
					   '</div>',
	 
				 showCancelButton: true, 
				 cancelButtonText: "取消", 
			     cancelButtonColor:'#ADADAD',
				 confirmButtonText: '確定', 
				 confirmButtonColor:'#FF5151',
			}).then((result) =>{
					if (result.isConfirmed){
						Swal.fire({
								icon: 'success',
								title: '交易完成！',
							    position: 'absolute; top:50%; left:50%',
								showConfirmButton: false,
								timer: 1500})
							
								setTimeout("wait_insert()",2000);	
					}else{
						document.getElementById('orderForm').reset();
						document.getElementById('show_total').innerText = "";
					}		
			   })

}


//確認頁面,取消按鈕-test 還沒改
function cancel_order(input){
	Swal.fire(
                "交易取消", //標題 
                "將重新回到下單頁面", 
                "error" //圖示(可省略) success/info/warning/error/question
                //圖示範例：https://sweetalert2.github.io/#icons
            );
}


//清空下單欄位+恢復預設值
function order_clear(input){
	document.getElementById("1").onclick();    //買進
	document.getElementById("but1").onclick(); //整券
	document.getElementById("but5").onclick(); //現股
}


//sweet alert > ok
function get_ok() {
	Swal.fire({
			  icon: 'success',
			  title: '交易完成！',
	          position: 'absolute; top:50%; left:50%',
			  showConfirmButton: false,
			  timer: 1500})
	
	setTimeout("wait()",2000);	
}


//等待3秒
function wait(){
	var ok = document.getElementById('ok');
    ok.submit();
}


//顯示千分位用
function format_with_regex(number) {
    var reg = /(\d)(?=(?:\d{3})+$)/g   
    return (number + '').replace(reg, '$1,');
}



	





 



