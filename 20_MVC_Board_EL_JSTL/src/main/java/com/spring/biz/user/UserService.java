package com.spring.biz.user;

import java.util.List;

public interface UserService {
//	public abstract UserVO getUser(UserVO vo);
	
	UserVO getUser(UserVO vo);
	List<UserVO> getList();
	void insertUser(UserVO vo);
	void updateUser(UserVO vo);
	void deleteUser(UserVO vo);

}
