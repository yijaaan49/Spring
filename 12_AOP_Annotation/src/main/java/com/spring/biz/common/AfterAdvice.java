package com.spring.biz.common;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

//실습 @Aspect, @Pointcut, @After

@Service
@Aspect
public class AfterAdvice {
	//포인트컷  설정
	@Pointcut("execution(* com.spring.biz..*Impl.*(..))")
	public void allPointcut() {}
	
	@Pointcut("execution(* com.spring.biz..*Impl.get*(..))")
	public void getPointcut() {}
	
	@After("getPointcut()")
	public void afterLog() {
		System.out.println("[후처리  - AfterAdvice.afterLog]" + " 비즈니스 로직 수행 후 로그(언제나, 무조건)");
	}
}
