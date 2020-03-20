package com.spring.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

import com.spring.biz.user.UserVO;

@Service
@Aspect
public class AfterReturningAdvice {
	
	@AfterReturning(pointcut="PointcutCommon.getPointcut()", returning="returnObj")
	public void afterReturnLog(JoinPoint jp, Object returnObj) {
		String methodName = jp.getSignature().getName();
		
		//리턴받은 객체 확인하고 필요한 작업 처리(afterReturning!!!)
		if(returnObj instanceof UserVO) { //returnObj가 UserVO 타입인가?
			UserVO vo = (UserVO)returnObj;
			if(vo.getRole().equalsIgnoreCase("admin")) {
				System.out.println(vo.getName() + " 로그인(Admin)");
			} else { 
				System.out.println(vo.getName() + " 로그인");
			}
		}
		
		System.out.println("[사후처리] " + methodName + " 메소드" + ", 리턴 값 : " + returnObj);
	}
}
