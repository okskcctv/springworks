package com.cloud.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.cloud.domain.MemberVO;
import com.cloud.mapper.MemberMapper;
import com.cloud.security.domain.CustomUser;

import lombok.extern.log4j.Log4j;

@Log4j
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private MemberMapper mapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.warn("Load User By Username : " + username);
		
		MemberVO vo = mapper.read(username); //회원 상세 보기
		log.warn("queried by member mapper : " + vo);
		
		//검색된 vo가 있는 CustomUser 객체 생성후 반환
		return vo == null ? null : new CustomUser(vo);
	}

}
