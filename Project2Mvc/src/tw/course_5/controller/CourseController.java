package tw.course_5.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import tw.course_5.bean.Course_5;
import tw.course_5.model.CourseService;

@Controller
@SessionAttributes(names = {"courseResultSet"})
public class CourseController {
	
	@Autowired 
	private CourseService courseService;
	
	@Autowired
	private Course_5 course;
	
//	@RequestMapping(path="/courseController",method = RequestMethod.GET)
//	public String manageCourseMainPage() {
//		return "5_course_manage";
//	}
	
	//@RequestMapping(path="/courseController",method = RequestMethod.GET)
	@GetMapping(path = "/courseController")
	public String selectMethod(Model model) {
		
		List<Course_5> courseList = courseService.selectAllCourses();
		
		model.addAttribute("courseResultSet",courseList);
		return "5_course_manage";
	}
	
	@RequestMapping(path="/courseController/updateControllerMethod",method = RequestMethod.POST)
	public String updateMethod(@ModelAttribute(name = "course") Course_5 course,Model model) {
		List<Course_5> courseList = courseService.updateCourse(course);
	
		model.addAttribute("courseResultSet",courseList);
		return "redirect:/courseController";
	}
	
	@DeleteMapping(path="/deleteControllerMethod")
	public String deleteMethod(@RequestParam(name = "deleteCourseID") String deleteCourseID,Model model) {
		List<Course_5> courseList = courseService.deleteCourse(Integer.parseInt(deleteCourseID));
		
		model.addAttribute("courseResultSet",courseList);
		return "redirect:/courseController";
	}
	
	@RequestMapping(path="/courseController/insertControllerMethod",method = RequestMethod.POST)
	public String insertMethod(@ModelAttribute(name = "course") Course_5 course,Model model) {
		List<Course_5> courseList = courseService.updateCourse(course);
		
		model.addAttribute("courseResultSet",courseList);
		return "5_course_manage";
	}
}
