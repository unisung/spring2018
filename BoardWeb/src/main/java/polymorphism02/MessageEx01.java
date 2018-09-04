package polymorphism02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MessageEx01 {
	public static void main(String[] args) {
	 ApplicationContext context
	   = new GenericXmlApplicationContext("config/beans02.xml");
	 
	 MessageBean messageBean = (MessageBean)context.getBean("ko");
     messageBean.sayHello("spring");
     
     MessageBean messageBean2 
                   = context.getBean("en",MessageBeanEn.class);
     messageBean2.sayHello("spring");
	}

}
