package xxp.security;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.util.DigestUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import xxp.service.UserService;

@Configuration
public class MyWebSecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private UserService userService;
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(new PasswordEncoder() {

			@Override
			public String encode(CharSequence rawPassword) {
				// TODO Auto-generated method stub
				return DigestUtils.md5DigestAsHex(rawPassword.toString().getBytes());
//				return rawPassword.toString();
			}

			@Override
			public boolean matches(CharSequence rawPassword, String encodedPassword) {
				// TODO Auto-generated method stub
				//return rawPassword.toString().equals(encodedPassword);
				return encodedPassword.equals(DigestUtils.md5DigestAsHex(rawPassword.toString().getBytes()));
			}
			
		});
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().authorizeRequests()
		.antMatchers("/admin/**")
		.hasRole("ADMIN")
		.antMatchers("/user/**")
		.access("hasAnyRole('ADMIN','USER')")
		.antMatchers("/db/**")
		.access("hasRole('ADMIN') and hasRole('DBA')")
		.antMatchers("/teacher/**")
		.access("hasAnyRole('DBA','ADMIN','TEACHER')")
		.anyRequest()
		.authenticated()
		.and()
		.formLogin()
		//.loginPage("/login_page")
		.successHandler(new AuthenticationSuccessHandler () {

			@Override
			public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
					Authentication auth) throws IOException, ServletException {
				// TODO Auto-generated method stub
				Object pricipal = auth.getPrincipal();
				response.setContentType("application/json;charset=utf-8");
				PrintWriter out = response.getWriter();
				response.setStatus(200);
				Map<String, Object> map = new HashMap<>();
				map.put("status", 200);
				map.put("msg", pricipal);
				ObjectMapper om = new ObjectMapper();
				out.write(om.writeValueAsString(map));
				out.flush();
				out.close();
			}
			
		})
		
		.failureHandler(new AuthenticationFailureHandler () {

			@Override
			public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
					AuthenticationException e) throws IOException, ServletException {
				// TODO Auto-generated method stub
				response.setContentType("application/json;charset=utf-8");
				PrintWriter out = response.getWriter();
				response.setStatus(200);
				Map<String, Object> map = new HashMap<>();
				map.put("status", 401);
				if (e instanceof LockedException) {
					map.put("msg", "账户被锁定，登陆失败");
				} else if (e instanceof BadCredentialsException) {
					map.put("msg", "账户名或密码输入错误，登陆失败");
				} else if (e instanceof DisabledException) {
					map.put("msg", "账户被禁用，登陆失败");
				} else if (e instanceof AccountExpiredException) {
					map.put("msg", "账户已过期，登陆失败");
				} else if (e instanceof CredentialsExpiredException) {
					map.put("msg", "密码过期，登陆失败");
				} else {
					map.put("msg", "登陆失败");
				}
				
				ObjectMapper om = new ObjectMapper();
				out.write(om.writeValueAsString(map));
				out.flush();
				out.close();
			}
			
		})
		.loginProcessingUrl("/login")
		.usernameParameter("username")
		.passwordParameter("password")
		.permitAll()
		.and()
		.csrf()
		.disable()
		.exceptionHandling()
		.accessDeniedHandler(getAccessDeniedHandler());
//		.exceptionHandling()
//		.accessDeniedHandler(getAccessDeniedHandler());
	}
	
	@Bean
    AccessDeniedHandler getAccessDeniedHandler() {
        return new AuthenticationAccessDeniedHandler();
    }
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/reg/**", "/css/**", "/course/**", "/work/**","terminal/stb/**");
		web.ignoring().antMatchers("/student/**");
		web.ignoring().antMatchers("/reply/**");
		
		web.ignoring().antMatchers("/file/**");
		web.ignoring().antMatchers("/image/**");
		web.ignoring().antMatchers("/course/addCourse");
		web.ignoring().antMatchers("/course/updateCourse");
		
	}
}
