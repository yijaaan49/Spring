package com.spring.biz.board.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.biz.board.BoardVO;

@Repository("BoardDAOMyBatis")
public class BoardDAOMyBatis {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public BoardDAOMyBatis() {
		System.out.println(">> BoardDAOMyBatis 객체 생성");
	}
	
	//글 삽입
	public void insertBoard(BoardVO vo) {
		System.out.println("===> MyBatis로 insertBoard() 실행");
		mybatis.insert("BoardDAO.insertBoard", vo);
	}
	
	//글 수정
	public void updateBoard(BoardVO vo) {
		System.out.println("===> MyBatis로 updateBoard() 실행");
		mybatis.update("BoardDAO.updateBoard", vo);
	}
	
	//글 삭제
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> MyBatis로 deleteBoard() 실행");
		mybatis.delete("BoardDAO.deleteBoard", vo);
	}
	
	//글 하나 조회
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> MyBatis로 getBoard() 실행");
		return mybatis.selectOne("BoardDAO.getBoard", vo);
	}
	
	//전체 데이터 조회
	public List<BoardVO> getBoardList() {
		System.out.println("===> MyBatis로 getBoardList() 실행");
		return mybatis.selectList("BoardDAO.getBoardList");
	}
	
	//검색조건 적용해서 조회
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> MyBatis로 getBoardList() 실행");
		return mybatis.selectList("BoardDAO.getBoardList", vo);
	}
}
