package tw.comment_3.model;

import java.util.List;

import tw.comment_3.bean.Comment_board_3;

public interface SocialDao {
	
	public Comment_board_3 findCommentByComment_num(Integer comment_num);
	
	public List<Comment_board_3> findAllText();
	
	public boolean insertComment(Comment_board_3 bean);
	
	public boolean deleteComment(Integer comment_num);

	public boolean updateComment(Comment_board_3 bean);

}