package com.spring.view.controller;

import java.util.HashMap;
import java.util.Map;

import com.spring.view.board.DeleteBoardController;
import com.spring.view.board.GetBoardController;
import com.spring.view.board.GetBoardListController;
import com.spring.view.board.InsertBoardController;
import com.spring.view.board.UpdateBoardController;
import com.spring.view.user.LoginController;
import com.spring.view.user.LogoutController;


/*
 * HandlerMapping 요청정보와 처리할 컨트롤러를 연결하는 정보 저장
 * DispatcherServlet의 init() 메소드 호출 시 생성 
 */
public class HandlerMapping {
	private Map<String, Controller> mappings;
	
	public HandlerMapping() {
		mappings = new HashMap<>();
		mappings.put("/login.do", new LoginController());
		mappings.put("/logout.do", new LogoutController());
		mappings.put("/getBoardList.do", new GetBoardListController());
		mappings.put("/getBoard.do", new GetBoardController());
		mappings.put("/insertBoard.do", new InsertBoardController());
		mappings.put("/updateBoard.do", new UpdateBoardController());
		mappings.put("/deleteBoard.do", new DeleteBoardController());
	}
	
	public Controller getController(String path) {
		return mappings.get(path);
	}
}
