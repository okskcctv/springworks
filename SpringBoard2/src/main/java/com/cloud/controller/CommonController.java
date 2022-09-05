package com.cloud.controller;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class CommonController {
	//���� ó��
	@GetMapping("/accessError")
	public void accessDenied(Authentication auth, Model model) {
		log.info("access Denied : " + auth);
		model.addAttribute("msg", "접근 불가");
	}
	
	//�α��� �� ������ ��û
	@GetMapping("/customLogin")
	public void login(String error, String logout, Model model) {
		log.info("error : " + error);
		log.info("logout : " + logout);
	
		if(error != null) {
			model.addAttribute("error", "���̵� ��й�ȣ�� Ȯ���� �ּ���");
		}
		
		if(logout != null) {
			model.addAttribute("logout", "로그아웃!!");
		}
	}
	
	//�α׾ƿ� ó��
	@GetMapping("/customLogout")
	public String logout(HttpSession session) {
		session.invalidate();  //���� ����
		
		log.info("custom logout");
		return "redirect:/";
	}
}





