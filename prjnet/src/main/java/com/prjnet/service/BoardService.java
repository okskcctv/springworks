package com.prjnet.service;

import java.util.List;

import com.prjnet.domain.BoardVO;
import com.prjnet.domain.Criteria;

public interface BoardService {
	
	public void insert(BoardVO vo);	// 글 쓰기
	
	public List<BoardVO> getBoardList(Criteria cri);	// 목록 페이지
	
	public BoardVO getBoard(int bno);	// 글 상세보기
	
	public void delete(BoardVO vo);	// 글 삭제
	
	public void update(BoardVO vo);	// 글 수정
}
