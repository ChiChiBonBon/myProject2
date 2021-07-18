package tw.back.a02_Order.model;

import java.sql.SQLException;
import java.util.ArrayList;

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
	public String selectOrder(OrderBean order_list,Model m) { //mber.mber
		String order_lists = orderBeanDao.selectOrder(order_list.getStock_ID()).toString() ;
		m.addAttribute("order_lists", order_lists);
		
		//測試取sum order
		try {
			orderBeanDao.selectProfit("0800-123456-9");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return order_lists;
	}
	
//修改
	@Override
	public void updateOrder(String change_ID, String change_price, String change_quant, String change_total,OrderBean order_list,Model m) {
		orderBeanDao.updateOrder(change_ID, change_price, change_quant, change_total);
		selectOrder(order_list, m);
		return ;
	}

	
//查詢歷史資料	
	@Override
	public ArrayList<OrderBean> selectorderlog(String stock_ID,Model m) {
		String history_lists = orderBeanDao.selectHistoryLog(stock_ID).toString() ;
		m.addAttribute("history_lists", history_lists);
		return orderBeanDao.selectHistoryLog(stock_ID) ;
	}
	
//測試庫存損益
@Override
	public ArrayList<Profit> selectprofit(String stock_ID, Model m) {
		String profit_lists;
		try {
			profit_lists = orderBeanDao.selectProfit(stock_ID).toString();
			m.addAttribute("profit_lists", profit_lists);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		return null;
	}
	
	
	
	



	
	
	



	

}
