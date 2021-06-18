package tw.course_5.model;

import java.util.List;

import tw.course_5.bean.Course_5;

public interface CourseService {
	 
	abstract public List<Course_5> insertCourse(Course_5 course);
	
	abstract public List<Course_5> selectAllCourses();
	
	abstract public List<Course_5> updateCourse(Course_5 course);
	
	abstract public List<Course_5> deleteCourse(int deleteCourseID);
	
	abstract public Course_5 selectCourse(Course_5 course);
}
