package com.prjnet.security.domain;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.prjnet.domain.MemberVO;

import lombok.Getter;

@Getter
public class CustomUser extends User{

	private static final long serialVersionUID = 1L;
	
	private MemberVO member;	// 맴버
	
	// 
	public CustomUser(String username, String password,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}
	
	// MemberVO 
	public CustomUser(MemberVO vo) {
		super(vo.getId(), vo.getPw(),
			  vo.getAuthList()
			  .stream()
			  .map(auth -> new SimpleGrantedAuthority(auth.getAuth()))
			  .collect(Collectors.toList())
			);
		this.member = vo;
	}

}
