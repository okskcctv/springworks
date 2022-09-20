package com.prjnet.service;

import com.prjnet.domain.MemberVO;

public interface MemberService {
	
	// 회원 가입
	public void signup(MemberVO member);
	
	// 회원 찾기
	public MemberVO read(String id);
	
	// 회원 삭제
	public void delete(MemberVO member);
	
	// 회원 수정
	public void update(MemberVO member);
	
}
