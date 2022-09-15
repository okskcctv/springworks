package com.cloud.domain;

import lombok.Data;

@Data
public class Criteria {
	private int pageNum;	// 페이지 번호
	private int amount;		// 페이지당 게시글 수
	
	private String type;	// t, tc, tcw (배열, 맵으로 구현)
	private String keyword;	// 검색어
	
	public Criteria() {	// 또 다른 생성자 호출
		this(1, 10);
	}
	
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	// 타입을 저장할 메서드 정의(type이 null이 아니면 문자열을 분리하여 배열로 반환)
	public String[] getTypeArr() {
		return type == null ? new String[] {} : type.split("");
	}
}
