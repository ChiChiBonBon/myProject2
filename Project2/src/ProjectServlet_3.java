


import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import bean01_3.SocialBean_3;
@WebServlet(name = "ProjectServlet_3", urlPatterns = { "/ProjectServlet_3" })
public class ProjectServlet_3 extends HttpServlet {
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		DataSource ds = null;
	    InitialContext ctxt = null;
	    Connection conn = null;	
	    
	    try {
	        
	        //建立Context Object,連到JNDI Server
	        ctxt = new InitialContext();

	        //使用JNDI API找到DataSource
	        ds = ( DataSource ) ctxt.lookup("java:comp/env/jdbc/myProject2");
	       
	        //向DataSource要Connection
	        conn = ds.getConnection();
	        
	        //建立Database Access Object,負責Table的Access
	        SocialDAOImpl_3 socialDAO = new SocialDAOImpl_3(conn);

	        //如果要編碼值為UTF-8
	       request.setCharacterEncoding("UTF-8");

//			String comment_num = request.getParameter("comment_num");
//			String comment = request.getParameter("comment");
//			SocialBean_3 socl_bean = new SocialBean_3(comment_num,comment);
//			request.getSession(true).setAttribute("socl_bean",socl_bean);

	       if (request.getParameter("SELECT") != null) {
	    	   SELECT(request,response,socialDAO);
	       } 
	        if (request.getParameter("SELECTALL") != null) {
	        	SELECTALL(request,response,socialDAO);
	        } 
	        if (request.getParameter("UPDATE") != null) {
	          Update(request,response,socialDAO);
	        } 
	        if (request.getParameter("INSERT") != null) {
	      	  Insert(request,response,socialDAO);
	        } 
	        if (request.getParameter("DELETE") != null) {
	        	Delete(request,response,socialDAO);
	        } 
	      } catch (NamingException ne) {
	        System.out.println("Naming Service Lookup Exception");  
	      } catch (SQLException e) {
	        System.out.println("Database Connection Error"); 
	      } finally {
	        try {
	          if (conn != null) conn.close();
	        } catch (Exception e) {
	          System.out.println("Connection Pool Error!");
	        }
	      }
	    
	}

	private void SELECT(HttpServletRequest request, HttpServletResponse response, SocialDAOImpl_3 socialDAO) throws ServletException, IOException 	  {

	    DataSource ds = null;
	    InitialContext ctxt = null;
	    Connection conn = null;
	    
	    try {
	     

	      ctxt = new InitialContext();
	      //DataSource去連資料庫的標準做法
	      ds = ( DataSource ) ctxt.lookup("java:comp/env/jdbc/myProject2");
	      //運用context去找尋該服務
	      conn = ds.getConnection();
	      SocialDAO_3 socialDAO_3 = new SocialDAOImpl_3(conn);
	      //運用DAO跟資料庫做連線
	      SocialBean_3 socialData = (SocialBean_3)request.getSession(true).getAttribute("socl_bean");
	      if (socialDAO_3.insertComment(socialData))
	        {
	          System.out.println("Get some SQL commands done!");
	          request.getSession(true).invalidate();
	          request.getRequestDispatcher("./PostCOL_3.jsp").forward(request,response);
	        }
	    } catch (NamingException ne) {
	      System.out.println("Naming Service Lookup Exception");  
	    } catch (SQLException e) {
	      System.out.println("Database Connection Error"); 
	    } finally {
	      try {
	        if (conn != null) conn.close();
	      } catch (Exception e) {
	        System.out.println("Connection Pool Error!");
	      }
	    }
	           
	  }

	private void SELECTALL(HttpServletRequest request, HttpServletResponse response, SocialDAOImpl_3 socialDAO) throws IOException, ServletException {
		response.setContentType("text/html; charset=UTF-8");

		SocialBean_3 findAllText = socialDAO.findAllText();
		request.setAttribute("qrqr", findAllText);
	    request.getRequestDispatcher("./PostCOL_3.jsp").forward(request,response);
		System.out.println(findAllText);
	}

	private void Insert(HttpServletRequest request, HttpServletResponse response, SocialDAOImpl_3 socialDAO) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		String comment_num = request.getParameter("comment_num");
		String comment = request.getParameter("comment");
		SocialBean_3 socl_bean = new SocialBean_3(comment_num,comment);
		request.getSession(true).setAttribute("socl_bean",socl_bean);
		
		System.out.println(comment_num);
		System.out.println(comment);
		
		if (socialDAO.insertComment(socl_bean)==true) {
			System.out.println("新增成功");
			SocialBean_3 findAllText = socialDAO.findAllText();
			request.setAttribute("qrqr", findAllText);
			request.getRequestDispatcher("./PostCOL_3.jsp").forward(request,response);
		}else{
			System.out.print("失敗");
		}

	}

	private void Update(HttpServletRequest request, HttpServletResponse response, SocialDAOImpl_3 socialDAO) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		SocialBean_3 sBean=new SocialBean_3();
		String comment_num = request.getParameter("comment_numDB");
		String comment = request.getParameter("commentDB");
		sBean.setComment_num(comment_num);
		sBean.setComment(comment);
		System.out.println(comment_num);
		System.out.println(comment);
		if (socialDAO.updateComment(sBean)==true) {
			System.out.println("socialDAO.updateComment(sBean)==true棒喔");
			SocialBean_3 findAllText = socialDAO.findAllText();
			request.setAttribute("qrqr", findAllText);
			request.getRequestDispatcher("./PostCOL_3.jsp").forward(request,response);
		}else {
			System.out.println("什麼鬼");
		}
		
	}

	private void Delete(HttpServletRequest request, HttpServletResponse response, SocialDAOImpl_3 socialDAO) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		String comment_num = request.getParameter("delHidden");
		
		System.out.println(comment_num);
		SocialBean_3 sBean=new SocialBean_3();
		sBean.setComment_num(comment_num);
		try {
			socialDAO.deleteComment(comment_num);
			System.out.println("刪除成功");
			SELECTALL(request,response,socialDAO);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
