package polymorphism03;

public class TVUser {

	public static void main(String[] args) {
		//삼성 또는 LG TV 사용
		BeanFactory factory = new BeanFactory();
		
//		TV tv = (TV)factory.getBean("samsung");
//		
//		tv.powerOn();
//		tv.powerOff();
//		tv.volumeDown();
//		tv.volumeUp();
		
//		TV tv = (TV)factory.getBean("lg");
//		
//		tv.powerOff();
//		tv.powerOn();
//		tv.volumeDown();
//		tv.volumeUp();
		
		TV tv = (TV)factory.getBean(args[0]);
		
		tv.powerOff();
		tv.powerOn();
		tv.volumeDown();
		tv.volumeUp();

	}

}
