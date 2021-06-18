package tw.course_5.model;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import tw.course_5.bean.Course_5;

@Repository("courseDao")
@Transactional
public class CourseDaoImpl implements CourseDao{
	
	@Override
	public Course_5 selectCourse(Course_5 course) {
		Session session = sessionFactory.getCurrentSession();
		Query<Course_5> courseQuery = session.createQuery("from Course_5",Course_5.class);
		
		return courseQuery.uniqueResult();
	}

	@Autowired @Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	
	@Override
	public List<Course_5> insertCourse(Course_5 course) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		
		if(selectCourse(course) == null) {
			session.save(course);
		}
		
		return selectAllCourses();
	}

	@Override
	public List<Course_5> selectAllCourses() {
		// TODO Auto-generated method stub
		List<Course_5> listCourses = null;
		
		Session session = sessionFactory.getCurrentSession();
		Query<Course_5> courseQuery = session.createQuery("from Course_5",Course_5.class);
		listCourses = courseQuery.list();
		
		return listCourses;
	}

	@Override
	public List<Course_5> updateCourse(Course_5 course) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		if(selectCourse(course)!=null) {
			session.update(course);
		}
		
		return selectAllCourses();
	}

	@Override
	public List<Course_5> deleteCourse(int deleteCourseID) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Course_5 deleteCourseBean = session.get(Course_5.class,deleteCourseID);
		
		if(deleteCourseBean != null) {
			session.delete(deleteCourseBean);
		}
		
		return selectAllCourses();
	}

}
