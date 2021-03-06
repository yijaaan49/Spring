package com.spring.view.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.spring.biz.board.BoardService;
import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;
import com.spring.biz.board.impl.BoardServiceImpl;

@Controller
@SessionAttributes("board") //'board'라는 이름의 Model이 있으면 session에 저장
public class BoardController {
	
	@Autowired
	private BoardService boardService; //----> 메소드 호출 시마다 생성되던 BoardDAO 객체 생성할 필요 없어짐
			
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
	
	//목록 조회
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, Model model) {
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
//		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		List<BoardVO> boardList = boardService.getBoardList(vo);
		
		//2. boardList를 model에 저장??
		model.addAttribute("boardList", boardList);
		
		return "getBoardList.jsp";
	}
	
	//게시글 조회
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, Model model) {
		System.out.println(">>> 글 상세조회 처리");
		BoardVO board = boardService.getBoard(vo);
		
		model.addAttribute("board", board); //@SessionAttributes("board")로 인해 request, session 모두에 저장되어있다
		System.out.println("> board : " + board);
		
		return "getBoard.jsp";
	}
	
	//글 삽입
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo) {
		System.out.println(">>> 글 등록 처리");
		
		boardService.insertBoard(vo);
		
		return "getBoardList.do";
	}
	
	//글 수정
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo) {
							//'board'라는 이름의 Model이 있으면 가져다 쓰고, 없다면 'board'로 새로 생성한다
							//(생성하면 update시 기존에 담겨있던 객체도 새로 생성되어 writer 사라짐)
		System.out.println(">>> 글 수정 처리");
		System.out.println("> board vo : " + vo);
		
		boardService.updateBoard(vo);
		
		return "getBoardList.do";
	}
	
	//글 삭제
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		System.out.println(">>> 글 삭제 처리");
		
		boardService.deleteBoard(vo);
		
		return "getBoardList.do";
	}

}
