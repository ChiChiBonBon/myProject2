package tw.back.a03_Comment.service;

import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.back.a03_Comment.dao.CommentDaoImpl;
import tw.back.a03_Comment.dao.PostDaoImpl;
import tw.back.a03_Comment.model.Comment_board_3;
import tw.back.a03_Comment.model.Post_board_3;


@Service
@Transactional
public class CommentServiceImpl{

	public CommentServiceImpl() {
		System.out.println("---CommentServiceImpl------------------------------------");
	}
	
	@Autowired
	public CommentDaoImpl commentDao;
	
	@Autowired
	public PostDaoImpl postdao;
	
	
	public Comment_board_3 findCommentByComment_num(Integer comment_num) {
		return commentDao.findCommentByComment_num(comment_num);
	}

	public Map<String, Object> findBypost_num(Integer postboard) {
		System.out.println("service post_num = "+ postboard);
		return commentDao.findBypost_num(postboard);
	}
	
	// 關聯資料表=======================================
	public boolean insertComment(Comment_board_3 bean) {
		Post_board_3 postboard = postdao.findPostByPost_num(bean.getPostboard().getPost_num());
		bean.setPostboard(postboard);
		return commentDao.insertComment(bean);
	}
	// =================================================

	public boolean deleteComment(Integer comment_num) {
		return commentDao.deleteComment(comment_num);
	}

	public boolean updateComment(Comment_board_3 bean) {
		return commentDao.updateComment(bean);
	}

}
