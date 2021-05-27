
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import bean_5.Course;
import dao_5.DAO_5;
import dao_5.DAOImpl_5;

/**
 * Servlet implementation class CourseServlet
 */
@WebServlet("/CourseServlet")
public class CourseServlet_5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CourseServlet_5() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	public void init() throws ServletException {
		
		DataSource dataSource = null;
		
		try {
			Context ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/myProject2");
			conn = dataSource.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

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
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		String actionCode = request.getParameter("actionCode");
		List<Course> listCourses = null;
		Course course = new Course();
		DAO_5 dao = new DAOImpl_5();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

		HttpSession session = request.getSession();
	
		switch (actionCode) {
			case "insert":
				/*listCourses = dao.selectCourse(conn);
				for(Course checkBean:listCourses) {
					if(checkBean.getCourseID().toString() == request.getParameter("courseID")) {
						System.out.println("ID重覆");
					}
				}
				
				listCourses.clear(); 做重覆insert判斷*/
				
				course.setCourseID(Integer.parseInt(request.getParameter("courseID").trim()));
				course.setCourseOutline(request.getParameter("courseOutline"));
				course.setTeacherName(request.getParameter("teacherName"));
				course.setCourseDate(Date.valueOf(request.getParameter("courseDate")));
				course.setCourseTime(Time.valueOf((request.getParameter("courseTime")+":00")));
				course.setFee(BigDecimal.valueOf(Long.parseLong(request.getParameter("fee"))));
				course.setQuota(Integer.parseInt(request.getParameter("quota").trim()));
				course.setTeachingMethod(request.getParameter("teachingMethod"));
				course.setClassification(request.getParameter("classification"));
				course.setArea(request.getParameter("area"));
				course.setComment(request.getParameter("comment"));
				
				listCourses = dao.insertCourse(course, conn);
			break;
			
			case "update":
				course.setCourseID(Integer.parseInt(request.getParameter("courseID").trim()));
				course.setCourseOutline(request.getParameter("courseOutline"));
				course.setTeacherName(request.getParameter("teacherName"));
				course.setCourseDate(Date.valueOf(request.getParameter("courseDate")));
				course.setCourseTime(Time.valueOf(request.getParameter("courseTime")+":00"));
				course.setFee(BigDecimal.valueOf(Long.parseLong(request.getParameter("fee"))));
				course.setQuota(Integer.parseInt(request.getParameter("quota").trim()));
				course.setTeachingMethod(request.getParameter("teachingMethod"));
				course.setClassification(request.getParameter("classification"));
				course.setArea(request.getParameter("area"));
				course.setComment(request.getParameter("comment"));

				
				
				listCourses = dao.updateCourse(course, conn);
			break;
			
			case "delete":
				course.setCourseID(Integer.parseInt(request.getParameter("deleteCourseID").trim()));
				System.out.println(request.getParameter("deleteCourseID"));
				listCourses = dao.deleteCourse(course, conn);
			break;
			
			case "select":
				listCourses = dao.selectCourse(conn);
			break;
			
			default:
			break;
		}
		
		session.setAttribute("Courses", listCourses);
		
		
		request.getRequestDispatcher("./CourseDataSet5.jsp").forward(request, response);
		
	}
	
	public void destroy() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
