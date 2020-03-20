package com.spring.biz.board;

import java.util.ArrayList;
import java.util.List;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;

public class BoardTest {

	public static void main(String[] args) {
		BoardDAO dao = new BoardDAO();
		List<BoardVO> list = new ArrayList<>();	
		
		BoardVO boardVo = new BoardVO("들어갑니다~", "ㅇㅈㅇ", "안뇽안뇽내용입니당");
		boardVo = new BoardVO(2, "제목제목", "내용내용내용");
		//dao.insertBoard(boardVo);
		//dao.deleteBoard(7);
		//dao.updateBoard(boardVo);
		System.out.println(dao.getBoard(boardVo));
		
//		list = dao.getBoardList();
//		for(BoardVO vo : list) {
//			System.out.println(vo);
//		}
		
		
	}
}
