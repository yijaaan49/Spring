package com.spring.view.board;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;

@Controller
public class BoardController {
	
	//리턴타입 ModelAndView -> String 변경해서 리턴타입 통일
	//데이터 저장타입 ModelAndView -> Model 
	//목록 조회
	@RequestMapping("/getBoardList.do")
	public String getBoardList(
			@RequestParam(value="searchCondition",
						  defaultValue="TITLE",
						  required=false) String condition, //parameter name이 'searchCondition'인 것을 String 타입 condition에 매칭,
															//'searchCondition'이 없으면 TITLE을
			@RequestParam(value="searchKeyword",
						  defaultValue="",
						  required=false) String keyword, //파라미터 값을 특정 변수에 담을 때(RequestParam)
			BoardDAO boardDAO,
			Model model) {
				
		//1. 게시글 목록 조회
		List<BoardVO> boardList = boardDAO.getBoardList(condition, keyword);
		
		//2. boardList를 model에 저장??
		model.addAttribute("boardList", boardList);
		
		return "getBoardList.jsp";
	}
	
	//목록 조회
//	@RequestMapping("/getBoardList.do")
//	public String getBoardList(BoardDAO boardDAO, Model model) {
//		System.out.println(">>> 전체 글 조회 처리");			
//		//1. 게시글 목록 조회
//		List<BoardVO> boardList = boardDAO.getBoardList();
//		
//		//2. boardList를 model에 저장??
//		model.addAttribute("boardList", boardList);
//		
//		return "getBoardList.jsp";
//	}
	
	//목록 조회
//	@RequestMapping("/getBoardList.do")
//	public ModelAndView getBoardList(BoardDAO boardDAO, ModelAndView mav) {
//		System.out.println(">>> 전체 글 조회 처리");			
//		//1. 게시글 목록 조회
//		List<BoardVO> boardList = boardDAO.getBoardList();
//		
//		//2. boardList를 model에 저장??
//		mav.addObject("boardList", boardList);
//		mav.setViewName("getBoardList.jsp");
//		
//		return mav;
//	}
	
	//게시글 조회
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, BoardDAO boardDAO, Model model) {
		System.out.println(">>> 글 상세조회 처리");
		BoardVO board = boardDAO.getBoard(vo);
		
		model.addAttribute("board", board);
		
		return "getBoard.jsp";
	}
	
	//글 삽입
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println(">>> 글 등록 처리");
		
		boardDAO.insertBoard(vo);
		
		return "getBoardList.do";
	}
	
	//글 수정
	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println(">>> 글 수정 처리");
		
		boardDAO.updateBoard(vo);
		
		return "getBoardList.do";
	}
	
	//글 삭제
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println(">>> 글 삭제 처리");
		
		boardDAO.deleteBoard(vo);
		
		return "getBoardList.do";
	}

}
