package tw.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyControllerInclude {

	@GetMapping("/6_company_insert_copy")
	public String company_insert_copy() {
		return "6_company_insert_copy";
	}
	
	@GetMapping("/table")
	public String table() {
		return "table";
	}
	
}
