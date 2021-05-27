package myServlet_1;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import projectDAO.projectDAOImpl_1.ProjectDAOImpl;
import projectDAO_1.ProjectDAO;
import projectVO_1.ProjectBean;

/**
 * Servlet implementation class Login_1
 */
@WebServlet(urlPatterns = { "/Login_1" }, initParams = { @WebInitParam(name = "Johnny_admin", value = "johnny") })
public class Login_1 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	DataSource ds;


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login_1() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		try {
			InitialContext ctxt = new InitialContext();
			// for SQL Server
			this.ds = (DataSource) ctxt.lookup("java:comp/env/jdbc/myProject2");

			System.out.println("Run init");

		} catch (NamingException ne) {
			throw new ServletException(ne);

		}

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String account = request.getParameter("account_1");
		String password = request.getParameter("password_1");
		String password_encodeString = null;
		
//		加密
		try {
		    MessageDigest digest = MessageDigest.getInstance("SHA-256");
		    digest.reset();
		    digest.update(password.getBytes("utf8"));
		    password_encodeString = String.format("%064x", new BigInteger(1, digest.digest()));
		} catch (NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		System.out.println(account);
		System.out.println(password);
		System.out.println(password_encodeString);
		
		
		Connection conn = null;
		ProjectDAO dao = new ProjectDAOImpl();
		
		try {
			conn = this.ds.getConnection();
			ProjectBean member_info = dao.checkAccount(account, password_encodeString, conn);

			if (member_info != null) {
				System.out.println("login Success");
				System.out.println("account info: " + member_info);
				
//				創造session
				HttpSession session_1 = request.getSession(true);
				session_1.setAttribute("member_info", member_info);
				System.out.println("Login_1: create session");
//		        創造cookie
				Cookie myCookie = new Cookie("cookie_id", "" + member_info.getId());
				myCookie.setMaxAge(30*60);
				response.addCookie(myCookie);
				System.out.println("Login_1: create cookie");

				
				response.sendRedirect("Member_info_1.jsp");
				return;
			}
			System.out.println("請輸入正確帳號密碼");
			request.setAttribute("message", "請輸入正確帳號密碼");
			request.getRequestDispatcher("/login_1.jsp").forward(request, response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
