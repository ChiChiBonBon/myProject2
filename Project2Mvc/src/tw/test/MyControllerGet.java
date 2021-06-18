package tw.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MyControllerGet {
	

	
	@GetMapping("/myMainParGet/{asdf}")
	public String myMainPar(@PathVariable String asdf, Model m) {
		
		m.addAttribute("Str", asdf);
		return "test/myMainA";
	}
	
}
