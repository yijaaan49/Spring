package di_annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("tv") //객체명 - tv
public class SamsungTV implements TV {
	@Autowired //동일한 타입의 객체(인스턴스)를 찾아서 주입(해당 객체도 @component 해놔야함)
	@Qualifier("apple") //"000"라는 이름에 Speaker타입인 객체 주입할 것
	private Speaker speaker;
	private int price;
	private int width;
	private int height;
		

	public SamsungTV() { //기본 생성자
		System.out.println(">> SamsungTV 생성");
	}
	
	public SamsungTV(Speaker speaker) { //speaker를 받는 생성자
		System.out.println(">> SamsungTV(Speaker) 객체 생성");
		this.speaker = speaker;
	}

	public SamsungTV(Speaker speaker, int price) { //speaker, price를 받는 생성자
		this.speaker = speaker;
		this.price = price;
	}
	
	public SamsungTV(Speaker speaker, int width, int height) { //speaker, width, height를 받는 생성자
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
	
	public Speaker getSpeaker() {
		return speaker;
	}
	
	public void setSpeaker(Speaker speaker) {
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
