package com.spring.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service //객체(인스턴스) 생성 : component-scan에 의해 처리됨(Bean태그 대체)
@Aspect //포인트컷 + 어드바이스 연결
public class BeforeAdvice {
	
	@Before("PointcutCommon.allPointcut()")
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
