package com.cloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor	// 매개변수 없는 기본 생성자
@AllArgsConstructor	// 매개변수 있는 생성자
@Data
public class SampleVO {
	
	private Integer mno;
	private String firstName;
	private String lastName;
}
