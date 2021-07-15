package tw.back.a07_EventLog.Util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.back.a07_EventLog.bean.AuthorityType_7;
import tw.back.a07_EventLog.bean.SeverityType_7;
import tw.back.a07_EventLog.model.AuthorityDao;
import tw.back.a07_EventLog.model.SeverityDao;

@Service
public class InitializationData {
	
	@Autowired
	SeverityDao severityDao;
	@Autowired
	AuthorityDao authorityDao;
	
	
	public void insertInitDataSeverityType() {
		
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
	
	public void insertInitDataAuthorityType() {
	
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
