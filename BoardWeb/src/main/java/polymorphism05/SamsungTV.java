package polymorphism05;

public class SamsungTV implements TV {
	SonySpeaker speaker;

	//기본생성자(default constructor)
	public SamsungTV() {} 
	
	//매개변수 1개짜리 생성자
	public SamsungTV(SonySpeaker speaker) {
	   this.speaker=speaker;
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
   
	//setter메소드
	public void setSpeaker(SonySpeaker speaker) {
		this.speaker = speaker;
	}
}
