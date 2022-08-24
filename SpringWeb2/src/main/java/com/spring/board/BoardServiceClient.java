package com.spring.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {

	public static void main(String[] args) {
		// 1. spring �����̳� ����
		AbstractApplicationContext container = 
				new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2. BoardServiceImpl ��ü�� Lookup
		BoardService boardService = (BoardService) container.getBean("boardService");
		
		// 3. �� ��� ��� �׽�Ʈ
		BoardVO vo = new BoardVO();
		vo.setTitle("�ȳ��ϼ���");
		vo.setWriter("���̵̹��");
		vo.setContent("���� ��õ���� �����߽��ϴ�.");
		boardService.insertBoard(vo);
		
		// 4. �� ��� �˻� ��� �׽�Ʈ
		List<BoardVO> boardList = boardService.getBoardList();
		for(BoardVO board : boardList) {
			System.out.println("---> " + board.toString());
		}
		
		// 5. spring �����̳� ����
		container.close();
	}

}
