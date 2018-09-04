package polymorphism07;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex01 {
public static void main(String[] args) {
	ApplicationContext ac
	  =new ClassPathXmlApplicationContext("polymorphism07/beans11.xml");
	MessageBean mb = (MessageBean)ac.getBean("mb");
	mb.ride();
}
}
