package xxp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import xxp.entity.Work;
@Component
@Mapper
public interface WorkMapper {
	
	List<Work> getAllWorks(@Param("courseName")String courseName);
	
	
	void addWork(Work work);
	
	
	Work getWorkById(int workId);
	
	
	void updateWork(Work work);
	
	void deleteWork(int workId);
}
