$(document).ready(function () {
    $('#table_id').DataTable();
});



function setActionCodeInsert() {
    document.getElementById("actionCode1").setAttribute("value", "insert");

    let inputTags = $("#insertOrAlter").find('input');
    let inputTagsSize = inputTags.size();
    let tempArray = new Array(inputTagsSize);
    let myModalTag = document.getElementById("myModal");

    // for (let j = 0; j < inputTagsSize; j++) {
    //     tempArray[j] = inputTags.eq(j).val();
    // }

    // console.log(myModalTag);
    //console.log(typeof tempArray[1]);
    //console.log(inputTags.eq(0));
    inputTags.eq(0).attr('readonly', false);
    inputTags.eq(0).attr('style', "background-color:#FFFFFF;");



    for (let i = 0; i < inputTags.size(); i++) {
        inputTags.eq(i).val("");
    }


    // myModalTag.click(function(e){
    //     console.log(e);
    //     for (let i = 0; i < inputTags.size(); i++) {
    //         inputTags.eq(i).attr("value", tempArray[i]);
    //     }
    // });


    //$(':input').val("");
};

function setActionCodeUpdate(myTag) {
    document.getElementById("actionCode1").setAttribute("value", "update");
    /*let a = myTag.parentNode.parentNode.nextSibling;
    let deleteID = $(myTag).closest('tr').find('td').eq(1).text();
    alert(deleteID);
    console.log(deleteID);
    document.getElementById("deletecourseID").setAttribute("value", deleteID);*/
    //let deleteID = $(myTag).closest('tr').find('td').eq(1).text();
    let tdTags = $(myTag).closest('tr').find('td');
    console.log(tdTags);
    let inputTags = $("#insertOrAlter").find('input');

    inputTags.eq(0).attr('readonly', true);
    inputTags.eq(0).attr('style', "background-color:#F0F0F0;");

    for (let i = 0; i < tdTags.size(); i++) {
        //console.log(tdTags.eq(i).text());
        //console.log(inputTags.eq(0).val());
        console.log(tdTags.eq(i + 1).text());
        //console.log(inputTags);
        //console.log(tdTags.eq(i + 1).innnerHTML);
        //inputTags.eq(i).attr("value", tdTags.eq(i + 1).text());
        inputTags.eq(i).val(tdTags.eq(i + 1).text().trim());
        console.log(inputTags.eq(i).val());
    }
};

function setActionCodeDelete(myTag) {

    document.getElementById("actionCode2").setAttribute("value", "delete");
    let deleteID = $(myTag).closest('tr').find('td').eq(1).text();
    console.log(deleteID);
    $(document.getElementById("deletecourseID").setAttribute("value", deleteID));
    document.getElementById("FormSubmiter").submit();
    //.closest('form').find('input').eq(3);
    //document.getElementById("autoSubmiter").click();
};

document.onkeydown = function (e) {
    keyNum = e.which;
    if (keyNum == 13) {
        document.getElementById("actionCode2").setAttribute("value", "select");
        document.getElementById("autoSubmiter").click();
    }

}

document.getElementsByClassName("update")

function check() {
    reg1 = /^\d+$/; //不能空白且只允許輸入數字
    if (!reg1.test(document.forms[0].courseID.value)) {
        alert(`${$('label').eq(2).text()}欄位 不能空白且只允許輸入數字`);
        document.forms[0].courseID.focus();
        return false;
    }


    let checkUpdate = $('#actionCode1').val().trim();

    if (reg1.test(document.forms[0].courseID.value) && (checkUpdate != 'update')) {
        let inputTags = $('#insertOrAlter').find('input');
        let insertCourseId = inputTags.eq(0).val();
        let courseIdSet = $('.courseIdSet');

        for (let j = 0; j < courseIdSet.size(); j++) {
            if (insertCourseId == courseIdSet.eq(j).text().trim()) {
                alert("課程編號 重覆!!!");
                document.forms[0].courseID.focus();
                return false;
            }
        }
    }

    if (document.forms[0].teacherName.value == "") {
        alert(`${$('label').eq(3).text()}欄位 不能空白`);
        document.forms[0].teacherName.focus();
        return (false);
    }

    if (document.forms[0].courseOutline.value == "") {
        alert(`${$('label').eq(4).text()}欄位 不能空白`);
        document.forms[0].courseOutline.focus();
        return (false);
    }

    // if (document.forms[0].courseDate) {
    //     alert(`${$('label').eq(5).text()}欄位 必須選取日期`);
    //     document.forms[0].courseDate.focus();
    //     return (false);
    // }

    if (document.forms[0].courseTime.value == "") {
        alert(`${$('label').eq(6).text()}欄位 不能空白`);
        document.forms[0].courseTime.focus();
        return (false);
    }

    if (!reg1.test(document.forms[0].fee.value)) {
        alert(`${$('label').eq(7).text()}欄位 不能空白且只允許輸入數字`);
        document.forms[0].fee.focus();
        return false;
    }

    if (!reg1.test(document.forms[0].quota.value)) {
        alert(`${$('label').eq(8).text()}欄位 不能空白且只允許輸入數字`);
        document.forms[0].quota.focus();
        return false;
    }

    if (document.forms[0].classification.value == "") {
        alert(`${$('label').eq(9).text()}欄位 不能空白`);
        document.forms[0].classification.focus();
        return (false);
    }

    if (document.forms[0].teachingMethod.value == "") {
        alert(`${$('label').eq(10).text()}欄位 不能空白`);
        document.forms[0].teachingMethod.focus();
        return (false);
    }

    if (document.forms[0].area.value == "") {
        alert(`${$('label').eq(11).text()}欄位 不能空白`);
        document.forms[0].area.focus();
        return (false);
    }


    return true;
}

