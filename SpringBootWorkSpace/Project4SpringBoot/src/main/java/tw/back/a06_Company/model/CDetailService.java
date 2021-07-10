package tw.back.a06_Company.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.back.a06_Company.bean.CompanyDetail_6;

@Service
public class CDetailService {
	
	@Autowired
	CDetailDao dao;
	
	public void insertCDetail(CompanyDetail_6 bean) {
		dao.insertCDetail(bean);
	}
	
	public CompanyDetail_6 select(String stock){
		return dao.select(stock);
	}
	
	public Boolean update(CompanyDetail_6 bean){
		return dao.update(bean);
	}
}
