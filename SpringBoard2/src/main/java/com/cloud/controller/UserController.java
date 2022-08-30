package com.cloud.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cloud.domain.UserVO;
import com.cloud.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService service;
	
	//로그인 폼 페이지 요청
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	//로그인 처리
	@PostMapping("/login")
	public String login(UserVO vo, HttpSession session, Model model) {
		int result = service.login(vo);
		if(result == 1) { //일치하는 결과가 있으면
			session.setAttribute("sessionId", vo.getId()); //세션 발급
			return "redirect:/board/boardList";
		}else {
			int error = 1;
			model.addAttribute("error", error); //"error" 모델 보내기
			return "login";
		}
	}
	
	//로그아웃 처리
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate(); //모든 세션 삭제
		return "index";
	}
}
