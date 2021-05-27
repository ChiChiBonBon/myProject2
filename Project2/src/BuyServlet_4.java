
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class BuyServlet_4
 */
@WebServlet("/BuyServlet_4")
public class BuyServlet_4 extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BuyServlet_4() {
		super();
		// TODO Auto-generated constructor stub
	}



	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 確認前端資料 (encondig)
		// 建立Database Access Object,負責Table的Access
		BuyDAO_4 buyDAO_4 = new BuyDAO_4();

		// 如果要編碼值為UTF-8
		request.setCharacterEncoding("UTF-8");

		// 確認HTML 的CRUD button
		String name = request.getParameter("aaa");

		// 建立Context Object,連到JNDI Server
		DataSource ds = null;
		InitialContext ctxt = null;
		Connection conn = null;
		try {
			ctxt = new InitialContext();
			// 使用JNDI API找到DataSource
			ds = (DataSource) ctxt.lookup("java:comp/env/jdbc/myProject2");

			// 向DataSource要Connection
			conn = ds.getConnection();

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 將資料傳到 Control (request, response)
		switch (name) {
//		新增
		case "新增":
//	    	 創建insert物件
			BuyComtrol_4 insert = new BuyComtrol_4();
			insert.insert(request, response, conn);
//	    	使用insert方法
			
			//當新增完成後進入看所有資料
			BuyComtrol_4 select1 = new BuyComtrol_4();
			select1.select(request, response, conn);
			break;
//			搜尋
		case "現有產品":
			BuyComtrol_4 select = new BuyComtrol_4();
			select.select(request, response, conn);
			break;
//	    	 修改
		case "修改":
			BuyComtrol_4 update = new BuyComtrol_4();
			update.update(request, response, conn);
			
			BuyComtrol_4 select2 = new BuyComtrol_4();
			select2.select(request, response, conn);
			break;
//	    	 刪除
		case "刪除":

			BuyComtrol_4 delete = new BuyComtrol_4();
			delete.delete(request, response, conn);
			
			BuyComtrol_4 select3 = new BuyComtrol_4();
			select3.select(request, response, conn);
			break;

		default:
			break;
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
