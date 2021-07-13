package tw.back.a04_Drawlost.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import tw.back.a04_Drawlost.model.Drawlots;
import tw.back.a04_Drawlost.service.DrawableServiceInterface;
import tw.back.a04_Drawlost.service.DrawlotsService;
import tw.back.a06_Company.bean.ProfitAnalysis_6;
import tw.back.a06_Company.tools.FileTool;
import tw.back.a06_Company.tools.TimeTool;

@Controller
public class DrawlotsController {
	
	@Autowired
	private DrawableServiceInterface drawlotsService = new DrawlotsService();

	@GetMapping(value = "/back/drawlots")
	public String drawlotsMain() {
		return "back/jsp/4_Drawlost/drawlotsManagement";
	}
	
//	@GetMapping(value = "/back/subscription")
//	public String subscriptionMain() {
//		return "back/jsp/4_Drawlost/subscriptionManagement";
//	}
	
	@GetMapping(value = "/back/drawlots/login")
	public String drawlotsLogin() {
		return "back/jsp/4_Drawlost/logIn";
	}
	
	@GetMapping(value = "/back/drawlots/selectAll")
	public @ResponseBody List<Drawlots> drawlotsSelectAll() {
		return	drawlotsService.selectAll();
	}
	
	@GetMapping("/back/drawlots/deleteAll")
	public @ResponseBody Boolean deleteAll() {
		return drawlotsService.deleteAll();
	}

	@PostMapping("/back/drawlots/delete")
	public @ResponseBody Boolean delete(@RequestParam String id) {
		return drawlotsService.deleteOne(id);
	};
	
	@GetMapping("/back/drawlots/update/{id}")
	public String companyPaUpdateMain(@PathVariable String id, Model m) {
		Drawlots drawlots = drawlotsService.selectOne(id);
		m.addAttribute("bean", drawlots);
		return "back/jsp/4_Drawlost/DM_NewOrModified";
	}
}
