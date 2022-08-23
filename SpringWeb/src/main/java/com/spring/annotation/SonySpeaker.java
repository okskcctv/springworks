package com.spring.annotation;

public class SonySpeaker implements Speaker{
	
	public SonySpeaker() {
		System.out.println("==> SonySpeaker 按眉 积己");
	}

	@Override
	public void volumeUp() {
		System.out.println("SonySpeaker -- 家府 棵覆");
	}

	@Override
	public void volumeDown() {
		System.out.println("SonySpeaker -- 家府 郴覆");
	}
	
}
