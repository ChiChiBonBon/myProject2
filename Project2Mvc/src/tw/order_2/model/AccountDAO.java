package tw.order_2.model;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;


@Repository("accountDao")
@Transactional
public class AccountDAO {

	@Autowired 
	@Qualifier("sessionFactory")
    private SessionFactory sessionFactory;
	
	
	public  Account insert(Account user) {
		Session session = sessionFactory.getCurrentSession();
		Account insertaccount = session.get(Account.class, user.getStock_ID());
		
		if(insertaccount==null) {
			session.save(user);
			return user;
		}
		return null;
	}
	
	
	
	
	public boolean checkLogin(Account users) {
		Session session = sessionFactory.getCurrentSession();
		
		String hqlstr = "from Account where username=:user and userpwd=:pwd";
		Query<Account> query = session.createQuery(hqlstr, Account.class);
		
		query.setParameter("user", users.getUser_account());
		query.setParameter("pwd", users.getUser_password());
		
		Account result = query.uniqueResult();
		
		if(result!=null) {
			return true;
		}
		
		return false;
	}
	
	
	
	
	
	
	
	
	
	
}
