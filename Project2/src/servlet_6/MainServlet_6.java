package servlet_6;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import jdbc_6.TableBean_6;

/**
 * Servlet implementation class main
 */
@WebServlet(name = "MainServlet_6", urlPatterns = { "/MainServlet_6" })
public class MainServlet_6 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MainServlet_6() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Encoding
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; Charset=UTF-8");

		// 建立 Bean
		String whichOne = "no";
		TableBean_6 bean = new TableBean_6();
		if (!(request.getParameter("whichOne") == null)) {
			whichOne = request.getParameter("whichOne");
		}

		// css
		request.setAttribute("formData", "none");
		// 建立 Control 物件
		Control_6 control6 = new Control_6();

		// 建立 context 物件
		ServletContext context = this.getServletContext();
		
		// 連線設定
		Connection conn = null;
		try {
			InitialContext ctxt = new InitialContext();
			DataSource ds = (DataSource) ctxt.lookup("java:comp/env/jdbc/myProject2");
			conn = ds.getConnection();

		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 判定是哪個CRUD
		if (whichOne.equals("select")) {
			control6.selectDB(request, response, bean, conn, context);
		} else if (whichOne.equals("insert")) {
			control6.insertDB(request, response, bean, conn, context);
		} else if (whichOne.equals("update")) {
			control6.updateDB(request, response, bean, conn, context);
		} else if (whichOne.equals("delete")) {
			control6.deleteDB(request, response, bean, conn, context);
		} else {
			request.getRequestDispatcher("./company_6.jsp").forward(request, response);
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
