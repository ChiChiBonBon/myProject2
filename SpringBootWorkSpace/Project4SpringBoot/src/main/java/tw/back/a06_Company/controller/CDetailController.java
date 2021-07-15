package tw.back.a06_Company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import tw.back.a06_Company.bean.CompanyBasic_6;
import tw.back.a06_Company.bean.CompanyDetail_6;
import tw.back.a06_Company.bean.ProfitAnalysis_6;
import tw.back.a06_Company.model.CBasicService;
import tw.back.a06_Company.model.CDetailService;

@Controller
@RequestMapping("/back/cDetail")
public class CDetailController {
	
	@Autowired
	public CBasicService cBasicService;
	
	@Autowired
	public CDetailService cDetailService;
	
	@GetMapping("/Main/{stock}")
	public String cDetailMain(@PathVariable String stock, Model m) {
		CompanyDetail_6 bean = cDetailService.select(stock);
		m.addAttribute("bean", bean);
		return "/back/jsp/6_Company/companyBasicDetail";
	}
	
	@PostMapping(value="/Update" , consumes = "application/json")
	public @ResponseBody Boolean companyPaUpdate(@RequestBody CompanyDetail_6 beanDetail, BindingResult result) {
		
		Boolean resultBoolean = true;
		
		if(result.hasErrors()) {
			System.out.println("Error");
			resultBoolean = false;
			return resultBoolean;
		}
		// update beanDetail
		resultBoolean = cDetailService.update(beanDetail);
		// update beanBasic
		CompanyBasic_6 beanBasic = cBasicService.select(beanDetail.getStock());
		beanBasic.setBusiness_Accounting_NO(beanDetail.getBusiness_Accounting_NO());
		beanBasic.setCompany_Name(beanDetail.getCompany_Name());
		beanBasic.setResponsible_Name(beanDetail.getChairman_Board());
		beanBasic.setCompany_Location(beanDetail.getCompany_Location());
		cBasicService.update(beanBasic);
		
		
		
		return resultBoolean;
	}
}
