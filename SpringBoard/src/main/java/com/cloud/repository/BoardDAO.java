package com.cloud.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.common.JDBCUtil;

public class BoardDAO {
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	// SQL 쿼리 상수 선언
	private final String BOARD_INSERT =
			"INSERT INTO board(bno, title, writer, content) VALUES "
			+ "(seq.NEXTVAL, ?, ?, ?)";
	private final String BOARD_LIST = 
			"SELECT * FROM board ORDER BY bno DESC";
	private final String BOARD_ONE =
			"SELECT * FROM board WHERE bno = ?";
	private final String BOARD_UPDATE =
			"UPDATE board SET title = ?, content = ? WHERE bno = ?";
	private final String BOARD_DELETE =
			"DELETE FROM board WHERE bno = ?";
	
	// 글 등록
	public void insertBoard(BoardVO vo) {
		System.out.println("==> insertBoard() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_INSERT);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getContent());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, pstmt);
		}
	}
	
	// 글 목록
	public List<BoardVO> getBoardList(){
		System.out.println("==> getBoardList() 기능 처리");
		List<BoardVO> boardList = new ArrayList<>();
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_LIST);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setBno(rs.getInt("bno"));
				vo.setTitle(rs.getString("title"));
				vo.setWriter(rs.getString("writer"));
				vo.setContent(rs.getString("content"));
				vo.setRegDate(rs.getDate("regdate"));
				vo.setCnt(rs.getInt("cnt"));
				
				boardList.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		return boardList;
	}
	
	// 글 상세 보기
	public BoardVO getBoard(int bno) {
		System.out.println("==> getBoard()");
		BoardVO board = new BoardVO();
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_ONE);
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				board.setBno(rs.getInt("bno"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setRegDate(rs.getDate("regdate"));
				board.setCnt(rs.getInt("cnt"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		return board;
	}
	
	// 글 수정하기
	public void updateBoard(BoardVO vo) {
		System.out.println("==> updateBoard()");
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_UPDATE);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getBno());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, pstmt);
		}
	}
	
	// 글 삭제
	public void deleteBoard(BoardVO vo) {
		System.out.println("==> deleteBoard()");
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_DELETE);
			pstmt.setInt(1, vo.getBno());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, pstmt);
		}
	}
	
	// 조회수
	public void updateCount(int bno) {
		try {
			conn = JDBCUtil.getConnection();
			String sql = "SELECT cnt FROM board WHERE bno=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();
			int cnt = 0;
			if(rs.next()) {
				cnt = rs.getInt("cnt") + 1;
			}
			
			// 조회수 update 쿼리
			sql = "UPDATE board SET cnt = ? WHERE bno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cnt);
			pstmt.setInt(2, bno);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
	}
}
