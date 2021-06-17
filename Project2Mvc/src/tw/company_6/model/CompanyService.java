package tw.company_6.model;

import java.util.List;

import tw.company_6.bean.Company_6;

public interface CompanyService {

	public List<Company_6> selectAll();
	public Company_6 select(String accNo);
	public boolean insert(Company_6 bean);
	public boolean update(Company_6 bean);
	public boolean delete(String accNo);
}
