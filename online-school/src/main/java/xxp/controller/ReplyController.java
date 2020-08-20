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
import xxp.entity.Reply;
import xxp.entity.Student;
import xxp.entity.Work;
import xxp.service.*;


@ResponseBody
@RestController
@RequestMapping("/reply")
@CrossOrigin(allowCredentials = "true")


public class ReplyController {
	
	@Resource
	private ReplyService replyService;
	@Resource
	private StudentService studentService;
	
	@PostMapping("/getAllReplys")
	public List<Reply> findAllReplys(int workId) {
		
		return replyService.getAllReplys(workId);
	}
	
	@RequestMapping("/getReplyById")
	public Reply getWorkById (int replyId) {
		
		return replyService.getReplyById(replyId);
	}
	
	
	@RequestMapping("/updateGrade")
	public void getWorkById (int replyId,String grade) {
		System.out.println(replyId);
		Reply reply = this.replyService.getReplyById(replyId);
		
		reply.setGrade(grade);
		
		this.replyService.updateGrade(reply);
			
	}
	
	@RequestMapping("/upReply")
	public void upReply (int workId,String studentName,String submitTime,String replyFile) {
		
		System.out.println(studentName);
		Student student = this.studentService.getStudentByName(studentName);
		
		Reply reply = new Reply();
		reply.setStudentNo (student.getStudentNo());
		reply.setStudentName(studentName);
		reply.setSubmitTime(submitTime);
		reply.setReplyFile(replyFile);	
		
		System.out.println(student.getStudentNo());
		System.out.println(workId);
		this.replyService.addReply(reply);	
		this.replyService.addReply_work(workId,reply.getReplyId());
		
	}
	
		
}
