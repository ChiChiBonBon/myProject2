$(function () {

    $('#select').on('click',function () {
        

        $('#answer').text("")
        $('#searchData').show()
        $('#formData').hide()

        $('#submit').off().click(function () {
            let search = $('#search').val();
            console.log(search)

            if(search == ""){
                $('#search').val("必要輸入").css('color', 'red');
                return false;
            }

            if (isNaN(search)) {
                $('#search').val("統一編號格式錯誤").css('color', 'red');
                return false;
            }
        })
    })

    $('#delete').on('click',function () {

        $('#answer').text("")
        $('#searchData').show()
        $('#formData').hide()

        $('#submit').off().click(function () {
            let search = $('#search').val();
            console.log(search)

            if(search == ""){
                $('#search').val("必要輸入").css('color', 'red');
                return false;
            }

            if (isNaN(search)) {
                $('#search').val("統一編號格式錯誤").css('color', 'red');
                return false;
            }
        })
    })

    $('#insert').on('click',function () {
       
        $('#answer').text("")
        $('#formData').show()
        $('#searchData').hide()

        $('#submit').off().click(function () {
            let check = false
            let money = $('#capital_Stock_Amount').val();
            let Account = $('#business_Accounting_NO').val();
            console.log(money + ":"+ Account)

            if(Account == ""){
                $('#business_Accounting_NO').val("必要輸入");
                $('#business_Accounting_NO').css('color', 'red')
                return false
            }

            if (isNaN(money)){
                $('#capital_Stock_Amount').val("資本總額輸入錯誤");
                $('#capital_Stock_Amount').css('color', 'red')
                check = true;
            }
            if (isNaN(Account)){
                $('#business_Accounting_NO').val("統一編號輸入錯誤");
                $('#business_Accounting_NO').css('color', 'red')
                check = true;
            }

            if (check){ 
                return false
            }
        })

    })

    $('#update').on('click',function () {
      
        $('#answer').text("")
        $('#formData').show()
        $('#searchData').hide()

        $('#submit').off().click(function () {
            let check = false
            let money = $('#capital_Stock_Amount').val();
            let Account = $('#business_Accounting_NO').val();
            console.log(money + ":"+ Account)

            if(Account == ""){
                $('#business_Accounting_NO').val("必要輸入");
                $('#business_Accounting_NO').css('color', 'red')
                return false
            }

            if (isNaN(money)){
                $('#capital_Stock_Amount').val("資本總額輸入錯誤");
                $('#capital_Stock_Amount').css('color', 'red')
                check = true;
            }
            if (isNaN(Account)){
                $('#business_Accounting_NO').val("統一編號輸入錯誤");
                $('#business_Accounting_NO').css('color', 'red')
                check = true;
            }

            if (check){    
                return false
            }
        })
    })





})