package tw.front.a06_Company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/front/cTable")
public class CompanyTable {

	@GetMapping("/Main")
	public String cTableMain() {
		return "/front/jsp/6_Company/CompanyTable";
	}
}
