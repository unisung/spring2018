package polymorphism;

public class StringPrinter implements Printer{
    private StringBuffer buffer = new StringBuffer();
	
	@Override
	public void print(String message) {
	     buffer.append(message);
	     System.out.print(buffer.toString());
	}

	@Override
	public String toString() {
		return buffer.toString();
	}
	
	

}
