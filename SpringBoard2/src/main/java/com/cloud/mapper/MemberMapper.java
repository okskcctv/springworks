package com.cloud.mapper;

import java.util.List;

import com.cloud.domain.MemberVO;

public interface MemberMapper {
	
	public MemberVO read(String userid);

	public void insertMember(MemberVO member);

	public List<MemberVO> getMemberList();
	
	public void deleteMember(MemberVO member);

	public void updateMember(MemberVO member);

}





