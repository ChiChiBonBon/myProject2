package tw.back.a02_Order.model;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;


@Service("orderService")
@Transactional
public class OrderService implements OrderServiceable{
	
	@Autowired
	public OrderBeanDAO orderBeanDao ;
	
	public OrderService() {
	}

//增刪查改-Service呼叫
//新增
	@Override
	public void insertOrder(OrderBean order_list,Model m) {
		orderBeanDao.insertOrder(order_list);
		selectOrder(order_list, m);
		return ;
	}
	
//刪除
	@Override
	public void deleteOrder(String delorder_ID,OrderBean order_list,Model m) {
		orderBeanDao.deleteOrder(delorder_ID);
		selectOrder(order_list, m);
		return ;
	}
	
//查詢
	@Override
	public String selectOrder(OrderBean order_list,Model m) {
		String order_lists = orderBeanDao.selectOrder(order_list.getStock_ID()).toString() ;
		m.addAttribute("order_lists", order_lists);
		return order_lists;
	}
	
//修改
	@Override
	public void updateOrder(String change_ID, String change_price, String change_quant, String change_total,OrderBean order_list,Model m) {
		orderBeanDao.updateOrder(change_ID, change_price, change_quant, change_total);
		selectOrder(order_list, m);
		return ;
	}



	

}
