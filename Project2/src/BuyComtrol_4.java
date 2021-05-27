import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean_4.BuyBeam_4;

public class BuyComtrol_4 {

	//看全部產品
	public void select(HttpServletRequest request, HttpServletResponse response, Connection conn) {

		// 將Bean 傳給DAO，回傳Bean (select data)
		
		BuyDAO_4 select=new BuyDAO_4();
		//回傳BuyBeam_4用bean接她
		ArrayList<BuyBeam_4> bean = select.select(conn);
		
		// 傳給JSP處理
		HttpSession session = request.getSession(true);
		session.setAttribute("bean", bean);
		
		
		try {
			request.getRequestDispatcher("./BuyJSP_4.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
	
	//新增產品
	public void insert(HttpServletRequest request, HttpServletResponse response, Connection conn) {
		// request 得到資料，將資料放到 Bean VO
		BuyBeam_4 bean = new BuyBeam_4();
		bean.setStock_id(Integer.valueOf(request.getParameter("id")));
		bean.setStock_name(request.getParameter("name"));
		bean.setSub_start(request.getParameter("date"));
		bean.setSub_end(request.getParameter("date1"));
		bean.setSub_quantity(Integer.valueOf(request.getParameter("qty")));
		bean.setSub_price(Integer.valueOf(request.getParameter("price")));
		
		// 將Bean 傳給DAO，回傳Bean (select data)	
		BuyDAO_4 dao_4 = new BuyDAO_4();
		boolean beanOut= dao_4.insert(bean, conn);
		
		/*
		// 傳給JSP處理
		request.setAttribute("bean_boolean", beanOut);

		try {
			request.getRequestDispatcher("./BuyJSP_4.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		*/
	}

	//刪除產品
	public void delete(HttpServletRequest request, HttpServletResponse response, Connection conn) {
		// request 得到資料，將資料放到 Bean
		BuyBeam_4 bean = new BuyBeam_4();
		bean.setStock_id(Integer.valueOf(request.getParameter("id")));
		// 將Bean 傳給DAO，回傳Bean (select data)
		BuyDAO_4 dao_4 = new BuyDAO_4();
		boolean beanOut = dao_4.delete(bean, conn);

		/*
		// 傳給JSP處理
		request.setAttribute("bean_boolean", beanOut);

		try {
			request.getRequestDispatcher("./BuyJSP_4.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		*/
	}
//	更新產品資料
	public void update(HttpServletRequest request, HttpServletResponse response, Connection conn) {
		// request 得到資料，將資料放到 Bean
		BuyBeam_4 bean = new BuyBeam_4();
		bean.setStock_id(Integer.valueOf(request.getParameter("id")));
		bean.setStock_name(request.getParameter("name"));
		bean.setSub_start(request.getParameter("date"));
		bean.setSub_end(request.getParameter("date1"));
		bean.setSub_quantity(Integer.valueOf(request.getParameter("qty")));
		bean.setSub_price(Integer.valueOf(request.getParameter("price")));
		
		// 將Bean 傳給DAO，回傳Bean (select data)
		BuyDAO_4 dao_4 = new BuyDAO_4();
		boolean beanOut = dao_4.update(bean, conn);
		/*
		// 傳給JSP處理
		request.setAttribute("bean_boolean", beanOut);

		try {
			request.getRequestDispatcher("./BuyJSP_4.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		*/
	}
}
