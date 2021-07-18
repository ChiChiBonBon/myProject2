package tw.front.a03_Comment.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.front.a03_Comment.dao.FrontCommentDaoImpl;
import tw.front.a03_Comment.dao.FrontPostDaoImpl;
import tw.front.a03_Comment.model.Comment_board;
import tw.front.a03_Comment.model.Post_board;




@Service("FrontCommentServiceImpl")
@Transactional
public class FrontCommentServiceImpl{

	public FrontCommentServiceImpl() {
		System.out.println("---FrontCommentServiceImpl------------------------------------");
	}
	
	@Autowired
	public FrontCommentDaoImpl commentDao;
	
	@Autowired
	public FrontPostDaoImpl postdao;
	
	
	public Comment_board findCommentByComment_num(Integer comment_num) {
		return commentDao.findCommentByComment_num(comment_num);
	}

	public Map<String, Object> findBypost_num(Integer postboard) {
		System.out.println("service post_num = "+ postboard);
		return commentDao.findBypost_num(postboard);
	}
	
	// 關聯資料表=======================================
	public boolean insertComment(Comment_board bean) {
		Post_board postboard = postdao.findPostByPost_num(bean.getPostboard().getPost_num());
		bean.setPostboard(postboard);
		return commentDao.insertComment(bean);
	}
	// =================================================

	public boolean deleteComment(Integer comment_num) {
		return commentDao.deleteComment(comment_num);
	}

	public boolean updateComment(Comment_board bean) {
		return commentDao.updateComment(bean);
	}

}
