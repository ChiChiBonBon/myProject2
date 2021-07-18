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
	public String processHrefLogin() {
		return "front/jsp/1_Member/memberLoginRegister/login_1";
	}

	@GetMapping("/goregister_1")
	public String processHrefRegister(Model m) {
		MemberBean member = new MemberBean();
		m.addAttribute("member", member);
		return "front/jsp/1_Member/memberLoginRegister/register_1";
	}
	
	@GetMapping("/gomessage_page_1")
	public String processHrefMessage(Model m) {
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

//	擋住直接輸入 post url
	@GetMapping("/login_1")
	public String processRedirPosttoGetLogin() {
		return "redirect:/front/unmember/gologin_1";
	}
	
	
	@PostMapping("/login_1")
	public String processLogin(@RequestParam(name = "account_1") String account,
							   @RequestParam(name = "password_1") String password,
							   RedirectAttributes ra,
							   Model m,
							   HttpServletResponse response) {
		if (account == null || password == null) {
			ra.addFlashAttribute("Message", "請輸入帳號和密碼");
			return "redirect:/front/unmember/gomessage_page_1";
		}

//		加密
		String password_encodeString = SystemUtils.encodePassword(password);
		if (password_encodeString == null) {
			return "處理錯誤訊息";
		}
		System.out.println(account);
		System.out.println(password);
		System.out.println(password_encodeString);

//		從DB中 拿出會員的資訊 之後放入session
		MemberBean member_info = memberservice.member_checkAccount(account, password_encodeString);

		if (member_info != null) {
			System.out.println("login Success");
			System.out.println("account info: " + member_info);
			
//			登入時才會加入 會員證卷碼 因為註冊時 抓不到identity的id
//			這篇可能出問題 假如ID太大 是設計出類似銀行帳號的問題 不是程式問題
			if (member_info.getMember_stock_ID() == null) {
				StringBuffer msID = SystemUtils.generateMemberStockID(member_info.getId());
				member_info.setMember_stock_ID(msID.toString());
				int is_update = memberservice.member_updateAccount(member_info);
				System.out.println(is_update + " = 1 is update Member_stock_ID");
			}
			

	//      創造cookie
			String cookie_key = "StockOverFlowMember";
			String cookie_value = member_info.getAcc_encode_cookie();
			Cookie myCookie = new Cookie(cookie_key, cookie_value);
	//		60 分鐘到期
			myCookie.setMaxAge(60*60);
			myCookie.setPath("/project4");
			response.addCookie(myCookie);
			System.out.println("Login_1: create cookie");
			System.out.println(myCookie);
			
			m.addAttribute("member_info", member_info);
			ra.addFlashAttribute("Message", "登入成功");
			return "redirect:/front/member/gomessage_page_1";
		}
		String message = "請輸入正確帳號密碼";
//		System.out.println(account + password);
////		這部分是確保 alert 訊息程式重新跑時 不會一直跑出來 alert只會在特定message 才會出現
//		if (account  == "" && password == "") {
//			message = "";
//		}
		m.addAttribute("message", message);
		System.out.println(message);
		return "front/jsp/1_Member/memberLoginRegister/login_1";

	}

	
//	擋住直接輸入 post url
	@GetMapping("/register_1")
	public String processRedirPosttoGetRigster() {
		return "redirect:/front/unmember/register_1";
	}

	@PostMapping("/register_1")
	public String processRegister(@ModelAttribute(name = "member") @Valid MemberBean memberbean,
								  BindingResult result,
								  @RequestParam(name = "password_2") String pass_che,
								  RedirectAttributes ra,
								  Model m) {
		
//		不會用 vaildator 檢查 用這種方式檢查
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

		
//		加密
		String password_encodeString = SystemUtils.encodePassword(memberbean.getPassword());
		if (password_encodeString == null) {
			return "處理錯誤訊息";
		}
//		加密帳號作為 cookie 
		String cookie_value = SystemUtils.encodePassword(memberbean.getAccount());
		if (cookie_value == null) {
			return "處理錯誤訊息";
		}


		System.out.println("new member password:" + memberbean.getPassword());
		System.out.println("new member password encode:" + password_encodeString);

		if (memberbean.getPassword().equals(pass_che)) {
				
			memberbean.setPassword(password_encodeString);
			memberbean.setAcc_encode_cookie(cookie_value);
			memberbean.setMember_status("unactivated");
			memberbean.setMember_auth("一般戶");
			
//			要獲取 Java 中的當前時間戳，可以使用 Timestamp 類。由於此類沒有預設的建構函式
//			，因此我們以毫秒為單位傳遞時間。我們使用 System 類的 currentTimeMillis() 方法獲取時間。
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
				ra.addFlashAttribute("Message", "帳號註冊失敗, 不能使用已註冊過的會員資訊（帳號, Email)");
				return "redirect:/front/unmember/gomessage_page_1";
			}
			System.out.println("reString: " + is_create);
		} else {
			System.out.println("密碼輸入不一樣,失敗");
			ra.addFlashAttribute("Message", "帳號註冊失敗, 密碼輸入不一樣,失敗");
			return "redirect:/front/unmember/gomessage_page_1";
		}
		ra.addFlashAttribute("Message", "帳號註冊成功");
		return "redirect:/front/unmember/gomessage_page_1";
	}
}
