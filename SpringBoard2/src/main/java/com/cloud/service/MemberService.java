package com.cloud.service;

import java.util.List;

import com.cloud.domain.MemberVO;

public interface MemberService {

	//회원 가입
	public void signup(MemberVO member);
	
	//회원 목록
	public List<MemberVO> getMemberList();
	
	//회원 상세 보기
	public MemberVO read(String userid);
	
	//회원 탈퇴
	public void delete(MemberVO member);
	
	//회원 수정
	public void update(MemberVO member);
}





