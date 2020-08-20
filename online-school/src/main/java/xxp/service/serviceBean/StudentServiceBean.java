package xxp.service.serviceBean;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import xxp.entity.Course;
import xxp.mapper.CourseMapper;
import xxp.service.CourseService;
import xxp.service.ReplyService;
import xxp.service.StudentService;
import xxp.mapper.ReplyMapper;
import xxp.mapper.StudentMapper;
import xxp.entity.Reply;
import xxp.entity.Student;

@CrossOrigin(allowCredentials = "true")
@Service
public class StudentServiceBean  implements StudentService{

	@Autowired
	private StudentMapper studentMapper;
	
	

	

	@Override
	public Student getStudentByName(String studentName) {
		System.out.println(studentName);
		System.out.println("33");
		return this.studentMapper.getStudentByName(studentName);
	}




	
	
}
