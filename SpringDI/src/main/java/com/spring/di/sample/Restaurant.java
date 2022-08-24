package com.spring.di.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

// 생성자 주입 - @AllArgsConstructor
// Setter 주입
// 필드 주입 - Autowired

//@AllArgsConstructor
@Data
@Component
public class Restaurant {
	
	//@Autowired
	@Setter(onMethod_ = @Autowired)
	private Chef chef;	// new Chef()
	
	/* public Restaurant(Chef chef) {	// 자바 방식의 생성자 만들기
		this.chef = chef;
	} */
}
