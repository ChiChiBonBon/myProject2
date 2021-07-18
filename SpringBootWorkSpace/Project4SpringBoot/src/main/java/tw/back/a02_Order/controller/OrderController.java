package tw.back.a02_Order.controller;


import java.sql.SQLException;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import tw.back.a02_Order.model.Employee;
import tw.back.a02_Order.model.EmployeeDAO;
import tw.back.a02_Order.model.OrderBean;
import tw.back.a02_Order.model.OrderBeanDAO;
import tw.back.a02_Order.model.OrderServiceable;
import tw.back.a02_Order.tools.JsonTools;
import tw.front.a01_Member.model.MemberBean;
import tw.back.a02_Order.model.Account;
import tw.back.a02_Order.model.AccountDAO;


@Controller
@EnableTransactionManagement
@SessionAttributes(names = {"stock_ID", "user_account","user_password",
		                    "member_stock_ID","member_auth","member_quote","member_status",
							"emp_ID","emp_acc","emp_psd",
							"id","com_ID","order_ID","order_price","order_quant","order_total","order_date","order_time","trans_cond","trans_way","trans_sellorbuy","trans_stats","trans_report",
							"order_list","delorder_ID","order_lists", "history_lists", "profit_lists",
							"change_ID","change_price","change_quant","change_total"},
				   types = {Account.class,OrderBean.class,Employee.class,MemberBean.class})

public class OrderController {
	
	@Autowired
	private OrderServiceable orderService ;
	
	
//接收AJAX請求
	@GetMapping(value = "/getapi", produces = { "application/json; charset=UTF-8" })
	public @ResponseBody String getAPIbyCom_ID(
			 							@RequestParam(value = "com_ID"  ,defaultValue = "com_ID") String com_ID,
			 							@RequestParam(value = "com_name",defaultValue = "台積電" ) String com_name) throws Exception{
		//測試
		System.out.println(JsonTools.getJson_com(com_ID).toString());
		return JsonTools.getJson_com(com_ID).toString();
	 }
	
//管理者新增>get = 導向+查詢 ,  post = 導向+下單+查詢　
	@GetMapping("/admin/order")
	public String loadOrderPage_GET(Account acc,OrderBean order_list,Model m) {
		m.addAttribute("emp_ID" , "admin");
		m.addAttribute("stock_ID" , acc.getStock_ID());
		orderService.selectOrder(order_list, m);
		return "back/jsp/2_Order/2_Order" ;
	}
	
	@PostMapping("/admin/order")
	public String loadOrderPage_POST(Account acc,OrderBean order_list,Model m) {
		m.addAttribute("emp_ID" , "admin");
		m.addAttribute("stock_ID" , acc.getStock_ID());
		orderService.insertOrder(order_list,m);
		return "back/jsp/2_Order/2_Order" ;
	}

//使用者新增>
	@GetMapping("/front/order")
	public String loadOrder_GET(Account acc,OrderBean order_list,MemberBean mber,Model m) {
		m.addAttribute("user_ID" , "王曉明");           
		m.addAttribute("stock_ID" ,"0800-123456-9"); 
		orderService.selectOrder(order_list, m);
		return "front/jsp/2_Order/Order" ;
	}
	
	@PostMapping("/front/order")
	public String loadOrder_POST(Account acc,OrderBean order_list ,Model m) {
		m.addAttribute("user_ID" , "王曉明");            
		m.addAttribute("stock_ID" , "0800-123456-9"); 
		orderService.insertOrder(order_list,m);
		return "front/jsp/2_Order/Order" ;
	}

//共用>查詢、刪除、更改
	@GetMapping("/order/select")
	public String loadSelectOrder() {
		return "back/jsp/2_Order/2_Order_select" ;
	}
	
	@GetMapping("/front/order/select")
	public String loadSelectOrder_front(OrderBean order_list ,Model m) {
		orderService.selectOrder(order_list, m);
		return "front/jsp/2_Order/Order_select" ;
	}
	
	@PostMapping("/order/delete")
	public String loadDeleteOrderService(String delorder_ID,OrderBean order_list,Model m){
		orderService.deleteOrder(delorder_ID, order_list,m);
		return "back/jsp/2_Order/2_Order_select" ;
	}
	
	@PostMapping("/order/update")
	public String loadUpdateOrderService(String change_ID,String change_price,String change_quant,String change_total,OrderBean order_list,Model m){
		orderService.updateOrder(change_ID, change_price, change_quant, change_total, order_list, m);
		return "back/jsp/2_Order/2_Order_select" ;
	}

//歷史紀錄導向
	@GetMapping("/front/history/select")
	public String loadHistorySelect(String stock_ID ,Model m) {
		//orderService.selectorderlog("0800-123456-9", m);
		return "front/jsp/2_Order/Order_history" ;
	}
	
//歷史紀錄iframe
	@GetMapping("/history/select")
	public String loadHistoryTable(String stock_ID ,Model m) {
		orderService.selectorderlog("0800-123456-9", m);
		return "back/jsp/2_Order/History_select" ;
	}
	
//庫存損益導向
	@GetMapping("/front/profit/select")
	public String loadProfitSelect(String stock_ID ,Model m) {
		//orderService.selectprofit(stock_ID, m);
		return "front/jsp/2_Order/Order_profit" ;
	}

//庫存損益ifame
	@GetMapping("/profit/select")
	public String loadProfitTable(String stock_ID ,Model m) {
		orderService.selectprofit("0800-123456-9", m);
		return "back/jsp/2_Order/Profit_select" ;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
