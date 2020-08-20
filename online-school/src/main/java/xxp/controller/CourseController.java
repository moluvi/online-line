package xxp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xxp.entity.Course;
import xxp.service.*;


@ResponseBody
@RestController
@RequestMapping("/course")
@CrossOrigin(allowCredentials = "true")

public class CourseController {
	
	@Resource
	private CourseService courseService;
	
	
	@PostMapping("/getCoursesByTeacher")
	public List<Course> findAllCourses(String teachername) {	
		return courseService.getAllCourses(teachername);
	}
	
	
	@PostMapping("/getCoursesByStudent")
	public List<Course> getCoursesByStudent(String studentname) {
		System.out.println("11111");
		return courseService.getAllCoursesByStudent(studentname);
	}
	
	
	@RequestMapping("/getCourseByName")
	public Course getCourseByName (String courseName) {
		
		return courseService.getCourseByName(courseName);
	}
	
	
	
	@RequestMapping("/getCourseById")
	public Course getCourseById (int courseId) {
		
		return courseService.getCourseById(courseId);
	}
	
	@RequestMapping("/addCourse")
	public void addCourse (String courseName, String courseClass, String courseNO, String courseYear, String courseTerm, String teacher) {
		
		Course course = new Course();
		course.setCourseName(courseName);
		course.setCourseClass(courseClass);
		course.setCourseNO(courseNO);
		course.setCourseYear(courseYear);
		course.setCourseTerm(courseTerm);
		course.setTeacher(teacher);
		this.courseService.addCourse(course);
		
	}
	
	@PostMapping("/updateCourse")
	public void updateCourseById(int courseId, String courseName, String courseClass, String courseYear, String courseTerm) {
		
		
		Course course = this.courseService.getCourseById(courseId);
		course.setCourseName(courseName);
		course.setCourseClass(courseClass);
		
		course.setCourseYear(courseYear);
		course.setCourseTerm(courseTerm);
		
		this.courseService.updateCourse(course);
	}
	
	@RequestMapping("/deleteCourse")
	public void deleteCourse(String courseName) {
		
		this.courseService.deleteCourse(courseName);
		
	}
	
	@PostMapping("/judgeCourse")
	public Integer judgeCourse(String courseNO) {
		
		
		Integer count = this.courseService.getCountByNO(courseNO);
		
		return count;
	}
	
	
	@PostMapping("/joinCourse")
	public void joinCourse(String courseNO,String studentName) {
		
		
		Course course = this.courseService.getCourseByNO(courseNO);
		this.courseService.joinCourse(studentName,course.getCourseId());
		this.courseService.upadteMember(course.getCourseId());
	}
	
	
	@RequestMapping("/exitCourse")
	public void exitCourse(int courseId) {
		
		this.courseService.exitCourse(courseId);
		
	}
	
	@RequestMapping("/drawnCourse")
	public void drawnCourse(int courseId,String studentName) {
		
		Course course = this.courseService.getCourseById(courseId);
		this.courseService.drawnCourse(course);
		this.courseService.addStuDrawn(studentName,course.getCourseId());
		this.courseService.exitCourse(courseId);
		
	}
	
	@RequestMapping("/getDrawnCourses")
	public List<Course> getDrawnCourses(String studentName) {
	
		return this.courseService.getDrawnCourses(studentName);
	}
	
	@RequestMapping("/recoverCourse")
	public void recoverCourse(String studentName,String courseName) {
		
		Course course = this.courseService.getCourseByName(courseName);
		
		this.courseService.joinCourse(studentName, course.getCourseId());
		
		this.courseService.exitDrawnCourse(courseName);
	}
	

	@RequestMapping("/drawnExitCourse")
	public void drawnExitCourse(String courseName) {
		Course course = this.courseService.getCourseByName(courseName);
		this.courseService.exitCourse(course.getCourseId());
		this.courseService.drawnExitCourse(courseName);
	}
	
}
