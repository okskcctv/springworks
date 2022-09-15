package com.cloud.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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

import com.cloud.domain.BoardVO;
import com.cloud.domain.Criteria;
import com.cloud.domain.PageDTO;
import com.cloud.service.BoardService;

import jdk.internal.org.jline.utils.Log;
import lombok.extern.log4j.Log4j;

@RequestMapping("/board/*")  //localhost:8080/board/aaa
@Controller
@Log4j
public class BoardController {
	
	@Autowired
	private BoardService service;

	@GetMapping("/boardList")//localhost:8080/board/boardList
	public String getBoardList(Criteria cri, Model model) {	// 게시글 목록 요청
		List<BoardVO> boardList = service.getListWithPage(cri);
		PageDTO pageMaker = new PageDTO(cri, service.getTotalCount(cri));
		
		
		log.info(cri);
		model.addAttribute("boardList", boardList);	// model-"boardList"
		model.addAttribute("pageMaker", pageMaker);	// model-"pageMaker"
		return "/board/boardList";
	}
	
	//�۾��� �� ������ ��û
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/insertBoard")
	public String insert() {
		return "/board/insertBoard";
	}
	
	//�۾��� ó�� ��û
	@PostMapping("/insertBoard")
	@PreAuthorize("isAuthenticated()")
	public String insert(BoardVO vo) throws IllegalStateException, IOException{
		// 파일 업로드 처리
		MultipartFile uploadFile = vo.getUploadFile();
		if(!uploadFile.isEmpty()) {
			String fileName = uploadFile.getOriginalFilename();
			String filePath = "C:/upload/";
			uploadFile.transferTo(new File(filePath + fileName));
		}
		service.insert(vo);      
		return "redirect:/board/boardList";
	}
	
	@PreAuthorize("isAuthenticated()")
	@RequestMapping("/boardView")
	public String getBoard(int bno, @ModelAttribute("cri") Criteria cri, Model model) {
		service.updateCount(bno);	// 조회수 증가
		BoardVO board = service.getBoard(bno);	// 상세 보기 처리
		model.addAttribute("board", board);	// model-"board"
		return "/board/boardView";
	}
	
	@GetMapping("/deleteBoard")
	public String delete(BoardVO vo, Criteria cri, RedirectAttributes rttr) {	// 글 삭제 요청
		service.delete(vo);
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		return "redirect:/board/boardList";
	}
	
	@PostMapping("/updateBoard")
	public String update(BoardVO vo, Criteria cri, RedirectAttributes rttr) {	// 글 수정 요청
		service.update(vo);
		// URL 뒤에 원래의 페이디로 이동하기 위해 pageNum과 amount 값을 보내줌
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		return "redirect:/board/boardList";
	}
	
}
