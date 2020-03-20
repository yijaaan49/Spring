package com.spring.view.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;

@Controller
public class BoardController {
	
	//메소드에 선언된 @ModelAttribute 는 리턴된 데이터를 View에 전달
	//@ModelAttribute 선언된 메소드는 @ModelAttribute 메소드보다 먼저 실행된다
	//뷰에 전달될 때 설정된 명칭(예: @ModelAttribute("conditionMap"))으로 전달
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap() {
		//key: 제목, value: TITLE
		//key: 내용, value: CONTENT
		Map<String, String> conditionMap = new HashMap<>();
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
		
		return conditionMap;
	}
	
	//리턴타입 ModelAndView -> String 변경해서 리턴타입 통일
	//데이터 저장타입 ModelAndView -> Model 
	//목록 조회
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, BoardDAO boardDAO, Model model) {
		System.out.println("condition: " + vo.getSearchCondition());
		System.out.println("keyword: " + vo.getSearchKeyword());
		
		//null 체크 후 초기값 설정
		if(vo.getSearchCondition() == null) {
			vo.setSearchCondition("TITLE");
		} 
		if(vo.getSearchKeyword() == null) {
			vo.setSearchKeyword("");
		}
				
		System.out.println("null 처리후 condition: " + vo.getSearchCondition());
		System.out.println("null 처리후 keyword: -" + vo.getSearchKeyword() + "-");
		//1. 게시글 목록 조회
		List<BoardVO> boardList = boardDAO.getBoardList(vo.getSearchCondition(), vo.getSearchKeyword());
		
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
