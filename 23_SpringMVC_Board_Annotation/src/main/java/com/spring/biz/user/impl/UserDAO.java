package com.spring.biz.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.biz.common.JDBCUtil;
import com.spring.biz.user.UserVO;
@Repository("UserDAO")
public class UserDAO {
	//JDBC 관련 변수(필드)
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	public UserDAO() {
		System.out.println(">> UserDAO 객체 생성");
	}
		
	//SQL문
	private final String USER_GET
		= "SELECT * FROM USERS WHERE ID = ? AND PASSWORD = ?";
	private final String USER_INSERT
		= "INSERT INTO USERS VALUES(?, ?, ?, ?)";
	private final String USER_UPDATE
		= "UPDATE USERS SET PASSWORD = ?, NAME = ?, ROLE = ? WHERE ID = ?";
	private final String USER_DELETE
		= "DELETE FROM USERS WHERE ID = ?";
	private final String USER_LIST
		= "SELECT * FROM USERS";
	
	//user 상세조회
	public UserVO getUser(UserVO vo) {
		UserVO user = null;
		
		conn = JDBCUtil.getConnection();
		
		try {
			stmt = conn.prepareStatement(USER_GET);
			
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPassword());
			
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				user = new UserVO(rs.getString("ID"),
								  rs.getString("PASSWORD"),
								  rs.getString("NAME"),
								  rs.getString("ROLE"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt, rs);
		}
		
		return user;
	}
	
	
	//user 삽입
	public void insertUser(UserVO vo) {
		conn = JDBCUtil.getConnection();
		
		try {
			stmt = conn.prepareStatement(USER_INSERT);
			
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPassword());
			stmt.setString(3, vo.getName());
			stmt.setString(4, vo.getRole());
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt);
		}
		
	}
	
	
	//user 수정
	public void updateUser(UserVO vo) {
		conn = JDBCUtil.getConnection();
		
		try {
			stmt = conn.prepareStatement(USER_UPDATE);
			
			stmt.setString(1, vo.getPassword());
			stmt.setString(2, vo.getName());
			stmt.setString(3, vo.getRole());
			stmt.setString(4, vo.getId());
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt);
		}
	}
	
	
	//user 삭제
	public void deleteUser(UserVO vo) {
		conn = JDBCUtil.getConnection();
		
		try {
			stmt = conn.prepareStatement(USER_DELETE);
			
			stmt.setString(1, vo.getId());
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt);
		}		
	}
	
	
	//전체 목록 가져오기
	public List<UserVO> getList() {
		List<UserVO> userList = new ArrayList<>();
		
		conn = JDBCUtil.getConnection();		
		try {
			stmt = conn.prepareStatement(USER_LIST);
			
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				userList.add(new UserVO(rs.getString("ID"), rs.getString("PASSWORD"), rs.getString("NAME"), rs.getString("ROLE")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt, rs);
		}
		
		return userList;
	}
}
