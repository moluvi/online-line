package xxp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xxp.entity.Work;
import xxp.service.*;
import org.apache.ibatis.annotations.Param;

@ResponseBody
@RestController
@RequestMapping("/work")
@CrossOrigin(allowCredentials = "true")


public class WorkController {
	
	@Resource
	private WorkService workService;
	
	
	@PostMapping("/getWorksByTeacher")
	public List<Work> getWorksByTeacher(String courseName) {
		
		
		return workService.getAllWorks(courseName);
	}
	
	
	
	@RequestMapping("/getWorkById")
	public Work getWorkById (int workId) {
	
		return workService.getWorkById(workId);
	}
	
	@RequestMapping("/addWork")
	public void addWork (String workName, String workDetail, String workDate, String course, String fullGrade,String workFile) {
		Work work = new Work();
		
		work.setWorkName(workName);
		work.setWorkDetail(workDetail);
		work.setWorkDate(workDate);
		work.setCourse(course);
		work.setFullGrade(fullGrade);
		work.setWorkFile(workFile);
		this.workService.addWork(work);	
	}
	
	
	@PostMapping("/updateWork")
	public void updateWork(int workId, String workName, String workDetail, String workDate, String course, String fullGrade,String workFile) {
		
		Work work = new Work();
		work.setWorkId(workId);
		work.setWorkName(workName);
		work.setWorkDetail(workDetail);
		work.setWorkDate(workDate);
		work.setCourse(course);
		work.setFullGrade(fullGrade);
		work.setWorkFile(workFile);
		
		this.workService.updateWork(work);
	}
	
	@RequestMapping("/deleteWork")
	public void deleteWork(int workId) {
		
		this.workService.deleteWork(workId);
		
	}
	
}
