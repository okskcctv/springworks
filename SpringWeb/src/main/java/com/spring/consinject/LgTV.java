package com.spring.consinject;

public class LgTV implements TV{
	// 积己磊 牢璃记
	private SonySpeaker speaker;
	
	public LgTV() {
		System.out.println("===> LgTV 按眉 积己");
	}
	
	public LgTV(SonySpeaker speaker) {
		System.out.println("LgTV(2) 按眉 积己");
		this.speaker = speaker;
	}
	
	@Override
	public void powerOn() {
		System.out.println("LgTV--傈盔 囊促");
	}

	@Override
	public void powerOff() {
		System.out.println("LgTV--傈盔 馋促");
	}

	@Override
	public void volumeUp() {
		speaker.volumeUp();
	}

	@Override
	public void volumeDown() {
		speaker.volumeDown();
	}

}
