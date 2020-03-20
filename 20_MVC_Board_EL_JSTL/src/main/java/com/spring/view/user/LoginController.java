package com.spring.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spring.biz.user.UserVO;
import com.spring.biz.user.impl.UserDAO;
import com.spring.view.controller.Controller;

public class LoginController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(">>> 로그인 처리");
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
		//로그인성공 : 게시글목록 보여주기
		//로그인실패 : 로그인 화면으로 이동
		String returnStr = "";
		if (user != null) {//사용자 정보가 존재하는 경우
			System.out.println("로그인 성공!!!");
			returnStr = "getBoardList.do";
		} else {//사용자 정보가 없는 경우
			System.out.println("로그인 실패!!!");
			returnStr = "login";
		}
		
		return returnStr;
	}

}
