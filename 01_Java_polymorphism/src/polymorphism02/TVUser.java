package polymorphism02;

public class TVUser {
	
	public static void main(String[] args) {
//		//삼성TV 사용
//		TV tv = new SamsungTV();
//		
//		tv.powerOn();
//		tv.volumeUp();
//		tv.volumeDown();
//		tv.powerOff();
		
		TV tv = new LGTV();
		
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
	}
}
