package tw.company_6.model;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import tw.company_6.bean.Company_6;

@Repository("companyDao")
@Transactional
public class CompanyDao implements CompanyDaoInt{
	
	@Autowired @Qualifier("sessionFactory")
	public SessionFactory sessionFactory;
	
	@Override
	public List<Company_6> selectAll() {
		Session session = sessionFactory.openSession();
		Query<Company_6> query = session.createQuery("from company_6", Company_6.class);
		return query.list();
	}
	
	@Override
	public Company_6 select(String accNo) {
		Session session = sessionFactory.openSession();
		return session.get(Company_6.class, accNo);
	}

	

}
