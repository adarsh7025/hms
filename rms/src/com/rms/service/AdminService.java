package com.rms.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rms.contract.IDishDAO;
import com.rms.contract.IUserDAO;
import com.rms.dao.UserDAO;
import com.rms.entity.User;
import com.rms.formentity.UserForm;


public class AdminService {

	private final Logger logger = LoggerFactory.getLogger(UserDAO.class);

	public boolean addUser(UserForm user2) {
		
		logger.info("Add User");
		
		User user = new User();
		user.setId(user2.getId());
		user.setPassword(user2.getPassword());
		user.setUserId(user2.getUserId());
		user.setName(user2.getName());
		user.setParent(user2.getParent());
		user.setPhoneNo(user2.getPhoneNo());
		
		IUserDAO userDAO = new UserDAO();
		boolean user3 = userDAO.addUser(user);
		
		return user3;
		
	}
}