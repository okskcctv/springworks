package com.prjnet.mapper;

import com.prjnet.domain.AuthVO;

public interface MemberAuthMapper {
	
	// 권한 부여
	public void insertMemberAuth(AuthVO auth);
	
}
