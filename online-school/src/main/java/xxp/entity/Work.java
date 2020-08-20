package xxp.entity;

import java.util.Date;
import java.util.List;

public class Work {
	private int workId;
	private String workName;
	private String workDetail;
	private String workDate;
	private String course;
	private String fullGrade;
	private String workFile;
	private String publishTime;
	public int getWorkId() {
		return workId;
	}
	public void setWorkId(int workId) {
		this.workId = workId;
	}
	public String getWorkName() {
		return workName;
	}
	public void setWorkName(String workName) {
		this.workName = workName;
	}
	public String getWorkDetail() {
		return workDetail;
	}
	public void setWorkDetail(String workDetail) {
		this.workDetail = workDetail;
	}
	public String getWorkDate() {
		return workDate;
	}
	public void setWorkDate(String workDate) {
		this.workDate = workDate;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getFullGrade() {
		return fullGrade;
	}
	public void setFullGrade(String fullGrade) {
		this.fullGrade = fullGrade;
	}
	public String getWorkFile() {
		return workFile;
	}
	public void setWorkFile(String workFile) {
		this.workFile = workFile;
	}
	public Work() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Work(int workId, String workName, String workDetail, String workDate, String course, String fullGrade,
			String workFile) {
		super();
		this.workId = workId;
		this.workName = workName;
		this.workDetail = workDetail;
		this.workDate = workDate;
		this.course = course;
		this.fullGrade = fullGrade;
		this.workFile = workFile;
	}
	public String getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}
	
	
	
	
	
}
