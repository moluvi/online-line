package xxp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import xxp.entity.Role;
import xxp.entity.User;

@Component
@Mapper
public interface UserMapper {

	User loadUserByUsername(String username);

	List<Role> getUserRolesByUid(Integer id);
	
	void addUser(User user);

	void addRole_User_teacher(Integer uid);

	void addRole_User_Student(Integer uid);
	

	void addTeacher(@Param("username")String username, @Param("school")String school);
	
	void addStudent(@Param("username")String username, @Param("school")String school, @Param("studentNo")String studentNo);
	
}
