package com.mportal.ec.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mportal.ec.exception.ExceptionFactory;
import com.mportal.ec.exception.ExceptionType;
import com.mportal.ec.model.Role;
import com.mportal.ec.model.User;
import com.mportal.ec.model.UserRole;
import com.mportal.ec.repo.UserRepository;

@Service
public class UserService {
	
	private UserRepository userRepository;
	private BCryptPasswordEncoder encoder;
	private Logger LOG;
	
	@Autowired
	public UserService(UserRepository userRepository,BCryptPasswordEncoder encoder){
		this.userRepository = userRepository;
		this.encoder = encoder;
	}
	
	public User createUser(String username, String email,String password){
		
		
		
		Optional<User> user = userRepository.findByusername(username);
		
		if(user.isPresent()){
			throw ExceptionFactory.create(ExceptionType.ENTITY_EXISTS, "Entity found in database.");
		}
		
		User tmpUser = new User(username, email, encoder.encode(password));
		
		UserRole userRole= new UserRole(tmpUser,Role.ADMIN);
		
		List<UserRole> roles = new ArrayList<UserRole>();
		roles.add(userRole);
		
		tmpUser.setRoles(roles);
		
		return userRepository.save(tmpUser);
		
		
	}
	
	public Optional<User> getByUsername(String username){
		return userRepository.findByusername(username);
	}
}
