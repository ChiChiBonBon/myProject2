package myServlet_1;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Logout_1
 */
@WebServlet("/Logout_1")
public class Logout_1 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logout_1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getSession().invalidate();
//		HttpSession session = request.getSession();
//		Object testObject = session.getAttribute("member_info");
//		System.out.println("testObject: " + testObject);
		
		Cookie[] cookies = request.getCookies();
		int i = 0;
		String string;
		if (cookies != null) {
			for (Cookie c : cookies) {
				string = cookies[i].getName();
				System.out.println("Logout_1 cookie check:" + string);
				System.out.println("Logout_1 time:" + i);
				i += 1;
				if (string.equals("cookie_id")) {
//					加入一樣cookie名稱, 到期日期設為0, 來刪除cookie
					Cookie userNameCookieRemove = new Cookie("cookie_id", "");
					userNameCookieRemove.setMaxAge(0);
					response.addCookie(userNameCookieRemove);
					response.sendRedirect("login_1.jsp");
					break;
				}
			}
		}
		
	}

}
