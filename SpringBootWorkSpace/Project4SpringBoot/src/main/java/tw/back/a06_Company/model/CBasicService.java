package tw.back.a06_Company.model;

import java.util.List;

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
	
	public List<CompanyBasic_6> selectAll(){
		return dao.selectAll();
	}
	
	public CompanyBasic_6 select(String stock){
		return dao.select(stock);
	}
	
	public Boolean update(CompanyBasic_6 bean){
		return dao.update(bean);
	}
	
}
