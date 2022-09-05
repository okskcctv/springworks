package com.prjnet.domain;

import java.io.Serializable;

import lombok.Data;

@Data
public class boardVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int bno;
	private String title;
	private String content;
	private String image;
	private int uno;
	
}
