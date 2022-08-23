package com.spring.consinject;

public class SamsungTV implements TV{
	// 积己磊 牢璃记
	private SonySpeaker speaker;
	
	public SamsungTV() {
		System.out.println("===> SamsungTV(1) 按眉 积己");
	}
	
	public SamsungTV(SonySpeaker speaker) {
		System.out.println("SamsungTV(2) 按眉 积己");
		this.speaker = speaker;
	}
	
	@Override
	public void powerOn() {
		System.out.println("SamsungTV--傈盔 囊促");
	}

	@Override
	public void powerOff() {
		System.out.println("SamsungTV--傈盔 馋促");
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
