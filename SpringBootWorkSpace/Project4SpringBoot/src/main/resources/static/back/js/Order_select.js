//input Data
var dataSet = order_lists ;

$(document).ready(function() {
    $('#example').DataTable( {
        data: dataSet,
        "columnDefs": [
                    {
                        // targets用於指定操作的列，從第0列開始，-1為最後一列
                        "targets": -1,
                        "render": function ( data, type, full, meta ) {
                            return "<input type = 'button' id='del_order' value= '刪單'><input type = 'button' id='upd_order' value='改單' data-toggle='modal' data-target='#myModal'>"
                        }
                    }
        ],
        columns: [
            { title: "單號" },
            { title: "交易帳號" },
            { title: "股票代號" },
            { title: "價格" },
            { title: "股數" },
            { title: "總價" },
            { title: "下單日期" },
            { title: "下單時間" },
            { title: "條件" },
			{ title: "股種" },
            { title: "買賣" },
            { title: "狀態" },
            { title: "回報" },         
            { title: "交易處理" },
        ]
           
    });
   
    var change_price = null ;
	var change_quant = null ;
    
	//偵測改單價量,算總價 尚未判斷整張跟0股
	$('#change_price').on('input', function () {
 		change_price = $("#change_price").val();
 	});
 
	$('#change_quant').on('input', function () {
 		change_quant = $("#change_quant").val();
 		document.getElementById('change_total').value = change_price * change_quant *1000;
 	});

});


//刪單按鈕
$("#example tbody").on("click", "#del_order", function () {
        //獲取行
        var row = $("table#example tr").index($(this).closest("tr"));
        //取得某列的值,eq(0)開始
        var delorder_ID = $("table#example").find("tr").eq(row).find("td").eq(0).text();
		//套sweet
		swal.fire({ 
			 title: '確定刪除此筆交易嗎?', 
			 text:  '訂單編號:'+delorder_ID, 
			 icon:  'warning',
			 showCancelButton: true, 
			 cancelButtonText: "取消", 
		     cancelButtonColor:'#ADADAD',
			 confirmButtonText: '確定', 
			 confirmButtonColor:'#FF5151',
		}).then((result) =>{
				if (result.isConfirmed){
					document.getElementById('delorder_ID').value = delorder_ID ;
					Swal.fire({
							icon: 'success',
							title: '刪除完成！',
						    position: 'absolute; top:50%; left:50%',
							showConfirmButton: false,
							timer: 1500})
						
							setTimeout("wait_del()",2000);	
				}else{
					document.getElementById('passForm').reset();	
				}		
		   })
});


//等待3秒
function wait_del(){
	var ok = document.getElementById('passForm');
    ok.submit();
}


//改單按鈕
$("#example tbody").on("click", "#upd_order", function () {
                var row       = $("table#example tr").index($(this).closest("tr"));
				var get_price = $("table#example").find("tr").eq(row).find("td").eq(3).text();
				var get_quant = $("table#example").find("tr").eq(row).find("td").eq(4).text();

				//取order_ID + 顯示原訂單編號 +自動帶入隱藏欄位
				var order_ID  = $("table#example").find("tr").eq(row).find("td").eq(0).text();
                document.getElementById('myModalLabel').innerText = "修改訂單編號為:" + order_ID ;
                document.getElementById('change_ID').value = order_ID ;

				//欄位自動帶入價錢 + 去$ 
				var price_str =  get_price.toString(); //有$的字串
			    var price = price_str.substr(1);	   //去$
				document.getElementById('show_p').innerText = "修改前價格：" + price ;
				document.getElementById('change_price').value = price.replace(/[,]+/g, "");
				
				//欄位自動帶入數量
				var quant = get_quant ;
				document.getElementById('show_q').innerText = "修改前股數：" + quant ;
				document.getElementById('change_quant').value = quant;
});


//change_quant自動加千分位
$("#change_quant").on("keyup",function(){
			this.value =this.value.replace(/,/g, '').replace(/\d+?(?=(?:\d{3})+$)/g, function(s){
                return s +',';
            });
		$("#change_quant").val(this.value);	
});


//change_price自動加千分位
$("#change_price").on("keyup",function(){	
		this.value =this.value.replace(/,/g, '').replace(/\d+?(?=(?:\d{3})+$)/g, function(s){
                return s +',';
            });

		$("#change_price").val(this.value);	
});


//改單確認+套sweet alert
function update_ok() {
	//input change_price
	var get_price = document.getElementById('change_price').value.toString() ;
	var price = get_price.replace(/[,]+/g, "")
	document.getElementById('change_price').value = price;
	
	//input change_quant
	var get_quant = document.getElementById('change_quant').value.toString() ;
	var quant = get_quant.replace(/[,]+/g, "");
	document.getElementById('change_quant').value = quant;

	//input change_total 
	document.getElementById('change_total').value = price * quant ;

	//input change_ID 進入改單頁面已經載入
	
	
	Swal.fire({
			  icon: 'success',
			  title: '修改完成！',
	          position: 'absolute; top:50%; left:50%',
			  showConfirmButton: false,
			  timer: 1500})
	
	setTimeout("wait_up()",2000);	
}


//等待3秒
function wait_up(){
	var ok = document.getElementById('updateForm');
    ok.submit();
}



            