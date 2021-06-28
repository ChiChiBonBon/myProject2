package tw.back.a00_DashBoard;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashBoardController {
	
	@GetMapping("/")
	public String dashBoard() {
		return "back/jsp/0_DashBoard/index";
	}
}
