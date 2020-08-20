package xxp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import xxp.entity.Course;
@Component
@Mapper
public interface CourseMapper {
	
	List<Course> getAllCourses(@Param("teachername")String teachername);
	
	List<Course> getAllCoursesByStudent(@Param("studentname")String teachername);
	
	void addCourse(Course course);
	
	Course getCourseByName(String courseName);
	
	Course getCourseById(int courseId);
	
	
	void updateCourse(Course course);
	void deleteCourse(String courseName);

	Course getCourseByNO(String courseNO);

	void joinCourse(@Param("studentName")String studentName,@Param("courseId")int courseId);

	void exitCourse(int courseId);
	
	Integer getCountByNO(String courseNO);

	void updateMember(int courseId);

	void drawnCourse(Course course);

	List<Course> getDrawnCourses(String studentName);

	void exitDrawnCourse(String courseName);

	Course getDrawnCourseById(int courseId);

	void addStuDrawn(@Param("studentName")String studentName, @Param("courseId")int courseId);

	void drawnExitCourse(String courseName);
	
	
}
