package tw.company_6.model;

import java.util.List;

import tw.company_6.bean.Company_6;

public interface CompanyDao {
	
	public List<Company_6> selectAll();
	public Company_6 select(String accNo);
	
}
