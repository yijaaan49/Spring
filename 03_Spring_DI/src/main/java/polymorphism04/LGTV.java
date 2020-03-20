package polymorphism04;

public class LGTV implements TV{
	
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
	}
	@Override
	public void volumeDown() {
		System.out.println("LGTV - 볼륨 DOWN");
	}
	
	
	public void initMethod() {
		System.out.println("LGTV - initMethod()실행");
	}
	
	public void destroyMethod() {
		System.out.println("LGTV - destroyMethod()실행");
	
	}
}
