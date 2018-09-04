package polymorphism05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex02 {

	public static void main(String[] args) {
		ApplicationContext ac
		 = new ClassPathXmlApplicationContext("config/beans05-02.xml");
		TV tv = (TV)ac.getBean("tv");
		tv.volumeUp();
		tv.volumeDown();
		
	}
}
