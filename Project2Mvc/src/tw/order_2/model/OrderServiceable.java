package tw.order_2.model;

import java.util.ArrayList;

public interface OrderServiceable {
	//�s�W�q��
	public void insertOrder(ArrayList<OrderBean> orderlist);
	
	//�R���q��
	public void deleteOrder(String delorder_ID);

	//�d�߭q��
	ArrayList<OrderBean> selectOrder(String stock_ID);
	
	//�ק�q��
	public void updateOrder(String change_ID,String change_price,String change_quant,String change_total);

}
