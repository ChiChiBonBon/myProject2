//input Data
var dataSet = history_lists ;

$(document).ready(function() {
    $('#example').DataTable( {
        data: dataSet,
        "columnDefs": [
                    {
                        
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
            { title: "交易回報" },         
        ]
           
    });
   

});





            