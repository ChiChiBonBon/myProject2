package dao_5;

import java.sql.Connection;
import java.util.List;

import bean_5.Course;

public interface DAO_5 {
	 
	abstract public List<Course> insertCourse(Course course,Connection conn);
	
	abstract public List<Course> selectCourse(Connection conn);
	
	abstract public List<Course> updateCourse(Course course,Connection conn);
	
	abstract public List<Course> deleteCourse(Course course,Connection conn);
}
