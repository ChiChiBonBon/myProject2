package tw.order_2.model;

import java.util.ArrayList;

import org.hibernate.Session;

public class OrderBeanDAO {
	private Session session;

	public OrderBeanDAO(Session session) {
       this.session = session;
	}
	
//�W�R�d��
	public void insertOrder(ArrayList<OrderBean> orderlist) {
		
	}
	
	public void deleteOrder(String delorder_ID) {
		
	}
	
	public  ArrayList<OrderBean> selectOrder(String stock_ID) {
		    ArrayList<OrderBean>  order_list = new ArrayList<>();
		
		return order_list ;
	}
	
	public void updateOrder(String change_ID,String change_price,String change_quant,String change_total) {
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
