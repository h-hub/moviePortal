package com.mportal.ec.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mportal.ec.model.User;
import com.mportal.ec.model.UserRole;
import com.mportal.ec.repo.UserRepository;

@Service
public class UserService {
	private UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository){
		this.userRepository = userRepository;
	}
	
	public User createUser(String firstName,String lastName, String username, List<UserRole> roles, String email,String password){
		return userRepository.save(new User(firstName, lastName, username, roles, email, password));
	}
	
	public Optional<User> getByUsername(String username){
		return userRepository.findByusername(username);
	}
}
