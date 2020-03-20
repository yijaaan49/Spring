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
		
		//2-1. 입력
		UserVO vo = new UserVO();
		vo.setId("user");
		vo.setPassword("1111");
		vo.setName("유저");
		vo.setRole("u");
		
//		userService.insertUser(vo);
		
		UserVO user = userService.getUser(vo);
		System.out.println(user);
		
		//전체목록 조회
//		System.out.println("===============");
//		List<UserVO> userList = userService.getUserList();
//		for (UserVO user : userList) {
//			System.out.println(user);
//		}
		
		container.close();
	}

}
