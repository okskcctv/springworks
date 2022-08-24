package com.spring.user;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserServiceClient {

	public static void main(String[] args) {
		// 1. spring �����̳� ����
		AbstractApplicationContext container = 
				new GenericXmlApplicationContext("applicationContext.xml");
		
		UserService userService = (UserService) container.getBean("userService");
		
		// 3. �α��� ��� �׽�Ʈ
		UserVO vo = new UserVO();
		vo.setId("test");
		vo.setPasswd("test123");
		
		boolean result = userService.login(vo);
		if(result) {
			System.out.println("�α��ο� �����߽��ϴ�.");
		}else {
			System.out.println("���̵� ��й�ȣ�� Ȯ�����ּ���.");
		}
		
		// 4. spring �����̳� ����
		container.close();
	}

}
