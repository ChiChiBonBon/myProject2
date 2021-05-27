package dao_5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.naming.java.javaURLContextFactory;

import bean_5.Course;

public class DAOImpl_5 implements DAO_5{
	PreparedStatement stmt = null;
	
	@Override
	public List<Course> insertCourse(Course course, Connection conn) {
		// TODO Auto-generated method stub
		String sqlString= " INSERT INTO [dbo].[Course_5] " +
		                  " ([Course_ID],[Teacher_Name],[Course_Outline],[Course_Date],[Course_time],[Fee],[Quota],[Classification],[Teaching_Method],[Area],[Comment]) " +
						  " VALUES (?,?,?,?,?,?,?,?,?,?,?) ";
		try {
			stmt = conn.prepareStatement(sqlString);
			stmt.setInt(1,course.getCourseID());
			stmt.setString(2,course.getTeacherName());
			stmt.setString(3,course.getCourseOutline());
			stmt.setDate(4,course.getCourseDate());
			stmt.setTime(5,course.getCourseTime());
			stmt.setBigDecimal(6,course.getFee());
			stmt.setInt(7,course.getQuota());
			stmt.setString(8,course.getClassification());
			stmt.setString(9,course.getTeachingMethod());
			stmt.setString(10,course.getArea());
			stmt.setString(11,course.getComment());
			stmt.executeUpdate();
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return selectCourse(conn);
	}

	@Override
	public List<Course> selectCourse(Connection conn) {
		// TODO Auto-generated method stub
		Course course = null;
		List<Course> listCourses = new ArrayList<>();
		
		String sqlString = " SELECT [Course_ID] " + 
						   " ,[Teacher_Name] " + 
						   " ,[Course_Outline] " + 
						   " ,[Course_Date] " + 
						   " ,[Course_time] " + 
						   " ,[Fee] " + 
						   " ,[Quota] " + 
						   " ,[Classification] " + 
						   " ,[Teaching_Method] " + 
						   " ,[Area] " + 
						   " ,[Comment] " + 
						   " FROM [dbo].[Course_5] ";
		
		try {
			stmt = conn.prepareStatement(sqlString);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				course = new Course();
				course.setCourseID(rs.getInt(1));
				course.setTeacherName(rs.getString(2));
				course.setCourseOutline(rs.getString(3));
				course.setCourseDate(rs.getDate(4));
				course.setCourseTime(rs.getTime(5));
				course.setFee(rs.getBigDecimal(6));
				course.setQuota(rs.getInt(7));
				course.setClassification(rs.getString(8));
				course.setTeachingMethod(rs.getString(9));
				course.setArea(rs.getString(10));
				course.setComment(rs.getString(11));
				
				listCourses.add(course);	
			}
			
			stmt.close();
			rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listCourses;
	}

	@Override
	public List<Course> updateCourse(Course course, Connection conn) {
		// TODO Auto-generated method stub
		String sqlString = "UPDATE [dbo].[Course_5] " + 
						   " SET [Course_ID] = ? " + 
						   " ,[Teacher_Name] = ? " + 
						   " ,[Course_Outline] = ? " + 
						   " ,[Course_Date] = ? " + 
						   " ,[Course_time] = ? " + 
						   " ,[Fee] = ? " + 
						   " ,[Quota] = ? " + 
						   " ,[Classification] = ? " + 
						   " ,[Teaching_Method] = ? " + 
						   " ,[Area] = ? " + 
						   " ,[Comment] = ? " + 
						   " WHERE [Course_ID] = ? ";
		try {
			stmt = conn.prepareStatement(sqlString);
			stmt.setInt(1,course.getCourseID());
			stmt.setString(2,course.getTeacherName());
			stmt.setString(3,course.getCourseOutline());
			stmt.setDate(4,course.getCourseDate());
			stmt.setTime(5,course.getCourseTime());
			stmt.setBigDecimal(6,course.getFee());
			stmt.setInt(7, course.getQuota());
			stmt.setString(8,course.getClassification());
			stmt.setString(9,course.getTeachingMethod());
			stmt.setString(10,course.getArea());
			stmt.setString(11,course.getComment());
			stmt.setInt(12,course.getCourseID());
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return selectCourse(conn);
	}

	@Override
	public List<Course> deleteCourse(Course course, Connection conn) {
		// TODO Auto-generated method stub
		String sqlString = " DELETE FROM [dbo].[Course_5] " + 
						   " WHERE [Course_ID] = ?";
		try {
			stmt = conn.prepareStatement(sqlString);
			stmt.setInt(1,course.getCourseID());
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return selectCourse(conn);
	}

}
