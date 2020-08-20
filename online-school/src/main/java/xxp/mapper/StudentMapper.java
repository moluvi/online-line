package xxp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import xxp.entity.Reply;
import xxp.entity.*;


@Component
@Mapper
public interface StudentMapper {
	
	Student getStudentByName(String studentName);
	
}
