package tw.back.a07_EventLog.aop;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import tw.back.a06_Company.bean.ProfitAnalysis_6;
import tw.back.a07_EventLog.bean.AuthorityType_7;
import tw.back.a07_EventLog.bean.EventLog_7;
import tw.back.a07_EventLog.bean.SeverityType_7;
import tw.back.a07_EventLog.model.EventLogDao;


@Aspect
@Component
public class Aop6_Company_PA {
	
	@Autowired
	EventLogDao eventLogDao;
	

	@Pointcut(value = "execution(* tw.back.a06_Company.controller.PA_UpdateController.companyPaUpdateMain*(..))")
	public void pointCut1() {}
	
	@AfterReturning(pointcut = "pointCut1()", returning = "result")
	public void printLog(JoinPoint point, Object result) {	
		EventLog_7 log = new EventLog_7();
		AuthorityType_7 auto = new AuthorityType_7();
		SeverityType_7 severity = new SeverityType_7();
			
		auto.setAuthorityType("unknow");
		String person = "testAdmin";
		severity.setSeverityType("info");
		String content = "進入到" + point.getArgs()[0] + "的更新頁面";
		
		log.setDate(new Date());
		log.setAuthority(auto);
		log.setPerson(person);
		log.setSeverity(severity);
		log.setContent(content);
		
		eventLogDao.insert(log);
	}
	


	@AfterThrowing(pointcut = "pointCut1()", throwing = "e")
	public void logThrow(JoinPoint point, Throwable e) {
		EventLog_7 log = new EventLog_7();
		AuthorityType_7 auto = new AuthorityType_7();
		SeverityType_7 severity = new SeverityType_7();
			
		auto.setAuthorityType("unknow");
		String person = "testAdmin";
		severity.setSeverityType("danger");
		String content = e.toString();
		
		log.setDate(new Date());
		log.setAuthority(auto);
		log.setPerson(person);
		log.setSeverity(severity);
		log.setContent(content);
		
		eventLogDao.insert(log);
		
		
        
	}
	
}
