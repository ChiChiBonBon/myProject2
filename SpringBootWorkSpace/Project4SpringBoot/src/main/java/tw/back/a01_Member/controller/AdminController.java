package tw.back.a01_Member.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import tw.back.a01_Member.model.MemberJobs;
import tw.back.a01_Member.service.IAdminMemberService;
import tw.front.a01_Member.model.MemberBean;

@Controller
@RequestMapping("/back/admin_1")
public class AdminController {
	
	@Autowired
	private IAdminMemberService adminservice;
	
//	回傳json資料	
	@GetMapping(value = "/findAdminAllMember_1", produces = "application/json; charset=UTF-8")
	public @ResponseBody Map<String, Object> getAdminAllMember() {
		Map<String, Object> map= adminservice.admin_selectAllMember();
		return map;	
	}
	
//	回傳json資料	
	@GetMapping(value = "/findAdminOtherMemberInfo_1", produces = "application/json; charset=UTF-8")
	public @ResponseBody MemberBean getAdminMemberotherInfo(@RequestParam("id") long id) {
		MemberBean member = adminservice.admin_selectMember(id);
		return member;
	}
	
	
//	@ModelAttribute("member_auth")
//    public List<String>  getAdminMemberAuth(){
//		System.out.println("member_auth_map : ModelAttribute auto execute before every method");
//		List<String> list = new ArrayList<>();
//		list.add("一般戶");
//		list.add("信用戶");
//		list.add("停權戶");
//		return list;
//	}
//	
//	@ModelAttribute("member_status")
//    public List<String>  getAdminMemberStatus(){
//		System.out.println("member_status_map : ModelAttribute auto execute before every method");
//		List<String> list = new ArrayList<>();
//		list.add("unactivated");
//		list.add("activated");
//		list.add("deleted");
//		return list;
//	}
	
	@GetMapping(value = "/goAdminMember_1")
	public String processHrefAdminMember() {
		return "back/jsp/1_Member/admin_member_1";	
	}

//	用url傳id 再傳給下一個頁面id變數ajax抓資料 
	@GetMapping(value = "/goAdminMemberOtherInfo_1")
	public String processHrefAdminMemberOtherInfo(@RequestParam("id") long id, Model m) {
		m.addAttribute("id", id);
		return "back/jsp/1_Member/admin_member_other_info_1";	
	}
	
	
////	接收json資料 除存DB	
//	@PostMapping(value = "/saveAdminMemberInfo_1")
//	public @ResponseBody int saveAdminMemberotherInfo(@RequestParam("member_id") String id,
//											@RequestParam("member_quote") String quote,
//											@RequestParam("member_auth") String auth,
//											@RequestParam("member_status") String status) {
//		System.out.println("saveAdminMemberInfo_1");
//		System.out.println(id);
//		System.out.println(quote);
//		long convert_id = Long.parseLong(id);
//		System.out.println("convert_id: " + convert_id);
//		int is_update = adminservice.admin_update_member(convert_id, quote, auth, status);
//		return is_update;
//	}
	
	
    //接收json資料 除存DB	
    @PostMapping(value="/saveAdminMemberInfo_1", consumes = "application/json")
    public @ResponseBody int saveAdminMemberotherInfo(@RequestBody Map<String, List<String>> allupdateMember) {
    	int how_many_member = allupdateMember.size();
    	System.out.println(how_many_member);
    	int suceess = 0;
    	for (int i = 0; i < how_many_member; i++) {
    		List<String> listOfMemberValue = allupdateMember.get(i + "");
    		System.out.println("i" + i);
    		System.out.println(listOfMemberValue);
    		Map<Integer, String> member_map = new HashMap<>();
    		for (int j = 0; j < listOfMemberValue.size() ; j++) {
    			member_map.put(j, listOfMemberValue.get(j));
    		}
    		System.out.println("member_map.get(1): " + member_map.get(0));
    		System.out.println("member_map.get(2): " + member_map.get(1));
    		System.out.println("member_map.get(3): " + member_map.get(2));
    		System.out.println("member_map.get(4): " + member_map.get(3));
    		long convert_id = Long.parseLong(member_map.get(0));
    		System.out.println(convert_id + member_map.get(1) + member_map.get(2) + member_map.get(3));
    		int is_update = adminservice.admin_update_member(convert_id, member_map.get(1), member_map.get(2), member_map.get(3));
    		suceess += is_update;
    	}
    	return suceess;
    }
	
	
	@GetMapping(value = "/goAdminMemberJob_1")
	public String processHrefAdminJob(Model m) {
		List<MemberJobs> list = adminservice.admin_selectAll_jobs();
		m.addAttribute("AllJobs", list);
		return "back/jsp/1_Member/?";	
	}
//
//	
//	
//	@GetMapping(value = "/goAdminMember_oth_info_1")
//	public String processHrehAdminMember_Other_Info(Model m) {
//		return null;
////		超連結的其他個資選單
//	}
//	
//	
//	@PostMapping("/admin_member_1")
//	public String processAmdinMember() {
//		
////		資料中可以改的部分都用下拉式選單 或是 按鈕
//		
//		return null;
//	}
//
////	處理工作項目 可以增加或減少
//	@PostMapping("/admin_update_job_1")
//	public String processAdminJobs() {
//		return null;
//	}
//	
//	
//	@PostMapping("/admin_change_memb_password_1")
//	public String processAdminChangePassword() {
//		return null;
////		直接改新密碼
//	}

}
