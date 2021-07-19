package tw.front.a01_Member.controller;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
@RequestMapping("/email_request")
public class MemberSendEmail {
	
//    @Autowired
//    private JavaMailSender mailSender;
    
	@Autowired
	JavaMailSender javaMailSender;
    
    
	@GetMapping("/double_qualification_send")
	public String emailForgetPassword(@ModelAttribute("send_email_to") String email_send,
									  @ModelAttribute("send_email_url") String url_unique,
									  RedirectAttributes ra) {
		
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
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		ra.addFlashAttribute("Message", "帳號註冊成功");
		return "redirect:/front/unmember/gomessage_page_1";
	}
    
	
	@GetMapping("/double_qualification_received")
	public String emailForgetPassword() {
		return "";
	}
	
	
	@GetMapping("/forget_password")
	public String emailDoubleQualification() {
		return "front/jsp/1_Member/memberLoginRegister/login_1";
	}
}
