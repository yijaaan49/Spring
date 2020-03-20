package com.spring.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;

public class UpdateBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(">>> 글 수정 처리");
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
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("getBoardList.do");
		
		return mav;
	}

}
