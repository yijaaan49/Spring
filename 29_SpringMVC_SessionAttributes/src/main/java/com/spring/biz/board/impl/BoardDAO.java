package com.spring.biz.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.biz.board.BoardVO;
import com.spring.biz.common.JDBCUtil;

//@Repository : @Component 상속 받아 기능 확장된 어노테이션
// DB 연동 작업 처리하는 클래스에 설정(xxxDAO, xxxDao)
@Repository("boardDAO")
public class BoardDAO {
	//JDBC 관련 변수(필드)
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	//SQL문
	private final String BOARD_INSERT
		= "INSERT INTO BOARD (SEQ, TITLE, WRITER, CONTENT)"
		+ "VALUES ((SELECT NVL(MAX(SEQ), 0) + 1 FROM BOARD), ?, ?, ?)";
	private final String BOARD_UPDATE
		= "UPDATE BOARD SET TITLE = ?, WRITER = ?, CONTENT = ? WHERE SEQ = ?";
	private final String BOARD_DELETE
		= "DELETE FROM BOARD WHERE SEQ = ?";
	private final String BOARD_GET
		= "SELECT * FROM BOARD WHERE SEQ = ?";
	private final String BOARD_LIST
		= "SELECT * FROM BOARD ORDER BY SEQ DESC";
	//TITLE 값으로 조회
	private final String BOARD_LIST_T
		= "SELECT * FROM BOARD "
		+ " WHERE TITLE LIKE '%'|| ? ||'%' "
		+ " ORDER BY SEQ DESC";
	//CONTENT 값으로 조회
	private final String BOARD_LIST_C
		= "SELECT * FROM BOARD"
		+ " WHERE CONTENT LIKE '%'|| ? ||'%' "
		+ " ORDER BY SEQ DESC";
	
	public BoardDAO() {
		System.out.println(">> BoardDAO 객체 생성");
	}
	
	//글 입력(INSERT)
	public void insertBoard(BoardVO vo) {
		System.out.println("===> JDBC로 insertBoard() 실행");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_INSERT);
			
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getWriter());
			stmt.setString(3, vo.getContent());
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			JDBCUtil.close(conn, stmt);
		}
	}
	
	//글수정(UPDATE)
	public void updateBoard(BoardVO vo) {
		System.out.println("===> JDBC로 updateBoard() 실행");
		conn = JDBCUtil.getConnection();
		try {
			stmt = conn.prepareStatement(BOARD_UPDATE);
			
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getWriter());
			stmt.setString(3, vo.getContent());
			stmt.setInt(4, vo.getSeq());
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt);
		}
	}
	
	//글삭제(DELETE)
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> JDBC로 deleteBoard() 실행");
		conn = JDBCUtil.getConnection();
		try {
			stmt = conn.prepareStatement(BOARD_DELETE);
			
			stmt.setInt(1, vo.getSeq());
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt);
		}

	}
	
	//글 상세 조회(데이터 하나 조회)
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> JDBC로 getBoard() 실행");
		BoardVO board = null;
		conn = JDBCUtil.getConnection();
		
		try {
			stmt = conn.prepareStatement(BOARD_GET);
			
			stmt.setInt(1, vo.getSeq());
			
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				board = new BoardVO(rs.getInt("SEQ"),
									rs.getString("TITLE"),
									rs.getString("WRITER"),
									rs.getString("CONTENT"),
									rs.getDate("REGDATE"),
									rs.getInt("CNT")
									);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt, rs);
		}
		return board;
	}
	
	//글 전체 조회
	public List<BoardVO> getBoardList() {
		System.out.println("===> JDBC로 getBoardList() 실행");
		List<BoardVO> boardList = new ArrayList<>(); //ArrayList 객체로 생성 사용
		conn = JDBCUtil.getConnection();
		
		try {
			stmt = conn.prepareStatement(BOARD_LIST);
			
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				boardList.add(new BoardVO(rs.getInt("SEQ"), 
										  rs.getString("TITLE"),
										  rs.getString("WRITER"),
										  rs.getString("CONTENT"),
										  rs.getDate("REGDATE"),
										  rs.getInt("CNT")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt, rs);
		}
		
		return boardList;
	}

	public List<BoardVO> getBoardList(String condition, String keyword) {
		System.out.println("===> JDBC로 getBoardList() 실행");
		String sql = "";
		if(condition.equals("TITLE")) {
			sql = BOARD_LIST_T;
		} else {
			sql = BOARD_LIST_C;
		}
		
		List<BoardVO> boardList = new ArrayList<>();
		conn = JDBCUtil.getConnection();
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, keyword);			
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				boardList.add(new BoardVO(rs.getInt("SEQ"), 
										  rs.getString("TITLE"),
										  rs.getString("WRITER"),
										  rs.getString("CONTENT"),
										  rs.getDate("REGDATE"),
										  rs.getInt("CNT")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt, rs);
		}
		
		return boardList;
	}
}









