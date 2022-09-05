package com.prjnet.mapper;

import com.prjnet.domain.MemberVO;

public interface MemberMapper {
	
	// 회원 찾기
	public MemberVO read(String id);
	
	// 회원 가입
	public void insertMember(MemberVO member);
	
	// 회원 삭제
	public void deleteMember(MemberVO member);
	
	// 정보 수정
	public void updateMember(MemberVO member);
	
}
