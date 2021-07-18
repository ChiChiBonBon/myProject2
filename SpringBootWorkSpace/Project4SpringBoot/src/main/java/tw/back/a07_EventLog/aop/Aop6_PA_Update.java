package tw.back.a07_EventLog.aop;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tw.back.a06_Company.bean.ProfitAnalysis_6;
import tw.back.a07_EventLog.bean.AuthorityType_7;
import tw.back.a07_EventLog.bean.EventLog_7;
import tw.back.a07_EventLog.bean.SeverityType_7;
import tw.back.a07_EventLog.model.EventLogDao;


@Aspect
@Component
public class Aop6_PA_Update {
	
	@Autowired
	EventLogDao eventLogDao;
	

	@Pointcut(value = "execution(* tw.back.a06_Company.controller.PA_UpdateController.companyPaUpdateMain(..))")
	public void pointCut1() {}
	
	@Pointcut(value = "execution(* tw.back.a06_Company.controller.PA_UpdateController.companyPaUpdate(..))")
	public void pointCut2() {}
	
	
	@AfterReturning(pointcut = "pointCut1()", returning = "result")
	public void logCompanyPaUpdateMain(JoinPoint point, Object result) {	
		EventLog_7 log = new EventLog_7();
		AuthorityType_7 auto = new AuthorityType_7();
		SeverityType_7 severity = new SeverityType_7();
			
		auto.setAuthorityType("unknow");
		String person = "Admin";
		severity.setSeverityType("info");
		String content = point.getArgs()[0] + " - 進入到更新頁面";
		
		log.setDate(new Date());
		log.setAuthority(auto);
		log.setPerson(person);
		log.setSeverity(severity);
		log.setContent(content);
		
		eventLogDao.insert(log);
	}
	
	@AfterReturning(pointcut = "pointCut2()", returning = "result")
	public void logcompanyPaUpdate(JoinPoint point, Object result) {	
		EventLog_7 log = new EventLog_7();
		AuthorityType_7 auto = new AuthorityType_7();
		SeverityType_7 severity = new SeverityType_7();
			
		auto.setAuthorityType("unknow");
		String person = "Admin";
		severity.setSeverityType("success");
		
		ProfitAnalysis_6 bean = (ProfitAnalysis_6) point.getArgs()[0];
		String content = bean.getCompany_Name() + "(" +bean.getCompany_ID() + ")" + " - 進行更新";
		
		log.setDate(new Date());
		log.setAuthority(auto);
		log.setPerson(person);
		log.setSeverity(severity);
		log.setContent(content);
		
		eventLogDao.insert(log);
	}

	@AfterThrowing(pointcut = "pointCut1()", throwing = "e")
	public void errorCompanyPaUpdateMain(JoinPoint point, Throwable e) {
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
	
	@AfterThrowing(pointcut = "pointCut2()", throwing = "e")
	public void errorcompanyPaUpdate(JoinPoint point, Throwable e) {
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
