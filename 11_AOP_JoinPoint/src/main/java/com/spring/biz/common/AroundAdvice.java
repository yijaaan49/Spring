package com.spring.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class AroundAdvice {
	
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		String methodName = pjp.getSignature().getName();
		
		StopWatch stopWatch = new StopWatch();
		stopWatch.start(); //시간재기 시작
				
		System.out.println("[Around Before] 비즈니스 메소드 실행 전 처리");
		Object returnObj = pjp.proceed(); // 실행할 메소드 동작 시키기
		System.out.println("[Around After] 비즈니스 메소드 실행 후 처리");
		
		stopWatch.stop(); //시간재기 종료
		
		System.out.println("[around] " + methodName + " 메소드" + ", 실행시간 : " + stopWatch.getTotalTimeMillis() + "초(ms)");
		
		return returnObj;
		
	}
}
