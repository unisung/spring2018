package polymorphism04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PolyEx01 {

	public static void main(String[] args) {
		//classPath는 src아래의 폴더 참조
		ApplicationContext ac
		 = new ClassPathXmlApplicationContext("config/beans04.xml");

		MessageBean mb = (MessageBean)ac.getBean("mb04");
		mb.sayHello();
	}

}
