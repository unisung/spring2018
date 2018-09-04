package collections01;

import java.util.Iterator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class CollectionEx03_02 {

	public static void main(String[] args) {
		ApplicationContext ac =
				new ClassPathXmlApplicationContext("config/beans09-02.xml");
		
		CollectionBean04 cb = (CollectionBean04)ac.getBean("cb");
		Iterator<String> itor = cb.getAddressList().keySet().iterator();
		while(itor.hasNext()) {
			String name=itor.next();
		    Controller controller = cb.getAddressList().get(name);//new Cotroller();
			System.out.println("name="+name);
			controller.execute();
		}

	}

}
