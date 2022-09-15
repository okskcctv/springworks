package com.cloud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.domain.BoardVO;
import com.cloud.domain.Criteria;
import com.cloud.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardMapper mapper;

	@Override
	public void insert(BoardVO vo) {
		mapper.insertBoard(vo);
	}

	@Override
	public BoardVO getBoard(int bno) {
		return mapper.getBoard(bno);
	}

	@Override
	public void delete(BoardVO vo) {
		mapper.deleteBoard(vo);
	}

	@Override
	public void update(BoardVO vo) {
		mapper.updateBoard(vo);
	}

	@Override
	public void updateCount(int bno) {
		mapper.updateCount(bno);
	}

	@Override
	public List<BoardVO> getListWithPage(Criteria cri) {	// 목록 보기(페이징)
		return mapper.getListWithPage(cri);
	}

	@Override
	public int getTotalCount(Criteria cri) {	// 총 게시글 수
		return mapper.getTotalCount(cri);
	}

}
