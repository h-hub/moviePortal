package com.mportal.services;

import com.mportal.ec.model.User;
import com.mportal.ec.repo.UserRepository;

public class UserService {
	private UserRepository userRepository;
	
	public UserService(UserRepository userRepository){
		this.userRepository = userRepository;
	}
	
	public User createUser(Integer id,String firstName,String lastName,String email,String password){
		return userRepository.save(new User(id, firstName, lastName, email, password));
	}  
}
