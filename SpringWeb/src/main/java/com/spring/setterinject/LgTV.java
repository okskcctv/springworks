package com.spring.setterinject;

public class LgTV implements TV{
	// Setter ������
	private Speaker speaker;
	private int price;
	
	public LgTV() {
		System.out.println("===> LgTV ��ü ����");
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
		System.out.println("LgTV--���� �Ҵ� (����:" + price + ")");
	}

	@Override
	public void powerOff() {
		System.out.println("LgTV--���� ����");
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
