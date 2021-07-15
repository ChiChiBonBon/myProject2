package tw.back.a07_EventLog.model;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tw.back.a06_Company.tools.TimeTool;
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

	public List<EventLog_7> filter(String startDate, String severityType, String authorityType) {
		
		String severityString = "  log.severity.severityType like  :severity";
		String authorityString = " and  log.authority.authorityType like  :authority";
		String dateString = "";
		if(!startDate.equals("all")) {
			dateString = " and  log.date =  :date";
		}
		
		
		String sql = "from EventLog_7 log where"  + severityString + authorityString + dateString;

		TypedQuery<EventLog_7> query = em.createQuery(sql, EventLog_7.class);

		if(!startDate.equals("all")) {
			Date dateX = TimeTool.stringToDate(startDate);
			query.setParameter("date", dateX);
		}
		if(severityType.equals("all")) {
			severityType = "";
		}
		if(authorityType.equals("all")) {
			authorityType = "";
		}

		query.setParameter("severity", severityType + "%");
		query.setParameter("authority", authorityType + "%");
		
		return query.getResultList();
	}
}
