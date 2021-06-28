package tw.back.a06_Company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CompanyController {

	@GetMapping("/company")
	public String companyController() {
		return "back/jsp/6_Company/company";
	}
}
