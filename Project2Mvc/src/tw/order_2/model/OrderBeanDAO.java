package tw.order_2.model;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository("orderDao")
@Transactional
public class OrderBeanDAO  {
	
	@Autowired 
	@Qualifier("sessionFactory")
	public SessionFactory sessionFactory;
	
//增刪查改
	public void insertOrder(OrderBean order_list) {
		System.out.println("testDAO");
		System.out.println(order_list);
		System.out.println(sessionFactory);
		Session session = sessionFactory.getCurrentSession();
		session.save(order_list);
	}
	
	
	
	
	
	
	
	
	public void deleteOrder(String delorder_ID) {
		
	}
	
	public  ArrayList<OrderBean> selectOrder(String stock_ID) {
		    ArrayList<OrderBean>  order_list = new ArrayList<>();
		    
		    Session session = sessionFactory.getCurrentSession();
			
			String hqlstr = "from member where mber_acc=:user and mber_psd=:pwd";
			Query<OrderBean> query = session.createQuery(hqlstr, OrderBean.class);
			OrderBean result = query.uniqueResult();
		    	    
		return order_list ;
	}
	
	public void updateOrder(String change_ID,String change_price,String change_quant,String change_total) {
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
