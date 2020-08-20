package xxp.service;

import java.util.List;


import xxp.entity.Course;



public interface CourseService {
	
	List<Course> getAllCourses(String teachername);
	
	List<Course> getAllCoursesByStudent(String studentname);
	
	
	Course getCourseByName(String courseName);
	
	Course getCourseById(int courseId);
	
	void addCourse(Course course);

	void updateCourse(Course course);
	
	void deleteCourse(String courseName);

	Course getCourseByNO(String courseNO);

	void joinCourse(String studentName,int courseId);

	void exitCourse(int courseId);

	Integer getCountByNO(String courseNO);

	void upadteMember(int courseId);

	void drawnCourse(Course course);

	

	List<Course> getDrawnCourses(String studentName);

	void exitDrawnCourse(String courseName);

	Course getDrawnCourseById(int courseId);

	void addStuDrawn(String studentName, int courseId);

	void drawnExitCourse(String courseName);
	
	
}


