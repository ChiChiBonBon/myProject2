package tw.front.a01_Member.controller;

import java.sql.Timestamp;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import tw.front.a01_Member.model.MemberBean;
import tw.front.a01_Member.service.IMemberService;
import tw.front.a01_Member.utils.SystemUtils;


@Controller
@SessionAttributes({ "member_info" })
@RequestMapping(path = "/front/member")
public class MemberOtherInfoController {
	
	@Autowired
	private IMemberService memberservice;
	
	@Autowired
	ServletContext context;
	
	
	@GetMapping(value = "/gomembermenu_1")
	public String processHrefMember(@CookieValue(value = "StockOverFlowMember", defaultValue = "None") String cookie_value, RedirectAttributes ra) {
		if (cookie_value.equals("None")) {
			return "redirect:/front/unmember/gologin_1";
		} else {
			boolean cookie_exist = memberservice.check_cookie(cookie_value);
			if (!cookie_exist) {
				System.out.println("cookie doesn't exist");
				return "redirect:/front/unmember/gologin_1";
			}
		}
		return "front/jsp/1_Member/memberInfo/member_info_1";
	}
	
	@GetMapping(value = "/gochangepass_1")
	public String processHrefChangePass(@CookieValue(value = "StockOverFlowMember", defaultValue = "None") String cookie_value, RedirectAttributes ra) {
		System.out.println(cookie_value);
		if (cookie_value.equals("None")) {
			return "redirect:/front/unmember/gologin_1";
		} else {
			boolean cookie_exist = memberservice.check_cookie(cookie_value);
			if (!cookie_exist) {
				System.out.println("cookie doesn't exist");
				return "redirect:/front/unmember/gologin_1";
			}
		}
		return "front/jsp/1_Member/memberInfo/change_pass_1";
	}
	
	@GetMapping("/gomessage_page_1")
	public String processHrefMessage(Model m, @CookieValue(value = "StockOverFlowMember", defaultValue = "None") String cookie_value, RedirectAttributes ra) {
		System.out.println(cookie_value);
		if (cookie_value.equals("None")) {
			return "redirect:/front/unmember/gologin_1";
		} else {
			boolean cookie_exist = memberservice.check_cookie(cookie_value);
			if (!cookie_exist) {
				System.out.println("cookie doesn't exist");
				return "redirect:/front/unmember/gologin_1";
			}
		}
		return "front/jsp/1_Member/memberInfo/message_page_member_1";
	}
	
	@GetMapping(value = "/godelete_1")
	public String processHrefDeleteMember(@CookieValue(value = "StockOverFlowMember", defaultValue = "None") String cookie_value, RedirectAttributes ra) {
		if (cookie_value.equals("None")) {
			return "redirect:/front/unmember/gologin_1";
		} else {
			boolean cookie_exist = memberservice.check_cookie(cookie_value);
			if (!cookie_exist) {
				System.out.println("cookie doesn't exist");
				return "redirect:/front/unmember/gologin_1";
			}
		}
		return "front/jsp/1_Member/memberInfo/delete_membership_1";
	}
	
	
//	?????????????????? post url
	@GetMapping("/change_pass_1")
	public String processRedirPosttoGetChanfePass(@CookieValue(value = "StockOverFlowMember", defaultValue = "None") String cookie_value, RedirectAttributes ra) {
		if (cookie_value.equals("None")) {
			return "redirect:/front/unmember/gologin_1";
		} else {
			boolean cookie_exist = memberservice.check_cookie(cookie_value);
			if (!cookie_exist) {
				System.out.println("cookie doesn't exist");
				return "redirect:/front/unmember/gologin_1";
			}
		}
		return "redirect:/front/member/gochangepass_1";
	}
	
	@PostMapping("/change_pass_1")
	public String processChangePassword(@RequestParam(name = "orgin_pass_1") String pass_1,
										@RequestParam(name = "new_pass_1") String pass_2,
										@RequestParam(name = "che_new_pass_1") String pass_3,
										RedirectAttributes ra,
										Model m,
										@CookieValue(value = "StockOverFlowMember", defaultValue = "None") String cookie_value) {
		
		if (cookie_value.equals("None")) {
			return "redirect:/front/unmember/gologin_1";
		} else {
			boolean cookie_exist = memberservice.check_cookie(cookie_value);
			if (!cookie_exist) {
				System.out.println("cookie doesn't exist");
				return "redirect:/front/unmember/gologin_1";
			}
		}
		
//		???????????? validate ??? ??????????????????
		if (pass_2.equals("")) {
			ra.addFlashAttribute("Message", "????????????, ?????????????????????");
			return "redirect:/front/member/gomessage_page_1";
		}
		
		
//		??????
		String password_encodeString_ori = SystemUtils.encodePassword(pass_1);
		if (password_encodeString_ori == null) {
			return "??????????????????";
		}	
		String password_encodeString_new = SystemUtils.encodePassword(pass_2);
		if (password_encodeString_new == null) {
			return "??????????????????";
		}
		
		MemberBean session_member = (MemberBean) m.getAttribute("member_info");
		
		System.out.println("session:" + session_member.getPassword());
		System.out.println("session:" + session_member.getAccount());

		if (session_member.getPassword().equals(password_encodeString_ori)) {
//			??????????????????????????????????????????
			if (pass_2.equals(pass_3)) {

				boolean pass_is_update = memberservice.member_updatePassword(session_member.getId(),
						password_encodeString_new);
				String update_pass_statu = "?????????????????????";
				System.out.println("update password: " + pass_is_update);
				
				if (pass_is_update) {
//					????????????session?????????
					session_member.setPassword(password_encodeString_new);
//					?????????????????????session object
					m.addAttribute("member_info", session_member);
					
				} else {
					update_pass_statu = "?????????????????????";
				}
				System.out.println(update_pass_statu);
			} else {
				System.out.println("??????????????????????????????????????????");
				m.addAttribute("message", "??????????????????????????????????????????");
				return "front/jsp/1_Member/memberInfo/change_pass_1";
			}
		} else {
			System.out.println("??????????????????");
			m.addAttribute("message", "??????????????????");
			return "front/jsp/1_Member/memberInfo/change_pass_1";
		}
		ra.addFlashAttribute("Message", "??????????????????");
		return "redirect:/front/member/gomessage_page_1";
	}

	
//	?????????????????? post url
	@GetMapping("/delete_membership_1")
	public String processRedirPosttoGetDelete(@CookieValue(value = "StockOverFlowMember", defaultValue = "None") String cookie_value, RedirectAttributes ra) {
		if (cookie_value.equals("None")) {
			return "redirect:/front/unmember/gologin_1";
		} else {
			boolean cookie_exist = memberservice.check_cookie(cookie_value);
			if (!cookie_exist) {
				System.out.println("cookie doesn't exist");
				return "redirect:/front/unmember/gologin_1";
			}
		}
		return "redirect:/front/member/godelete_1";
	}
	
	@PostMapping("/delete_membership_1")
	public String processDeleteMember(@RequestParam(name = "password_del_1") String password_del_1,
									  @RequestParam(name = "password_del_che_1") String password_del_che_1,
									  RedirectAttributes ra,
									  Model m,
									  @CookieValue(value = "StockOverFlowMember", defaultValue = "None") String cookie_value) {
		
		if (cookie_value.equals("None")) {
			return "redirect:/front/unmember/gologin_1";
		} else {
			boolean cookie_exist = memberservice.check_cookie(cookie_value);
			if (!cookie_exist) {
				System.out.println("cookie doesn't exist");
				return "redirect:/front/unmember/gologin_1";
			}
		}
		
//		???????????? validate ??? ??????????????????
		if (password_del_1.equals("")) {
			ra.addFlashAttribute("Message", "????????????, ?????????????????????");
			return "redirect:/front/member/gomessage_page_1";
		}
		
//		??????
		String password_encodeString = SystemUtils.encodePassword(password_del_1);
		if (password_encodeString == null) {
			return "??????????????????";
		}

		
		MemberBean session_member = (MemberBean) m.getAttribute("member_info");

		System.out.println(session_member.getPassword());
//		????????????????????????session???????????????
		if (session_member.getPassword().equals(password_encodeString)) {
//			??????????????????????????????????????????
			if (password_del_1.equals(password_del_che_1)) {

				boolean is_delete = memberservice.member_deleteAccount(session_member.getId());

				System.out.println("delete password: " + is_delete);

				if (is_delete) {
					
					System.out.println("???????????????");
					ra.addFlashAttribute("Message", "???????????????");
					return "redirect:/front/member/gomessage_page_1";
				} else {
					System.out.println("??????????????????");
					ra.addFlashAttribute("Message", "?????????????????????");
					return "redirect:/front/member/member_info_1";
				}

			} else {
				System.out.println("??????????????????????????????");
				m.addAttribute("message", "??????????????????????????????");				
			}
		} else {
			System.out.println("??????????????????");
			m.addAttribute("message", "??????????????????");
		}
		return "front/jsp/1_Member/memberInfo/delete_membership_1";
		
	}
	
	
	@RequestMapping(path = "/logout_1", method = {RequestMethod.POST, RequestMethod.GET})
	public String processLogout(HttpSession session, SessionStatus se_status,
								Model m, HttpServletResponse response,
								@CookieValue(value = "StockOverFlowMember", defaultValue = "None") String cookie_value) {
		
		if (cookie_value.equals("None")) {
			return "redirect:/front/unmember/gologin_1";
		} else {
			boolean cookie_exist = memberservice.check_cookie(cookie_value);
			if (!cookie_exist) {
				System.out.println("cookie doesn't exist");
				return "redirect:/front/unmember/gologin_1";
			}
		}
		
//		????????? path
		Cookie userNameCookieRemove = new Cookie("StockOverFlowMember", null);
		userNameCookieRemove.setMaxAge(0);
		userNameCookieRemove.setPath("/project4");
		response.addCookie(userNameCookieRemove);
		System.out.println("cookie remove");

		MemberBean member = (MemberBean) session.getAttribute("member_info");
		
//		??????????????????????????? ??????????????????
        Long datetime = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(datetime);
        
        if (member.getId() != null) {
    		memberservice.member_updateTime(member.getId(), timestamp);
    		
    		System.out.println("Not logout yet:" + member);
    		
    		session.removeAttribute("member_info");
    		System.out.println("logout:" + session.getAttribute("member_info"));
    		se_status.setComplete();
		}
		return "redirect:/front/unmember/gologin_1";
	}
}
