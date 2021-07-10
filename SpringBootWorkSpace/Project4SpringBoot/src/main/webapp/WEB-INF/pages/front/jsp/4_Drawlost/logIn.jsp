<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<META name="viewport" content="width=device-width, initial-scale=1">
<META http-equiv="X-UA-Compatible" content="IE=edge">
<META http-equiv="cache-control" content="no-cache">
<META http-equiv="expires" content="0">
<META http-equiv="pragma" content="no-cache">

<title>股票申購登入</title>
<link href="<c:url value='/back/css/drawlots/bootstrap-theme.min.css'/>"
	rel="stylesheet">
<link href="<c:url value='/back/css/drawlots/bootstrap.min.css'/>"
	rel="stylesheet">
<link href="<c:url value='/back/css/drawlots/font-awesome.css'/>"
	rel="stylesheet">
<link href="<c:url value='/back/css/drawlots/Login.css'/>"
	rel="stylesheet">
<script src="<c:url value='/back/js/drawlots/jquery-1.12.3.min.js'/>"></script>
<script src="<c:url value='/back/js/drawlots/bootstrap.js'/>"></script>
<script src="<c:url value='/back/js/drawlots/bootbox.js'/>"></script>
<script
	src="<c:url value='/back/js/drawlots/ShareFunctions_20180723.js'/>"></script>
<script>
	function InitFunction() {
		// 1.build fun obj
		var sFids = "1,43,46";
		var nowFunType = "1";
		var showFids = [ "43", "1", "46" ];
		if (sFids != "")
			showFids = sFids.split(',');
		var functions = new Array();
		$.each(showFids, function(index, fid) {
			functions.push({
				type : fid,
				name : GetFunName(fid)
			});
		});

		$("#fids").val(sFids);
		$("#fid").val(nowFunType);

		// 2. html option
		var htmlArray = new Array();
		var selected = "";
		$.each(functions, function(index, rec) {
			selected = "";
			if (index == 0)
				selected = "selected";
			htmlArray.push("<option value='" + rec.type + "' " + selected + ">"
					+ rec.name + "</option>");
		});
		$("#function").html(htmlArray.join(''));
	}

	function functionChg() {
		$("#fid").val($("#function").val());
		//$("#stock").val("");
	}

	function TrustLogin() {
		if ($("#id").val() == "") {
			ShowSimpleAlert("請輸入身份證");
			return;
		}
		if ($("#psd").val() == "") {
			ShowSimpleAlert("請輸入密碼");
			return;
		}

		$("form").submit();
	}

	$(document).ready(function() {
		$("#id").val("");
		$("#psd").val("");
		$("#ErrMsg").html("");
		InitFunction();
	});
</script>
<script
	src="chrome-extension://jhffgcfmcckgmioipfnmbannkpncfipo/util.js"></script>
<script
	src="chrome-extension://jhffgcfmcckgmioipfnmbannkpncfipo/pagejs.js"></script>
</head>
<body>
	<div class="pagearea" style="width: 930px; height: 950px" >
		<a name="top"></a>
		
		<div class="header">
			<img width="35px" height="35px" style="margin-top: 4px;margin-left: 4px"  border="0"
				src="<c:url value='/back/img/EEIT.jpg'/>" title="萬泰證券" /></a>
		</div>
	
		<div class="ctn_mg"
			style="width: 900px; height: 900px; margin-left: auto; margin-right: auto;">
			<div class="title">系統登入</div>
			<div class="main">
				<form action="/ServicesWeb/Auth/Login?applytype=1,43,46&amp;orign=P"
					method="post">
					<input id="fids" name="fids" type="hidden" value="1,43,46"><input
						id="fid" name="fid" type="hidden" value="1"><input
						id="orign" name="orign" type="hidden" value="P"><input
						id="stock" name="stock" type="hidden" value="">
					<div class="form-group row">
						<div class="col-sm-12">
							<select class="form-control" id="function" name="function"
								onchange="functionChg();"><option value="1" selected="">股票申購</option>
								<option value="43">快e貸</option>
								<option value="46">定期定額專區</option></select>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-sm-12 ">
							<input type="text" class="form-control input-group-lg" id="id"
								name="id" placeholder="請輸入身分證號" autocomplete="off">
						</div>
					</div>
					<div class="form-group row">
						<div class="col-sm-12">
							<input type="password" class="form-control" id="psd" name="psd"
								placeholder="請輸入密碼" autocomplete="off">
						</div>
					</div>
					<div style="text-align: center">
						<p id="ErrMsg" style="color: red;"></p>
						<input class="btn btn-submit" style="width: 50%;" value="登入"
							onclick="TrustLogin();"><br> <a
							href="https://www.kgieworld.com.tw/PWOnline/login.aspx"
							target="blank"><span>忘記密碼</span></a>
					</div>
				</form>
				<div class="sepline"></div>
				<div class="note">
					登入說明：<br> 1. 密碼為7-10位字元的數字與英文字混合，英文字大小寫將視為不同字元。 <br> 2.
					首次登入之客戶請先修改密碼及申請電子憑證，才可以進行下單交易。
				</div>
			</div>
		</div>
	</div>
</body>
</html>