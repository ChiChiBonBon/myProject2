package tw.course_5.model;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.course_5.bean.Course_5;

@Service("courseService")
@Transactional
public class CourseServiceImpl implements CourseService{
	
	@Autowired
	private CourseDao courseDao;
	
	@Override
	public List<Course_5> insertCourse(Course_5 course) {
		// TODO Auto-generated method stub
		return courseDao.insertCourse(course);
	}

	@Override
	public List<Course_5> selectAllCourses() {
		// TODO Auto-generated method stub
		return courseDao.selectAllCourses();
	}

	@Override
	public List<Course_5> updateCourse(Course_5 course) {
		// TODO Auto-generated method stub
		return courseDao.updateCourse(course);
	}

	@Override
	public List<Course_5> deleteCourse(int deleteCourseID) {
		// TODO Auto-generated method stub
		return courseDao.deleteCourse(deleteCourseID);
	}

	@Override
	public Course_5 selectCourse(Course_5 course) {
		// TODO Auto-generated method stub
		return courseDao.selectCourse(course);
	}

}
