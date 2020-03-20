package com.spring.biz.user;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

//스프링 컨테이너 구동시킴
public class UserServiceClient {

	public static void main(String[] args) {
		
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext_after-returning.xml");
		UserService userService = (UserService)container.getBean("userService");
		
//		UserVO vo = new UserVO();
//		vo.setId("user1");
//		System.out.println(userService.getUser(vo));
		
//		UserVO vo = new UserVO();
//		vo.setId("abc");
//		vo.setPassword("1234");
//		vo.setName("하하하");
//		vo.setRole("role");
		
//		userService.insertUser(vo);
//		System.out.println(userService.getUser(vo));

		UserVO vo = new UserVO("test", "1234", "알파벳", "eng");
//		userService.updateUser(vo);
		System.out.println(userService.getUser(vo));
		
		container.close();
	}

}
