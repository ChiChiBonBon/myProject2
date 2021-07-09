/* micro plugin for extending jquery */
$.fn.ignore = function (sel) {
    return this.clone().find(sel || ">*").remove().end();
};

// 提示訊息框
function ShowSimpleAlert(alertMessage, size, callbackFunc) {

    var dialogSize = (size === null || size === undefined) ? "medium" : size;

    if (callbackFunc === null || callbackFunc === undefined) {
        callbackFunc = function () { };
    }

    bootbox.dialog({
        size: dialogSize,
        title: "",
        message: alertMessage,
        className: "SimpleAlertBox",
        closeButton: false,
        buttons: {
            OK: {
                label: "確定",
                className: "btn-primary",
                callback: callbackFunc
            }
        }
    });
}

// 確認訊息框
function ShowConfirm(confirmTitle, confirmContent, actionYes, actionNo) {
    bootbox.dialog({
        title: confirmTitle,
        message: confirmContent,
        closeButton: false,
        buttons: {
            YES: {
                label: "是",
                className: "btn-primary",
                callback: actionYes
            },
            NO: {
                label: "否",
                className: "btn-primary",
                callback: actionNo
            }
        }
    });
}

function AjaxInvoke(targetUrl, params, successAction) {
    $.ajax({
        url: targetUrl,
        type: "POST",
        data: $.toJSON(params),
        dataType: "json",
        contentType: 'application/json; charset=utf-8',
        success: function (resultData) {
            // successAction 指向於各呼叫頁面中自行定義的函式
            successAction(resultData);
        },
        error: AjaxInvokeError
    })
}

function AjaxInvokeError(xhr, status, errorThrown) {
    if (xhr.status === 400) {
        ShowSimpleAlert("查詢所需參數值無效！");
    } else if (xhr.status === 403) {
        ShowSimpleAlert("很抱歉，連線已經失效，請重新執行！");
    } else {
        var alertMsg = "<p style='text-align:center;'>伺服器目前過於忙碌，請稍後再試，謝謝！<br/>" +
                       //"status=" + status + " \n" +
                       //"error=" + errorThrown + "\n" +
                       //"xhr.responseText=" + xhr.responseText;
                       "<span style='color:#CCCCCC;'>" + xhr.responseText + "</span></p>";

        ShowSimpleAlert(alertMsg);
    }
}

function FetchAccountFromList(accountValue, accountsList) {
    var i, account = null;

    for (i = 0; i < accountsList.length; i++) {
        if (accountsList[i].AccountValue == accountValue || accountsList[i].CSeq == accountValue) {
            account = accountsList[i];
        }
    }

    return account;
}

function FixComboStyle() {
    if (isAndroidStockBrowser() ||
	    (userAgentInfo.IsIE && parseInt(userAgentInfo.BrowserVersion) <= 8 && !userAgentInfo.IsCompatibilityView)) {
        $('select.form-control').removeClass('form-control').css('width', 'auto').css('line-height', '1em');
    }
}

function isAndroidStockBrowser() {
    var nua = navigator.userAgent;
    var is_android = ((nua.indexOf('Mozilla/5.0') > -1 &&
                       nua.indexOf('Android ') > -1 &&
                       nua.indexOf('AppleWebKit') > -1) &&
                       !(nua.indexOf('Chrome') > -1));

    return is_android;
}

function WindowOpen(url, name, width, height) {
    if (width == null || height == null) {
        width = 980;
        height = 680;
    }
    var leftPosition = (screen.width) ? (screen.width - width) / 2 : 0;
    var topPosition = (screen.height) ? (((screen.height - height) / 2) - 30) : 0;
    var settings = 'height=' + height + ', width=' + width + ', top=' + topPosition + ', left=' + leftPosition + ', scrollbars=yes, resizable=yes, ';
    var wnd = window.open(url, name, settings);
}

// 限制鍵盤僅可輸入數字(binding to KeyUp event)
function NumericKeyOnly(event) {
    var key = event.charCode ? event.charCode : event.keyCode;
    return (key >= 48 && key <= 57) || key === 8 || key === 46;
}

function GetMitakeAppSignatureURL(apVer, userId, orderData, callbackName) {
    var url = "";

    // iOS Devices (iPhone、iPad)
    if (apVer === "J1" || apVer === "J2") {
        url = "kgi://?mode=sign;id=" + userId + ";signtype=P1;order=" + orderData + ";callback=" + callbackName;
    }
        // Android Devices (GPhone、GPad、GTV)
    else if (apVer === "J3" || apVer === "J4" || apVer === "J6") {    
        url = "kgi://mode=sign;id=" + userId + ";signtype=P1;order=" + orderData + ";callback=" + callbackName;
    }
        // Windows Phone
    else if (apVer === "J5") {
        url = "kgi?mode=sign;id=" + userId + ";signtype=P1;order=" + orderData + ";callback=" + callbackName;
    } else {
        alert("取得隨身營業員簽署URL 發生錯誤: apVer 參數值無效! (apVer=" + apVer + ")");
        WriteErrLog('GetMitakeAppSignatureURL', "apVer:" + apVer + ";userId:" + userId + ";orderData:" + orderData); // 20170411, 82057
        return "";
    }

    WriteInfoLog('GetMitakeAppSignatureURL', "apVer:" + apVer + ";userId:" + userId + ";url:" + url); // 20170411, 82057
    return url;
}

// added 20170411, 82057
function WriteInfoLog(funName, log) {
    WriteLog(funName, "I", log);
}

function WriteErrLog(funName, log) {
    WriteLog(funName+"失敗", "E", log);
}

function WriteLog(funName, type, log) {
    var LogAction = '/ServicesWeb/Log/Write';

    var params = {
        FunName: funName,
        LogType: type,
        Log: log
    }

    AjaxInvoke(LogAction, params, function (result) {
        if (result != null && result.length > 0)
            alert("LOG紀錄失敗:" + result);
    });
}
// added 20170411, 82057 end

function blockEnterKey(evt) {
    var evt = (evt) ? evt : ((event) ? event : null);
    var node = (evt.target) ? evt.target : ((evt.srcElement) ? evt.srcElement : null);
    if ((evt.keyCode == 13) && (node.type == "button")) { return false; }
}

function ValidateNumber(e, pnumber) {
    if (!/^\d+$/.test(pnumber)) {
        $(e).val(/^\d+/.exec($(e).val()));
    }

    return false;
}

function htmlEncode(value) {
    return $('<div/>').text(value).html();
}

function AdjustDataTableVisibleHeight(dataTableId, dataTableFrameId) {
    if (parseInt($(window).innerWidth()) > 800) {
        $("#" + dataTableFrameId).css("max-height", (parseInt($(window).innerHeight()) * 0.45) + "px");
    } else {
        if ($("#" + dataTableId).outerHeight() + 20 <= (parseInt($(window).innerHeight()) * 0.45)) {
            $("#" + dataTableFrameId).css("height", $("#" + dataTableId).outerHeight() + 20 + "px");
        } else {
            $("#" + dataTableFrameId).css("height", (parseInt($(window).innerHeight()) * 0.45) + "px");
        }
    }
}

function ShowIE8IncompatibleAlert() {
    var alertMsg = "<ol>";
    alertMsg += "<li>本功能僅支援 IE9 以上/Firefox / Safari 瀏覽器，建議您升級IE瀏覽器或使用其他瀏覽器登入全球交易中心<br>";
    alertMsg += "&nbsp;&nbsp;<p><a href='http://windows.microsoft.com/zh-TW/internet-explorer/download-ie' target='_blank'>下載Internet Explorer <img src='../Content/images/ie.png' /></a></p>";
    alertMsg += "&nbsp;&nbsp;<p><a href='https://www.mozilla.org/zh-TW/firefox/new/' target='_blank'>下載Firefox <img src='../Content/images/firefox.png' /></a></p>";
    alertMsg += "&nbsp;&nbsp;<p><a href='http://www.kgieworld.com.tw/service/service_diy.aspx' target='_blank'>凱基證券 電腦檢測DIY</a></p></li>";
    alertMsg += "<li>本功能支援行動平台，您也可於<span style='font-weight:bold;'><a href='http://www.kgieworld.com.tw/service/Service_3_4.aspx?frm=08' target='_blank'>凱基隨身營業員</a>&nbsp;&gt;&nbsp;凱基專區</span>使用本功能";
    alertMsg += "</ol>";

    ShowSimpleAlert(alertMsg);
}

function IsValidStockNo(stockNo) {
    if (/^([a-zA-Z0-9 _-]+)$/.test(stockNo) === false) {
        return false;
    }

    return true;
}

var kendoGridNoDataTemplate = "<div style='height:2em; line-height:2em; font-size:1.4em; font-weight:bold; color:\\#f00;'>查無資料</div>";

var _HiddenCode = {
    BankAcc: function (acc) {
        if (acc == null) return "";

        return _HiddenCode.Work(acc, [5, 6, 8, 11], '*');
    },
    // HiddenAry index [5, 6, 8, 11]
    // HiddenCode '*'
    Work: function (data, HiddenAry, HiddenCode) {
        if (HiddenAry == null || HiddenAry.length == 0 || HiddenCode == null)
            return data;

        var dataAry = data.split("");
        var FetchIdx = 0;
        var needHidden = true;
        var retStr = "";
        for (ii = 0; ii < dataAry.length; ii++) {
            if (needHidden && ii == HiddenAry[FetchIdx]) {
                retStr = retStr + HiddenCode;
                FetchIdx++;
                if (FetchIdx >= HiddenAry.length)
                    needHidden = false;
            } else {
                retStr = retStr + dataAry[ii];
            }
        }

        return retStr;
    }
};

function MyToExcel(objname, filename) {
    $(objname).table2excel({
        exclude: ".noExl",
        name: "Excel Document Name",
        filename: filename + ".xls",
        fileext: ".xls",
        exclude_img: true,
        exclude_links: true,
        exclude_inputs: true
    });
}

Number.prototype.toDiv = function (arg2) {
    var arg1 = this;
    var s1 = arg1.toString(), s2 = arg2.toString();
    var aryS1 = s1.split(".");
    var aryS2 = s2.split(".");
    var t1 = 0, t2 = 0, r1, r2;
    t1 = (aryS1.length >= 2) ? aryS1[1].length : 0;
    t2 = (aryS2.length >= 2) ? aryS2[1].length : 0;
    r1 = Number(s1.replace(".", ""));
    r2 = Number(s2.replace(".", ""));
    return (r1 / r2) * Math.pow(10, t2 - t1);
}