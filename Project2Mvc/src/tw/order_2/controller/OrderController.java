package tw.order_2.controller;

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

import tw.order_2.model.Account;
import tw.order_2.model.AccountDAO;
import tw.order_2.model.OrderBean;
import tw.order_2.model.OrderBeanDAO;
import tw.order_2.model.OrderBeanDAOable;
import tw.order_2.model.OrderService;
import tw.order_2.model.OrderServiceable;

@Controller
@EnableTransactionManagement
@SessionAttributes(names = {"stock_ID", "user_account","user_password","order_list",
							"com_ID","order_ID","order_price","order_quant","order_total","order_date","order_time",
							"trans_cond","trans_way","trans_sellorbuy","trans_stats","trans_report"},
				   types = {Account.class,OrderBean.class})
public class OrderController {
	
	@Autowired
	private AccountDAO   accountDao   ;
	private OrderBeanDAO orderBeanDao ;
	private OrderService orderService ;
	
	
	@ModelAttribute(name="order_list")
	public OrderBean orderinsert() {
		return new OrderBean();
	}
		
	@GetMapping("/testlogin")
    public String loadLoginPage() {
    	return "2_Login";	
    }
	
	@PostMapping("/checklogin")
	public String loadCheckPage(Account acc,Model m, SessionStatus status) {
		m.addAttribute("stock_ID"     , acc.getStock_ID()     );
		m.addAttribute("user_account" , acc.getUser_account() );
		m.addAttribute("user_password", acc.getUser_password());
		
		accountDao.insert(acc);
		return "2_Logok_to_order";	
	}
		
	@PostMapping("/order")
	public String loadOrderPage() {
		return "2_Order" ;
	}
	
	@PostMapping("/order/check")
	public String loadCheckOrderPage(OrderBean order_list,Model m, SessionStatus status) {
//		m.addAttribute("stock_ID"       ,order_list.getStock_ID()       );
//		m.addAttribute("order_ID"       ,order_list.getOrder_ID()       );
//		m.addAttribute("com_ID"         ,order_list.getCom_ID()         );
//		m.addAttribute("order_price"    ,order_list.getOrder_price()    );
//		m.addAttribute("order_quant"    ,order_list.getOrder_quant()    );
//		m.addAttribute("order_total"    ,order_list.getOrder_total()    );
//		m.addAttribute("order_date"     ,order_list.getOrder_date()     );
//		m.addAttribute("order_time"     ,order_list.getOrder_time()     );
//		m.addAttribute("trans_cond"     ,order_list.getTrans_cond()     );
//		m.addAttribute("trans_way"      ,order_list.getTrans_way()      );
//		m.addAttribute("trans_sellorbuy",order_list.getTrans_sellorbuy());
//		m.addAttribute("trans_stats"    ,order_list.getTrans_stats()    );
//		m.addAttribute("trans_report"   ,order_list.getTrans_report()   );
		System.out.println(order_list);
		return "2_Order_check" ;
	}
	
	@GetMapping("/order/select")
	public String loadSelectOrder() {
		return "2_Order_select" ;
	}
	
	@PostMapping("/order/controller/insert")
	public String loadOrderService(OrderBean order_list){
		System.out.println("--------");
		System.out.println(order_list);
		System.out.println("--------");
		OrderBeanDAO aaa = new OrderBeanDAO();
		aaa.insertOrder(order_list);
		//orderBeanDao.insertOrder(order_list);
		//orderService.insertOrder(order_list);
		
		return "2_Order" ;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
