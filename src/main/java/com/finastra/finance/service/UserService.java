package com.finastra.finance.service;

import com.finastra.finance.model.User;

public interface UserService 
{
	public User findUserByEmail(String email);
	public void saveUser(User user);
}