package tw.order_2.model;

import java.util.ArrayList;

public interface OrderBeanDAOable {
	public  void insertOrder(OrderBean order_list);
	public  void deleteOrder(String delorder_ID);
	ArrayList<OrderBean> selectOrder(String stock_ID);
	public  void updateOrder(String change_ID,String change_price,String change_quant,String change_total);

}
