package tw.company_6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import tw.company_6.bean.Company_6;
import tw.company_6.model.CompanyDaoImpl;
import tw.company_6.model.CompanyService;
import tw.company_6.model.CompanyServiceImpl;

@Controller
public class CompanyController {
	
	@Autowired
	private CompanyService service;
//	CompanyDao dao = new CompanyDao();
//	CompanyService service = new CompanyService(dao);
	
	
	@GetMapping(value = "/company")
	public String main() {
		return "6_company_select";
	}
	                      
	@GetMapping(value = "/companyController")
	public @ResponseBody List<Company_6> selectAll() {
		List<Company_6> listAll = service.selectAll();
		return listAll;
	}
	
	@GetMapping(value = "/companyController/{accNo}")
	public @ResponseBody Company_6 select(@PathVariable String accNo) {
		Company_6 bean = service.select(accNo);
		return bean;
	}
	
}
