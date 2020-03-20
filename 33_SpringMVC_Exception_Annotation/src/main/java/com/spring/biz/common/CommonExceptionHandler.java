package com.spring.biz.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

//@ControllerAdvice : 객체생성 + 적용범위 설정
// 해당범위(com.spring.view 포함 하위 패키지)내에서 예외 발생 시 처리하는 클래스 설정 
@ControllerAdvice("com.spring.view")
public class CommonExceptionHandler {
	
	//@ExceptionHandler : 해당 예외 발생 시 메소드 실행
	@ExceptionHandler(Exception.class)
	public ModelAndView HandleException(Exception e) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", e);
		mav.setViewName("/common/error.jsp");
		
		return mav;
	}
	
	//@ExceptionHandler("") "" 안에 구체적인 예외상황을 명시하면 좀 더 구체적인 예외처리 가능
	@ExceptionHandler(IllegalArgumentException.class)
	public ModelAndView HandleException(IllegalArgumentException e) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", e);
		mav.setViewName("/common/illegalArgError.jsp");
		
		return mav;
	}
	
	@ExceptionHandler(NullPointerException.class)
	public ModelAndView HandleException(NullPointerException e) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", e);
		mav.setViewName("/common/nullPointerError.jsp");
		
		return mav;
	}
}
