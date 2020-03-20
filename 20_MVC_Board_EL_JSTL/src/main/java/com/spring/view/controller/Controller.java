package com.spring.view.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
	작성할 Controller가 처리할 메소드를 통일 시키기 위해 인터페이스를 만듦
	모든 Controller는 해당 인터페이스 implements해서 작성되도록 함(표준화)
 */
public interface Controller {
	String handleRequest(HttpServletRequest request, HttpServletResponse response);
}
