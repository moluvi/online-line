package xxp.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import xxp.entity.Reply;
import xxp.entity.Student;
import xxp.service.ReplyService;
import xxp.service.StudentService;

@ResponseBody
@RestController
@RequestMapping("/student")
@CrossOrigin(allowCredentials = "true")
public class StudentController {

	
	@Resource
	private StudentService studentService;
	
	
	@RequestMapping("/getStudentByName")
	public Student getStudentByName (String studentName) {
		
		return studentService.getStudentByName(studentName);
	}
}
