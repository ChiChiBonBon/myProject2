package tw.back.a07_EventLog.model;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tw.back.a07_EventLog.bean.AuthorityType_7;
import tw.back.a07_EventLog.bean.SeverityType_7;

@Repository
@Transactional
public class SeverityDao {
	
	@Autowired
	EntityManager em;
	
	public void insert(SeverityType_7 bean) {
		em.persist(bean);
	}
	
	public SeverityType_7 select(String type) {
		return em.find(SeverityType_7.class, type);
	}
	
	@SuppressWarnings("unchecked")
	public List<SeverityType_7> selectAll(){
		String sql = "from SeverityType_7";
		return em.createQuery(sql).getResultList();
	}
}
