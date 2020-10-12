package com.app.service;


import com.app.model.User;

public interface IUserService {
	
	public Boolean saveUser(User user);
	public Boolean findByEmail(String email);
	public Boolean updateUser(User user);
	

}
