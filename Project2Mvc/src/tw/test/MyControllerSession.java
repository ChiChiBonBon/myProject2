package tw.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes(names = {"myBeanY"})
public class MyControllerSession {
	
	
	@ModelAttribute("myBeanY")
	public MyBean myBeanY() {
	    return new MyBean(100, "aaa");
	}
	
	
	@GetMapping("/getSession")
	public void getSession(@ModelAttribute(name = "myBeanY") MyBean yyyy, 
			               @ModelAttribute(name = "testX") MyBean xxxx) {
		
		System.out.println(yyyy.getId());
		System.out.println(xxxx.getId());
	}
	
}
