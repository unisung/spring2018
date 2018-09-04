package polimorphism;

public class BeanFactory {
	public Object getBean(String beanName) {
		if (beanName.equals("Samsung"))
			return new SamsungTV();//해당 객체를 생성 해서 넘겨줌
		else if (beanName.equals("Lg")) {
			return new LgTV();
		}
		return null;
	}
}
