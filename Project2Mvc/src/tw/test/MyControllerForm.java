package tw.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class MyControllerForm {
	
	@GetMapping("/myMainForm")
	public String myMainForm() {

		return "test/myMainForm";
	}
	
	@PostMapping(value =  "/formData")
	public void myMainPar(
			Model m,
			@RequestParam(name = "account") String account,
			@RequestParam String pwd,
			@RequestParam String memo,
			@RequestParam String gen,
			@RequestParam String[] hobby,
			@RequestParam String[] city,
			@RequestParam MultipartFile upload
			) {
		
		System.out.println(account);
		System.out.println(pwd);
		System.out.println(memo);
		System.out.println(gen);
		System.out.println(hobby);
		System.out.println(hobby[0]);
		System.out.println(city);
		System.out.println(city[0]);
		System.out.println(upload);
	
		
	
	}
	
}
