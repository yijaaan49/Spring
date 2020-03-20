package com.spring.biz.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {

	public static void main(String[] args) {
		//1. 스프링 컨테이너 구동
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml"); 
				
		//2. 스프링 컨테이너에 생성된 객체 요청 및 사용
		BoardService boardService = (BoardService) container.getBean("boardService");
		
		//2-1. 입력
		BoardVO vo = new BoardVO();
		vo.setSeq(100);
		vo.setTitle("제목-tx");
		vo.setWriter("글쓴이-tx");
		vo.setContent("내용-tx");
		
		try {
			boardService.insertBoard(vo);
		} catch (Exception e) {
			//e.printStackTrace();
		}			
				
		//전체목록 조회
		System.out.println("===============");
		List<BoardVO> boardList = boardService.getBoardList();
		for (BoardVO board : boardList) {
			System.out.println(board);
		}
		
		//3. 스프링 컨테이너 종료(close)
		container.close();

	}

}
