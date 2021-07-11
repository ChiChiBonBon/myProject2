package tw.front.a06_Company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import tw.back.a06_Company.bean.CompanyDetail_6;
import tw.back.a06_Company.model.CBasicService;
import tw.back.a06_Company.model.CDetailService;

@Controller
@RequestMapping("/front/cTableDetail")
public class CompanyTableDetail {

	@Autowired
	public CBasicService cBasicService;
	
	@Autowired
	public CDetailService cDetailService;
	
	@GetMapping("/Main/{stock}")
	public String cTableDetailMain(@PathVariable String stock, Model m) {
		CompanyDetail_6 bean = cDetailService.select(stock);
		m.addAttribute("bean", bean);
		return "/front/jsp/6_Company/CompanyTableDetail";
	}
}
