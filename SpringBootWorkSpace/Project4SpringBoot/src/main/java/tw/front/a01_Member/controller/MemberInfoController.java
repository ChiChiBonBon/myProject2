package tw.front.a01_Member.controller;

import java.io.File;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.sql.Blob;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import tw.front.a01_Member.model.MemberBean;
import tw.front.a01_Member.service.IMemberService;
import tw.front.a01_Member.utils.SystemUtils;
import tw.front.a01_Member.validate.MemberInfoValidator;


@Controller
@SessionAttributes({ "member_info" })
@RequestMapping(path = "/member")
public class MemberInfoController {
	
	@Autowired
	private IMemberService memberservice;
	
	@Autowired
	private MemberInfoValidator membervalidator;
	
	@Autowired
	ServletContext context;
	
	@GetMapping(value = "/gomembermenu_1")
	public String processHrefMember() {
		return "front/jsp/1_Member/memberInfo/member_info_1";
	}
	
	@GetMapping(value = "/goupadte_1")
	public String processHrefUpdateInfo(Model m) {
		MemberBean member = new MemberBean();
		m.addAttribute("member", member);
		return "front/jsp/1_Member/memberInfo/update_info_1";
	}
	
	@GetMapping(value = "/gochangepass_1")
	public String processHrefChangePass(Model m) {
//		MemberBean member = new MemberBean();
//		m.addAttribute("member", member);
		return "front/jsp/1_Member/memberInfo/change_pass_1";
	}
	
	@GetMapping(value = "/godelete_1")
	public String processHrefDeleteMember(Model m) {
//		MemberBean member = new MemberBean();
//		m.addAttribute("member", member);
		return "front/jsp/1_Member/memberInfo/delete_membership_1";
	}
	
	
	@PostMapping("/update_member_1")
	public String processUoddate(@ModelAttribute(name = "member") MemberBean memberbean,
								 BindingResult result,
								 RedirectAttributes ra,
								 Model m) {
		
//		vaildator 檢查		
		membervalidator.validate(memberbean, result);
		if (result.hasErrors()) {
			System.out.println("member update validaing");
			return "front/jsp/1_Member/memberInfo/update_info_1";
		}

//		從session中拿出id 幫助更新
		MemberBean session_member = (MemberBean) m.getAttribute("member_info");
//		
//		member set new value
		memberbean.setId(session_member.getId());

		
		String birthday = memberbean.getBirthday();
		String phone = memberbean.getCellphone();
//		因為數據庫出生日期類行為date, 
//		所以如果前端不選擇任何值會認定為是空字串 數據庫會報錯 因此改設為null來表示
		if (birthday.equals("")) {
			birthday = null;
		}
//		因為前端會把null值 直接印出來 所以再輸入後會認為輸入null字串 所以沒改動的話
//		在這設為null
		if (phone.equals("null")) {
			phone = null;
		}
//
//		member set new value
		memberbean.setBirthday(birthday);
//		
//		member set new value
		memberbean.setCellphone(phone);
		
		
//		這邊分別練習把圖片存入DB和資料夾
//		上面這個是存入DB
//		下面的是存入SystemUtils中 所設定的路徑 
//		把上傳圖片的 'multipart/form-data' 變成 blob
		Blob blob = null;
		String mimeType = "";
		String fileuploadname = "";
		MultipartFile placeImage = memberbean.getMemberImage();
		try {
			InputStream is = placeImage.getInputStream();
			fileuploadname = placeImage.getOriginalFilename();
			blob = SystemUtils.inputStreamToBlob(is);
			mimeType = context.getMimeType(fileuploadname);
//			
//			member set new value
			memberbean.setPicture(blob);
//			
//			member set new value
			memberbean.setMimeType(mimeType);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		System.out.println("uploadfile name = " + fileuploadname);
//		找出儲存圖片的類型 例如png jpg
		String ext = SystemUtils.getExtFilename(fileuploadname);
		// 將上傳的檔案移到指定的資料夾
		try {
			
//			我們可以使用 FileSystem 類的 getDefault() 方法來獲取預設的 FileSystem，
//			然後使用 toAbsolutePath() 方法來獲取當前工作目錄的絕對路徑。請看下面的例子。
			Path path = FileSystems.getDefault().getPath("");
			String directoryName = path.toAbsolutePath().toString();
			System.out.println("Current Working Directory is = " + directoryName);
			
			
			File imageFolder = new File(directoryName + SystemUtils.PLACE_IMAGE_FOLDER);
			if (!imageFolder.exists())
				imageFolder.mkdirs();
			File file = new File(imageFolder, "MemberImage_" + session_member.getId() + ext);
			placeImage.transferTo(file);
//			
//			member set new value
			memberbean.setPictureFile_name("MemberImage_" + session_member.getId() + ext);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("檔案上傳發生異常: " + e.getMessage());
		}
		
//		ra.addFlashAttribute("successMessage", memberbean.getName() + "新增成功");
// 		新增或修改成功，要用response.sendRedirect(newURL) 通知瀏覽器對newURL發出請求
		
		int is_update = 0;

		try {
			is_update = memberservice.member_updateAccount(memberbean);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("失敗報錯 UNIQUEKEY");
		}

		if (is_update == 1) {
			m.addAttribute("member_info", memberbean);
			System.out.println("update success");
			
//		} else if (is_update == -1) {
//			System.out.println("會員帳號已使用，請換一種");
//			m.addAttribute("message", "會員帳號已使用，請換一種");
//
//		} else if (is_update == -2) {
//			System.out.println("電子信箱已使用，請換一種");
//			m.addAttribute("message", "電子信箱已使用，請換一種");
//
//		} else if (is_update == -3) {
//			System.out.println("電話已使用，請換一種");
//			m.addAttribute("message", "電話已使用，請換一種");

		} else {
			System.out.println("無法更新，請回報");
			m.addAttribute("message", "無法更新，請回報");
		}

		return "redirect:/member/goupadte_1";
	}
	
	
	@PostMapping("/change_pass_1")
	public String processChangePassword(@RequestParam(name = "orgin_pass_1") String pass_1,
										@RequestParam(name = "new_pass_1") String pass_2,
										@RequestParam(name = "che_new_pass_1") String pass_3,
//										BindingResult result,
										RedirectAttributes ra,
										Model m) {
		
		
//		vaildator 檢查
//		HashSet<String> set = new HashSet<>();
//		set.add(pass_3);
//		set.add(pass_2);
//		set.add(pass_1);
//		membervalidator.validate(set, result);
//		if (result.hasErrors()) {
//			System.out.println("member register validaing");
//			return "front/jsp/1_Member/memberLoginRegister/register_1";
//		}
		
//		加密
		String password_encodeString_ori = SystemUtils.encodePassword(pass_1);
		if (password_encodeString_ori == null) {
			return "處理錯誤訊息";
		}	
		String password_encodeString_new = SystemUtils.encodePassword(pass_2);
		if (password_encodeString_new == null) {
			return "處理錯誤訊息";
		}
		
		MemberBean session_member = (MemberBean) m.getAttribute("member_info");
		
		System.out.println("session:" + session_member.getPassword());
		System.out.println("session:" + session_member.getAccount());

		if (session_member.getPassword().equals(password_encodeString_ori)) {
//			確認新密碼和確認密碼是一樣的
			if (pass_2.equals(pass_3)) {

				boolean pass_is_update = memberservice.member_updatePassword(session_member.getId(),
						password_encodeString_new);
				String update_pass_statu = "密碼更新成功！";
				System.out.println("update password: " + pass_is_update);
				
				if (pass_is_update) {
//					更改原本session的密碼
					session_member.setPassword(password_encodeString_new);
//					放入更新密碼的session object
					m.addAttribute("member_info", session_member);
					
				} else {
					update_pass_statu = "密碼更新失敗！";
				}
				System.out.println(update_pass_statu);
			} else {
				System.out.println("請輸入和新密碼一樣的確認密碼");
				m.addAttribute("message", "請輸入和新密碼一樣的確認密碼");
				return "front/jsp/1_Member/memberInfo/change_pass_1";
			}
		} else {
			System.out.println("輸入錯誤密碼");
			m.addAttribute("message", "輸入錯誤密碼");
			return "front/jsp/1_Member/memberInfo/change_pass_1";
		}
//		ra.addAttribute();
		return "redirect:/member/gomembermenu_1";
	}

	
	@PostMapping("/delete_membership_1")
	public String processDeleteMember(@RequestParam(name = "password_del_1") String password_del_1,
									  @RequestParam(name = "password_del_che_1") String password_del_che_1,
//									  BindingResult result,
									  RedirectAttributes ra,
									  Model m) {

//		vaildator 檢查
//		HashSet<String> set = new HashSet<>();
//		set.add(password_del_1);
//		set.add(password_del_che_1);
//		membervalidator.validate(set, result);
//		if (result.hasErrors()) {
//			System.out.println("member register validaing");
//			return "redirect:memberLoginRegister/register_1";
//		}
		
//		加密
		String password_encodeString = SystemUtils.encodePassword(password_del_1);
		if (password_encodeString == null) {
			return "處理錯誤訊息";
		}

		
		MemberBean session_member = (MemberBean) m.getAttribute("member_info");

		System.out.println(session_member.getPassword());
//		確定輸入密碼符合session儲存的密碼
		if (session_member.getPassword().equals(password_encodeString)) {
//			確認新密碼和確認密碼是一樣的
			if (password_del_1.equals(password_del_che_1)) {

				boolean is_delete = memberservice.member_deleteAccount(session_member.getId());

				System.out.println("delete password: " + is_delete);

				if (is_delete) {
					System.out.println("帳號刪除！");
//					ra.addAttribute(password_encodeString, session_member);
					return "redirect:/member/logout_1";
				} else {
					System.out.println("帳號刪除失敗");
					return "redirect:/member/member_info_1";
				}

			} else {
				System.out.println("請輸入正確的確認密碼");
				m.addAttribute("message", "請輸入正確的確認密碼");
//				return "";
				
			}
		} else {
			System.out.println("輸入錯誤密碼");
			m.addAttribute("message", "輸入錯誤密碼");
//			return "delete_membership_1";
		}
		return "front/jsp/1_Member/memberInfo/delete_membership_1";
		
	}
	
	
	@RequestMapping(path = "/logout_1", method = {RequestMethod.POST, RequestMethod.GET})
	public String processLogout(HttpSession session, SessionStatus se_status) {

		System.out.println("Not logout yet:" + session.getAttribute("member_info"));
		session.removeAttribute("member_info");
		System.out.println("logout:" + session.getAttribute("member_info"));
		se_status.setComplete();
		return "redirect:/unmember/gologin_1";
	}
	
	
}
