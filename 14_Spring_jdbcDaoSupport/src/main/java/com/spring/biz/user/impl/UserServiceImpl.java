package com.spring.biz.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.biz.user.UserService;
import com.spring.biz.user.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
//	private UserDAO UserDAO;
	private UserDAOSpring UserDAO;
	
//	public UserServiceImpl() {
//		this.UserDAO = new UserDAO();
//	}	---> 스프링 프레임워크를 사용하지 않았을 때 썼던 방법!!
	
	public UserServiceImpl() {
		System.out.println(">> UserServiceImpl() 실행");
	}

	@Override
	public UserVO getUser(UserVO vo) {
		return UserDAO.getUser(vo);
	}
	
	@Override
	public List<UserVO> getList() {
		return UserDAO.getList();
	}

	@Override
	public void insertUser(UserVO vo) {
		UserDAO.insertUser(vo);
	}

	@Override
	public void updateUser(UserVO vo) {
		UserDAO.updateUser(vo);
	}

	@Override
	public void deleteUser(UserVO vo) {
		UserDAO.deleteUser(vo);
	}

}
