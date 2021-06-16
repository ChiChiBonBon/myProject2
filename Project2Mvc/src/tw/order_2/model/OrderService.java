package tw.order_2.model;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("OrderService")
@Transactional
public class OrderService implements OrderServiceable{
	
	@Autowired
	public OrderBeanDAO orderDao ;
	
	public OrderService() {
		
	}

//	public OrderService (Session session) {
//		order = new OrderBeanDAO(session);
//	}
	
	@Override
	public void insertOrder(OrderBean order_list) {
		System.out.println(order_list);
		orderDao.insertOrder(order_list);
		return ;
	}
	


	@Override
	public void deleteOrder(String delorder_ID) {
		orderDao.deleteOrder(delorder_ID);
		return ;
	}

	@Override
	public ArrayList<OrderBean> selectOrder(String stock_ID) {
		return orderDao.selectOrder(stock_ID) ;
	}

	@Override
	public void updateOrder(String change_ID, String change_price, String change_quant, String change_total) {
		orderDao.updateOrder(change_ID, change_price, change_quant, change_total);
		return ;
	}



	

}
