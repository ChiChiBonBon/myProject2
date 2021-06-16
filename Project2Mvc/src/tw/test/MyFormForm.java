package tw.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
public class MyFormForm {
	

	
	
	@GetMapping("/myFormformJsp")
	public String mainFormform(Model m) {
		m.addAttribute("myBeanX", new MyBean());
		
		return "test/myFormformJsp";
	}
	
	
	@PostMapping("/formPrint")
	public void formPrint(@ModelAttribute MyBean xxxx, BindingResult result) {
		
		if(result.hasErrors()) {
			System.out.println(result);
		}else {			
			System.out.println(xxxx.getId());
			System.out.println(xxxx.getStr());
		}
		
	}
	
}
