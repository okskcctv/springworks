package com.spring.consinject;

public class LgTV implements TV{
	// ������ ������
	private SonySpeaker speaker;
	
	public LgTV() {
		System.out.println("===> LgTV ��ü ����");
	}
	
	public LgTV(SonySpeaker speaker) {
		System.out.println("LgTV(2) ��ü ����");
		this.speaker = speaker;
	}
	
	@Override
	public void powerOn() {
		System.out.println("LgTV--���� �Ҵ�");
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
