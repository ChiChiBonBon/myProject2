package tw.comment_3.model;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import tw.comment_3.bean.Comment_board_3;

@Service("socialService")
@Transactional
@EnableTransactionManagement
public class SocialServiceImpl implements SocialService{

	@Autowired
	public SocialDao socialDao;
	
	public SocialServiceImpl() {
		
	}
	
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
