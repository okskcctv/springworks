package com.cloud.service;

import java.util.List;

import com.cloud.domain.BoardVO;
import com.cloud.domain.Criteria;

public interface BoardService {
	
	// public List<BoardVO> getBoardList();	// 글 목록
	
	public void insert(BoardVO vo);	// 글 쓰기
	
	public List<BoardVO> getListWithPage(Criteria cri);	// 목록 페이지 처리
	
	public int getTotalCount(Criteria cri);	// 게시글 총 개수
	
	public BoardVO getBoard(int bno);	// 글 상세보기
	
	public void delete(BoardVO vo);	// 글 삭제
	
	public void update(BoardVO vo);	// 글 수정
	
	public void updateCount(int bno);	// 조회수
}
