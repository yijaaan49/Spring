<%@page import="com.spring.biz.board.impl.BoardDAO"%>
<%@page import="com.spring.biz.board.BoardVO"%>
<%@page import="com.spring.biz.user.UserVO"%>
<%@page import="com.spring.biz.user.impl.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 전달받은 값으로 DB연동작업(수정) 후 페이지 이동 --%>
<%
	//1. 전달받은 데이터 추출
	int seq = Integer.parseInt(request.getParameter("seq"));
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	
	//2. DB 연동 처리 (데이터 입력)
	BoardVO vo = new BoardVO();
	vo.setSeq(seq);
	vo.setTitle(title);
	vo.setContent(content);
	
	BoardDAO boardDAO = new BoardDAO();
	boardDAO.updateBoard(vo);
	
	//3. 화면 네비게이션(목록페이지로 이동)
	response.sendRedirect("getBoardList.jsp");
%>