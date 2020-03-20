package di_annotation;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

	public static void main(String[] args) {
		System.out.println("-------- 컨테이너 구동 전 ---------");
		
		//1. 스프링 컨테이너 구동(스프링 설정 파일 읽어서)
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		System.out.println("---- 컨테이너 구동 후 -----");
		
		//2. 스프링 컨테이너에 생성된 객체 요청(Lookup 방식)
		System.out.println("------- 객체 요청 전 --------- ");
		System.out.println("\n---------tv 요청----------");
		TV tv = (TV)factory.getBean("LGTV");
		System.out.println(tv);
		
		tv.powerOff();
		tv.powerOn();
		tv.volumeDown();
		tv.volumeUp();


		
		//3. 스프링 컨테이너 종료(close)
		System.out.println("\n----- 컨테이너 구동 종료 처리 ---------");
		factory.close();
	}

}
