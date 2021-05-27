package project_mid_2;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter sout = response.getWriter();
		
//測試取值進資料庫	
//		String stock_ID = request.getParameter("stock_ID");
//		String user_acc = request.getParameter("user_account"  );
//		String user_pas	= request.getParameter("user_password" );
	
//
//		sout.println("測試證券戶號是:" + stock_ID);
//		sout.println("<br>");
//		sout.println("您輸入的帳號是:" + user_acc);
//		sout.println("<br>");
//		sout.println("您輸入的密碼是:" + user_pas);
//		sout.println("<br>");
//		sout.println("-------------------------------");
//		sout.println("<br>");
		
		
//測試session
		HttpSession session = request.getSession(); 
		session.setAttribute("stock_ID",      request.getParameter("stock_ID")     );
		session.setAttribute("user_account",  request.getParameter("user_account") );
		session.setAttribute("user_password", request.getParameter("user_password"));
		
		String stock_ID      = (String) session.getAttribute("stock_ID"     );
		String user_account  = (String) session.getAttribute("user_account" );
		String user_password = (String) session.getAttribute("user_password");
		
		request.getRequestDispatcher("test_to_order.jsp").include(request, response);

		
//資料庫連線ByJNDI
		Connection         conn  = null;
		PreparedStatement  pstmt = null;
		ResultSet  rs   = null;
		
		String sql =
				  "  INSERT INTO [dbo].[member]\r\n"
				+ "     ([stock_ID]\r\n"
				+ "     ,[mber_acc]\r\n"
				+ "     ,[mber_psd])\r\n"
				+ "  VALUES\r\n"
				+ "           (?,?,?)";
		
		try {
			Context ctx = new javax.naming.InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/myProject2");
		
			try {
				conn  =ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				
//?填入值,放進資料庫
				pstmt.setString(1,stock_ID);
				pstmt.setString(2,user_account);
				pstmt.setString(3,user_password);
				
				pstmt.executeUpdate();
				sout.println("寫入資料成功");
				
			} catch (SQLException e) {
				sout.println("SQL語法錯誤!");
				e.printStackTrace();
			}
			
		} catch (NamingException e) {
			sout.println("建立資料庫連線失敗!");
			e.printStackTrace();
		} catch (Exception e) {
			sout.println("寫進資料庫失敗!");
		}
		
		
		
		
		
		
		
	}

}
