package tw.front.a00_DashBoard;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class frontController {

	
	@GetMapping("/front")
	public String frontMain() {
		return "front/jsp/0_DashBoard/index";
	}
	
	@GetMapping("/front/About")
	public String aboutMain() {
		return "front/jsp/0_DashBoard/about";
	}
}
