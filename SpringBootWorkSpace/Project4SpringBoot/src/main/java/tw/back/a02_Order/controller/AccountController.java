package tw.back.a02_Order.controller;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;


import tw.back.a02_Order.model.Employee;
import tw.back.a02_Order.model.EmployeeDAO;
import tw.back.a02_Order.model.OrderBean;
import tw.back.a02_Order.model.OrderBeanDAO;
import tw.back.a02_Order.model.OrderServiceable;
import tw.front.a01_Member.dao.MemberDao;
import tw.front.a01_Member.model.MemberBean;
import tw.back.a02_Order.model.Account;
import tw.back.a02_Order.model.AccountDAO;


@Controller
@EnableTransactionManagement
@SessionAttributes(names = {"mber_stock_ID","member_info",
							"change_ID","change_auth","change_quota",
							"acc_lists","order_lists","delacc_ID"},
					types = {Account.class,MemberBean.class})

public class AccountController {
	
	@Autowired
	private AccountDAO  accountDao;
	
	
//登入導向+權限修改
	@GetMapping("/admin/login")
    public String loadLoginPage() {
    	return "back/jsp/2_Order/2_Admin_login";	
    }
	
	@PostMapping("/admin/authority")
    public String loadPage(Model m) {
		m.addAttribute("emp_ID" , "admin");
		String stockid =  (String) m.getAttribute("mber_stock_ID");
		System.out.println("mber stock:" + stockid);
		
		MemberBean mber = (MemberBean) m.getAttribute("member_info");
		//System.out.println("取得的stock:" + mber.getMember_stock_ID());
		

    	return "back/jsp/2_Order/2_Authority";	
    }


//查詢會員資料 + 修改會員權限 auth + quota
	@GetMapping("/admin/account/select")
	public String loadSelectAcc(Account acc_list,Model m) {
		String stockid =  (String) m.getAttribute("mber_stock_ID");
		System.out.println(stockid);
		
		MemberBean mber = (MemberBean) m.getAttribute("member_info");
		System.out.println("取得的stock:" + mber.getMember_stock_ID());
		
		String acc_lists = accountDao.selectAcc("0620-817781-0").toString() ;
		m.addAttribute("acc_lists", acc_lists);
		return "back/jsp/2_Order/2_Authority_select" ;
		
	}
	
	

	@GetMapping("/admin/controller/update")
	public String loadUpdateAcc(String change_ID,String change_auth,String change_quota ,Account acc_list,Model m){
		accountDao.updateAuth(change_ID, change_auth, change_quota);
		loadSelectAcc(acc_list, m);
		return "back/jsp/2_Order/2_Authority_select" ;
	}
	
//	@PostMapping("/admin/controller/delete")
//	public String loadDeleteOrderService(String delacc_ID,Account acc_list,Model m){
//		accountDao.deleteAcc(delacc_ID);
//		loadSelectAcc(acc_list, m);
//		return "back/jsp/2_Order/2_Order_select" ;
//	}
	
	
//備份區
//	@GetMapping("/admin/account/select")
//	public String loadSelectAcc(Account acc_list,Model m) {
//		String acc_lists = accountDao.selectAcc(acc_list.getStock_ID()).toString() ;
//		m.addAttribute("acc_lists", acc_lists);
//		return "back/jsp/2_Order/2_Authority_select" ;
//	}
//	
//	@GetMapping("/admin/controller/update")
//	public String loadUpdateAcc(String change_ID,String change_auth,String change_quota ,Account acc_list,Model m){
//		accountDao.updateAuth(change_ID, change_auth, change_quota);
//		loadSelectAcc(acc_list, m);
//		return "back/jsp/2_Order/2_Authority_select" ;
//	}
	
	
	
	
	
	
}
