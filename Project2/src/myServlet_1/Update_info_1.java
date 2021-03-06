package myServlet_1;

import java.io.IOException;
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
 * Servlet implementation class Update_info
 */
@WebServlet("/Update_info_1")
public class Update_info_1 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	DataSource ds;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update_info_1() {
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String account = request.getParameter("account_1");
		String name = request.getParameter("name_1");
		String birthday = request.getParameter("birthday_1");
		System.out.println("birthady get: " + birthday);
		String nickname = request.getParameter("nickname_1");
		String gender = request.getParameter("gender_1");
		String email = request.getParameter("email_1");
		String cellphone = request.getParameter("cellphone_1");
		System.out.println("cellphone get: " + cellphone);
		String address = request.getParameter("address_1");
		String job = request.getParameter("job_1");
		String carrier = request.getParameter("carrier_1");
		
		HttpSession session = request.getSession();
		ProjectBean bean = (ProjectBean) session.getAttribute("member_info");
//		System.out.println(bean.getPassword());
//		System.out.println(bean.getId());
		
		ProjectBean projectBean = new ProjectBean();
		projectBean.setId(bean.getId());
		projectBean.setPassword(bean.getPassword());
		projectBean.setAccount(account);
		projectBean.setName(name);
//		????????????????????????????????????date, 
//		???????????????????????????????????????????????????????????? ?????????????????? ???????????????null?????????
		if (birthday.equals("")) {
			birthday = null;
		}
//		??????????????????null??? ??????????????? ?????????????????????????????????null?????? ?????????????????????
//		????????????null
		if (cellphone.equals("null")) {
			cellphone = null;
		}
		projectBean.setBirthday(birthday);
		projectBean.setNickname(nickname);
		projectBean.setGender(gender);
		projectBean.setE_mail(email);
		projectBean.setCellphone(cellphone);
		projectBean.setAddress(address);
		projectBean.setJob(job);
		projectBean.setCarrier(carrier);
		
	
		Connection conn = null;
		ProjectDAO dao = new ProjectDAOImpl();
		
		try {
			conn = this.ds.getConnection();
			int is_update =  dao.updateAccount(projectBean, conn);
			System.out.println("update account: " + is_update);
			
			if (is_update == 1) {
				session.setAttribute("member_info", projectBean);
			} else if (is_update == -1) {
				System.out.println("????????????????????????????????????");
				request.setAttribute("message", "????????????????????????????????????");

			} else if (is_update == -2) {
				System.out.println("????????????????????????????????????");
				request.setAttribute("message", "????????????????????????????????????");

			}else if (is_update == -3) {
				System.out.println("??????????????????????????????");
				request.setAttribute("message", "??????????????????????????????");

			}else {
				System.out.println("????????????????????????");
				request.setAttribute("message", "????????????????????????");

			}
			
			ProjectBean probean = (ProjectBean) session.getAttribute("member_info");
			System.out.println("update: " + probean.getAccount()); 
			
			request.getRequestDispatcher("/Update_info_1.jsp").forward(request, response);
			
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
