package com.prjnet.mapper;

import java.util.List;
import java.util.Map;

import com.prjnet.domain.BoardVO;

public interface BoardMapper {
	
	// 글 쓰기
	public void insertBoard(BoardVO board);
	
	// 글 수정
	public void updateBoard(BoardVO board);
	
	// 글 삭제
	public void deleteBoard(BoardVO board);
	
	// 글 목록
	public List<BoardVO> getBoardList();
	
	// 글 상세보기
	public BoardVO getBoard(int bno);
	
	// 검색 테스트
	List<BoardVO> searchTest(Map<String, Map<String, String>> map);
	
}
