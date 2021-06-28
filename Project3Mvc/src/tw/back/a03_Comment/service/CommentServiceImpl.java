package tw.back.a03_Comment.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import tw.back.a03_Comment.dao.CommentDaoImpl;
import tw.back.a03_Comment.model.Comment_board_3;


@Service("socialService")
public class CommentServiceImpl{

	public CommentServiceImpl() {
		System.out.println("---CommentServiceImpl------------------------------------");
	}
	
	@Autowired
	public CommentDaoImpl commentDao;
	
	
	@Override
	public Comment_board_3 findCommentByComment_num(Integer comment_num) {
		return socialDao.findCommentByComment_num(comment_num);
	}

	@Override
	public List<Comment_board_3> findAllText() {
		return socialDao.findAllText();
	}

	@Override
	public boolean insertComment(Comment_board_3 bean) {
		return socialDao.insertComment(bean);
	}

	@Override
	public boolean deleteComment(Integer comment_num) {
		return socialDao.deleteComment(comment_num);
	}

	@Override
	public boolean updateComment(Comment_board_3 bean) {
		return socialDao.updateComment(bean);
	}

}
