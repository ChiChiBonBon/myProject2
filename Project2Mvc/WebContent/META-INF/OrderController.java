package tw.order_2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import tw.order_2.model.OrderBean;
import tw.order_2.model.OrderBeanDAO;

@Controller
@EnableTransactionManagement
@SessionAttributes(names = {"order_ID","stock_ID","com_ID",
							"order_price","order_quant","order_total","order_date","order_time",
							"trans_cond","trans_way","trans_sellorbuy","trans_stats","trans_report"})
public class OrderController {
	
	@Autowired
	private OrderBeanDAO orderBeanDao;
	
	@RequestMapping(path = "/order", method = RequestMethod.GET)
    public String IntoOrderPage() {
    	return "2_Order";
    }
	
	
	@RequestMapping(path = "/order/check", method = RequestMethod.POST)
	public String processCheckLogin(@RequestParam(name = "order_ID")        String order_ID,
									@RequestParam(name = "stock_ID")        String stock_ID,
									@RequestParam(name = "com_ID")          String com_ID,
									@RequestParam(name = "order_price")     String order_price,
									@RequestParam(name = "order_quant")     String order_quant,
									@RequestParam(name = "order_total")     String order_total,
									@RequestParam(name = "order_date")      String order_date,
									@RequestParam(name = "order_time")      String order_time,
									@RequestParam(name = "trans_cond")      String trans_cond,
									@RequestParam(name = "trans_way")       String trans_way,
									@RequestParam(name = "trans_sellorbuy") String trans_sellorbuy,
									@RequestParam(name = "trans_stats")     String trans_stats,
									@RequestParam(name = "trans_report")    String trans_reports,
									Model m, SessionStatus status) {
		
		m.addAttribute("stock_ID"       ,stock_ID       );
		m.addAttribute("order_ID"       ,order_ID       );
		m.addAttribute("com_ID"         ,com_ID         );
		m.addAttribute("order_price"    ,order_price    );
		m.addAttribute("order_quant"    ,order_quant    );
		m.addAttribute("order_total"    ,order_total    );
		m.addAttribute("order_date"     ,order_date     );
		m.addAttribute("order_time"     ,order_time     );
		m.addAttribute("trans_cond"     ,trans_cond     );
		m.addAttribute("trans_way"      ,trans_way      );
		m.addAttribute("trans_sellorbuy",trans_sellorbuy);
		m.addAttribute("trans_stats"    ,trans_stats    );
		m.addAttribute("trans_report"   ,trans_reports  );
		
		orderBeanDao.insertOrder(null);
		return "2_Order_check";	
		
	}
	
	
	
	
	
	
	
	
	
	
}
