package com.spring.board;

import java.util.List;

public interface BoardService {
	
	// 글 등록
	void insertBoard(BoardVO vo);
	
	// 글 목록 조회
	List<BoardVO> getBoardList();
}
