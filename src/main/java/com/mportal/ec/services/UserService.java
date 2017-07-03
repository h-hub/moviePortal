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
	public UserService(UserRepository userRepository,BCryptPasswordEncoder encoder){
		this.userRepository = userRepository;
		this.encoder = encoder;
	}
	
	public void createUser(String username, String email,String password){
		
		userRepository.save(new User(username, email, encoder.encode(password)));
		//return null;
	}
	
	public Optional<User> getByUsername(String username){
		return userRepository.findByusername(username);
	}
}
