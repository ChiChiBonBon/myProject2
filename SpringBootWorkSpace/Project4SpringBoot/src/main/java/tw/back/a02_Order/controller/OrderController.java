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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import tw.back.a02_Order.model.Employee;
import tw.back.a02_Order.model.EmployeeDAO;
import tw.back.a02_Order.model.OrderBean;
import tw.back.a02_Order.model.OrderServiceable;
import tw.back.a02_Order.tools.JsonTools;
import tw.back.a02_Order.model.Account;
import tw.back.a02_Order.model.AccountDAO;


@Controller
@EnableTransactionManagement
@SessionAttributes(names = {"stock_ID", "user_account","user_password",
							"emp_ID","emp_acc","emp_psd",
							"id","com_ID","order_ID","order_price","order_quant","order_total","order_date","order_time","trans_cond","trans_way","trans_sellorbuy","trans_stats","trans_report",
							"order_list","delorder_ID","order_lists",
							"change_ID","change_price","change_quant","change_total"},
					types = {Account.class,OrderBean.class,Employee.class})

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
	
//get = 導向+查詢 ,  post = 導向+下單+查詢　
	@GetMapping("/admin/order")
	public String loadOrderPage_GET(Account acc,OrderBean order_list ,Model m) {
		m.addAttribute("emp_ID" , "admin");
		m.addAttribute("stock_ID" , acc.getStock_ID());
		orderService.selectOrder(order_list, m);
		return "back/jsp/2_Order/2_Order" ;
	}
	
	@PostMapping("/admin/order")
	public String loadOrderPage_POST(Account acc,OrderBean order_list ,Model m) {
		m.addAttribute("emp_ID" , "admin");
		m.addAttribute("stock_ID" , acc.getStock_ID());
		orderService.insertOrder(order_list,m);
		return "back/jsp/2_Order/2_Order" ;
	}
	
//查詢、刪除、更改
	@GetMapping("/order/select")
	public String loadSelectOrder() {
		return "back/jsp/2_Order/2_Order_select" ;
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
	
}
