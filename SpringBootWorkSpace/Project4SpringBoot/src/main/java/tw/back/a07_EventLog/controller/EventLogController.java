package tw.back.a07_EventLog.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import tw.back.a06_Company.bean.ProfitAnalysis_6;
import tw.back.a07_EventLog.bean.AuthorityType_7;
import tw.back.a07_EventLog.bean.EventLog_7;
import tw.back.a07_EventLog.bean.SeverityType_7;
import tw.back.a07_EventLog.model.AuthorityDao;
import tw.back.a07_EventLog.model.EventLogDao;
import tw.back.a07_EventLog.model.SeverityDao;

@Controller
@RequestMapping("/back/eventLog")
public class EventLogController {
	
	@Autowired
	SeverityDao severityDao;
	@Autowired
	AuthorityDao authorityDao;
	@Autowired
	EventLogDao eventLogDao;
	
	@GetMapping("/Main")
	public String cBasicMain(Model m) {		
		return "/back/jsp/7_EventLog/eventLog";
	}
	
	@GetMapping("/initData")
	public @ResponseBody Boolean initData() {
		// 初始化資料 -- EventLog
		Boolean result = true;
		try {
			initSeverity();
			initAuthority();
		} catch (Exception e) {
			result = false; 
		}
		
		return result;
		
	}
	
	@GetMapping("/showAllData")
	public @ResponseBody List<EventLog_7> showAllData() {
		return eventLogDao.selectAll();
	}
	
	@PostMapping("/filter" )
	public @ResponseBody List<EventLog_7> filter(@RequestParam String startDate,
												 @RequestParam String severityType,
												 @RequestParam String authorityType
			) {
		
		List<EventLog_7> lists = eventLogDao.filter(startDate, severityType, authorityType);
		return lists;
	}
	
	@ModelAttribute("severityList")
	public List<SeverityType_7> selectAllSeverity(){
		return severityDao.selectAll();
	}
	
	@ModelAttribute("authorityList")
	public List<AuthorityType_7> selectAllAuthority(){
		return authorityDao.selectAll();
	}
	
	
	public void initSeverity() {
		List<String> severityList = new ArrayList<String>();
		severityList.add("success");
		severityList.add("danger");
		severityList.add("info");
		
		for(String type : severityList) {

			SeverityType_7 select = severityDao.select(type);
			
			if(select == null) {
				SeverityType_7 bean = new SeverityType_7();
				bean.setSeverityType(type);
				severityDao.insert(bean);
			}
		}
	}
	
	public void initAuthority() {
		List<String> authorityList = new ArrayList<String>();
		authorityList.add("admin");
		authorityList.add("user");
		authorityList.add("unknow");
		
		for(String type : authorityList) {
			AuthorityType_7 select = authorityDao.select(type);
			if(select == null) {
				AuthorityType_7 bean = new AuthorityType_7();
				bean.setAuthorityType(type);
				authorityDao.insert(bean);
			}
		}
	}
	
	
	
}
