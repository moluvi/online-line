package xxp.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import xxp.entity.ResultCCC;
import xxp.entity.User;
import xxp.service.UserService;
@ResponseBody
@RestController
public class LoginContorller {
	
	@Autowired
	private UserService userservice;
	
	@RequestMapping("/hello")
	public String hello() {
		return "hello world";
	}
	
	@RequestMapping("/admin/hello")
	public String helloAdmin() {
		return "hello admin";
	}
	
	@RequestMapping("/user/hello")
	public String helloUser() {
		return "hello user";
	}
	
	@RequestMapping("/db/hello")
	public String helloDb() {
		return "hello db";
	}
	
	@RequestMapping("/login_page")
	public String loginPage() {
		return "error";
	}
	
	@ResponseBody
	@RequestMapping("/reg/registerTeacher")
	public ResultCCC registerTeacher (String username, String nickname, String password, String school) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
		
		user.setNickname(nickname);
		user.setEnabled(true);
		user.setLocked(false);
	
		return userservice.addUserForTeacher(user, school);
		
	}
	
	@ResponseBody
	@RequestMapping("/reg/registerStudent")
	public ResultCCC registerStudent (String username, String nickname, String password,String school,String studentNo) {
		System.out.println("222");
		System.out.println(username);
		System.out.println(nickname);
		System.out.println(studentNo);
		User user = new User();
		user.setUsername(username);
		user.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
		user.setNickname(nickname);
		user.setEnabled(true);
		user.setLocked(false);
	
		return userservice.addUserForStudent(user, school, studentNo);
		
	}
	
	
	
	
	
}
