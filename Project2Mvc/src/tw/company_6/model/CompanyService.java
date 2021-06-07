package tw.company_6.model;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import tw.company_6.bean.Company_6;



@Service("companyService")
public class CompanyService {
	
//	@Autowired @Qualifier("companyDao")
	private CompanyDao companyDao;
	
	public CompanyService() {

	}
	
	public CompanyService(CompanyDao companyDao) {
		this.companyDao = companyDao;
	}

	public List<Company_6> selectAll(){
		return companyDao.selectAll();
	}
	
	public Company_6 select(String accNo) {
		return companyDao.select(accNo);
	}
}
