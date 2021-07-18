//input Data
var dataSet = profit_lists ;

$(document).ready(function() {
    $('#example').DataTable( {
        data: dataSet,
        "columnDefs": [
                    {
                        
                    }
        ],
        columns: [
            { title: "商品代號" },
            { title: "商品名稱" },
            { title: "成交價" },
            { title: "現價" },
			{ title: "損益" },
            { title: "報酬率" },
			{ title: "股數" },
            { title: "總成本" },
            { title: "現值" },         
        ]
           
    });
   

});





            