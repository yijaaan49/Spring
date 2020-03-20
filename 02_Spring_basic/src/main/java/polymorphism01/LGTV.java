package polymorphism01;

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
}
