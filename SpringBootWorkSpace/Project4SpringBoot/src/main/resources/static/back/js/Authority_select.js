var dataSet = acc_list ;

$(document).ready(function() {
    $('#example').DataTable( {
        data: dataSet,
        "columnDefs": [
                    {
                        // targets用於指定操作的列，從第0列開始，-1為最後一列
                        "targets": -1,
                        "render": function ( data, type, full, meta ) {
                            return "<input type = 'button' id='upd_order' value='額度調整' data-toggle='modal' data-target='#myModal'>"
                        }
                    }
        ],
        columns: [
            { title: "證券帳號" },
            { title: "用戶姓名" },
            { title: "用戶權限" },
            { title: "交易額度" },
			{ title: "權限操作" },
        ]
           
    } );
     
} );


//修改用戶權限
$("#example tbody").on("click", "#upd_order", function () {
                var row      = $("table#example tr").index($(this).closest("tr"));
                var order_ID = $("table#example").find("tr").eq(row).find("td").eq(0).text();
                document.getElementById('myModalLabel').innerText = "修改對象為:" + order_ID ;
                document.getElementById('change_ID').value = order_ID ;
            });
