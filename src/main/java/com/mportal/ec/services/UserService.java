package com.mportal.ec.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mportal.ec.model.User;
import com.mportal.ec.repo.UserRepository;

@Service
public class UserService {
	
	private UserRepository userRepository;
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	public UserService(UserRepository userRepository){
		this.userRepository = userRepository;
	}
	
	public User createUser(String username, String email,String password){
		
		User user = new User(username, email, encoder.encode(password));
		
		return userRepository.save(user);
	}
	
	public Optional<User> getByUsername(String username){
		return userRepository.findByusername(username);
	}
}
