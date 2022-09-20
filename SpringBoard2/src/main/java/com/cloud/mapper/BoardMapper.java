package com.cloud.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.cloud.domain.BoardVO;
import com.cloud.domain.Criteria;

public interface BoardMapper {
	
	public void insertBoard(BoardVO vo);	// 글 쓰기
	
	public List<BoardVO> getBoardList();	// 글 목록
	
	public List<BoardVO> getListWithPage(Criteria cri);	// 목록 페이지 처리
	
	public int getTotalCount(Criteria cri);	// 게시글 총 개수
	
	public BoardVO getBoard(int bno);	// 글 상세보기
	
	public void deleteBoard(BoardVO vo);	// 글 삭제
	
	public void updateBoard(BoardVO vo);	// 글 수정
	
	public void updateCount(int bno);	// 조회수
	
	List<BoardVO> searchTest(Map<String, Map<String, String>> map);	// 검색
	
	// 댓글 개수 - MyBatis는 2개의 파라미터를 사용할 수 없음. @Param 사용
	public void updateReplyCnt(
			@Param("bno") int bno,
			@Param("amount") int amount
	);
	
}
