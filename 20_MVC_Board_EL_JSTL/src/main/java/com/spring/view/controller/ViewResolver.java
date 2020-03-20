package com.spring.view.controller;

/*
	ViewResolver 클래스는 Controller가 리턴한 String(View 이름)에
	접두어(prefix)와 접미어(suffix)를 결합해서 
	재요청(응답할) 페이지 경로(prefix쪽)와 파일명(suffix쪽)을 완성해서 리턴
	DispatcherServlet init() 메소드 호출 시 생성 
 */
public class ViewResolver {
	private String prefix;
	private String suffix;
	
	//값 설정만 할 수 있음(setter만)
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	
	// login.jsp 응답처리 -> 전달받는 viewName은 login
	// 리턴값 : "./"(prefix) + login + ".jsp"(suffix) ===> ./login.jsp
	public String getView(String viewName) {
		return prefix + viewName + suffix;
	}
	
}
