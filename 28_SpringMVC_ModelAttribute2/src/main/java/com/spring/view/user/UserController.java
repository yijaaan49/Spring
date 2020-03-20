package com.spring.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.biz.user.UserVO;
import com.spring.biz.user.impl.UserDAO;

@Controller
//@RequestMapping("/user") : 메소드 요청 시 공통된 경로가 있으면 class단위에 선언해서 사용
public class UserController {
	
	//로그인
	@RequestMapping(value="/login.do", method=RequestMethod.POST) //--->post방식(수행)으로 DB다녀옴
	public String login(UserVO vo, UserDAO userDAO) {
		System.out.println(">>> 로그인 처리");
		System.out.println("전달받은 vo : " + vo);
		
		UserVO user = userDAO.getUser(vo);
		
		if(user != null) {
			return "getBoardList.do";
		} else {
			return "login.jsp";
		}		
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.GET) //--->get방식(가져옴)으로 로그인 화면으로 이동만 함
	
	//@ModelAttribute : 모델의 속성값으로 지정(속성명 별도 지정가능)하여 메소드 내 뿐만아니라 응답받는 곳에서까지 사용가능하게 함
	//별도로 명칭 부여하지 않으면 <데이터타입>의 첫글자 소문자로 작성된 명칭이 사용됨
	//@ModelAttribute UserVo vo: 속성명 userVO 형태
	//@ModelAttribute("user") UserVo vo : 속성명 user 형태
	public String loginView(@ModelAttribute("user") UserVO vo) {
		System.out.println(">> 로그인 화면으로 이동 - loginView()");
		vo.setId("test");
		vo.setPassword("test");
		
		return "login.jsp";
	}
	
	
	//로그아웃
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		System.out.println(">>> 로그아웃 처리");
		//1. 세션 초기화 작업
		session.invalidate();
		
		//2. 화면이동(로그인페이지)
		return "login.jsp";
	}
}
