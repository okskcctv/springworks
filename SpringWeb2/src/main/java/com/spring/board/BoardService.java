package com.spring.board;

import java.util.List;

public interface BoardService {
	
	// �� ���
	void insertBoard(BoardVO vo);
	
	// �� ��� ��ȸ
	List<BoardVO> getBoardList();
}
