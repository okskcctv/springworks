package com.spring.user;

public class UserServiceImpl implements UserService{

	private UserDAO userDAO;
	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	@Override
	public boolean login(UserVO vo) {
		return userDAO.login(vo);
	}

}
