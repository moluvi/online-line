package xxp.entity;

public class Reply {
	private int replyId;
	private String studentNo;
	private String studentName;
	private String grade;
	private String submitTime;
	private String replyFile;
	public int getReplyId() {
		return replyId;
	}
	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}
	public String getStudentNo() {
		return studentNo;
	}
	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getSubmitTime() {
		return submitTime;
	}
	public void setSubmitTime(String submitTime) {
		this.submitTime = submitTime;
	}
	public String getReplyFile() {
		return replyFile;
	}
	public void setReplyFile(String replyFile) {
		this.replyFile = replyFile;
	}
	public Reply() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Reply(int replyId, String studentNo, String studentName, String grade, String submitTime, String replyFile) {
		super();
		this.replyId = replyId;
		this.studentNo = studentNo;
		this.studentName = studentName;
		this.grade = grade;
		this.submitTime = submitTime;
		this.replyFile = replyFile;
	}
	
	
	
	
	
	
}
