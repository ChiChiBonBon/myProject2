package tw.back.a01_Member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tw.back.a01_Member.service.IAdminMemberService;
import tw.front.a01_Member.model.MemberBean;

@Controller
@RequestMapping("/admin_1")
public class AdminController {
	
	@Autowired
	private IAdminMemberService adminservice;
	
//	回傳json資料	
//	@GetMapping(value = "/goAdminMember_1", produces = "application/json; charset=UTF-8")
//	public @ResponseBody List<MemberBean> processHrefAdminMember() {
//		List<MemberBean> list= adminservice.admin_selectAllMember();
//		return list;	
//	}
	
	@GetMapping(value = "/goAdminMember_1")
	public String processHrefAdminMember(Model m) {
		List<MemberBean> list= adminservice.admin_selectAllMember();
		m.addAttribute("AllMember", list);
		return "back/jsp/1_Member/admin_member_1";	
	}
	
	
	@PostMapping("/admin_member_1")
	public String processAmdinMember() {
		return null;
	}

//	處理工作項目 可以增加或減少
	@PostMapping("/admin_update_job_1")
	public String processAdminJobs() {
		return null;
	}
	
	
	@PostMapping("/admin_change_memb_status_1")
	public String processAdminChangeMembStatus() {
		return null;
	}

}
