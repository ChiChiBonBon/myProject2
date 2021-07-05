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
import tw.back.a02_Order.model.OrderServiceable;
import tw.back.a02_Order.model.Account;
import tw.back.a02_Order.model.AccountDAO;


@Controller
@EnableTransactionManagement
@SessionAttributes(names = {"stock_ID", "user_account","user_password",
							"emp_ID","emp_acc","emp_psd",
							"com_ID","order_ID","order_price","order_quant","order_total","order_date","order_time","trans_cond","trans_way","trans_sellorbuy","trans_stats","trans_report",
							"order_list","delorder_ID","order_lists",
							"change_ID","change_price","change_quant","change_total"},
					types = {Account.class,OrderBean.class,Employee.class})

public class OrderController {
	
	
	@Autowired
	private OrderServiceable orderService ;
	

	@PostMapping("/order/check")
	public String loadCheckOrderPage(OrderBean order_list,Model m) {
		m.addAttribute("emp_ID" , "admin");
		return "back/jsp/2_Order/2_Order_check" ;
	}
	
	@PostMapping("/order/delete")
	public String loadCheckDeletePage(OrderBean order_list,Model m) {
		m.addAttribute("emp_ID" , "admin");
		return "back/jsp/2_Order/2_Order_delete" ;
	}
	
	@GetMapping("/order/select")
	public String loadSelectOrder() {
		return "2_Order_select" ;
	}
	
	@PostMapping("/order/controller/insert")
	public String loadOrderService(OrderBean order_list,Model m){
		orderService.insertOrder(order_list,m);
		return "back/jsp/2_Order/2_Order" ;
	}
	
	@PostMapping("/order/controller/delete")
	public String loadDeleteOrderService(String delorder_ID,OrderBean order_list,Model m){
		orderService.deleteOrder(delorder_ID, order_list,m);
		return "back/jsp/2_Order/2_Order_select" ;
	}
	
	@PostMapping("/order/controller/update")
	public String loadUpdateOrderService(String change_ID,String change_price,String change_quant,String change_total,OrderBean order_list,Model m){
		orderService.updateOrder(change_ID, change_price, change_quant, change_total, order_list, m);
		return "back/jsp/2_Order/2_Order_select" ;
	}
	
	
	
	
}
