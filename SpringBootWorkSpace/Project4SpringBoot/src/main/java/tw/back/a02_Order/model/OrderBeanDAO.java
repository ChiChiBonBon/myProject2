package tw.back.a02_Order.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.query.Query;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tw.back.a02_Order.tools.JsonTools;


@Repository("orderBeanDAO")
@Transactional
public class OrderBeanDAO  {
	
	@Autowired 
	@PersistenceContext
	private EntityManager session ;
	
//增刪查改-實作
//新增
	@Transactional
	public  void insertOrder(OrderBean order_list) {
		order_list.setId(null);
		session.persist(order_list);
	}
	
//刪除
	public void deleteOrder(String delorder_ID) {
	
		String hql="update OrderBean set trans_report=:stats  where id=:delid";
		Query query = (Query) session.createQuery(hql);	
		query.setParameter("stats", "刪單成功");
		query.setParameter("delid", delorder_ID);
		query.executeUpdate();	
	}
	
//查詢
	public  ArrayList<OrderBean> selectOrder(String stock_ID) {
		    
			String hql = "from OrderBean where stock_ID=:id And trans_report!=:con";
			Query<OrderBean> query = (Query<OrderBean>) session.createQuery(hql, OrderBean.class);		
			query.setParameter("con","刪單成功");
			query.setParameter("id", stock_ID);
			//原始格式
			ArrayList<OrderBean> order_lists = (ArrayList<OrderBean>) query.list();
			
			//輸出格式
			ArrayList<OrderBean> formatlist = new ArrayList<>();
		    for (int i=0;i<order_lists.size();i++) {
		    	OrderBean input = new OrderBean() ;
			    	input.setId			    (order_lists.get(i).getId()             );
			    	input.setStock_ID	    (order_lists.get(i).getStock_ID()       );
			    	input.setCom_ID		    (order_lists.get(i).getCom_ID()         );
			    	input.setOrder_price    ("$"+JsonTools.getMoneyFormat(order_lists.get(i).getOrder_price()));
			    	input.setOrder_quant    (    JsonTools.getMoneyFormat(order_lists.get(i).getOrder_quant()));
			    	input.setOrder_total    ("$"+JsonTools.getMoneyFormat(order_lists.get(i).getOrder_total()));
			    	input.setOrder_date     (order_lists.get(i).getOrder_date()     );
			    	input.setOrder_time	    (order_lists.get(i).getOrder_time()     );
			    	input.setTrans_cond     (order_lists.get(i).getTrans_cond()     );
			    	input.setTrans_way      (order_lists.get(i).getTrans_way()      );
			    	input.setTrans_sellorbuy(order_lists.get(i).getTrans_sellorbuy());
			    	input.setTrans_stats    (order_lists.get(i).getTrans_stats()    );
			    	input.setTrans_report   (order_lists.get(i).getTrans_report()   );
			    formatlist.add(input);
		    }
		    
			//測試結果
//			System.out.println("原始格式:" + order_lists);
//			System.out.println("輸出格式:" + formatlist);
			
		return formatlist ;
	}	
	
//修改	
	public void updateOrder(String change_ID,String change_price,String change_quant,String change_total) {
		
		String hql="update OrderBean set order_price=:price,order_quant=:quant,order_total=:total  where id=:id";
		Query query = (Query) session.createQuery(hql);	
		query.setParameter("price", change_price);
		query.setParameter("quant", change_quant);
		query.setParameter("total", change_total);
		query.setParameter("id", change_ID);
		query.executeUpdate();		
	}
	
//查詢歷史資料
	public  ArrayList<OrderBean>  selectHistoryLog(String stock_ID) {
		
			String hql = "from OrderBean where stock_ID=:id";
			Query<OrderBean> query = (Query<OrderBean>) session.createQuery(hql, OrderBean.class);		
			query.setParameter("id", stock_ID);
		    //原始格式 
			ArrayList<OrderBean> allorder = (ArrayList<OrderBean>) query.list();
		   
		    //輸出格式
		    ArrayList<OrderBean> formatlist = new ArrayList<>();
		    for (int i=0;i<allorder.size();i++) {
		    	OrderBean input = new OrderBean() ;
			    	input.setId			    (allorder.get(i).getId()			 );
			    	input.setStock_ID		(allorder.get(i).getStock_ID()		 );
			    	input.setCom_ID			(allorder.get(i).getCom_ID()		 );
			    	input.setOrder_price	("$"+JsonTools.getMoneyFormat(allorder.get(i).getOrder_price()));
			    	input.setOrder_quant	(	 JsonTools.getMoneyFormat(allorder.get(i).getOrder_quant()));
			    	input.setOrder_total	("$"+JsonTools.getMoneyFormat(allorder.get(i).getOrder_total()));
			    	input.setOrder_date		(allorder.get(i).getOrder_date()	 );
			    	input.setOrder_time		(allorder.get(i).getOrder_time()	 );
			    	input.setTrans_cond	    (allorder.get(i).getTrans_cond()     );
			    	input.setTrans_way	    (allorder.get(i).getTrans_way()	     );
			    	input.setTrans_sellorbuy(allorder.get(i).getTrans_sellorbuy());
			    	input.setTrans_stats	(allorder.get(i).getTrans_stats()    );
			    	input.setTrans_report	(allorder.get(i).getTrans_report()   );
		    	formatlist.add(input);
		    }
		    //測試結果
//		    	System.out.println("原始格式:" + allorder);
//		    	System.out.println("輸出格式:" + formatlist);
//		    	System.out.println("輸出格式.tostring():" + formatlist.toString());
		    	
	return formatlist;
}
	
//測試庫存損益
	public  ArrayList<Profit>  selectProfit(String stock_ID) throws Exception  {
				
		String hql ="from OrderBean where stock_ID=:id and trans_report=:rep order by com_ID";
		
		Query<OrderBean> query = (Query<OrderBean>) session.createQuery(hql, OrderBean.class);		
		query.setParameter("id", stock_ID);
		query.setParameter("rep","委託成功");
		
	    //原始格式 
		ArrayList<OrderBean> sumorder = (ArrayList<OrderBean>) query.list();
		
	    //輸出格式
	    ArrayList<Profit> formatlist = new ArrayList<>();
	    for (int i=0;i<sumorder.size();i++) {
	    	Profit input = new Profit() ;
	    	
	    	String input_id  =  sumorder.get(i).getCom_ID();
	    	JSONObject api  = JsonTools.getapi(input_id);
	  		
	    	Float qn         = Float.parseFloat (sumorder.get(i).getOrder_quant());
	    	Float pn         = Float.parseFloat (sumorder.get(i).getOrder_price());
	    	Float pn_now     = Float.parseFloat (api.get("z").toString());
	    	Double total     = (double) (pn * qn) ;
	    	Double total_now = (double) (pn_now * qn) ;
	    	Double balance   = total_now  - ((double) (qn * pn))  ;
	    	Double per       = (balance / total)*100 ;
	    	
	    	
	    	DecimalFormat df1 = new DecimalFormat("###,###,###,##0.00");
	    	DecimalFormat df2 = new DecimalFormat("###,###,###,###");
	    	
	    	input.setCom(sumorder.get(i).getCom_ID());
			input.setCom_n(api.get("n").toString());
	    	input.setP("$"+ JsonTools.getMoneyFormat(sumorder.get(i).getOrder_price()));
	    	input.setP_now("$"+ JsonTools.getMoneyFormat(pn_now.toString()));
	    	input.setBalance("$" + df2.format(balance));
	    	input.setMoney_per(df1.format(per) + "%");
	    	input.setQ(JsonTools.getMoneyFormat(sumorder.get(i).getOrder_quant()));
	    	input.setTotal("$"+ JsonTools.getMoneyFormat(sumorder.get(i).getOrder_total()));
	    	input.setTotal_now("$"+ df1.format(total_now));
  	
	    	formatlist.add(input);
	    }
	    //測試結果
//	    	System.out.println("原始格式:" + sumorder);
//	    	System.out.println("輸出格式:" + formatlist);
//	    	System.out.println("輸出格式.tostring():" + formatlist.toString());
	    	
    return formatlist;
}
	

	
	

	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
