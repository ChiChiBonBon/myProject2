package tw.back.a04_Drawlost.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DrawlotsController {

	@GetMapping(value = "/back/drawlots")
	public String drawlotsMain() {
		return "back/jsp/4_Drawlost/drawlotsInformation";
	}
	
	@GetMapping(value = "/back/drawlots/login")
	public String drawlotsLogin() {
		return "back/jsp/4_Drawlost/logIn";
	}
}
