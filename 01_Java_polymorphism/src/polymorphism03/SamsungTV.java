package polymorphism03;

public class SamsungTV implements TV{
	public void powerOn() {
		System.out.println("SamsungTV - 전원 on");
	}

	public void powerOff() {
		System.out.println("SamsungTV - 전원 off");
	}
	
	@Override
	public void volumeUp() {
		System.out.println("SamsungTV - 소리 크게");
	}

	@Override
	public void volumeDown() {
		System.out.println("SamsungTV - 소리 작게");
	}
}
