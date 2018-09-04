package polymorphism04;

public class MessageBenImpl implements MessageBean {
   private String name;
   private String greet;
   
   
  public void setName(String name) {	this.name = name;}
  public void setGreet(String greet) {	this.greet = greet;}

	@Override
	public void sayHello() {
		System.out.println(name+"님"+greet+"||");
	}

}
