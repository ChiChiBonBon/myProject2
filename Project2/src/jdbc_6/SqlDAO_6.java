package jdbc_6;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletContext;

public class SqlDAO_6 implements SqlDAOInt_6{

	@Override
	public TableBean_6 selectDAO(TableBean_6 bean, Connection conn, ServletContext context) {
		
		String sql = "select * from company_6 where business_Accounting_NO = ?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bean.getSearch_business_NO());
			ResultSet rs = pstmt.executeQuery();
			
			Boolean check = true;
			
			while (rs.next()) {

				bean.setBusiness_Accounting_NO(rs.getString("business_Accounting_NO"));
				bean.setCompany_Name          (rs.getString("company_Name"));
				bean.setCapital_Stock_Amount  (rs.getLong("capital_Stock_Amount"));
				bean.setResponsible_Name      (rs.getString("responsible_Name"));
				bean.setCompany_Location      (rs.getString("company_Location"));
				bean.setIs_DB(true);
				bean.setIs_Success(true);
				check = false;
				
			}
			
			if(check) {
				bean.setIs_DB(false);
			}else {
				conn.close();
			}
			
		} catch (SQLException e) {
			context.log("SQL Select Error", e);
		}
		return bean;
	}

	@Override
	public TableBean_6 updateDAO(TableBean_6 bean, Connection conn, ServletContext context) {
		
		String sql = "update company_6 set company_Name=?, capital_Stock_Amount=?, responsible_Name=?, company_Location=? where business_Accounting_NO=?";
		
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(5, bean.getBusiness_Accounting_NO());
			pstmt.setString(1, bean.getCompany_Name());
			pstmt.setLong  (2, bean.getCapital_Stock_Amount());
			pstmt.setString(3, bean.getResponsible_Name());
			pstmt.setString(4, bean.getCompany_Location());
			int in = pstmt.executeUpdate();
			
			if (in > 0) {
				bean.setIs_Success(true);
			}
			conn.close();
		} catch (Exception e) {
			context.log("SQL Update Error", e);
		}
		return bean;
		
	}

	@Override
	public TableBean_6 deleteDAO(TableBean_6 bean, Connection conn, ServletContext context) {
		
		String sql = "delete company_6 where business_Accounting_NO=?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString	(1, bean.getSearch_business_NO());
			int in = pstmt.executeUpdate();
			
			if (in > 0) {
				bean.setIs_Success(true);
			}

			conn.close();
		} catch (Exception e) {
			context.log("SQL Delete Error", e);
		}	
		return bean;
		
	}

	@Override
	public TableBean_6 insertDAO(TableBean_6 bean, Connection conn, ServletContext context) {
		
		String sql = "Insert into company_6(business_Accounting_NO, company_Name, capital_Stock_Amount, responsible_Name, company_Location)"
				+ "values (?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bean.getBusiness_Accounting_NO());
			pstmt.setString(2, bean.getCompany_Name());
			pstmt.setLong  (3, bean.getCapital_Stock_Amount());
			pstmt.setString(4, bean.getResponsible_Name());
			pstmt.setString(5, bean.getCompany_Location());
			int in = pstmt.executeUpdate();
			
			if (in > 0) {		
				bean.setIs_Success(true);
			}
			conn.close();
		} catch (Exception e) {
			context.log("SQL Insert Error", e);
		}
		
		return bean;
	}

}
