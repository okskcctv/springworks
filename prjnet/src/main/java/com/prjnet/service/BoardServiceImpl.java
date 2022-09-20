package com.prjnet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prjnet.domain.BoardVO;
import com.prjnet.domain.Criteria;
import com.prjnet.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardMapper mapper;
	
	@Override
	public void insert(BoardVO vo) {
		mapper.insertBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList(Criteria cri) {
		return mapper.getBoardList(cri);
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

}
