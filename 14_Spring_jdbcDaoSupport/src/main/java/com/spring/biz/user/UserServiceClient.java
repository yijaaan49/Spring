package com.spring.biz.user;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.spring.biz.board.BoardVO;

//스프링 컨테이너 구동시킴
public class UserServiceClient {

	public static void main(String[] args) {
		
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
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

		UserVO vo = new UserVO("user2", "1234", "우아앙", "role2");
		userService.insertUser(vo);
		
		List<UserVO> userList = userService.getList();
		for (UserVO user : userList) {
			System.out.println(user);
		}
		
		container.close();
	}

}
