package polymorphism01;

public class SamsungTV implements TV{
	
	private SonySpeaker speaker;
	
	public SamsungTV() {
		System.out.println(">> SamsungTV 생성");
		//필드 SonySpeaker에 객체 주입
		speaker = new SonySpeaker();
	}
	
	public void powerOn() {
		System.out.println("SamsungTV - 전원 on");
	}

	public void powerOff() {
		System.out.println("SamsungTV - 전원 off");
	}
	
	@Override
	public void volumeUp() {
		System.out.println("SamsungTV - 소리 크게");
		speaker.volumeUp();
	}

	@Override
	public void volumeDown() {
		System.out.println("SamsungTV - 소리 작게");
		speaker.volumeDown();
	}
	
	public void initMethod() {
		System.out.println("SamsungTV - initMethod()실행");
	}
	
	public void destroyMethod() {
		System.out.println("SamsungTV - destroyMethod()실행");
	
	}
}
