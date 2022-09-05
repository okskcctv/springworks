package com.cloud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cloud.domain.AuthVO;
import com.cloud.domain.MemberVO;
import com.cloud.mapper.MemberAuthMapper;
import com.cloud.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberMapper mapper;
	
	@Autowired
	private MemberAuthMapper authMapper;
	
	@Autowired
	private PasswordEncoder pwencoder;

	@Override
	public void signup(MemberVO member) {  //회원 가입
		//비밀번호 암호화
		String encPw = pwencoder.encode(member.getUserpw());
		member.setUserpw(encPw);
		
		mapper.insertMember(member); //member 가입
		
		AuthVO auth = new AuthVO();
		auth.setUserid(member.getUserid());
		auth.setAuth("ROLE_USER");  //권한 변경 처리
		
		authMapper.insertMemberAuth(auth); //auth 부여
	}

	@Override
	public List<MemberVO> getMemberList() {
		return mapper.getMemberList();
	}

	@Override
	public MemberVO read(String userid) {
		return mapper.read(userid);
	}

	@Override
	public void delete(MemberVO member) {
		mapper.deleteMember(member);
	}

	@Override
	public void update(MemberVO member) {
		//비밀번호 암호화 (수정 처리)
		String encPw = pwencoder.encode(member.getUserpw());
		member.setUserpw(encPw);
		
		mapper.updateMember(member);
	}

}
