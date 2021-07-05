package tw.back.a02_Order.model;

import java.util.ArrayList;

import org.springframework.ui.Model;

public interface OrderServiceable {
	public  void insertOrder(OrderBean order_list,Model m);
	public  void deleteOrder(String delorder_ID,OrderBean order_list,Model m);
	String selectOrder(OrderBean order_list,Model m);
	public  void updateOrder(String change_ID,String change_price,String change_quant,String change_total,OrderBean order_list,Model m);

}
