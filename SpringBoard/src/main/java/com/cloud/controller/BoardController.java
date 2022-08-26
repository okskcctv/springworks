package com.cloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cloud.repository.BoardVO;
import com.cloud.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@RequestMapping("/boardList")
	public String getBoardList(Model model) {	// 게시글 목록 요청
		List<BoardVO> boardList = service.getBoardList();
		model.addAttribute("boardList", boardList);	// model-"boardList"
		return "boardList";
	}
	
	@RequestMapping("/boardView")
	public String getBoard(int bno, Model model) {	// 상세 보기 요청
		service.updateCount(bno);	// 조회수 증가
		BoardVO board = service.getBoard(bno);	// 상세 보기 처리
		model.addAttribute("board", board);	// model-"board"
		return "boardView";
	}
	
	@RequestMapping(value="/inserBoard", method=RequestMethod.GET)
	public String insertBoard() {	// 글쓰기 폼 페이지 요청
		return "insertBoard";
	}
	
	@RequestMapping(value="/insertBoard", method=RequestMethod.POST)
	public String insertBoard(BoardVO vo) {	// 글쓰기 처리
		//	 command 객체 - BoardVO -> HttpServletRequest request 대체함
		service.insert(vo);
		return "redirect:boardList";
	}
	
	@GetMapping("/deleteBoard")
	public String deleteBoard(BoardVO vo) {	// 글 삭제 요청
		service.delete(vo);
		return "redirect:boardList";
	}
	
	@PostMapping("/updateBoard")
	public String updateBoard(BoardVO vo) {	// 글 수정 요청
		service.update(vo);
		return "redirect:boardList";
	}
}
