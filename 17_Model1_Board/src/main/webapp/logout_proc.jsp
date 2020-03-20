<%@page import="com.spring.biz.user.UserVO"%>
<%@page import="com.spring.biz.user.impl.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 연결된 세션 초기화하고 화면이동 --%>
<%
	//1. 브라우저와 연결된 세션 객체를 종료(초기화)
	session.invalidate();
	
	//2. 화면 네비게이션(로그인 페이지)
	response.sendRedirect("login.jsp");
%>