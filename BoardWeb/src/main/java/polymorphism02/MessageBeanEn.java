package polymorphism02;

public class MessageBeanEn implements MessageBean {

	@Override
	public void sayHello(String name) {
		System.out.println(name+"! hello");
	}

}
