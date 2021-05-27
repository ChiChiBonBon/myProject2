
import java.sql.Connection;
import java.util.ArrayList;

import bean01_3.SocialBean_3;


public interface SocialDAO_3 {
	
	SocialBean_3 findCommentByComment_num(String comment_num);
	
	SocialBean_3 findAllText();
	
	boolean insertComment(SocialBean_3 social);
	
	boolean deleteComment(String comment_num);

	boolean updateComment(SocialBean_3 social);

}
