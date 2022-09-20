package com.cloud.service;

import java.util.List;

import com.cloud.domain.ReplyVO;

public interface ReplyService {
	
	public int register(ReplyVO vo);	// 댓글 추가
	
	public List<ReplyVO> getReplyList(int bno);	// 댓글 목록 조회
	
	public ReplyVO getReply(int rno);	// 댓글 1개 조회
	
	public void delete(ReplyVO vo);	// 댓글 삭제
	
	public void update(ReplyVO vo);	// 댓글 수정
	
}
