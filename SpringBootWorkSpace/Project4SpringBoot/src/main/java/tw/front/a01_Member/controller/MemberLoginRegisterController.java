package tw.front.a01_Member.controller;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import tw.front.a01_Member.model.MemberBean;
import tw.front.a01_Member.service.IMemberService;
import tw.front.a01_Member.utils.SystemUtils;

@Controller
@SessionAttributes({ "member_info" })
@RequestMapping("/front/unmember")
public class MemberLoginRegisterController {
	
	@Autowired
	private IMemberService memberservice;


	@GetMapping("/gologin_1")
	public String processHrefLogin(@CookieValue(value = "StockOverFlowMember", defaultValue = "None") String cookie_value, RedirectAttributes ra) {
		if (!cookie_value.equals("None")) {
			return "redirect:/front/member/gomembermenu_1";
		} 
		return "front/jsp/1_Member/memberLoginRegister/login_1";
	}

	@GetMapping("/goregister_1")
	public String processHrefRegister(Model m, @CookieValue(value = "StockOverFlowMember", defaultValue = "None") String cookie_value, RedirectAttributes ra) {
		if (!cookie_value.equals("None")) {
			return "redirect:/front/member/gomembermenu_1";
		}
		MemberBean member = new MemberBean();
		m.addAttribute("member", member);
		return "front/jsp/1_Member/memberLoginRegister/register_1";
	}
	
	@GetMapping("/gomessage_page_1")
	public String processHrefMessage(Model m, @CookieValue(value = "StockOverFlowMember", defaultValue = "None") String cookie_value, RedirectAttributes ra) {
		if (!cookie_value.equals("None")) {
			return "redirect:/front/member/gomembermenu_1";
		}
		return "front/jsp/1_Member/memberLoginRegister/message_page_1";
	}
	
	@GetMapping(value = "/gocheck_account", produces = "application/json; charset=UTF-8")
	public @ResponseBody String processAjaxCheckAccount(@RequestParam("account") String account, Model m) {
		String Result = memberservice.check_unique("account", account);
		System.out.println(Result);
		return Result;
	}
	
	@GetMapping(value = "/gocheck_email", produces = "application/json; charset=UTF-8")
	public @ResponseBody String processAjaxCheckEmail(@RequestParam("email") String email,  Model m) {
		String Result = memberservice.check_unique("e_mail", email);
		System.out.println(Result);
		return Result;
	}

//	?????????????????? post url
	@GetMapping("/login_1")
	public String processRedirPosttoGetLogin(@CookieValue(value = "StockOverFlowMember", defaultValue = "None") String cookie_value, RedirectAttributes ra) {
		if (!cookie_value.equals("None")) {
			return "redirect:/front/member/gomembermenu_1";
		}
		return "redirect:/front/unmember/gologin_1";
	}
	
	
	@PostMapping("/login_1")
	public String processLogin(@RequestParam(name = "account_1") String account,
							   @RequestParam(name = "password_1") String password,
							   RedirectAttributes ra,
							   Model m,
							   HttpServletResponse response,
							   @CookieValue(value = "StockOverFlowMember", defaultValue = "None") String cookie_value) {
		
		if (!cookie_value.equals("None")) {
			return "redirect:/front/member/gomembermenu_1";
		}
		
		if (account == null || password == null) {
			ra.addFlashAttribute("Message", "????????????????????????");
			return "redirect:/front/unmember/gomessage_page_1";
		}

//		??????
		String password_encodeString = SystemUtils.encodePassword(password);
		if (password_encodeString == null) {
			return "??????????????????";
		}
		System.out.println(account);
		System.out.println(password);
		System.out.println(password_encodeString);

//		???DB??? ????????????????????? ????????????session
		MemberBean member_info = memberservice.member_checkAccount(account, password_encodeString);
		
		if (member_info != null) {
			System.out.println("login Success");
			System.out.println("account info: " + member_info);
			
//			????????????????????? ??????????????? ??????????????? ?????????identity???id
//			????????????????????? ??????ID?????? ??????????????????????????????????????? ??????????????????
			if (member_info.getMember_stock_ID() == null) {
				StringBuffer msID = SystemUtils.generateMemberStockID(member_info.getId());
				member_info.setMember_stock_ID(msID.toString());
				int is_update = memberservice.member_updateAccount(member_info);
				System.out.println(is_update + " = 1 is update Member_stock_ID");
			}
			

	//      ??????cookie
			String cookie_key = "StockOverFlowMember";
			String cookie_for_value = member_info.getAcc_encode_cookie();
			Cookie myCookie = new Cookie(cookie_key, cookie_for_value);
	//		60 ????????????
			myCookie.setMaxAge(60*60);
			myCookie.setPath("/project4");
			response.addCookie(myCookie);
			System.out.println("Login_1: create cookie");
			System.out.println(myCookie);
			
			m.addAttribute("member_info", member_info);
			ra.addFlashAttribute("Message", "????????????");
			return "redirect:/front/member/gomessage_page_1";
		}
		String message = "???????????????????????????";
//		System.out.println(account + password);
////		?????????????????? alert ???????????????????????? ????????????????????? alert???????????????message ????????????
//		if (account  == "" && password == "") {
//			message = "";
//		}
		m.addAttribute("message", message);
		System.out.println(message);
		return "front/jsp/1_Member/memberLoginRegister/login_1";
	}

	
//	?????????????????? post url
	@GetMapping("/register_1")
	public String processRedirPosttoGetRigster() {
		return "redirect:/front/unmember/register_1";
	}

	@PostMapping("/register_1")
	public String processRegister(@ModelAttribute(name = "member") @Valid MemberBean memberbean,
								  BindingResult result,
								  @RequestParam(name = "password_2") String pass_che,
								  RedirectAttributes ra,
								  Model m,
								  @CookieValue(value = "StockOverFlowMember", defaultValue = "None") String cookie_value) {
		
		if (!cookie_value.equals("None")) {
			return "redirect:/front/member/gomembermenu_1";
		}
		
//		????????? vaildator ?????? ?????????????????????
		if (result.hasErrors()) {
			System.out.println("member register validaing");
			List<ObjectError> errorList = result.getAllErrors();
			for (ObjectError error : errorList) {
				System.out.println(error);
				System.out.println(error.getDefaultMessage());
				System.out.println();
			}
			return "front/jsp/1_Member/memberLoginRegister/register_1";
		}

		
//		??????
		String password_encodeString = SystemUtils.encodePassword(memberbean.getPassword());
		if (password_encodeString == null) {
			return "??????????????????";
		}
//		?????????????????? cookie 
		String cookie_value_insert = SystemUtils.encodePassword(memberbean.getAccount());
		if (cookie_value_insert == null) {
			return "??????????????????";
		}


		System.out.println("new member password:" + memberbean.getPassword());
		System.out.println("new member password encode:" + password_encodeString);

		if (memberbean.getPassword().equals(pass_che)) {
				
			memberbean.setPassword(password_encodeString);
			memberbean.setAcc_encode_cookie(cookie_value_insert);
			memberbean.setMember_status("unactivated");
			memberbean.setMember_auth("?????????");
			
//			????????? Java ???????????????????????????????????? Timestamp ?????????????????????????????????????????????
//			???????????????????????????????????????????????????????????? System ?????? currentTimeMillis() ?????????????????????
	        Long datetime = System.currentTimeMillis();
	        Timestamp timestamp = new Timestamp(datetime);
			memberbean.setRegistertime(timestamp);
			memberbean.setLastUsing(timestamp);
			
			
			int is_create = 0;
			try {
				is_create = memberservice.member_createAccount(memberbean);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("error!!!");
				System.out.println("");
				e.printStackTrace();
				ra.addFlashAttribute("Message", "??????????????????, ????????????????????????????????????????????????, Email)");
				return "redirect:/front/unmember/gomessage_page_1";
			}
			System.out.println("reString: " + is_create);
		} else {
			System.out.println("?????????????????????,??????");
			ra.addFlashAttribute("Message", "??????????????????, ?????????????????????,??????");
			return "redirect:/front/unmember/gomessage_page_1";
		}		
		ra.addFlashAttribute("send_email_to", memberbean.getE_mail());
		ra.addFlashAttribute("send_email_url", cookie_value_insert);
		return "redirect:/email_request/double_qualification_send";
	}
}
