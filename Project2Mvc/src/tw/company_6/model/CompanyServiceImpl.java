package tw.company_6.model;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.company_6.bean.Company_6;



@Service("companyService")
@Transactional
public class CompanyServiceImpl implements CompanyService{
	
	@Autowired
	public CompanyDao companyDao;
	
	public CompanyServiceImpl() {

	}

//	public CompanyService(CompanyDao companyDao) {
//		this.companyDao = companyDao;
//	}

	public List<Company_6> selectAll(){
		return companyDao.selectAll();
	}
	
	public Company_6 select(String accNo) {
		return companyDao.select(accNo);
	}

	@Override
	public boolean insert(Company_6 bean) {
		
		return companyDao.insert(bean);
	}

	@Override
	public boolean update(Company_6 bean) {
		
		return companyDao.update(bean);
	}

	@Override
	public boolean delete(String accNo) {
		
		return companyDao.delete(accNo);
	}
}
