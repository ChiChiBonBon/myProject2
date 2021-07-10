package tw.back.a06_Company.model;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tw.back.a06_Company.bean.CompanyDetail_6;

@Transactional
@Repository
public class CDetailDao {
	
	@Autowired
	EntityManager em;
	
	public void insertCDetail(CompanyDetail_6 bean) {
		em.persist(bean);
	}
	
	
}
