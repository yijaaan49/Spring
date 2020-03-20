package di_annotation;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

//객체 생성 요청을 하는 어노테이션
//어노테이션 이름 설정하지 않으면 클래스명(소문자로 시작)이 default
@Component
public class LGTV implements TV{
	@Resource(name="speaker")
	private Speaker speaker;
	
	public LGTV() {
		System.out.println(">> LGTV 생성");
	}
	
	@Override
	public void powerOn() {
		System.out.println("LGTV - 전원 ON");
		
	}
	@Override
	public void powerOff() {
		System.out.println("LGTV - 전원 OFF");
	}
		
	@Override
	public void volumeUp() {
		System.out.println("LGTV - 볼륨 UP");
		speaker.volumeUp();
	}
	@Override
	public void volumeDown() {
		System.out.println("LGTV - 볼륨 DOWN");
		speaker.volumeDown();
	}
	
	//-----------------------------------------------------------
	public void initMethod() {
		System.out.println("LGTV - initMethod()실행");
	}
	
	public void destroyMethod() {
		System.out.println("LGTV - destroyMethod()실행");
	
	}
}
