package com.spring.biz.user.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.spring.biz.user.UserVO;

@Repository("userDAOSpring")
public class UserDAOSpring {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//SQL문
	private final String USER_GET
		= "SELECT * FROM USERS WHERE ID = ? AND PASSWORD = ?";
	private final String USER_INSERT
		= "INSERT INTO USERS VALUES(?, ?, ?, ?)";
	private final String USER_UPDATE
		= "UPDATE USERS SET PASSWORD = ? WHERE ID = ?";
	private final String USER_DELETE
		= "DELETE FROM USERS WHERE ID = ?";
	private final String USER_LIST
		= "SELECT * FROM USERS";
	

	//user 하나 불러오기
	public UserVO getUser(UserVO vo) {
		Object[] args = {vo.getId(), vo.getPassword()};
		return jdbcTemplate.queryForObject(USER_GET, args, new UserRowMapper());		
	}
	
	//user 전체 불러오기
	public List<UserVO> getList() {
		return jdbcTemplate.query(USER_LIST, new UserRowMapper());		
	}
	
	//user 삽입
	void insertUser(UserVO vo) {
		Object[] args = {vo.getId(), vo.getPassword(), vo.getName(), vo.getRole()};
		jdbcTemplate.update(USER_INSERT, args);
	}
	
	//user 수정
	void updateUser(UserVO vo) {
		jdbcTemplate.update(USER_UPDATE, vo.getPassword(), vo.getId());
	}
	
	//user 삭제
	void deleteUser(UserVO vo) {
		jdbcTemplate.update(USER_DELETE, vo.getId());
	}

}
