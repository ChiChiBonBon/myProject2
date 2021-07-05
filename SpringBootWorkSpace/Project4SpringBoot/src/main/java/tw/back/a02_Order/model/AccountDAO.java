package tw.back.a02_Order.model;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

@Repository("accountDao")
@Transactional
public class AccountDAO {

	@Autowired 
    private EntityManager session;
	
//刪除
	public void deleteAcc(String stock_ID) {
		
		String hql="update Account set mber_auth=:auth mber_quota=:quota where stock_ID=:id";
		Query query = (Query) session.createQuery(hql);	
		query.setParameter("id", stock_ID);
		query.setParameter("auth", "註銷戶");
		query.setParameter("quota",0);
		query.executeUpdate();	
	}

//查詢
	public  ArrayList<Account> selectAcc(String stock_ID) {
	    
		String hql = "from Account where stock_ID=:id ";
		Query<Account> query = (Query<Account>) session.createQuery(hql, Account.class);		
		query.setParameter("id", stock_ID);
		
		ArrayList<Account> acc_lists = (ArrayList<Account>) query.list();	 
		return acc_lists ;
	}
	
//修改
	public void updateAuth(String change_ID,String change_auth,String change_quota) {
		
		String hql="update Account set mber_auth=:auth,mber_quota=:quota where stock_ID=:id";
		Query query = (Query) session.createQuery(hql);	
		query.setParameter("id", change_ID);
		query.setParameter("auth", change_auth);
		query.setParameter("quota", change_quota);
		query.executeUpdate();		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
