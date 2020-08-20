package xxp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import xxp.entity.Reply;


@Component
@Mapper
public interface ReplyMapper {
	
	List<Reply> getAllReplys(int workId);

	Reply getReplyById(int replyId);

	void updateGrade(Reply reply);

	void addReply(Reply reply);

	void addReply_work(@Param("workId")int workId, @Param("replyId")int replyId);
	
	
}
