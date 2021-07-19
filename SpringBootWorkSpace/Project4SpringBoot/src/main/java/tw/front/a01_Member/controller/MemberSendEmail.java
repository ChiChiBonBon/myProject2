package tw.front.a01_Member.controller;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import tw.back.a01_Member.service.IAdminMemberService;



@Controller
@RequestMapping("/email_request")
public class MemberSendEmail {
	
//    @Autowired
//    private JavaMailSender mailSender;
    
	@Autowired
	JavaMailSender javaMailSender;
	
	@Autowired
	private IAdminMemberService adminservice;
	
    
	@GetMapping("/double_qualification_send")
	public String emailDoubleQualification_send(@ModelAttribute("send_email_to") String email_send,
												@ModelAttribute("send_email_url") String url_unique,
												RedirectAttributes ra
												) {
		
		if (email_send != null && url_unique != null) {
			System.out.println(email_send);
			System.out.println(url_unique);
			String url_final = "http://localhost:8099/project4/email_request/double_qualification_received?member=" + url_unique;
//			sender.setHost("joycepan0513@gmail.com");
			MimeMessage message = javaMailSender.createMimeMessage();
			MimeMessageHelper helper;
			try {
				helper = new MimeMessageHelper(message, true);
				helper.setTo(email_send);
		        helper.setSubject("主旨：恭喜註冊成功");
		        String htmlString = "<html><body><a href='"+ url_final +"'>按此點連結來激活帳號</a></body></html>";
				helper.setText(htmlString, true);
				javaMailSender.send(message);
				ra.addFlashAttribute("Message", "請去信箱激活帳號");
				return "redirect:/front/unmember/gomessage_page_1";
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		ra.addFlashAttribute("Message", "信箱激活失敗，請回報");
		return "redirect:/front/unmember/gomessage_page_1";
	}
    
	
//	用之前輸入的cookie value 來當作超連結來激活 這邊在使用check_cookie來判斷 是否存在來作為激活依據
	@GetMapping("/double_qualification_received")
	public String emailDoubleQualification_receive(@RequestParam("member") String member_active,
												   Model m, RedirectAttributes ra) {
		if (member_active != null) {
			boolean result = adminservice.change_status_byEmail(member_active);
			if (result) {
				ra.addFlashAttribute("Message", "帳號激活成功");
				return "redirect:/front/unmember/gomessage_page_1";
			} 
		}
		ra.addFlashAttribute("Message", "帳號激活失敗");
		return "redirect:/front/unmember/gomessage_page_1";
	}
	
	
	
	@PostMapping(value = "/forget_password", produces = "application/json; charset=UTF-8")
	public @ResponseBody String emailDoubleQualification(@RequestParam("email") String email,
														 RedirectAttributes ra) {
		
		if (email != null) {
			System.out.println(email);
			
			String check_email_result = adminservice.check_email_to_resetPassword(email);
			if (!check_email_result.equals("None")){
				
				String url_final = "http://localhost:8099/project4/front/unmember/gologin_1";
//				sender.setHost("joycepan0513@gmail.com");
				MimeMessage message = javaMailSender.createMimeMessage();
				MimeMessageHelper helper;
				String new_password = "";
				try {
					helper = new MimeMessageHelper(message, true);
					helper.setTo(email);
			        helper.setSubject("主旨：密碼以重置");
			        String htmlString = "<div>這是新密碼"+ new_password +"</div>"
			        		+ "<html><body><a href='"+ url_final +"'>按此返回登入區</a></body></html>";
					helper.setText(htmlString, true);
					javaMailSender.send(message);
					return "Success";
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return "Fail";
	}


	
	
}
