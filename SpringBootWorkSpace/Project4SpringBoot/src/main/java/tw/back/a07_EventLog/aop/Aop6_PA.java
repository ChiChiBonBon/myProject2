package tw.back.a07_EventLog.aop;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import tw.back.a06_Company.bean.ProfitAnalysis_6;
import tw.back.a07_EventLog.bean.AuthorityType_7;
import tw.back.a07_EventLog.bean.EventLog_7;
import tw.back.a07_EventLog.bean.SeverityType_7;
import tw.back.a07_EventLog.model.EventLogDao;

@Aspect
@Component
public class Aop6_PA {
	
	@Autowired
	EventLogDao eventLogDao;
	
	@Pointcut(value = "execution(* tw.back.a06_Company.controller.PAcontroller.insertData(..))")
	public void pointCut1() {}
	
	@Pointcut(value = "execution(* tw.back.a06_Company.controller.PAcontroller.deleteAll(..))")
	public void pointCut2() {}
	
	@Pointcut(value = "execution(* tw.back.a06_Company.controller.PAcontroller.delete(..))")
	public void pointCut3() {}
	
	@AfterReturning(pointcut = "pointCut1()", returning = "result")
	public void logInsertData(JoinPoint point, Object result) {	
		EventLog_7 log = new EventLog_7();
		AuthorityType_7 auto = new AuthorityType_7();
		SeverityType_7 severity = new SeverityType_7();
			
		auto.setAuthorityType("unknow");
		String person = "Admin";
		severity.setSeverityType("success");
		
		MultipartFile file = (MultipartFile) point.getArgs()[0];
		String content = file.getOriginalFilename() + " - 進行檔案上傳";
		
		log.setDate(new Date());
		log.setAuthority(auto);
		log.setPerson(person);
		log.setSeverity(severity);
		log.setContent(content);
		
		eventLogDao.insert(log);
	}
	
	@AfterReturning(pointcut = "pointCut2()", returning = "result")
	public void logDeleteAll(JoinPoint point, Object result) {	
		EventLog_7 log = new EventLog_7();
		AuthorityType_7 auto = new AuthorityType_7();
		SeverityType_7 severity = new SeverityType_7();
			
		auto.setAuthorityType("unknow");
		String person = "Admin";
		severity.setSeverityType("success");
		
		
		String content = "基本面 - 進行資料刪除";
		
		log.setDate(new Date());
		log.setAuthority(auto);
		log.setPerson(person);
		log.setSeverity(severity);
		log.setContent(content);
		
		eventLogDao.insert(log);
	}
	
	@AfterReturning(pointcut = "pointCut3()", returning = "result")
	public void logDelete(JoinPoint point, Object result) {	
		EventLog_7 log = new EventLog_7();
		AuthorityType_7 auto = new AuthorityType_7();
		SeverityType_7 severity = new SeverityType_7();
			
		auto.setAuthorityType("unknow");
		String person = "Admin";
		severity.setSeverityType("success");
		
		
		String content = point.getArgs()[0] + " - 進行資料刪除";
		
		log.setDate(new Date());
		log.setAuthority(auto);
		log.setPerson(person);
		log.setSeverity(severity);
		log.setContent(content);
		
		eventLogDao.insert(log);
	}
	
}
