package tw.back.a07_EventLog.model;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tw.back.a07_EventLog.bean.AuthorityType_7;

@Repository
@Transactional
public class AuthorityDao {
	
	@Autowired
	EntityManager em;
	
	public void insert(AuthorityType_7 bean) {
		em.persist(bean);
	}
	
	public AuthorityType_7 select(String type) {
		return em.find(AuthorityType_7.class, type);
	}
}
