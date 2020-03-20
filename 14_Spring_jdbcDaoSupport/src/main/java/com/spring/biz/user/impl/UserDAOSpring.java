package com.spring.biz.user.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.spring.biz.user.UserVO;

@Repository("UserDAOSpring")
public class UserDAOSpring extends JdbcDaoSupport {
	
	//SQL문
	private final String USER_GET
		= "SELECT * FROM USERS WHERE ID = ?";
	private final String USER_INSERT
		= "INSERT INTO USERS VALUES(?, ?, ?, ?)";
	private final String USER_UPDATE
		= "UPDATE USERS SET PASSWORD = ?, NAME = ?, ROLE = ? WHERE ID = ?";
	private final String USER_DELETE
		= "DELETE FROM USERS WHERE ID = ?";
	private final String USER_LIST
		= "SELECT * FROM USERS";
	
	
	@Autowired
	public void setSuperDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}
	
	//user 하나 불러오기
	public UserVO getUser(UserVO vo) {
		Object[] args = {vo.getId()};
		return getJdbcTemplate().queryForObject(USER_GET, args, new UserRowMapper());		
	}
	
	//user 전체 불러오기
	public List<UserVO> getList() {
		return getJdbcTemplate().query(USER_LIST, new UserRowMapper());		
	}
	
	//user 삽입
	void insertUser(UserVO vo) {
		Object[] args = {vo.getId(), vo.getPassword(), vo.getName(), vo.getRole()};
		getJdbcTemplate().update(USER_INSERT, args);
	}
	
	//user 수정
	void updateUser(UserVO vo) {
		getJdbcTemplate().update(USER_UPDATE, vo.getPassword(), vo.getName(), vo.getRole(), vo.getId());
	}
	
	//user 삭제
	void deleteUser(UserVO vo) {
		getJdbcTemplate().update(USER_DELETE, vo.getId());
	}

}
