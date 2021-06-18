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
			user.getStock_ID();
			user.getUser_account();
			user.getUser_password();
			session.save(user);
			return user;
	}
	
	
	
	
	public boolean checkLogin(Account users) {
		Session session = sessionFactory.getCurrentSession();
		
		String hqlstr = "from member where mber_acc=:user and mber_psd=:pwd";
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
