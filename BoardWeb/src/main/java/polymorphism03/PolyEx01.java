package polymorphism03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class PolyEx01 {
	public static void main(String[] args) {
		//FileSystem내의 설정파일 찾기 
		ApplicationContext ac
/*		 = new FileSystemXmlApplicationContext("src/main/java/config/beans03.xml");*/
		 = new FileSystemXmlApplicationContext("src/main/java/config/beans04.xml");
		
		Vehicle vh = ac.getBean(Vehicle.class);//bean설정파일에서 Vehicle인터페이스를 구현객체를 구함
		vh.ride("길동");
		
		
		Vehicle vh2 = (Vehicle)ac.getBean("vh");
		vh2.ride("길동");
		
		
	}

}
