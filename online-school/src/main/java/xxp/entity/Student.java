package xxp.entity;

public class Student {
	private Integer studentId;
	private String studentName;
	private String school;
	private String studentNo;
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getStudentNo() {
		return studentNo;
	}
	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}
	public Student(Integer studentId, String studentName, String school, String studentNo) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.school = school;
		this.studentNo = studentNo;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
}
