package annotation01;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("tv")
public class LgTV implements TV{
	 //Speaker타입 중에서 아이디가 "sony"인 객체 주입
	 /*  @Inject 
	 @Qualifier("apple")*/
	 @Resource(name="apple")
	  private Speaker speaker;
	  
	 public Speaker getSpeaker() {
		return speaker;
	}

	 public void setSpeaker(Speaker speaker) {
		 this.speaker=speaker;
	 }
	 
	@Override
	public void powerOn() {
	   System.out.println("power On");		
	}

	@Override
	public void volumeUp() {
		System.out.println("volumeUp");
		speaker.volumeUp();
		
	}

	@Override
	public void volumeDown() {
		System.out.println("volume Down");
		try {
		speaker.volumeDown();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void powerOff() {
		System.out.println("power Off");
		
	}
	

}
