package tw.back.a03_Comment.controller;

import java.io.File;
import java.io.InputStream;
import java.security.Timestamp;
import java.sql.Blob;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import tw.back.a03_Comment.model.Comment_board_3;
import tw.back.a03_Comment.model.Post_board_3;
import tw.back.a03_Comment.service.CommentServiceImpl;
import tw.back.a03_Comment.service.PostServiceImpl;
import tw.back.a03_Comment.utils.SystemUtils;



@Controller
public class CommentController {
	
	@Autowired
	private CommentServiceImpl commentService;
	
	@Autowired
	private PostServiceImpl postService;
	
	// 自動幫我們產生mimeType
	@Autowired
	ServletContext context;
	
	// 跳轉頁面===============================================================================================
	// 進入後臺文章首頁
	@GetMapping(value = "/post")
	public String PostHomePage() {
		return "back/jsp/3_Comment/post";
	}

    // 點選某篇文章後到文章編輯&秀該文章留言的jsp
	@GetMapping(value = "/postedit/{post_num}")
	public String Postedit(@PathVariable Integer post_num, Model m) {
		Post_board_3 bean = postService.findPostByPost_num(post_num);
		System.out.println("文章編號 = "+post_num);
		System.out.println(bean.getPost_num());
		m.addAttribute("bean",bean);
		System.out.println("Model = "+m);
		return "back/jsp/3_Comment/postedit";
	}
	
	
	
	// 點選該文章內某則留言 導到該留言編輯的jsp
	@GetMapping(value = "/comedit/{comment_num}")
	public String updateComment(@PathVariable Integer comment_num, Model m) {
		Comment_board_3 bean = commentService.findCommentByComment_num(comment_num);
		System.out.println("留言編號 = "+comment_num);
		System.out.println(bean.getComment_num());
		m.addAttribute("bean",bean);
		System.out.println("Model = "+m);
		return "back/jsp/3_Comment/comedit";
	}
	

	
//	//ajax===================================================================================================
//	
//	
//	
//	測試用
	@PostMapping(value = "/post/getImgFile", consumes = { "multipart/form-data"})
	public void getImgFile( @RequestParam MultipartFile imgFile,
							@RequestParam String userid,
							@RequestParam String title,
							@RequestParam String postType,
							@RequestParam Integer post,
							@RequestParam String ptime
			) {
		System.out.println("=========MultiTesting=======");
		
		System.out.println(imgFile.getOriginalFilename());
		System.out.println(userid);
		System.out.println(title);
		System.out.println(postType);
		System.out.println(post);
		System.out.println(ptime);
		
	}
	
	
//	判斷管理者有無送出文章
	@PostMapping(value = "/postinsert", consumes = { "multipart/form-data"})
	public @ResponseBody Map<String, String> save( 
			@RequestParam MultipartFile imgFile,
			@RequestParam String userid,
			@RequestParam String title,
			@RequestParam String postType,
			@RequestParam String post,
			@RequestParam String ptime
			) {
		System.out.println("====Json Testing =====");
		Map<String, String> map = new HashMap<>();
		System.out.println(ptime);
		
		// timestamp進不去======================================================================
		DateFormat toFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		toFormat.format(ptime);
		java.sql.Timestamp date = java.sql.Timestamp.valueOf(ptime);
		Post_board_3 bean = new Post_board_3(null,userid,postType,title,post,date,null, null, null,imgFile);
		// =====================================================================================
		
		boolean insert = postService.insertPost(bean);
		System.out.println(insert);
		// 將上傳的檔案放到表格內
				// 優點是備份後匯入資料庫方便 缺點為圖片檔很大 會給資料庫帶來負擔
				Blob blob = null;
				String mimeType = "";
				String name = "";
				MultipartFile postImage = bean.getPostImage();
				try {
					InputStream is = postImage.getInputStream();
					name = postImage.getOriginalFilename();
					// 你給我inputStream我就給你Blob
					blob = SystemUtils.inputStreamToBlob(is);
					mimeType = context.getMimeType(name);
					bean.setPpicture(blob);
					bean.setPmimeType(mimeType);
				} catch(Exception e) {
					e.printStackTrace();
				}
				
				postService.insertPost(bean);  
				// 最後才存入資料庫 寫在上傳的檔案放到表格內的功能的最後
				// 先讓資料庫存bean進去 底下再把主鍵拿出來用 寫在上傳的檔案移到指定的資料夾之前
				// 不最後再存 是避免主鍵定義時重複的問題
				
				System.out.println("name=" + name);
				
				// ==================================================================================
				// 將上傳的檔案移到指定的資料夾, 目前註解此功能
				// 減輕資料庫的負擔 缺點為匯入較麻煩 但業界比較常用此方式
				String ext = SystemUtils.getExtFilename(name);
				try {
					File imageFolder = new File(SystemUtils.POST_IMAGE_FOLDER);
					if (!imageFolder.exists())
						imageFolder.mkdirs();
					File file = new File(imageFolder, "PostImage_" + bean.getPost_num() + ext);
					postImage.transferTo(file);
				} catch (Exception e) {
					e.printStackTrace();
					throw new RuntimeException("檔案上傳發生異常: " + e.getMessage());
				}
				// ===================================================================================

		if (insert) {
			map.put("success", "已送出文章");
			System.out.println("true");
		}else {
			map.put("fail", "文章發送失敗");
			System.out.println("false");
		}
		return map;
	}

	// 文章table的JSON資料
	@GetMapping(value={"/showAllPost"}, produces = "application/json; charset=UTF-8")	
	public @ResponseBody Map<String, Object> findAllPost(){
		return postService.findAllPost(); 
	}
	
	// 留言table的JSON資料
	@GetMapping(value="/findBypost_num", produces = "application/json; charset=UTF-8")	
	public @ResponseBody Map<String, Object> findBypost_num(@RequestParam(value = "post_num", required = false)
	Integer postboard){
		System.out.println("控制器post_num = "+ postboard);
		return commentService.findBypost_num(postboard);
	}
	
	
	// 修改文章
	@PutMapping(value = "/postedit", consumes = { "application/json" })
	public @ResponseBody Map<String, String> updatePost(@RequestBody Post_board_3 bean){
		Map<String, String>map = new HashMap<>();
		System.out.println("文章put控制器進來了");
		try {
			postService.updatePost(bean);
			map.put("success", "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("fail", "修改失敗");
		}
		return map;
	}
	
	// 修改留言
	@PutMapping(value = "/commentedit", consumes = { "application/json" })
	public @ResponseBody Map<String, String> updateComment(@RequestBody Comment_board_3 bean){
		Map<String, String>map = new HashMap<>();
		System.out.println("留言put控制器進來了");
		try {
			commentService.updateComment(bean);
			map.put("success", "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("fail", "修改失敗");
		}
		return map;
	}
	
	// 刪除文章
	@DeleteMapping(value = "/deletepost/{post_num}", consumes = { "application/json" }, produces = { "application/json" })
	public @ResponseBody Map<String, String>deletePost(@PathVariable(required = true) Integer post_num){
		System.out.println("刪除文章controller"+post_num);
		Map<String, String>map = new HashMap<>();
		   try {
		    postService.deletePost(post_num);
		    map.put("success", "刪除成功");
		   } catch (Exception e) {
		    e.printStackTrace();
		    map.put("fail", "刪除失敗");
		    System.out.println("刪除失敗");
		   }
		return map;
	}
	
	// 刪除留言
	@DeleteMapping(value = "/deletecomment/{comment_num}", consumes = { "application/json" }, produces = { "application/json" })
	public @ResponseBody Map<String, String>deleteComment(@PathVariable(required = true) Integer comment_num){
		System.out.println("刪除留言controller"+comment_num);
		Map<String, String>map = new HashMap<>();
		try {
			commentService.deleteComment(comment_num);
			map.put("success", "刪除成功");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("fail", "刪除失敗");
			System.out.println("刪除失敗");
		}
		return map;
	}
}
