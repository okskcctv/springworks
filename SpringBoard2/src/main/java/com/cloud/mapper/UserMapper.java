package com.cloud.mapper;

import com.cloud.domain.UserVO;

public interface UserMapper {
	
	public int login(UserVO vo);  //로그인 체크
}
