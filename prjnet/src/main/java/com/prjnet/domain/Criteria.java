package com.prjnet.domain;

import lombok.Data;

@Data
public class Criteria {
	private String type;	// t, c, tc (배열, 맵으로 구현)
	private String keyword;	// 검색어
	
	// 타입을 저장할 메서드 정의(type이 null이 아니면 문자열을 분리하여 배열로 반환)
	public String[] getTypeArr() {
		return type == null ? new String[] {} : type.split("");
	}
}
