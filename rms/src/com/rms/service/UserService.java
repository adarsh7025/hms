package com.rms.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rms.contract.IUserDAO;
import com.rms.dao.UserDAO;
import com.rms.entity.User;
import com.rms.formentity.UserForm;

/**
 * 
 * @author hegde_a
 *
 */
public class UserService {

	final Logger logger = LoggerFactory.getLogger(UserService.class);

	public UserForm authenticateUser(UserForm user) {

		logger.info("Authenticating the user using service");
		String userName = user.getUserId();
		String password = user.getPassword();

		User user2 = new User();
		user2.setUserId(userName);
		user2.setPassword(password);

		IUserDAO userDAO = new UserDAO();
		User user3 = userDAO.authenticateUser(user2);
		UserForm userForm = new UserForm(user3.getId(), user3.getUserId(), user3.getPassword(), user3.getName(),
				user3.getType(), user3.getLocationId(), user3.getParent(), user3.getPhoneNo());
		return userForm;

	}
}
