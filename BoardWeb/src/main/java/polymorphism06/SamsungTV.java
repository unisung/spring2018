package polymorphism06;

public class SamsungTV implements TV {
	SonySpeaker speaker;//객체타입
	int price;//기본 데이타 타입

	//기본생성자(default constructor)
	public SamsungTV() {} 
	
	//매개변수 1개짜리 생성자
	public SamsungTV(SonySpeaker speaker, int price) {
	   this.speaker=speaker;
	   this.price=price;
	}
	
	@Override
	public void powerOn() {	}

	@Override
	public void powerOff() {}

	@Override
	public void volumeUp() {
		speaker.volumeUp();
	}
	@Override
	public void volumeDown() {
		speaker.volumeDown();
	}
   
	//객체 타입 setter메소드
	public void setSpeaker(SonySpeaker speaker) {
		this.speaker = speaker;
	}
   //기본데이타 타입 setter메소드
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
