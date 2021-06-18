package tw.comment_3.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import tw.comment_3.bean.Comment_board_3;
import tw.comment_3.model.SocialService;

@Controller
public class CommentController {
	
	@Autowired
	private SocialService service;
	
	//跳轉頁面===============================================================================================
	//進入首頁
	@GetMapping(value = "/3_index")
	public String HomePage() {
		return "3_index";
	}

    //檢視更多後導到第2張jsp
	@GetMapping(value = "/commentBoard")
	public String showAllCommentView() {
		return "3_Post";
	}
	
	//進入修改頁面
	@GetMapping(value = "/updatecomment/{comment_num}")
	public String updateComment(@PathVariable Integer comment_num, Model m) {
		Comment_board_3 bean = service.findCommentByComment_num(comment_num);
		System.out.println(comment_num);
		System.out.println(bean.getComment_num());
		m.addAttribute("bean",bean);
		System.out.println(123);
		return "3_update";
	}
	
	//輸入留言後導到第二張jsp
//	@PostMapping(value = "/commentBoard")
//	public String HomePage2(@ModelAttribute Comment_board_3 social,BindingResult result,Model m) {
//		m.addAttribute("mComment_num",social.getComment_num());
//		m.addAttribute("mComment",social.getComment());
//		return "3_PostCOL";
//	}
	

	
	
	//ajax===================================================================================================
	
	
	
	
//	判斷有沒有輸入留言
	@PostMapping(value = "/commentBoard2",consumes = "application/json", produces = { "application/json" })
	public @ResponseBody Map<String, String> save(@RequestBody Comment_board_3 bean){
		Map<String, String> map = new HashMap<>();
		boolean insert = service.insertComment(bean);
		System.out.println(insert);
		if (insert) {
			map.put("success", "已送出留言");
			System.out.println("true");
		}else {
			map.put("fail", "留言發送失敗");
			System.out.println("false");
		}
		return map;
	}
	//查詢所有留言資料
	@GetMapping(value = "/commentBoardJSON")
	public @ResponseBody List<Comment_board_3> selectAll(){
		//Model是用來換頁使用 若沒有要使用換頁 就不需要Model
		//ajax可以做到不換頁功能
		List<Comment_board_3> list = service.findAllText();
		System.out.println(list);
		return list;
	}
	
	
	
	
	@PutMapping(value = "/updatecomment/{comment_num}", consumes = { "application/json" }, produces = { "application/json" })
	public @ResponseBody Map<String, String> updateComment(@RequestBody Comment_board_3 bean,@PathVariable Integer comment_num){
		Map<String, String>map = new HashMap<>();
		System.out.println("要修改的樓層:"+comment_num);
		try {
			service.updateComment(bean);
			map.put("success", "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("fail", "修改失敗");
		}
		return map;
	}
	
	@DeleteMapping(value = "/commentBoardDEL/{comment_num}", consumes = { "application/json" }, produces = { "application/json" })
	public @ResponseBody Map<String, String>deleteComment(@PathVariable(required = true) Integer comment_num){
		System.out.println("刪除controller"+comment_num);
		Map<String, String>map = new HashMap<>();
		   try {
		    service.deleteComment(comment_num);
		    map.put("success", "刪除成功");
		   } catch (Exception e) {
		    e.printStackTrace();
		    map.put("fail", "刪除失敗");
		    System.out.println("刪除失敗");
		   }
		return map;
	}
}
