package polymorphism;

public class Hello {
  private String name;
  private Printer printer;//포함관계 interface
  
  
  public Hello() {}

public String getName() { return name;}

public void setName(String name) {
	this.name = name;
}

public Printer getPrinter() {	return printer;}
public void setPrinter(Printer printer) {	this.printer = printer;}

 public String sayHello() {
	 System.out.println("name="+name);
	 return "Hello "+ name;
 }
 
 public void print() {
	 printer.print(sayHello());
 }

  
}
