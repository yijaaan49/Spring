<%@page import="com.spring.biz.user.UserVO"%>
<%@page import="com.spring.biz.user.impl.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- id, password 값을 받아서 DB에 있는지 확인하고 로그인 처리 --%>
<%
	//1. 사용자가 입력한 데이터(정보)추출
	String id = request.getParameter("id");
	String pw = request.getParameter("password");
	
	//2. DB연동처리(id, password 유무 확인)
	UserVO vo = new UserVO();
	vo.setId(id);
	vo.setPassword(pw);
	
	UserDAO userDAO = new UserDAO();
	UserVO user = userDAO.getUser(vo);
	
	//3. 화면 네비게이션(화면이동)
		//로그인 성공 : 게시글 목록 보여주기
		//로그인 실패 : 로그인 화면으로 이동
	if(user != null) {//사용자 정보가 존재하는 경우
		System.out.println("로그인 성공");
		response.sendRedirect("getBoardList.jsp");
	} else {//사용자 정보가 존재하지 않는 경우
		System.out.println("로그인 실패");
		response.sendRedirect("login.jsp");
	}
%>