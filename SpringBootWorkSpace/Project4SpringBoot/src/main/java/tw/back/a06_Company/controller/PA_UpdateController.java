package tw.back.a06_Company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import tw.back.a06_Company.bean.ProfitAnalysis_6;
import tw.back.a06_Company.model.PAservice;

@Controller
public class PA_UpdateController {

	@Autowired
	public PAservice paService;
	
	@GetMapping("/paUpdate/{id}")
	public String companyPaUpdateMain(@PathVariable String id, Model m) {
		ProfitAnalysis_6 bean = paService.select(Integer.parseInt(id));
		m.addAttribute("bean", bean);
		return "back/jsp/6_Company/companyPa_Update";
	}
	
	@PutMapping(value="/paUpdate" , consumes = "application/json")
	public @ResponseBody Boolean companyPaUpdate(@RequestBody ProfitAnalysis_6 bean, BindingResult result) {
		Boolean resultBoolean = true;
		
		if(result.hasErrors()) {
			resultBoolean = false;
			return resultBoolean;
		}
		
		resultBoolean = paService.update(bean);
		
		return resultBoolean;
	}
	
	
}
