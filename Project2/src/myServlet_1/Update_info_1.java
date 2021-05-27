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
//		因為數據庫出生日期類行為date, 
//		所以如果前端不選擇任何值會認定為是空字串 數據庫會報錯 因此改設為null來表示
		if (birthday.equals("")) {
			birthday = null;
		}
//		因為前端會把null值 直接印出來 所以再輸入後會認為輸入null字串 所以沒改動的話
//		在這設為null
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
				System.out.println("會員帳號已使用，請換一種");
				request.setAttribute("message", "會員帳號已使用，請換一種");

			} else if (is_update == -2) {
				System.out.println("電子信箱已使用，請換一種");
				request.setAttribute("message", "電子信箱已使用，請換一種");

			}else if (is_update == -3) {
				System.out.println("電話已使用，請換一種");
				request.setAttribute("message", "電話已使用，請換一種");

			}else {
				System.out.println("無法更新，請回報");
				request.setAttribute("message", "無法更新，請回報");

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
