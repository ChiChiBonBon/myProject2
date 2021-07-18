package tw.back.a07_EventLog.aop;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tw.back.a07_EventLog.bean.AuthorityType_7;
import tw.back.a07_EventLog.bean.EventLog_7;
import tw.back.a07_EventLog.bean.SeverityType_7;
import tw.back.a07_EventLog.model.EventLogDao;

@Aspect
@Component
public class Aop_AllFront {
	
	@Autowired
	EventLogDao eventLogDao;
	
	@Pointcut(value = "execution(* tw.front..*.*(..))")
	public void pointCut1() {}
	
	@AfterThrowing(pointcut = "pointCut1()", throwing = "e")
	public void errorFront(JoinPoint point, Throwable e) {
		EventLog_7 log = new EventLog_7();
		AuthorityType_7 authority = new AuthorityType_7();
		SeverityType_7 severity = new SeverityType_7();
			
		authority.setAuthorityType("unknow");
		String person = "Admin";
		severity.setSeverityType("danger");
		
		String classString = point.getTarget().getClass().toString();
		String functionName = point.getSignature().getName();
		
		String content = "[" + classString + "]" + " [" + functionName + "] " +   e.toString();
		
		log.setDate(new Date());
		log.setAuthority(authority);
		log.setPerson(person);
		log.setSeverity(severity);
		log.setContent(content);
		
		eventLogDao.insert(log);      
	}
}
