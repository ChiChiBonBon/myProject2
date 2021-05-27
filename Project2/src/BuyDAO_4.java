import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import bean_4.BuyBeam_4;

public class BuyDAO_4 {
	


	//看現有產品
	public ArrayList<BuyBeam_4> select(Connection conn) {
		ArrayList<BuyBeam_4> beam =new ArrayList<>();
		String sql="select * FROM [dbo].[subscribe_form_4]";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs =stmt.executeQuery(sql);
			while (rs.next()) {
				BuyBeam_4 Bean =new BuyBeam_4();
				Bean.setStock_id(rs.getInt("stock_id"));	
				Bean.setStock_name(rs.getString("stock_name"));	
				Bean.setSub_start(rs.getDate("sub_start").toString());		
				Bean.setSub_end(rs.getDate("sub_end").toString());		
				Bean.setSub_quantity(rs.getInt("sub_quantity"));	
				Bean.setSub_price(rs.getInt("sub_price"));
				beam.add(Bean);
				
			}
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return beam;
	}
	//新增產品
	public boolean insert(BuyBeam_4 bean, Connection conn) {
		String sql ="INSERT INTO [dbo].[subscribe_form_4]\r\n"
				+ "           ([stock_id],[stock_name],[sub_start],[sub_end],[sub_quantity],[sub_price])"
				+ "     VALUES  (?,?,?,?,?,?)";
		boolean isInsert=false;
		try {
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(	1, bean.getStock_id());
			stmt.setString(	2, bean.getStock_name());
			stmt.setString(	3, bean.getSub_start());
			stmt.setString(	4, bean.getSub_end());
			stmt.setInt(	5, bean.getSub_quantity());
			stmt.setInt(	6, bean.getSub_price());
			
			int i=stmt.executeUpdate();
			if (i>0) {
				isInsert=true;
			}
		} catch (Exception e) {
			e.printStackTrace();	
		}
		return isInsert;
	}
	
	
	//刪除產品
	public boolean delete(BuyBeam_4 bean, Connection conn) {
		String sql="DELETE FROM [dbo].[subscribe_form_4]"
				+ "      WHERE stock_id=?";
		boolean isDelete=false;
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, bean.getStock_id());
			int i=stmt.executeUpdate();
			if (i>0) {
				isDelete=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isDelete;
	}
	
	//修改產品
	public boolean update(BuyBeam_4 bean, Connection conn) {
		String sql="UPDATE [dbo].[subscribe_form_4]\r\n"
				+ "SET [stock_name] =?,[sub_start] = ?,[sub_end] = ?,[sub_quantity] = ?,[sub_price] = ?"
				+ " WHERE [stock_id] = ?";
		boolean isUpdate =false;
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(	6, bean.getStock_id());
			stmt.setString(	1, bean.getStock_name());
			stmt.setString(	2, bean.getSub_start());
			stmt.setString(	3, bean.getSub_end());
			stmt.setInt(	4, bean.getSub_quantity());
			stmt.setInt(	5, bean.getSub_price());
			int i=stmt.executeUpdate();
			if (i>0) {
				isUpdate=true;
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isUpdate;	
		}
}
