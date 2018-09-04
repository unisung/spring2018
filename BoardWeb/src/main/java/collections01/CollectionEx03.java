package collections01;

import java.util.Iterator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class CollectionEx03 {

	public static void main(String[] args) {
		ApplicationContext ac =
				new ClassPathXmlApplicationContext("config/beans09.xml");
		
		CollectionBean03 cb = (CollectionBean03)ac.getBean("cb");
		Iterator<String> itor = cb.getAddressList().keySet().iterator();
		while(itor.hasNext()) {
			String name=itor.next();
			String address=cb.getAddressList().get(name);
			
			System.out.println("name="+name);
			System.out.println("address="+address);
			
		}
		
		

	}

}
