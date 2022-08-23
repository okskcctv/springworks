package com.spring.annotation;

public class SamsungTV implements TV{
	// setter ������
	private Speaker speaker;
	private int price;
	
	public SamsungTV() {
		System.out.println("===> SamsungTV(1) ��ü ����");
	}
	
	public void setSpeaker(Speaker speaker) {
		System.out.println("==> setSpeaker() ȣ��");
		this.speaker = speaker;
	}
	
	public void setPrice(int price) {
		System.out.println("==> setPrice() ȣ��");
		this.price = price;
	}
	
	@Override
	public void powerOn() {
		System.out.println("SamsungTV--���� �Ҵ� (����:" + price + ")");
	}

	@Override
	public void powerOff() {
		System.out.println("SamsungTV--���� ����");
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
