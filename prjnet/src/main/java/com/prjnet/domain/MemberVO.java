package com.prjnet.domain;

import java.io.Serializable;

import lombok.Data;

@Data
public class MemberVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int uno;
	private String id;
	private String pw;
	private String name;
	private int age;
}
