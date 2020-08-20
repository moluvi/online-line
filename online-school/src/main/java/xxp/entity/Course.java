package xxp.entity;

import java.util.List;

public class Course {
	private int courseId;
	private String courseName;
	private String courseClass;
	private String courseNO;
	private String courseYear;
	private String courseTerm;
	private String recentWork;
	private String teacher;
	private int member;
	private boolean isEnd;
	
	public Course () {}

	public Course(int courseId, String courseName, String courseClass, String courseNO, String courseYear,String courseTerm,
			String recentWork, String teacher, boolean isEnd , int member) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseClass = courseClass;
		this.courseNO = courseNO;
		this.courseYear = courseYear;
		this.courseTerm = courseTerm;
		this.recentWork = recentWork;
		this.teacher = teacher;
		this.isEnd = isEnd;
		this.member = member;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseClass() {
		return courseClass;
	}

	public void setCourseClass(String courseClass) {
		this.courseClass = courseClass;
	}

	public String getCourseNO() {
		return courseNO;
	}

	public void setCourseNO(String courseNO) {
		this.courseNO = courseNO;
	}

	

	public String getCourseYear() {
		return courseYear;
	}

	public void setCourseYear(String courseYear) {
		this.courseYear = courseYear;
	}

	public String getCourseTerm() {
		return courseTerm;
	}

	public void setCourseTerm(String courseTerm) {
		this.courseTerm = courseTerm;
	}
	
	

	public String getRecentWork() {
		return recentWork;
	}

	public void setRecentWork(String recentWork) {
		this.recentWork = recentWork;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public boolean isEnd() {
		return isEnd;
	}

	public void setEnd(boolean isEnd) {
		this.isEnd = isEnd;
	}

	public int getMember() {
		return member;
	}

	public void setMember(int member) {
		this.member = member;
	}
	
	
	
	
}
