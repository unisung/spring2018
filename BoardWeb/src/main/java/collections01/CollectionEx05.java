package collections01;

import java.util.Iterator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CollectionEx05 {

	public static void main(String[] args) {
		ApplicationContext ac
		 = new ClassPathXmlApplicationContext("config/beans10.xml");
		
		CollectionBean05 cb = (CollectionBean05)ac.getBean("cb");
		
		Iterator<Object> it = cb.getAddressList().keySet().iterator();
         while(it.hasNext()) {
        	 String key = (String) it.next();
        	 String address = cb.getAddressList().getProperty(key);
        	 
        	 System.out.println("name="+key);
        	 System.out.println("address="+address);
         }
	}

}
