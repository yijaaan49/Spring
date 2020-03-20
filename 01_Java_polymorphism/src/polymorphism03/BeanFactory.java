package polymorphism03;

public class BeanFactory {
	
	//Factory 패턴을 적용해서 결합도를 낮춤
	//TV를 만들어주는 공장 역할 클래스의 메소드
	public Object getBean(String beanName) {
		Object bean = null;
		//요청하는 bean 이름이 samsung이면 SamsungTV를 만들고,
		//				 lg면 LGTV를 만들어 전달
		if(beanName.equalsIgnoreCase("samsung")) {
			bean = new SamsungTV();
			
		} else if(beanName.equalsIgnoreCase("lg")) {
			bean = new LGTV();
		}
		
		return bean;
	}
}
