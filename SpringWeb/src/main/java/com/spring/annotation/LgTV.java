package com.spring.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("tv")
public class LgTV implements TV{
	
	@Autowired
	private Speaker speaker;	// Speaker °´Ã¼ ¼±¾ð
	
	public LgTV() {
		System.out.println("===> LgTV °´Ã¼ »ý¼º");
	}
	
	@Override
	public void powerOn() {
		System.out.println("LgTV--Àü¿ø ÄÒ´Ù");
	}

	@Override
	public void powerOff() {
		System.out.println("LgTV--Àü¿ø ²ö´Ù");
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
