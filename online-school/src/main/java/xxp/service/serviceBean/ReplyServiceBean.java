package xxp.service.serviceBean;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import xxp.entity.Course;
import xxp.mapper.CourseMapper;
import xxp.service.CourseService;
import xxp.service.ReplyService;
import xxp.mapper.ReplyMapper;
import xxp.entity.Reply;

@CrossOrigin(allowCredentials = "true")
@Service
public class ReplyServiceBean  implements ReplyService{

	@Autowired
	private ReplyMapper replyMapper;
	
	

	public List<Reply> getAllReplys(int workId) {
		// TODO Auto-generated method stub
	
		return this.replyMapper.getAllReplys(workId);
	}



	@Override
	public Reply getReplyById(int replyId) {
		
		return this.replyMapper.getReplyById(replyId);
	}



	@Override
	public void updateGrade(Reply reply) {
		
		this.replyMapper.updateGrade(reply);
		
	}



	@Override
	public void addReply(Reply reply) {
		// TODO Auto-generated method stub
		this.replyMapper.addReply(reply);
	}



	@Override
	public void addReply_work(int workId, int replyId) {
		// TODO Auto-generated method stub
		System.out.println(workId);
		System.out.println(replyId);
		this.replyMapper.addReply_work(workId,replyId);
	}

	
	
}
