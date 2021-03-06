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
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import projectDAO.projectDAOImpl_1.ProjectDAOImpl;
import projectDAO_1.ProjectDAO;
import projectVO_1.ProjectBean;

/**
 * Servlet implementation class Delete_member_1
 */
@WebServlet("/Delete_member_1")
public class Delete_member_1 extends HttpServlet {

	private static final long serialVersionUID = 1L;
	DataSource ds;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Delete_member_1() {
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

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String password_del_1 = request.getParameter("password_del_1");
		String password_del_che_1 = request.getParameter("password_del_che_1");
		String password_encodeString = null;
		
//		??????
		try {
		    MessageDigest digest = MessageDigest.getInstance("SHA-256");
		    digest.reset();
		    digest.update(password_del_1.getBytes("utf8"));
		    password_encodeString = String.format("%064x", new BigInteger(1, digest.digest()));
		} catch (NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


		HttpSession session = request.getSession();
		ProjectBean bean = (ProjectBean) session.getAttribute("member_info");
		System.out.println(bean.getPassword());
//		????????????????????????session???????????????
		if (bean.getPassword().equals(password_encodeString)) {
//			??????????????????????????????????????????
			if (password_del_1.equals(password_del_che_1)) {

				Connection conn = null;
				ProjectDAO dao = new ProjectDAOImpl();
				String delete_acc_statu = "???????????????";
				String return__url = "logout_1.jsp";
				String return__Page = "??????????????????";

				try {
					conn = this.ds.getConnection();
					boolean is_delete = dao.deleteAccount(bean, conn);
					System.out.println("delete password: " + is_delete);
					if (is_delete) {
						System.out.println("???????????????");
					} else {
						System.out.println("??????????????????");
						delete_acc_statu = "?????????????????????";
						return__url = "Member_info_1.jsp";
						return__Page = "??????????????????";
					}
					response.setContentType("text/html"); // setup response content type
					response.setCharacterEncoding("UTF-8"); // setup response character encoding type
					PrintWriter out = response.getWriter();

					out.println(
							"<!DOCTYPE html>\n" + "<html lang=\"en\">\n" + "<head>\n" + "    <meta charset=\"UTF-8\">\n"
									+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n"
									+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
									+ "    <title>Document</title>\n" + "</head>\n" + "<body>\n"
									+ "    <h3>" + delete_acc_statu + "</h3>\n"
									+ "    <a href=" + return__url + ">" + return__Page + "</a>\n"
									+ "</body>\n" + "</html>");

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
				System.out.println("??????????????????????????????");
				request.setAttribute("message", "??????????????????????????????");
				request.getRequestDispatcher("/Delete_membership_1.jsp").forward(request, response);
			}
		} else {
			System.out.println("??????????????????");
			request.setAttribute("message", "??????????????????");
			request.getRequestDispatcher("/Delete_membership_1.jsp").forward(request, response);
		}

	}

}
