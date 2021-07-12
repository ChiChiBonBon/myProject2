package tw.back.a04_Drawlost.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import tw.back.a04_Drawlost.model.Drawlots;
import tw.back.a04_Drawlost.service.DrawableServiceInterface;
import tw.back.a04_Drawlost.service.DrawlotsService;

@Controller
public class DrawlotsController {
	
	@Autowired
	private DrawableServiceInterface drawlotsService = new DrawlotsService();

	@GetMapping(value = "/back/drawlots")
	public String drawlotsMain() {
		return "back/jsp/4_Drawlost/drawlotsManagement";
	}
	
	@GetMapping(value = "/back/subscription")
	public String subscriptionMain() {
		return "back/jsp/4_Drawlost/subscriptionManagement";
	}
	
	@GetMapping(value = "/back/drawlots/login")
	public String drawlotsLogin() {
		return "back/jsp/4_Drawlost/logIn";
	}
	
	@GetMapping(value = "/back/drawlots/selectAll")
	public @ResponseBody List<Drawlots> drawlotsSelectAll() {
		return	drawlotsService.selectAll();
	}
}
