package tw.back.a06_Company.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.back.a06_Company.bean.ProfitAnalysis_6;

@Service
public class PAservice {
	
	@Autowired
	public PAdao padao;
	
	public Boolean insert(ProfitAnalysis_6 bean) {
		return padao.insert(bean);
	}
	
	public List<ProfitAnalysis_6> selectAll(){
		return padao.selectAll();
	}
	
	public Boolean deleteAll() {
		return padao.deleteAll();
	}
	
	public Boolean delete(Integer company_ID) {
		return padao.delete(company_ID);
	}
}
