package com.spring.product;

public class TVUser {

	public static void main(String[] args) {
		/* SamsungTV tv = new SamsungTV();
		
		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.volumeDown(); */
		
		LgTV tv = new LgTV();
		
		tv.turnOn();
		tv.turnOff();
		tv.soundUp();
		tv.soundDown();
	}

}
