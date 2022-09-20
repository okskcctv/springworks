package com.prjnet.controller;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class CommonController {
	// 권한 오류
	@GetMapping("/accessError")
	public void accessDenied(Authentication auth, Model model) {
		log.info("access Denied : " + auth);
		model.addAttribute("msg", "접근 불가");
	}
	
	// 로그인 처리
	@GetMapping("/customLogin")
	public void login(String error, String logout, Model model) {
		log.info("error : " + error);
		log.info("logout : " + logout);
		
		if(error != null) {
			model.addAttribute("error", "에러입니다");
		}
		
		if(logout != null) {
			model.addAttribute("logout", "로그아웃");
		}
	}
	
	// 로그아웃
	@GetMapping("/customLogout")
	public String logout(HttpSession session) {
		session.invalidate();	// 모든 세션 삭제
		
		log.info("custom logout");
		return "redirect:/";
	}
}
