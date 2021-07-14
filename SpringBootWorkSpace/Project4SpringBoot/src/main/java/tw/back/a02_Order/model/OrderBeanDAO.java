package tw.back.a02_Order.model;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


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
			
			ArrayList<OrderBean> order_lists = (ArrayList<OrderBean>) query.list();	    
		return order_lists ;
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

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
