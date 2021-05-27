

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import bean01_3.SocialBean_3;

public class SocialDAOImpl_3 implements SocialDAO_3 {

	private Connection conn;

	public SocialDAOImpl_3(Connection conn) {
		this.conn = conn;
	}

	@Override
	public SocialBean_3 findCommentByComment_num(String comment_num) {
		SocialBean_3 Bean = new SocialBean_3();
		String sql = "SELECT * FROM [dbo].[comment_board_3] where [comment_num] =?";
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, comment_num);
			ResultSet rt = st.executeQuery();
			while (rt.next()) {
				Bean.setComment_num(rt.getString   ("comment_num"));
				Bean.setComment	   (rt.getString("comment"));
			}
			conn.close();
			} catch (Exception e) {
				e.printStackTrace();
		}
		return Bean;
	}
	
	@Override
	public SocialBean_3 findAllText() {
		ArrayList dbcomment_num =new ArrayList();
		ArrayList dbcomment =new ArrayList();
		String sql = "select * from [dbo].[comment_board_3]";
		SocialBean_3 Bean = new SocialBean_3();
		try {
			Statement st = conn.createStatement();
			ResultSet rt = st.executeQuery(sql);
			while (rt.next()) {
				dbcomment_num.add(rt.getString("comment_num"));
				dbcomment.add(rt.getString("comment"));
				Bean.setDBcomment_num(dbcomment_num);
				Bean.setDBcomment(dbcomment);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Bean;
	}

	@Override
	public boolean insertComment(SocialBean_3 social) {
		String sql = "INSERT INTO [dbo].[comment_board_3]\r\n"
				+ "           ([comment])\r\n"
				+ "     VALUES (?)";
		boolean isInsert = false;
		try {
			PreparedStatement st = conn.prepareStatement(sql);

			st.setString(1, social.getComment());
			int i = st.executeUpdate();
			if (i > 0) {
				isInsert = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isInsert;
	}

	@Override
	public boolean deleteComment(String comment_num) {
		String sql = "DELETE FROM [dbo].[comment_board_3]\r\n"
				+ "      WHERE [comment_num] =?";
		boolean isDelete = false;
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, comment_num);
			int i = st.executeUpdate();
			if (i > 0) {
				isDelete = true;
			}

//			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return isDelete;
	}

	@Override
	public boolean updateComment(SocialBean_3 social) {
		String sql = "UPDATE [dbo].[comment_board_3]\r\n"
				+ "   SET [comment] = ?\r\n"
				+ " WHERE [comment_num] =?";
		boolean isUpdate = false;
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, social.getComment());
			st.setString(2, social.getComment_num());

			int i = st.executeUpdate();
			if (i > 0) {
				isUpdate = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isUpdate;
	}

}
