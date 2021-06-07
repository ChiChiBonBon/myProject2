package tw.company_6.model;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tw.company_6.bean.Company_6;

@Repository
@Transactional
public class CompanyDao implements CompanyDaoInt{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Company_6> selectAll() {
		Session session = sessionFactory.getCurrentSession();
		Query<Company_6> query = session.createQuery("from company_6", Company_6.class);
		return query.list();
	}
	
	@Override
	public Company_6 select(String accNo) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Company_6.class, accNo);
	}

	

}
