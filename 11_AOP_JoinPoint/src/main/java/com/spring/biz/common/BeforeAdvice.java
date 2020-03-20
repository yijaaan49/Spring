package com.spring.biz.common;

import org.aspectj.lang.JoinPoint;

public class BeforeAdvice {
//	public void beforeLog() {
//		System.out.println("[사전처리 - BeforeAdvice.beforeLog]" + " 비즈니스 로직 수행 전 로그");
//	}
	
	public void beforeLog(JoinPoint jp) {
		String methodName = jp.getSignature().getName(); //실행될 메소드명
		Object[] args = jp.getArgs();
		
		String paramStr = "파라미터 없음";
		if(args != null && args.length != 0) {
			paramStr = args[0].toString();
		}
		System.out.println("[사전처리]" + methodName + " 메소드" + ", args 정보 : " + paramStr);
	}
	
}
