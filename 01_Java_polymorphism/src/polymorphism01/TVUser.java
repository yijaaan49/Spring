package polymorphism01;

public class TVUser {
	
	public static void main(String[] args) {
//		//삼성TV 사용
//		SamsungTV tv = new SamsungTV();
//		
//		tv.powerOn();
//		tv.volumeUp();
//		tv.volumeDown();
//		tv.powerOff();
		
		//LGTV 사용형태로 변경
		LGTV tv = new LGTV();
		
		tv.on();
		tv.off();
		tv.soundUp();
		tv.soundDown();
		
	}
}
