package tw.order_2.model;

import java.util.ArrayList;

import org.hibernate.Session;

public class OrderService implements OrderServiceable{
	private OrderBeanDAO order ;

	public OrderService (Session session) {
		order = new OrderBeanDAO(session);
	}
	
	@Override
	public void insertOrder(ArrayList<OrderBean> orderlist) {	
		order.insertOrder(orderlist);
	}

	@Override
	public void deleteOrder(String delorder_ID) {
		order.deleteOrder(delorder_ID);
	}

	@Override
	public ArrayList<OrderBean> selectOrder(String stock_ID) {
		
		return order.selectOrder(stock_ID) ;
	}

	@Override
	public void updateOrder(String change_ID, String change_price, String change_quant, String change_total) {
		order.updateOrder(change_ID, change_price, change_quant, change_total);
	}

}
