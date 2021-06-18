package tw.order_2.model;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import tw.company_6.bean.Company_6;

@Repository("orderBeanDAO")
@Transactional
public class OrderBeanDAO  {
	
	@Autowired 
	@Qualifier("sessionFactory")
	public SessionFactory sessionFactory;
	
//增刪查改-實作
//新增
	public void insertOrder(OrderBean order_list) {
		Session session = sessionFactory.getCurrentSession();
		session.save(order_list);
	}
	
//刪除
	public void deleteOrder(String delorder_ID) {
		Session session = sessionFactory.getCurrentSession();
		
		String hql="update OrderBean set trans_report=:stats  where order_ID=:delid";
		Query query = session.createQuery(hql);	
		query.setParameter("stats", "刪單成功");
		query.setParameter("delid", delorder_ID);
		query.executeUpdate();	
	}
	
//查詢
	public  ArrayList<OrderBean> selectOrder(String stock_ID) {
		    Session session = sessionFactory.getCurrentSession();
		    
			String hql = "from OrderBean where stock_ID=:id And trans_report!=:con";
			Query<OrderBean> query = session.createQuery(hql, OrderBean.class);		
			query.setParameter("con","刪單成功");
			query.setParameter("id", stock_ID);
			
			ArrayList<OrderBean> order_lists = (ArrayList<OrderBean>) query.list();	    
		return order_lists ;
	}	
//修改	
	public void updateOrder(String change_ID,String change_price,String change_quant,String change_total) {
		Session session = sessionFactory.getCurrentSession();
		
		String hql="update OrderBean set order_price=:price,order_quant=:quant,order_total=:total  where order_ID=:id";
		Query query = session.createQuery(hql);	
		query.setParameter("price", change_price);
		query.setParameter("quant", change_quant);
		query.setParameter("total", change_total);
		query.setParameter("id", change_ID);
		query.executeUpdate();		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
