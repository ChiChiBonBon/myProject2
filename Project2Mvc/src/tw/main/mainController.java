package tw.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class mainController {
	
	@GetMapping("/")
	public String mainDashBoard() {
		return "0_dashboard";
	}
	
}
