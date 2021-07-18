
<%
/* 判斷是否有Login_1.java 執行過後cookie: cookie_id */
/* 假如沒有cookie, cookie=null 回到登入畫面 */
/* 預設check_id=true 當有cookie_id存在 更改check_id=false */
/* 所以當check_id=true 程式就會倒回登入畫面 */
Cookie[] cookies = request.getCookies();
int i = 0;
String string;
boolean check_id = true;
if (cookies != null) {
	for (Cookie c : cookies) {
		string = cookies[i].getName();
		System.out.println("StockOverFlowMember cookie check:" + string);
		System.out.println("StockOverFlowMember time:" + i);
		i += 1;
		if (string.equals("StockOverFlowMember")) {
	check_id = false;
	break;
		}
	}
}
if (cookies == null) {
	response.sendRedirect("/project4/front/unmember/gologin_1");
}		
if (check_id) {
	response.sendRedirect("/project4/front/unmember/gologin_1");
}
%>