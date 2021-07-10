package tw.back.a06_Company.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.back.a06_Company.bean.CompanyBasic_6;

@Service
public class CBasicService {
	
	@Autowired
	CBasicDao dao;
	
	public void insertCBasic(CompanyBasic_6 bean) {
		dao.insertCBasic(bean);
	}
	
}
