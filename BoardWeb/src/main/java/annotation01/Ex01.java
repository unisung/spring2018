package annotation01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Ex01 {
public static void main(String[] args) {

	ApplicationContext ac
	 = new GenericXmlApplicationContext("applicationContext.xml");
	
	LgTV tv = (LgTV)ac.getBean("tv");
	tv.volumeUp();
	tv.volumeDown();
	
	
}
}
