package tw.order_2.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import tw.order_2.model.Account;
import tw.order_2.model.AccountDAO;


@Controller
@EnableTransactionManagement
@SessionAttributes(names = {"stock_ID","user_account", "user_password"})
public class LoginController {
	
	@Autowired
	private AccountDAO accountDao;
	
	@RequestMapping(path = "/testlogin", method = RequestMethod.GET)
    public String processLoginMainPage() {
    	return "2_Login";
    }
	
	@RequestMapping(path = "/checklogin.controller", method = RequestMethod.POST)
	public String processCheckLogin(@RequestParam(name = "stock_ID")      String stock_ID,
									@RequestParam(name = "user_account")  String user_account,
									@RequestParam(name = "user_password") String user_password,
									Model m, SessionStatus status) {
		Map<String, String> errors = new HashMap<String, String>();
		m.addAttribute("errors", errors);
		
		if(stock_ID==null || stock_ID.length()==0) {   //SessionStatus status setComplete();
			errors.put("stock_ID", "請輸入測試證券帳號");
		}
		
		if(user_account==null || user_account.length()==0) {   //SessionStatus status setComplete();
			errors.put("user_account", "請輸入測試帳號");
		}
		
		if(user_password==null || user_password.length()==0) {
			errors.put("user_password", "請輸入測試密碼");
		}
		
		if(errors!=null && !errors.isEmpty()) {
			return "Login";
		}
		
		
		boolean checkUserStatus = accountDao.checkLogin(new Account( stock_ID, user_account, user_password));
		
		if(checkUserStatus) {
			m.addAttribute("stock_ID"     , stock_ID     );
			m.addAttribute("user_account" , user_account );
			m.addAttribute("user_password", user_password);
			return "loginSuccess";
		}
		
		errors.put("msg", "�п�J�����Ҩ�b��,���ձb��,���ձK�X");
		return "Login";
	}
	
	
	
	
	
	
	
	
	
	
}
