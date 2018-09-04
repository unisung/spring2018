package polymorphism07;

public class MessageBeanImpl implements MessageBean {
	private String rider;
	private int speed;
	private Output output;

	public MessageBeanImpl(String rider, int speed) {
		this.rider = rider;
		this.speed = speed;
	}

	public void setOutput(Output output) {
		this.output = output;
	}

	@Override
	public void ride() {
		String msg = rider + "를" + speed + "속도로 탄다";
		System.out.println(msg);
		if (output != null)
			output.output(msg);
	}

}
