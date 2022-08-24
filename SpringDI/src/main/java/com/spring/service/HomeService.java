package com.spring.service;

import org.springframework.stereotype.Service;

import com.spring.vo.FriendVO;
import com.spring.vo.FriendVO2;

@Service
public class HomeService {
	
	public void sayHello() {
		//System.out.println("æ»≥Á«œººø‰~");
		FriendVO vo1 = new FriendVO();
		vo1.setName("æ»ªÍ");
		vo1.setAge(21);
		
		FriendVO2 vo2 = new FriendVO2("º’»ÔπŒ", 30);
		
		System.out.println(vo1.getName() + "¥‘ æ»≥Á«œººø‰.");
		System.out.println(vo2.getName() + "¥‘ æ»≥Á«œººø‰.");
	}
}
