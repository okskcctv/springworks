package com.prjnet.domain;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class MemberVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String pw;
	private String name;
	private int age;
	private List<AuthVO> authList;
}
