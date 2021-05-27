package myServlet_1;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
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


import projectDAO.projectDAOImpl_1.ProjectDAOImpl;
import projectDAO_1.ProjectDAO;
import projectVO_1.ProjectBean;

/**
 * Servlet implementation class Register_1
 */
@WebServlet("/Register_1")
public class Register_1 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	DataSource ds;


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Register_1() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
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
		String password_che = request.getParameter("password_2");
		String name = request.getParameter("name_1");
		String gender = request.getParameter("gender_1");
		String email = request.getParameter("email_1");
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
		
		System.out.println(password);
		System.out.println(password_che);
		System.out.println(password_encodeString);
		
		if (password.equals(password_che)) {
			ProjectBean projectBean = new ProjectBean();
			projectBean.setAccount(account);
			projectBean.setPassword(password_encodeString);
			projectBean.setName(name);
//			System.out.println(gender);
			projectBean.setGender(gender);
			projectBean.setE_mail(email);
			
			
			
			
			Connection conn = null;
			ProjectDAO dao = new ProjectDAOImpl();
			
			try {
				conn = this.ds.getConnection();
				int is_create =  dao.createAccount(projectBean, conn);
//				System.out.println("create account: " + is_create);
				String reString = null;
				if (is_create == 1) {
					reString = "帳號創建成功";
				} else if (is_create == -1) {
					reString = "帳號創建失敗, 會員帳號已使用";
				} else if (is_create == -2) {
					reString = "帳號創建失敗, 電子信箱已使用";
				}else {
					reString = "帳號創建失敗";
				}
				response.setContentType("text/html");   //setup response content type
				response.setCharacterEncoding("UTF-8"); //setup response character encoding type
				PrintWriter out = response.getWriter();
					
				out.println("<!DOCTYPE html>\n"
						+ "<html lang=\"en\">\n"
						+ "<head>\n"
						+ "    <meta charset=\"UTF-8\">\n"
						+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n"
						+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
						+ "    <title>Document</title>\n"
						+ "</head>\n"
						+ "<body>\n"
						+ "    <h3>" + reString + "</h3>\n"
						+ "    <a href=\"login_1.jsp\"> 返回登入 </a>\n"
						+ "</body>\n"
						+ "</html>");
				
				
				
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
			
			
		} else {
			System.out.println("確認密碼不一致");
			request.setAttribute("message", "確認密碼不一致");
			request.getRequestDispatcher("/register_1.jsp").forward(request, response);
			
		}
	
	}
}
