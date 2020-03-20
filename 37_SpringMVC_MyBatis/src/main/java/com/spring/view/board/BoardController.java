package com.spring.view.board;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.spring.biz.board.BoardListVO;
import com.spring.biz.board.BoardService;
import com.spring.biz.board.BoardVO;

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
//		System.out.println("condition: " + vo.getSearchCondition());
//		System.out.println("keyword: " + vo.getSearchKeyword());
		
		//null 체크 후 초기값 설정
		if(vo.getSearchCondition() == null) {
			vo.setSearchCondition("TITLE");
		} 
		if(vo.getSearchKeyword() == null) {
			vo.setSearchKeyword("");
		}
				
//		System.out.println("null 처리후 condition: " + vo.getSearchCondition());
//		System.out.println("null 처리후 keyword: -" + vo.getSearchKeyword() + "-");
		
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
	public String insertBoard(BoardVO vo) throws IllegalStateException, IOException {
		System.out.println(">>> 글 등록 처리");
		
		/* ********* 파일 업로드처리 **********
		 * MultipartFile 인터페이스 주요 메소드
		 * String getOriginalFilename() : 업로드한 파일명 찾기
		 * void transferTo(대상위치) : 업로드한  파일을 destFile(위치)에 저장
		 * boolean isEmpty() : 업로드한 파일의 존재여부(없으면 true 리턴)
		 */
		MultipartFile uploadFile = vo.getUploadFile();
		System.out.println("uploadFile: " + uploadFile);
		
		if(!uploadFile.isEmpty()) { //파일이 있으면 지정한 경로에 저장해라 
			String fileName = uploadFile.getOriginalFilename(); //실제 업로드되는 파일명
			uploadFile.transferTo(new File("c:/Mystudy/temp/" + fileName)); //데이터 저장 메소드(transferTo())
		}
		
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
	
	//============================================
	//데이터 전환(XML)
	@RequestMapping("/dataTransform.do")
	@ResponseBody //응답객체의 몸체 담아서 전달
	public BoardListVO dataTransform(BoardVO vo) {
		System.out.println(">>> dataTransform() 실행(XML)");
		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("");
		
		List<BoardVO> boardList = boardService.getBoardList();
		BoardListVO boardListVO = new BoardListVO();
		boardListVO.setBoardList(boardList);
		
		return boardListVO;
	}

}











