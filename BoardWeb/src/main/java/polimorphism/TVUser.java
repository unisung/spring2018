package polimorphism;


public class TVUser {
	public static void main(String[] args) {
		// TVUser  와  SamsungTV는 높은 결합도
		BeanFactory factory 
		 = (BeanFactory) new BeanFactory();
		
		//DI(Dependency Injection)
		TV tv = (TV) factory.getBean(args[0]);//argument에 따라서 달라짐
		
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		
		
	}
}
