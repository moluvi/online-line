package xxp.service.serviceBean;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import xxp.entity.Course;
import xxp.mapper.CourseMapper;
import xxp.service.CourseService;

@CrossOrigin(allowCredentials = "true")
@Service
public class CourseServiceBean  implements CourseService{

	@Autowired
	private CourseMapper courseMapper;
	
	

	public List<Course> getAllCourses(String teachername) {
		// TODO Auto-generated method stub
		
		return this.courseMapper.getAllCourses(teachername);
	}
	
	@Override
	public List<Course> getAllCoursesByStudent(String studentname) {
		// TODO Auto-generated method stub
		return this.courseMapper.getAllCoursesByStudent(studentname);
	}
	
	
	@Override
	public Course getCourseByName(String courseName) {
		// TODO Auto-generated method stub
		return this.courseMapper.getCourseByName(courseName);
	}
	
	@Override
	public Course getCourseById(int courseId) {
		// TODO Auto-generated method stub
		return this.courseMapper.getCourseById(courseId);
	}
	
	
	@Override
	public void addCourse(Course course) {
		// TODO Auto-generated method stub
		courseMapper.addCourse(course);
	}


	@Override
	public void updateCourse(Course course) {
		// TODO Auto-generated method stub
		courseMapper.updateCourse(course);
	}

	@Override
	public void deleteCourse(String courseName) {
		// TODO Auto-generated method stub
		courseMapper.deleteCourse(courseName);
	}

	@Override
	public Course getCourseByNO(String courseNO) {
		
		
		return this.courseMapper.getCourseByNO(courseNO);
	}

	@Override
	public void joinCourse(String studentName,int courseId) {
		
		courseMapper.joinCourse(studentName,courseId);
		
	}

	@Override
	public void exitCourse(int courseId) {
		courseMapper.exitCourse(courseId);
		
	}

	@Override
	public Integer getCountByNO(String courseNO) {
		// TODO Auto-generated method stub
		return this.courseMapper.getCountByNO(courseNO);
	}

	@Override
	public void upadteMember(int courseId) {
		// TODO Auto-generated method stub
		
		courseMapper.updateMember(courseId);
		
	}

	@Override
	public void drawnCourse(Course course) {
		
		courseMapper.drawnCourse(course);
		
	}

	@Override
	public List<Course> getDrawnCourses(String studentName) {
		// TODO Auto-generated method stub
		
		return courseMapper.getDrawnCourses(studentName);
	}

	@Override
	public void exitDrawnCourse(String courseName) {
		// TODO Auto-generated method stub
		courseMapper.exitDrawnCourse(courseName);
	}

	@Override
	public Course getDrawnCourseById(int courseId) {
		// TODO Auto-generated method stub
		return this.courseMapper.getDrawnCourseById(courseId);
	}

	@Override
	public void addStuDrawn(String studentName, int courseId) {
		
		System.out.println("ppppp"+studentName+courseId);
		this.courseMapper.addStuDrawn(studentName,courseId);
		
	}

	@Override
	public void drawnExitCourse(String courseName) {
		// TODO Auto-generated method stub
		this.courseMapper.drawnExitCourse(courseName);
	}

	
}
