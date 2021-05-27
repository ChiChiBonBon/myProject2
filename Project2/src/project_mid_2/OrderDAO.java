package project_mid_2;

import java.util.ArrayList;

public interface OrderDAO {
	//新增訂單
	public void insertOrder(ArrayList<OrderBean> orderlist);
	
	//刪除訂單
	public void deleteOrder(String delorder_ID);

	//查詢訂單
	ArrayList<OrderBean> selectOrder(String stock_ID);
	
	//修改訂單
	public void updateOrder(String change_ID,String change_price,String change_quant,String change_total);

	
	
}
