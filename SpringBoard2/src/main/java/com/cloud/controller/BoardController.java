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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.cloud.domain.BoardVO;
import com.cloud.service.BoardService;

@RequestMapping("/board/*")  //localhost:8080/board/aaa
@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;

	//��� ����
	@GetMapping("/boardList")//localhost:8080/board/boardList
	public String getBoardList(Model model) {
		List<BoardVO> boardList = service.getBoardList();
		model.addAttribute("boardList", boardList); //view�� ����
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
	
	//�� �󼼺��� ó��
	@GetMapping("/boardView")
	public String getBoard(int bno, Model model) {
		service.updateCount(bno);   //��ȸ�� ����
		BoardVO board = service.getBoard(bno); //�� ���� ó��
		model.addAttribute("board", board);  //model="board" ������
		return "/board/boardView";
	}
	
	//�� ����
	@GetMapping("/deleteBoard")
	public String delete(BoardVO vo) {
		service.delete(vo);
		return "redirect:/board/boardList";
	}
	
	//�� ����
	@PostMapping("/updateBoard")
	public String update(BoardVO vo) {
		service.update(vo);
		return "redirect:/board/boardList";
	}
	
}
