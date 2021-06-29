package tw.back.a06_Company.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tw.back.a06_Company.bean.ProfitAnalysis_6;

@Transactional
@Repository
public class PAdao {
	
	@Autowired
	EntityManager em;
	
	public Boolean insert(ProfitAnalysis_6 bean) {
		Boolean result = false;
		try {
			em.persist(bean);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public List<ProfitAnalysis_6> selectAll(){
		String sql = "from ProfitAnalysis_6";
		return em.createQuery(sql).getResultList();
	}
	
	public ProfitAnalysis_6 select(Integer company_ID) {
		ProfitAnalysis_6 bean = em.find(ProfitAnalysis_6.class, company_ID);
		return bean;
	}
	
	
	public Boolean deleteAll() {
		Boolean result = false;
		String sql = "delete from ProfitAnalysis_6";
		
		try {
			em.createQuery(sql).executeUpdate();
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public Boolean delete(Integer company_ID) {
		Boolean result = true;
		ProfitAnalysis_6 bean = em.find(ProfitAnalysis_6.class, company_ID);
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
	
	public Boolean update(ProfitAnalysis_6 bean) {
		Boolean result = true;
		try {
			em.merge(bean);
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}
		
		return result;
	}
	
}
