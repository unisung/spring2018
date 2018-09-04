package polymorphism03;

public class Car implements Vehicle {

	@Override
	public void ride(String name) {
	System.out.println(name+"은 자동차를 탄다.");
	}
}
