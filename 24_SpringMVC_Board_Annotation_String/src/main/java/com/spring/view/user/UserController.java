package com.spring.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.biz.user.UserVO;
import com.spring.biz.user.impl.UserDAO;

@Controller
public class UserController {
	
	//로그인
	@RequestMapping("/login.do")
	public String login(UserVO vo, UserDAO userDAO) {
		System.out.println(">>> 로그인 처리");
		System.out.println("전달받은 vo : " + vo);
		
		UserVO user = userDAO.getUser(vo);
		
		if(user != null) {
			return "getBoardList.do";
		} else {
			return "login.jsp";
		}		
	}
	
	//로그아웃
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		System.out.println(">>> 로그아웃 처리");
		//1. 세션 초기화 작업
		session.invalidate();
		
		//2. 화면이동(로그인페이지)
		return "login.jsp";
	}
}
