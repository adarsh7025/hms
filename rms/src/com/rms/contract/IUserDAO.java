package com.rms.contract;

import com.rms.entity.User;

public interface IUserDAO {

	public boolean addUser(User user);

	public User authenticateUser(User user);
}
