package com.spring.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterThrowingAdvice {
	
	//포인트컷  설정 : 명칭(id)은 메소드명 사용(aop:config 내 aop:pointcut)
	@Pointcut("execution(* com.spring.biz..*Impl.*(..))")
	public void allPointcut() {}
	
	@Pointcut("execution(* com.spring.biz..*Impl.get*(..))")
	public void getPointcut() {}
	
	@AfterThrowing(pointcut="allPointcut()", throwing="exceptObj")
	public void exceptionLog(JoinPoint jp, Exception exceptObj) {
		String methodName = jp.getSignature().getName();
		
		if(exceptObj instanceof IllegalArgumentException) {
			System.out.println(">>> 부적합한 값이 입력되었습니다.");
		} else if(exceptObj instanceof NumberFormatException) {
			System.out.println(">>> 숫자형식이 아닙니다.");
		} else if(exceptObj instanceof Exception) {
			System.out.println(">>> 문제가 발생했습니다.");
		}
		
		System.out.println("[예외발생] " + methodName + " 메소드" + " 실행 중 예외발생, 메시지 : " + exceptObj.getMessage());
	}
}
