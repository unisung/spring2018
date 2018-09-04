package polimorphism;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser2 {
	public static void main(String[] args) {
      //1.spring컨테이너의 구동.
		//=IOC컨테이너(등록된 bean객체를 생성, 관리하는 역활)
		AbstractApplicationContext factory =
		  /*BeanFactory factory=*/
		 /* ApplicationContext factory =*/ 
				new GenericXmlApplicationContext("applicationContext.xml");
		
	 //2. Spring컨테이너로 부터 필요한 객체를 요청
		//(TV)applicationContext.getBean(id) :리턴 타입 Object -> TV로 casting
		TV tv = (TV) factory.getBean("tv");//argument에 따라서 달라짐
		
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		//applicationContext.getBean(id,타입): 리턴타입 해당 타입
		TV tv2 = factory.getBean("tv",LgTV.class);
		tv2.powerOn();
		tv2.volumeUp();
		tv2.volumeDown();
		tv2.powerOff();
		
		
		//tv과 tv2과 참조하는 객체가 동일한지 비교
		System.out.println(tv==tv2);
		System.out.println(factory.isSingleton("tv"));
		
		
		//3. Spring 컨테이너 종료
		factory.close();
		
		
		
	}
}
