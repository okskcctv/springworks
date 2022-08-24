package com.spring.di.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

// ������ ���� - @AllArgsConstructor
// Setter ����
// �ʵ� ���� - Autowired

//@AllArgsConstructor
@Data
@Component
public class Restaurant {
	
	//@Autowired
	@Setter(onMethod_ = @Autowired)
	private Chef chef;	// new Chef()
	
	/* public Restaurant(Chef chef) {	// �ڹ� ����� ������ �����
		this.chef = chef;
	} */
}
