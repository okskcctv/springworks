package com.prjnet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.prjnet.domain.AuthVO;
import com.prjnet.domain.MemberVO;
import com.prjnet.mapper.MemberAuthMapper;
import com.prjnet.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberMapper mapper;
	
	@Autowired
	private MemberAuthMapper authMapper;
	
	@Autowired
	private PasswordEncoder pwencoder;
	
	@Override
	public void signup(MemberVO member) {	// 회원 가입
		// 암호화를 위한 인코딩
		String encPw = pwencoder.encode(member.getPw());
		member.setPw(encPw);
		
		mapper.insertMember(member);	// member 등록
		
		AuthVO auth = new AuthVO();
		auth.setId(member.getId());
		auth.setAuth("MEMBER");	// 맴버에 MEMBER 권한 주기
		
		authMapper.insertMemberAuth(auth);	// auth 등록
	}

	@Override
	public MemberVO read(String id) {
		return mapper.readMember(id);
	}

	@Override
	public void delete(MemberVO member) {
		mapper.deleteMember(member);
	}

	@Override
	public void update(MemberVO member) {
		// 비밀번호 인코딩
		String encPw = pwencoder.encode(member.getPw());
		member.setPw(encPw);
		
		mapper.updateMember(member);
	}

}
