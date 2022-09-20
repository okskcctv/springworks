package com.prjnet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.prjnet.domain.MemberVO;
import com.prjnet.service.MemberService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@AllArgsConstructor
@Log4j
@RequestMapping("/member/*")
@Controller
public class MemberController {
	
	private MemberService service;
	
	// 회원가입 요청
	@GetMapping("/signup")
	public void signUp() {
		log.info("회원가입");
	}
	
	// 회원가입
	@PostMapping("/signup")
	public String signUp(MemberVO member) {
		service.signup(member);
		return "redirect:/login";
	}
	
	// 회원 정보
	@GetMapping("/memberView")
	public String getMember(String id, Model model) {
		MemberVO member = service.read(id);
		model.addAttribute("member", member);
		return "/member/memberView";
	}
	
	// 회원 삭제
	@GetMapping("/delete")
	public String delete(MemberVO member) {
		service.delete(member);
		return "redirect:/";	// 홈으로 이동
	}
	
	// 회원 수정
	@PostMapping("/update")
	public String update(MemberVO member) {
		service.update(member);
		return "redirect:/member/memberList";
	}
}
