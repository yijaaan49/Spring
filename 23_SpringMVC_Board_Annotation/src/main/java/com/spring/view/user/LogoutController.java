package com.spring.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogoutController {

	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		System.out.println(">>> 로그아웃 처리");
		//1. 세션 초기화 작업
		session.invalidate();
		
		//2. 화면이동(로그인페이지)
		return "login.jsp";
	}

	
/*	
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(">>> 로그아웃 처리");
		//1. 브라우저와 연결된 세션 객체를 종료(초기화)
		request.getSession().invalidate();
		
		//2. 화면 네비게이션(로그인 페이지)
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login.jsp");
		
		return mav;
	}
*/
}
