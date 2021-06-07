package tw.company_6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@GetMapping(value = "/companyUpdate")
	public String mainUpdate() {
		return "6_company_update";
	}
	
	@GetMapping(value = "/companyInsert")
	public String mainInsert(Model m) {
		Company_6 bean = new Company_6();
		m.addAttribute("bean", bean);
		return "6_company_insert";
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
	
	@PostMapping(value = "/companyController", produces = "text/plain; charset=UTF-8")
	public String insert(@ModelAttribute Company_6 bean, BindingResult result, Model m) {
		if(result.hasErrors()) {
			return "";
		}
		boolean resultBean = service.insert(bean);
		System.out.println(resultBean);
		System.out.println(bean);
		if(resultBean) {			
			m.addAttribute("cAcc", bean.getBusiness_Accounting_NO());
		}else {
			m.addAttribute("cAcc", "新增失敗");
		}
		return "6_company_select"; 
	}
	
}
