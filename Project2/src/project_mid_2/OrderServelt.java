package project_mid_2;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;


@WebServlet("/OrderSevelt")
public class OrderServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//指定編碼、輸出設定
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter sout = response.getWriter();	
//UUID主鍵
		java.util.UUID uuid = java.util.UUID.randomUUID();
		String order_ID     = uuid.toString();
//取值測試
		String stock_ID        = request.getParameter("stock_ID"       );
		String com_ID          = request.getParameter("com_ID"         );
		String order_price     = request.getParameter("order_price"    ); 
		String order_quant     = request.getParameter("order_quant"    );
		String order_total     = request.getParameter("order_total"    );
		String order_date      = request.getParameter("order_date"     );
		String order_time      = request.getParameter("order_time"     );
		String trans_cond      = request.getParameter("trans_cond"     );
		String trans_way       = request.getParameter("trans_way"      );
		String trans_sellorbuy = request.getParameter("trans_sellorbuy");
		String trans_stats     = request.getParameter("trans_stats"    );
		String trans_report    = request.getParameter("trans_report"   );
//封裝
		ArrayList<OrderBean> orderlist  = new ArrayList<OrderBean>();
		OrderBean items =new OrderBean();
		items.setOrder_ID       (request.getParameter("order_ID")       );
		items.setStock_ID       (request.getParameter("stock_ID")       );
		items.setCom_ID         (request.getParameter("com_ID")         );
		items.setOrder_price    (request.getParameter("order_price")    );
		items.setOrder_quant    (request.getParameter("order_quant")    );
		items.setOrder_total    (request.getParameter("order_total")    );
		items.setOrder_date     (request.getParameter("order_date")     );
		items.setOrder_time     (request.getParameter("order_time")     );
		items.setTrans_cond     (request.getParameter("trans_cond")     );
		items.setTrans_way      (request.getParameter("trans_way")      );
		items.setTrans_sellorbuy(request.getParameter("trans_sellorbuy"));
		items.setTrans_stats    (request.getParameter("trans_stats")    );
		items.setTrans_report   (request.getParameter("trans_report")   );
		orderlist.add(items);

		
		request.getRequestDispatcher("control.java").include(request, response);
		
	
//建立seesion
		HttpSession session = request.getSession(); 
		session.setAttribute("order_ID", request.getParameter("order_ID"));
		session.setAttribute("stock_ID", request.getParameter("stock_ID"));

//資料庫連線
		Connection         conn  = null;
		PreparedStatement  pstmt = null;
		ResultSet  rs   = null;
		
		String sql ="USE [Demo]\r\n"
				+ "  INSERT INTO [dbo].[order_list]\r\n"
				+ "           ([order_ID]\r\n"
				+ "           ,[stock_ID]\r\n"
				+ "           ,[com_ID]\r\n"
				+ "           ,[order_price]\r\n"
				+ "           ,[order_quant]\r\n"
				+ "           ,[order_total]\r\n"
				+ "           ,[order_date]\r\n"
				+ "           ,[order_time]\r\n"
				+ "           ,[trans_cond]\r\n"
				+ "           ,[trans_way]\r\n"
				+ "           ,[trans_sellorbuy]\r\n"
				+ "           ,[trans_stats]\r\n"
				+ "           ,[trans_report])\r\n"
				+ "   VALUES\r\n"
				+ "           (?,?,?,?,?,?,?,?,?,?,?,?,?)" ;
		
		try {
			Context ctx = new javax.naming.InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/myProject2");
		
			try {
				conn  =ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				
//?填入值,放進資料庫
				pstmt.setString(1,order_ID        );
				pstmt.setString(2,stock_ID        );
				pstmt.setString(3,com_ID          );
				pstmt.setString(4,order_price     );
				pstmt.setString(5,order_quant     );
				pstmt.setString(6,order_total     );
				pstmt.setString(7,order_date      );
				pstmt.setString(8,order_time      );
				pstmt.setString(9,trans_cond      );
				pstmt.setString(10,trans_way      );
				pstmt.setString(11,trans_sellorbuy);
				pstmt.setString(12,trans_stats    );
				pstmt.setString(13,trans_report   );
				
				pstmt.executeUpdate();
				sout.println("下單完成!");
				
				request.getRequestDispatcher("Order.jsp").include(request, response);
				
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
