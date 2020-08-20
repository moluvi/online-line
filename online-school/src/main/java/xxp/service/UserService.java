package xxp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import xxp.entity.ResultCCC;
import xxp.entity.User;
import xxp.mapper.UserMapper;

@Service
public class UserService implements UserDetailsService{
	
	@Autowired
	private UserMapper usermapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = usermapper.loadUserByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("账户不存在");
		}
		// 通过id查找角色
		user.setRoles(usermapper.getUserRolesByUid(user.getId()));
		return user;
	}
	
	public ResultCCC addUserForTeacher(User user, String school) {
		System.out.println(user.getUsername()+ " " +school);
		User users = usermapper.loadUserByUsername(user.getUsername());
		if (users == null) {
			usermapper.addUser(user);
			user = usermapper.loadUserByUsername(user.getUsername());
			usermapper.addRole_User_teacher(user.getId());
			System.out.println(user.getUsername()+ " " +school);
			usermapper.addTeacher(user.getUsername(), school);	
		} else {
			return new ResultCCC(401, "用户名已存在");
		}
		
		return new ResultCCC(200, "成功");
	}
	
	
	public ResultCCC addUserForStudent(User user, String school,String studentNo) {
		System.out.println(user.getUsername()+ " " +school);
		User users = usermapper.loadUserByUsername(user.getUsername());
		if (users == null) {
				usermapper.addUser(user);
				user = usermapper.loadUserByUsername(user.getUsername());
				usermapper.addStudent(user.getUsername(), school, studentNo);
				usermapper.addRole_User_Student(user.getId());
			
		} 
		else {
			return new ResultCCC(401, "用户名已存在");
		}
		
		return new ResultCCC(200, "成功");
	}

}
