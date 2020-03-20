package com.spring.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service //객체(인스턴스) 생성 : component-scan에 의해 처리됨(Bean태그 대체)
@Aspect //포인트컷 + 어드바이스 연결
public class BeforeAdvice {
	/* 스프링 설정파일(xml)에서의 포인트컷 설정
	 <aop:pointcut id="allPointcut" expression="execution(* com.spring.biz..*Impl.*(..))" />
 	 <aop:pointcut id="getPointcut" expression="execution(* com.spring.biz..*Impl.get*(..))" />
	 */
	
	
	//포인트컷  설정 : 명칭(id)은 메소드명 사용(aop:config 내 aop:pointcut)
	@Pointcut("execution(* com.spring.biz..*Impl.*(..))")
	public void allPointcut() {}
	
	@Pointcut("execution(* com.spring.biz..*Impl.get*(..))")
	public void getPointcut() {}
		
	
	//어드바이스 메소드(어노테이션 안에는 메소드 호출시키는 형태!!)
	//어드바이스에 동작시점 설정 + 포인트컷 지정(aop:aspect 내 aop:before)
	@Before("allPointcut()")
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
