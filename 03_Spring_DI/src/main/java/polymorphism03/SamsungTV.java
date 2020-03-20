package polymorphism03;

public class SamsungTV implements TV{
	
	private SonySpeaker speaker;
	private int price;
	private int width;
	private int height;
		

	public SamsungTV() {
		System.out.println(">> SamsungTV 생성");
	}
	
	public SamsungTV(SonySpeaker speaker) { //speaker를 받는 생성자
		System.out.println(">> SamsungTV(Speaker) 객체 생성");
		this.speaker = speaker;
	}

	public SamsungTV(SonySpeaker speaker, int price) { //speaker, price를 받는 생성자
		this.speaker = speaker;
		this.price = price;
	}
	
	public SamsungTV(SonySpeaker speaker, int width, int height) { //speaker, width, height를 받는 생성자
		System.out.println(">> SamsungTV(Speaker, width, height) 객체 생성");
		this.speaker = speaker;
		this.width = width;
		this.height = height;
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
	
	public SonySpeaker getSpeaker() {
		return speaker;
	}
	
	public void setSpeaker(SonySpeaker speaker) {
		this.speaker = speaker;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getWidth() {
		return width;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "SamsungTV [speaker=" + speaker + ", price=" + price + ", width=" + width + ", height=" + height + "]";
	}
		
}
