var dataSet = order_list ;

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
            { title: "下單編號" },
            { title: "交易帳號" },
            { title: "公司代號" },
            { title: "價格" },
            { title: "數量(股)" },
            { title: "總價" },
            { title: "下單日期" },
            { title: "下單時間" },
            { title: "交易條件" },
			{ title: "交易選項" },
            { title: "交易方式" },
            { title: "交易狀態" },
            { title: "交易回報" },         
            { title: "交易處理" },
        ]
           
    } );
    
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

 	

    
} );

//刪單按鈕
$("#example tbody").on("click", "#del_order", function () {
        //獲取行
        var row = $("table#example tr").index($(this).closest("tr"));
        //取得某列的值,eq(0)開始
        var delorder_ID = $("table#example").find("tr").eq(row).find("td").eq(0).text();
        alert("欲刪除訂單編號為:"+delorder_ID  );
        document.getElementById('delorder_ID').value = delorder_ID ;
        document.getElementById('passForm').submit();
        
    });
    

//改單按鈕
$("#example tbody").on("click", "#upd_order", function () {
                var row      = $("table#example tr").index($(this).closest("tr"));
                var order_ID = $("table#example").find("tr").eq(row).find("td").eq(0).text();
                document.getElementById('myModalLabel').innerText = "欲修改訂單編號為:" + order_ID ;
                document.getElementById('change_ID').value = order_ID ;
          
    
            });
            

 

 
 
 
 
       
            
          


