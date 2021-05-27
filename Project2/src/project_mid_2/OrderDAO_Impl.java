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

@WebServlet("/OrderDAO_Impl")
public class OrderDAO_Impl extends HttpServlet  implements OrderDAO{
	private static final long serialVersionUID = 1L;
       
    public OrderDAO_Impl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//指定編碼、輸出設定
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter sout = response.getWriter();	
//測試
		HttpSession session = request.getSession();
		String stock_ID     = (String) session.getAttribute("stock_ID");
		
//新增下單
		if(request.getParameter("order_ID") !=null) {
			ArrayList<OrderBean> order  = new ArrayList<OrderBean>();
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
			order.add(items);		

			insertOrder(order);
			
			String 	order_list = selectOrder(stock_ID).toString();
			session.setAttribute("order_list",order_list);
			request.getRequestDispatcher("Order.jsp").forward(request, response);
					
		}
		
//刪除訂單			
		String delorder_ID  = request.getParameter("delorder_ID") ;
			if (request.getParameter("delorder_ID") != null) {
				deleteOrder(delorder_ID);
			
				String 	delorder_list = selectOrder(stock_ID).toString();	
				session.setAttribute("order_list",delorder_list);
				request.getRequestDispatcher("select_order.jsp").forward(request, response);

				
			}
//修改訂單
		String change_ID     = request.getParameter("change_ID") ;
		String change_price  = request.getParameter("change_price");
		String change_quant  = request.getParameter("change_quant");
		String change_total  = request.getParameter("change_total");
		
			if(change_price != null) {
				updateOrder(change_ID, change_price, change_quant,change_total);
	
				String 	delorder_list = selectOrder(stock_ID).toString();
				session.setAttribute("order_list",delorder_list);
				request.getRequestDispatcher("select_order.jsp").forward(request, response);
						
			}			
			
//查詢訂單
//		String 	select_list = selectOrder(stock_ID).toString();
//		session.setAttribute("order_list",select_list);
//		request.getRequestDispatcher("select_order.jsp").forward(request, response);
		
	}

//DAO
	@Override
	public void insertOrder(ArrayList<OrderBean> orderlist) {
//JDBC宣告
		Connection         conn  = null;
		PreparedStatement  pstmt = null;
		ResultSet          rs    = null;
		
//資料庫連線
		try {
			Context ctx = new javax.naming.InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/myProject2");
			
			try {
				conn  =ds.getConnection();
				for(int i = 0 ; i<orderlist.size();i++) {
					String sql =
							  "  INSERT INTO [dbo].[order_list_2]\r\n"
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
					
					pstmt = conn.prepareStatement(sql);		
					pstmt.setString(1 ,orderlist.get(i).getOrder_ID()       );
					pstmt.setString(2 ,orderlist.get(i).getStock_ID()       );
					pstmt.setString(3 ,orderlist.get(i).getCom_ID()         );
					pstmt.setString(4 ,orderlist.get(i).getOrder_price()    );
					pstmt.setString(5 ,orderlist.get(i).getOrder_quant()    );
					pstmt.setString(6 ,orderlist.get(i).getOrder_total()    );
					pstmt.setString(7 ,orderlist.get(i).getOrder_date()     );
					pstmt.setString(8 ,orderlist.get(i).getOrder_time()     );
					pstmt.setString(9 ,orderlist.get(i).getTrans_cond()     );
					pstmt.setString(10,orderlist.get(i).getTrans_way()      );
					pstmt.setString(11,orderlist.get(i).getTrans_sellorbuy());
					pstmt.setString(12,orderlist.get(i).getTrans_stats()    );
					pstmt.setString(13,orderlist.get(i).getTrans_report()   );
					
					pstmt.executeUpdate();			
				}
				System.out.println("下單完成!");
				
			} catch (SQLException e) {
				System.out.println("SQL語法錯誤!");
				e.printStackTrace();
			}
			} catch (NamingException e) {
				System.out.println("建立資料庫連線失敗!");
				e.printStackTrace();
			} catch (Exception e) {
				System.out.println("寫進資料庫失敗!");
			}
	
	}

	@Override
	public void deleteOrder(String delorder_ID) {
//		String sql ="USE [Demo]\r\n"
//				+   "DELETE  FROM [dbo].[order_list]\r\n"
//				+   "WHERE [order_ID] = ?";
		
		String sql = 
				     " UPDATE [dbo].[order_list_2]\r\n"
	 		    +    " SET    [trans_report] = '刪單成功'\r\n"
	 		    +    " WHERE  [order_ID] = ? ";
//JDBC宣告
		Connection         conn  = null;
		PreparedStatement  pstmt = null;
		ResultSet          rs    = null;		
//資料庫連線
		try {
			Context ctx = new javax.naming.InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/myProject2");
					
			try {
				conn  =ds.getConnection();	
				pstmt =conn.prepareStatement(sql);
				pstmt.setString(1 ,delorder_ID);
				pstmt.executeUpdate();		
					 System.out.println("刪除資料完成!");
			} catch (SQLException e) {
						System.out.println("SQL語法錯誤!");
						e.printStackTrace();
			}
			} catch (NamingException e) {
						System.out.println("建立資料庫連線失敗!");
						e.printStackTrace();
			} catch (Exception e) {
						System.out.println("讀取資料庫失敗!");
			}
	
		
	}

	@Override
	public  ArrayList<OrderBean> selectOrder(String stock_ID) {
			ArrayList<OrderBean>  order_list = new ArrayList<>();
			String sql =
					    "SELECT  * FROM [dbo].[order_list_2]\r\n"
					+   "WHERE [stock_ID] = ? AND [trans_report] !='刪單成功'";
//JDBC宣告
		Connection         conn  = null;
		PreparedStatement  pstmt = null;
		ResultSet          rs    = null;		
//資料庫連線
		try {
			Context ctx = new javax.naming.InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/myProject2");
			
			try {
				conn  =ds.getConnection();	
				pstmt =conn.prepareStatement(sql);
				pstmt.setString(1 ,stock_ID);
				rs    =pstmt.executeQuery();
				while(rs.next()) {
					OrderBean items =new OrderBean();

					items.setOrder_ID       (rs.getString("order_ID")       );
					items.setStock_ID       (rs.getString("stock_ID")       );
					items.setCom_ID         (rs.getString("com_ID")         );
					items.setOrder_price    (rs.getString("order_price")    );
					items.setOrder_quant    (rs.getString("order_quant")    );
					items.setOrder_total    (rs.getString("order_total")    );
					items.setOrder_date     (rs.getString("order_date")     );
					items.setOrder_time     (rs.getString("order_time")     );
					items.setTrans_cond     (rs.getString("trans_cond")     );
					items.setTrans_way      (rs.getString("trans_way")      );
					items.setTrans_sellorbuy(rs.getString("trans_sellorbuy"));
					items.setTrans_stats    (rs.getString("trans_stats")    );
					items.setTrans_report   (rs.getString("trans_report")   );
					order_list.add(items);	
				}
					System.out.println("查詢完成!");
			} catch (SQLException e) {
				System.out.println("SQL語法錯誤!");
				e.printStackTrace();
			}
			} catch (NamingException e) {
				System.out.println("建立資料庫連線失敗!");
				e.printStackTrace();
			} catch (Exception e) {
				System.out.println("讀取資料庫失敗!");
			}
		
		return order_list;
	}
	
	@Override
	public void updateOrder(String change_ID,String change_price,String change_quant,String change_total) {
		String sql = 
				     " UPDATE [dbo].[order_list_2]  \r\n"
				+    " SET    [order_price]  = ?  \r\n"
				+    "       ,[order_quant]  = ?  \r\n"
				+    "       ,[order_total]  = ?  \r\n"
				+    " WHERE  [order_ID] = ? ";				
//JDBC宣告
Connection         conn  = null;
PreparedStatement  pstmt = null;

//資料庫連線
try {
	Context ctx = new javax.naming.InitialContext();
	DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/myProject2");
			
	try {
		conn  =ds.getConnection();	
		pstmt =conn.prepareStatement(sql);
		pstmt.setString(1 ,change_price);
		pstmt.setString(2 ,change_quant);
		pstmt.setString(3 ,change_total);
		pstmt.setString(4 ,change_ID);
		pstmt.executeUpdate();		
			 System.out.println("修改資料完成!");
	} catch (SQLException e) {
				System.out.println("SQL語法錯誤!");
				e.printStackTrace();
	}
	} catch (NamingException e) {
				System.out.println("建立資料庫連線失敗!");
				e.printStackTrace();
	} catch (Exception e) {
				System.out.println("讀取資料庫失敗!");
	}		
		
	}

}
