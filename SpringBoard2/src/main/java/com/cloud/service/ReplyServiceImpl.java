package com.cloud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloud.domain.ReplyVO;
import com.cloud.mapper.BoardMapper;
import com.cloud.mapper.ReplyMapper;

@Service
public class ReplyServiceImpl implements ReplyService{
	
	@Autowired
	private ReplyMapper mapper;
	
	@Autowired
	private BoardMapper boardMapper;
	
	// 댓글 등록
	@Transactional	// boardMapper와 연동함
	@Override
	public int register(ReplyVO vo) {
		// 댓글 개수
		boardMapper.updateReplyCnt(vo.getBno(), 1);	// 1 - amount(개수)
		return mapper.register(vo);
	}
	
	// 댓글 목록
	@Override
	public List<ReplyVO> getReplyList(int bno){
		return mapper.getReplyList(bno);
	}
	
	// 특정 댓글 조회
	@Override
	public ReplyVO getReply(int rno) {
		return mapper.getReply(rno);
	}
	
	// 댓글 삭제
	@Override
	public void delete(ReplyVO vo) {
		mapper.delete(vo);
	}
	
	// 댓글 수정
	@Override
	public void update(ReplyVO vo) {
		mapper.update(vo);
	}
	
}
