package com.spring.di.sample;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@Component
@ToString
public class Hotel {
	
	private Chef chef;
	
	/* public Hotel(Chef chef) {	// �����ڸ� ���� ���� ���
		this.chef = chef;
	} */
}
