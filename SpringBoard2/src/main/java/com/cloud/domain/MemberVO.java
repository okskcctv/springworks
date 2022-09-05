package com.cloud.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class MemberVO implements Serializable{
	
	private static final long serialVersionUID = 11L;
	
	private String userid;
	private String userpw;
	private String username;
	private String enabled;
	private Date regDate;
	private Date updateDate;
	private List<AuthVO> authList;
}
