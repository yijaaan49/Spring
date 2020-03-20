package com.spring.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.biz.user.UserVO;
import com.spring.biz.user.impl.UserDAO;

/*
 @Controller : DispatcherServlet에서 인식할 수 있는 컨트롤러로 객체 생성(<bean>설정 필요없음)
 */
@Controller
public class LoginController {

	/* @RequestMapping & Command 객체 ***********
	* @RequestMapping : 요청과 처리(Controller) 연결
	 	(HandlerMapping 역할을 대체)
	* Command 객체 사용 : 파라미터로 전달되는 값을 Command 객체에 설정(Spring에서 제공)
	 	스프링 프레임워크에서 객체 생성하고 파라미터 값을 설정
	 	1. UserVO 타입의 객체 생성
	 	2. UserDAO 타입의 객체에 전달받은 파라미터 값을 설정(setter 사용)
	 	3. UserVO 타입의 객체를 메소드의 파라미터 값을 전달
	 *****************************************/
	@RequestMapping("/login.do")
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
	
	
/*	
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(">>> 로그인 처리");
		
		//1. 사용자가 입력한 데이터(정보) 추출
		String id = request.getParameter("id"); //--------------------> Spring Framework에서 알아서 해당 하는 객체의 데이터가 있으면 담아줌
		String password = request.getParameter("password");
		
		//2. DB연동처리(id, password 유무 확인)
		UserVO vo = new UserVO(); //------------------> Command 객체에 담김(객체 생성할 필요 x)
		vo.setId(id);
		vo.setPassword(password);
		
		UserDAO userDAO = new UserDAO(); //------------------> Command 객체에 담김(객체 생성할 필요 x)
		UserVO user = userDAO.getUser(vo);
		
		//3. 화면 네비게이션(화면이동)
		//로그인성공 : 게시글목록 보여주기
		//로그인실패 : 로그인 화면으로 이동
		ModelAndView mav = new ModelAndView();
		if (user != null) {//사용자 정보가 존재하는 경우
			System.out.println("로그인 성공!!!");
			//returnStr = "getBoardList.do";
			mav.setViewName("getBoardList.do");
		} else {//사용자 정보가 없는 경우
			System.out.println("로그인 실패!!!");
			//returnStr = "login";
			mav.setViewName("login.jsp");
		}
		return mav;
	}
*/
}
