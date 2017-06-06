package com.mportal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mportal.ec.model.User;
import com.mportal.ec.repo.UserRepository;

@Service
public class UserService {
	private UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository){
		this.userRepository = userRepository;
	}
	
	public User createUser(String firstName,String lastName,String email,String password){
		return userRepository.save(new User(firstName, lastName, email, password));
	}
	
//	public User grtUser(String email){
//		return userRepository.save(new User(firstName, lastName, email, password));
//	}
}
