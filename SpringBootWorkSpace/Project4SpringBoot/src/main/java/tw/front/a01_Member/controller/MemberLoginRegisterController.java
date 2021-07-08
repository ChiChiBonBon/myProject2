package tw.front.a01_Member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import tw.front.a01_Member.model.MemberBean;
import tw.front.a01_Member.service.IMemberService;
import tw.front.a01_Member.utils.SystemUtils;
import tw.front.a01_Member.validate.MemberLoginRegisterValidator;

@Controller
@SessionAttributes({ "member_info" })
@RequestMapping("/unmember")
public class MemberLoginRegisterController {
	
	@Autowired
	private IMemberService memberservice;
	
	@Autowired
	private MemberLoginRegisterValidator membervalidator;

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

	
	@PostMapping("/login_1")
	public String processLogin(@RequestParam(name = "account_1") String account,
							   @RequestParam(name = "password_1") String password,
							   RedirectAttributes ra,
							   Model m) {
		
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
				System.out.println(is_update + " = 1 is update");
			}
			

//      創造cookie
//		Cookie myCookie = new Cookie("cookie_id", "" + member_info.getId());
//		myCookie.setMaxAge(30*60);
//		response.addCookie(myCookie);
//		System.out.println("Login_1: create cookie");

			m.addAttribute("member_info", member_info);
			return "redirect:/member/gomembermenu_1";

		}
		System.out.println("請輸入正確帳號密碼");
		m.addAttribute("message", "請輸入正確帳號密碼");
		return "front/jsp/1_Member/memberLoginRegister/login_1";

	}

	
	@PostMapping("/register_1")
	public String processRegister(@ModelAttribute(name = "member") MemberBean memberbean,
								  @RequestParam(name = "password_2") String pass_che,
								  BindingResult result,
								  RedirectAttributes ra,
								  Model m) {
		
//		vaildator 檢查
		membervalidator.validate(memberbean, result);
		if (result.hasErrors()) {
			System.out.println("member register validaing");
			return "front/jsp/1_Member/memberLoginRegister/register_1";
		}

//		加密
		String password_encodeString = SystemUtils.encodePassword(memberbean.getPassword());
		if (password_encodeString == null) {
			return "處理錯誤訊息";
		}


		System.out.println("new member password:" + memberbean.getPassword());
		System.out.println("new member password encode:" + password_encodeString);

		if (memberbean.getPassword().equals(pass_che)) {
			
			
			memberbean.setPassword(password_encodeString);
			memberbean.setMember_status("unactivated");
			memberbean.setMember_auth("一般戶");
			
			
			int is_create = 0;
			try {
				is_create = memberservice.member_createAccount(memberbean);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("error!!!");
				System.out.println("");
				e.printStackTrace();
			}

//			String reString = null;
//			if (is_create == 1) {
//				reString = "帳號創建成功";
//			} else if (is_create == -1) {
//				reString = "帳號創建失敗, 會員帳號已使用";
//			} else if (is_create == -2) {
//				reString = "帳號創建失敗, 電子信箱已使用";
//			} else {
//				reString = "帳號創建失敗";
//			}

			System.out.println("reString: " + is_create);

		} else {
			System.out.println("密碼輸入不一樣,失敗");
		}
//		ra.addFlashAttribute("");


		return "redirect:/unmember/gologin_1";
	}
}
