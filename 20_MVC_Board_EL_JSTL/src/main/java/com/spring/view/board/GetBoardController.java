package com.spring.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;
import com.spring.view.controller.Controller;

public class GetBoardController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(">>> 글 상세조회 처리");
		//1. 전달받은 데이터 추출
		int seq = Integer.parseInt(request.getParameter("seq"));

		//2. DB 연동 처리 (하나의 글 조회)
		BoardVO vo = new BoardVO();
		vo.setSeq(seq);
		
		BoardDAO boardDAO = new BoardDAO();
		BoardVO board = boardDAO.getBoard(vo);
		
		//3. 검색결과를 세션에 저장(뷰에서 사용할 수 있도록)하고 상세보기화면으로 이동
		request.getSession().setAttribute("board", board);
		
		return "getBoard";
	}

}
