package tw.back.a07_EventLog.model;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tw.back.a07_EventLog.bean.EventLog_7;

@Repository
@Transactional
public class EventLogDao {
	
	@Autowired
	EntityManager em;
	
	public void insert(EventLog_7 bean) {
		em.persist(bean);
	}
	
	@SuppressWarnings("unchecked")
	public List<EventLog_7> selectAll(){
		String sql = "from EventLog_7";
		return em.createQuery(sql).getResultList();
	}
}
