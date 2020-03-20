package com.spring.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.biz.board.BoardService;
import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;

//@Service : @Component 상속받아 만들어짐
//비즈니스 로직 처리 서비스 영역에 사용
@Service("boardService")
public class BoardServiceImpl implements BoardService {
	@Autowired //타입이 일치하는 객체(인스턴스) 주입
//	private BoardDAO boardDAO;
	private BoardDAOSpring boardDAO;
	
	public BoardServiceImpl() {
		System.out.println(">> BoardServiceImpl() 실행");
	}
	
	@Override
	public void insertBoard(BoardVO vo) throws Exception {
		
		//트랜잭션이 적용되고 있는 메소드 '내부'에서 예외처리를 하면 스프링프레임워크에서 트랜잭션처리를 못함(실패여부를 알 수가 없음)
		
		boardDAO.insertBoard(vo);
		System.out.println("1번 insert 후 data : " + getBoard(vo));
		
		boardDAO.insertBoard(vo); //키중복 오류 발생시킴
		System.out.println("2번 insert 후 data : " + getBoard(vo));
		
	/*	
	 	try {
		 	boardDAO.insertBoard(vo);
			System.out.println("1번 insert 후 data : " + getBoard(vo));
			
			boardDAO.insertBoard(vo); //키중복 오류 발생시킴
			System.out.println("2번 insert 후 data : " + getBoard(vo));
		} catch (Exception e) {
			e.printStackTrace();
		}
	 */
	}

	@Override
	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		boardDAO.deleteBoard(vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		return boardDAO.getBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList() {
		return boardDAO.getBoardList();
	}
	
}
