package collections01;

import java.util.Iterator;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CollectionEx02 {
	public static void main(String[] args) {
		ApplicationContext ac
		 = new ClassPathXmlApplicationContext("config/beans08.xml");
		
		CollectionBean02 cb = (CollectionBean02)ac.getBean("cb");
		
		Set<String> set = cb.getAddressList();
		Iterator<String> it = set.iterator();
		while(it.hasNext())
			System.out.println(it.next());
	}
}
