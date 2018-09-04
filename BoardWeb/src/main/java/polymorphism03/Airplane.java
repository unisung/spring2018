package polymorphism03;

public class Airplane implements Vehicle {

	@Override
	public void ride(String name) {
	 System.out.println(name+"은 비행기를 타다");
	}

}
