package tw.back.a06_Company.model;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tw.back.a06_Company.bean.CompanyBasic_6;
import tw.back.a06_Company.bean.CompanyDetail_6;

@Transactional
@Repository
public class CDetailDao {
	
	@Autowired
	EntityManager em;
	
	public void insertCDetail(CompanyDetail_6 bean) {
		em.persist(bean);
	}
	
	public CompanyDetail_6 select(String stock){
		return em.find(CompanyDetail_6.class, stock);
	}
	
	public Boolean update(CompanyDetail_6 bean){
		Boolean result = true;
		try {
			em.merge(bean);
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}
		
		return result;
	}
	
	public Boolean delete(String stock) {
		Boolean result = true;
		CompanyDetail_6 bean = em.find(CompanyDetail_6.class, stock);
		if(bean != null) {
			try {
				em.remove(bean);
			} catch (Exception e) {
				e.printStackTrace();
				result = false;
			}
		}
		return result;
	}
	
	public Boolean deleteAll() {
		Boolean result = false;
		String sql = "delete from CompanyDetail_6";
		
		try {
			em.createQuery(sql).executeUpdate();
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
}
