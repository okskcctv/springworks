package com.cloud.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/sample/*")
@Controller
public class SampleController {
	
	@GetMapping("/functions")
	public String doFunctions() {
		return "/sample/functions";
	}

	/*@GetMapping("/all")
	public void doAll() {
		log.info("��� ����ڰ� ������ �� ����");
	}*/
	
	@GetMapping("/all")
	public String doAll() {
		log.info("��� ����ڰ� ������ �� ����");
		return "/sample/all";
	}
	
	@GetMapping("/member")
	public void doMember() {
		log.info("�α����� ȸ��(���)");
	}
	
	@GetMapping("/admin")
	public void doAdmin() {
		log.info("�α����� �����ڸ� ����");
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MEMBER')")
	@GetMapping("/annoMember")
	public void doMember2() {
		log.info("�α����� ����� ������ ���");
	}
	
	@Secured({"ROLE_ADMIN"})
	@GetMapping("/annoAdmin")
	public void doAdmin2(){
		log.info("�α����� �����ڸ�");
	}
	
}





