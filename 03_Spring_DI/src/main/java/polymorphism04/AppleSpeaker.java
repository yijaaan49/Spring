package polymorphism04;

public class AppleSpeaker implements Speaker{

	@Override
	public void volumeUp() {
		System.out.println(">> AppleSpeaker - 소리 크게");
		
	}

	@Override
	public void volumeDown() {
		System.out.println(">> AppleSpeaker - 소리 작게");
		
	}
	
}
