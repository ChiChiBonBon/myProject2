package tw.front.a01_Member.controller;

import java.io.File;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.sql.Blob;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import tw.back.a01_Member.dao.IAdminMemberDao;
import tw.back.a01_Member.model.MemberJobs;
import tw.front.a01_Member.model.MemberBean;
import tw.front.a01_Member.service.IMemberService;
import tw.front.a01_Member.utils.SystemUtils;

@Controller
@SessionAttributes({ "member_info" })
@RequestMapping(path = "/front/member_up")
public class MemberUpdateController {

	
	@Autowired
	private IMemberService memberservice;
	
	@Autowired
	private IAdminMemberDao adminmemberservice;
	
	@Autowired
	ServletContext context;
	
	@GetMapping(value = "/goupdate_1")
	public String processHrefUpdateInfo(Model m, @CookieValue(value = "StockOverFlowMember", defaultValue = "None") String cookie_value, RedirectAttributes ra) {
//		理論上有用下面的 @ModelAttribute 寫法就不用自己創新物件傳到前端
//		MemberBean member = new MemberBean();
//		m.addAttribute("member", member);
		if (cookie_value.equals("None")) {
			return "redirect:/front/unmember/gologin_1";
		} else {
			boolean cookie_exist = memberservice.check_cookie(cookie_value);
			if (!cookie_exist) {
				System.out.println("cookie doesn't exist");
				return "redirect:/front/unmember/gologin_1";
			}
		}
		return "front/jsp/1_Member/memberInfo/update_info_1";
	}
	
	@GetMapping("/gomessage_page_1")
	public String processHrefMessage(@CookieValue(value = "StockOverFlowMember", defaultValue = "None") String cookie_value, RedirectAttributes ra) {
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
	
	
	@GetMapping(value = "/gocheck_account", produces = "application/json; charset=UTF-8")
	public @ResponseBody String processAjaxCheckAccount(@RequestParam("account") String account, Model m) {
		MemberBean session_member = (MemberBean) m.getAttribute("member_info");
		String origin_value = session_member.getAccount();
		String Result = memberservice.check_unique("account", account, origin_value);
		System.out.println(Result);
		return Result;
	}
	
	
	@GetMapping(value = "/gocheck_email", produces = "application/json; charset=UTF-8")
	public @ResponseBody String processAjaxCheckEmail(@RequestParam("email") String email,  Model m) {
		MemberBean session_member = (MemberBean) m.getAttribute("member_info");
		String origin_value = session_member.getE_mail();
		String Result = memberservice.check_unique("e_mail", email, origin_value);
		System.out.println(Result);
		return Result;
	}
	
	
	@GetMapping(value = "/gocheck_phone", produces = "application/json; charset=UTF-8")
	public @ResponseBody String processAjaxCheckPhone(@RequestParam("cellphone") String phone, Model m) {
		MemberBean session_member = (MemberBean) m.getAttribute("member_info");
		String origin_value = session_member.getCellphone();
		String Result = memberservice.check_unique("cellphone", phone, origin_value);
		System.out.println(Result);
		return Result;
	}
	
	
	
	@ModelAttribute("member")
	public MemberBean getMemberBean_BerforEveryMethod(Model m) {
		
		System.out.println("member : ModelAttribute auto execute before every method");
		if (m.getAttribute("member_info") != null) {
			MemberBean session_member = (MemberBean) m.getAttribute("member_info");
			MemberBean member = memberservice.member_member_info(session_member.getId());
			return member;
		}		
		return null;
	}
	
	@ModelAttribute("job_list")
	public List<MemberJobs> getMemberJob_BerforEveryMethod(Model m) {
		System.out.println("job_list : ModelAttribute auto execute before every method");
		List<MemberJobs> list = adminmemberservice.admin_selectAll_jobs();		
		return list;	
	}
	
	@ModelAttribute("gender_map")
    public Map<String, String>  getGenderMap(){
		System.out.println("gender_map : ModelAttribute auto execute before every method");
		Map<String, String> map = new HashMap<>();
		map.put("其他", "其他");
		map.put("女性", "女性");
		map.put("男性", "男性");
		return map;
    }
	
//	擋住直接輸入 post url
	@GetMapping("/update_member_1")
	public String processRedirPosttoGetUpdate(@CookieValue(value = "StockOverFlowMember", defaultValue = "None") String cookie_value, RedirectAttributes ra) {
		if (cookie_value.equals("None")) {
			return "redirect:/front/unmember/gologin_1";
		} else {
			boolean cookie_exist = memberservice.check_cookie(cookie_value);
			if (!cookie_exist) {
				System.out.println("cookie doesn't exist");
				return "redirect:/front/unmember/gologin_1";
			}
		}
		return "redirect:/front/member_up/goupdate_1";
	}
	
	@PostMapping("/update_member_1")
	public String processUoddate(@ModelAttribute(name = "member") @Valid MemberBean memberbean,
								 BindingResult result,
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
		
		String birthday = memberbean.getBirthday();
		System.out.println("birthday:   " + birthday );
		
		String phone = memberbean.getCellphone();
//		因為數據庫出生日期類行為date, 
//		所以如果前端不選擇任何值會認定為是空字串 數據庫會報錯 因此改設為null來表示
		if (birthday.equals("")) {
			birthday = "0000-00-00";
		}
//		因為前端會把空值 設成空字串 所以沒輸入要維持 null
//		在這設為null
		if (phone.equals("")) {
			phone = null;
		}
		
//		不會用 vaildator 檢查 用這種方式檢查
		if (result.hasErrors()) {
			System.out.println("member register validaing");
			List<ObjectError> errorList = result.getAllErrors();
			for (ObjectError error : errorList) {
				System.out.println(error.getDefaultMessage());
				System.out.println();
			}
			return "front/jsp/1_Member/memberInfo/update_info_1";
		}

//		從session中拿出id 幫助更新
		MemberBean session_member = (MemberBean) m.getAttribute("member_info");
//		
//		member set new value
//		memberbean.setId(session_member.getId());
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
		System.out.println("placeImage: " + placeImage);
		
//		如果圖片不為空再執行
		if (placeImage != null) {
			try {
				InputStream is = placeImage.getInputStream();
				fileuploadname = placeImage.getOriginalFilename();
				blob = SystemUtils.inputStreamToBlob(is);
				mimeType = context.getMimeType(fileuploadname);
//				
//				member set new value
				memberbean.setPicture(blob);
//				
//				member set new value
				memberbean.setMimeType(mimeType);
			} catch(Exception e) {
				e.printStackTrace();
				ra.addFlashAttribute("Message", "圖片上傳錯誤");
				return "redirect:/front/member_up/gomessage_page_1";
			}
			
			
			System.out.println("uploadfile name = " + fileuploadname);
//			找出儲存圖片的類型 例如png jpg
			String ext = SystemUtils.getExtFilename(fileuploadname);
			// 將上傳的檔案移到指定的資料夾
			try {			
//				我們可以使用 FileSystem 類的 getDefault() 方法來獲取預設的 FileSystem，
//				然後使用 toAbsolutePath() 方法來獲取當前工作目錄的絕對路徑。請看下面的例子。
				Path path = FileSystems.getDefault().getPath("");
				String directoryName = path.toAbsolutePath().toString();
				System.out.println("Current Working Directory is = " + directoryName);
				
				
				File imageFolder = new File(directoryName + SystemUtils.PLACE_IMAGE_FOLDER);
				if (!imageFolder.exists())
					imageFolder.mkdirs();
				File file = new File(imageFolder, "MemberImage_" + session_member.getId() + ext);
				placeImage.transferTo(file);
//				
//				member set new value
				memberbean.setPictureFile_name("MemberImage_" + session_member.getId() + ext);
				
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("檔案上傳發生異常: " + e.getMessage());
			}
		} 
		int is_update = 0;

		try {
			is_update = memberservice.member_updateAccount(memberbean);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("失敗報錯 UNIQUEKEY");
			ra.addFlashAttribute("Message", "無法更新, 不能使用已註冊過的會員資訊（帳號, Email, 電話)");
			return "redirect:/front/member_up/gomessage_page_1";
		}

		if (is_update == 1) {
			m.addAttribute("member_info", memberbean);
			System.out.println("update success");
			ra.addFlashAttribute("Message", "會員資料更新成功");		
		} 
//		else {
//			System.out.println("無法更新，請回報");
//			m.addAttribute("message", "無法更新，請回報");
//		}
		return "redirect:/front/member_up/gomessage_page_1";	
	}
}
