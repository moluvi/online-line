package xxp.service;

import java.util.List;


import xxp.entity.Reply;



public interface ReplyService {
	
	List<Reply> getAllReplys(int workId);
	
	Reply getReplyById(int replyId);

	void updateGrade(Reply reply);
	
	void addReply(Reply reply);

	void addReply_work(int workId, int replyId);
	
}


