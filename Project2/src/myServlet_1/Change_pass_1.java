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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import projectDAO.projectDAOImpl_1.ProjectDAOImpl;
import projectDAO_1.ProjectDAO;
import projectVO_1.ProjectBean;

/**
 * Servlet implementation class Change_pass
 */
@WebServlet("/Change_pass_1")
public class Change_pass_1 extends HttpServlet {

	private static final long serialVersionUID = 1L;
	DataSource ds;

	@Override
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
	 * @see HttpServlet#HttpServlet()
	 */
	public Change_pass_1() {
		super();
		// TODO Auto-generated constructor stub
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
		String originString = request.getParameter("orgin_pass_1");
		String newsString = request.getParameter("new_pass_1");
		String che_newString = request.getParameter("che_new_pass_1");
		String password_encodeString_ori = null;
		String password_encodeString_new = null;
		
//		加密
		try {
		    MessageDigest digest = MessageDigest.getInstance("SHA-256");
		    digest.reset();
		    digest.update(originString.getBytes("utf8"));
		    password_encodeString_ori = String.format("%064x", new BigInteger(1, digest.digest()));
		    
		    digest.update(newsString.getBytes("utf8"));
		    password_encodeString_new = String.format("%064x", new BigInteger(1, digest.digest()));

		    
		} catch (NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

		HttpSession session = request.getSession();
		ProjectBean bean = (ProjectBean) session.getAttribute("member_info");
		System.out.println(bean.getPassword());
//		確定輸入密碼符合session儲存的密碼
		if (bean.getPassword().equals(password_encodeString_ori)) {
//			確認新密碼和確認密碼是一樣的
			if (newsString.equals(che_newString)) {
				
				ProjectBean projectBean = new ProjectBean();
				projectBean.setId(bean.getId());
				projectBean.setPassword(password_encodeString_new);
				Connection conn = null;
				ProjectDAO dao = new ProjectDAOImpl();
				String update_pass_statu = "密碼更新成功！";

				try {
					conn = this.ds.getConnection();
					boolean pass_is_update = dao.updatePassword(projectBean, conn);
					System.out.println("update password: " + pass_is_update);
					if (pass_is_update) {
//						更改原本session的密碼
						bean.setPassword(password_encodeString_new);
//						放入更新密碼的session object
						session.setAttribute("member_info", bean);
					} else {
						update_pass_statu = "密碼更新失敗！";
					}
					ProjectBean probean = (ProjectBean) session.getAttribute("member_info");
					System.out.println("update: " + probean.getId());
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
							+ "    <h3>" + update_pass_statu + "</h3>\n"
							+ "    <a href=\"Member_info_1.jsp\"> 返回會員中心 </a>\n"
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
				System.out.println("請輸入和新密碼一樣的確認密碼");
				request.setAttribute("message", "請輸入和新密碼一樣的確認密碼");
				request.getRequestDispatcher("/Change_pass_1.jsp").forward(request, response);
			}
		} else {
			System.out.println("輸入錯誤密碼");
			request.setAttribute("message", "輸入錯誤密碼");
			request.getRequestDispatcher("/Change_pass_1.jsp").forward(request, response);
		}
		
	}

}
