package collections01;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CollectionEx01 {

	public static void main(String[] args) {
	   
		ApplicationContext ac
		  = new ClassPathXmlApplicationContext("classpath:beans07.xml");
		
         CollectionBean01 cb = (CollectionBean01)ac.getBean("cb");
         
        List<String> list =  cb.getAddressList();
        
        for(String s:list) {
        	System.out.println(s);
        }

	}

}
