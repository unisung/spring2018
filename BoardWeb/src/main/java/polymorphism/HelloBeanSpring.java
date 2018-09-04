package polymorphism;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloBeanSpring {
	public static void main(String[] args) {
	/* ApplicationContext factory*/
		AbstractApplicationContext factory
	     = new GenericXmlApplicationContext("config/beans01.xml");
	 
	  //Hello hello = new Hello();//사용주도의 의존관계 주입
     Hello hello = (Hello)factory.getBean("hello");
     hello.print();
     
     System.out.println();

      //xml설정파일에서 bean정보를 읽어서 해당 instance를 printer변수에 대입
     Printer printer = factory.getBean("printer",StringPrinter.class);
     printer.print("Hello Spring");
     
     factory.close();
	 
	}
}
