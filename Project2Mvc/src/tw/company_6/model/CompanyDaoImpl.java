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
public class CompanyDaoImpl implements CompanyDao {

	@Autowired
	@Qualifier("sessionFactory")
	public SessionFactory sessionFactory;

	@Override
	public List<Company_6> selectAll() {
		Session session = sessionFactory.getCurrentSession();
		Query<Company_6> query = session.createQuery("from Company_6", Company_6.class);
		return query.list();
	}

	@Override
	public Company_6 select(String accNo) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Company_6.class, accNo);
	}

	@Override
	public boolean insert(Company_6 bean) {
		Session session = sessionFactory.getCurrentSession();
		Company_6 resultBean = select(bean.getBusiness_Accounting_NO());
		if (resultBean == null) {
			session.save(bean);
			return true;
		}
		return false;
	}

	@Override
	public boolean update(Company_6 bean) {
		String business_Accounting_NO = bean.getBusiness_Accounting_NO();
		long capital_Stock_Amount = bean.getCapital_Stock_Amount();
		String company_Location = bean.getCompany_Location();
		String company_Name = bean.getCompany_Name();
		String responsible_Name = bean.getResponsible_Name();

		Company_6 resultBean = select(business_Accounting_NO);
		if (resultBean != null) {
			resultBean.setBusiness_Accounting_NO(business_Accounting_NO);
			resultBean.setCapital_Stock_Amount(capital_Stock_Amount);
			resultBean.setCompany_Location(company_Location);
			resultBean.setCompany_Name(company_Name);
			resultBean.setResponsible_Name(responsible_Name);
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(String accNo) {
		Session session = sessionFactory.getCurrentSession();

		Company_6 resultBean = select(accNo);
		if (resultBean != null) {
			session.delete(resultBean);
			return true;
		}
		return false;
	}

}
