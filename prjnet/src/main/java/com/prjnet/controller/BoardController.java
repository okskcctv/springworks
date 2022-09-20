package com.prjnet.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.prjnet.domain.BoardVO;
import com.prjnet.domain.Criteria;
import com.prjnet.service.BoardService;

import lombok.extern.log4j.Log4j;

@RequestMapping("/board/*")	// localhost:8080/board/*
@Controller
@Log4j
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	// 글 목록
	@GetMapping("/boardList")
	public String getBoardList(Criteria cri, Model model) {
		List<BoardVO> boardList = service.getBoardList(cri);
		
		log.info(cri);
		model.addAttribute("boardList", boardList);	// model - "boardList"
		return "/board/boardList";
	}
	
	// 글 작성 요청
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/insertBoad")
	public String insert() {
		return "/board/insertBoard";
	}
	
	// 글 작성
	@PostMapping("/insertBoard")
	@PreAuthorize("isAuthenticated()")
	public String insert(BoardVO vo) throws IllegalStateException, IOException{
		// 파일 업로드 처리
		MultipartFile uploadFile = vo.getImage();
		if(!uploadFile.isEmpty()) {
			String fileName = uploadFile.getOriginalFilename();
			String filePath = "C:/upload/";
			uploadFile.transferTo(new File(filePath + fileName));
		}
		service.insert(vo);
		return "redirect:/board/boardList";
	}
	
	// 글 조회
	@PreAuthorize("isAuthenticated()")
	@RequestMapping("/boardView")
	public String getBoard(int bno, @ModelAttribute("cri") Criteria cri, Model model) {
		BoardVO board = service.getBoard(bno);
		
		model.addAttribute("board", board);	// model - "board"
		return "/board/boardView";
	}
	
	// 글 삭제 요청
	@GetMapping("/deleteBoard")
	public String delete(BoardVO vo, Criteria cri, RedirectAttributes rttr) {
		service.delete(vo);
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		return "redirect:/board/boardList";
	}
	
	// 글 수정 요청
	@PostMapping("/updateBoard")
	public String update(BoardVO vo, Criteria cri, RedirectAttributes rttr) {
		service.update(vo);
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		return "redirect:/board/boardList";
	}
}
