package com.mportal.ec.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mportal.ec.exception.ExceptionFactory;
import com.mportal.ec.exception.ExceptionType;
import com.mportal.ec.model.Role;
import com.mportal.ec.model.Roles;
import com.mportal.ec.model.User;
import com.mportal.ec.repo.RoleRepository;
import com.mportal.ec.repo.UserRepository;

@Service
public class UserService {
	
	private UserRepository userRepository;
	private RoleRepository roleRepository;
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	public UserService(UserRepository userRepository,BCryptPasswordEncoder encoder,RoleRepository roleRepository){
		this.userRepository = userRepository;
		this.encoder = encoder;
		this.roleRepository = roleRepository;
	}
	
	public User createUser(String username, String email,String password,Integer roleId){
		
		Optional<User> user = userRepository.findByusername(username);
		
		if(user.isPresent()){
			throw ExceptionFactory.create(ExceptionType.ENTITY_EXISTS, "Entity found in database.");
		}
		
		User newUser = new User(username, email, encoder.encode(password));
		
		Role userRole= roleRepository.findByid(roleId);
		
		Set<Role> roles = new HashSet<Role>();
		roles.add(userRole);
		
		newUser.setRoles(roles);
		
		return userRepository.save(newUser);
		
		
	}
	
	public Optional<User> getByUsername(String username){
		return userRepository.findByusername(username);
	}

	public User getUser(String username) {
		
		Optional<User> user = userRepository.findByusername(username);
		
		if(!user.isPresent()){
			throw ExceptionFactory.create(ExceptionType.ENTITY_EXISTS, "Entity not found in database.");
		}
		return user.get();
	}

	public boolean deletetUser(String username) {
		Optional<User> user = userRepository.findByusername(username);
		
		if(!user.isPresent()){
			throw ExceptionFactory.create(ExceptionType.ENTITY_EXISTS, "Entity not found in database.");
		}
		return userRepository.deleteByusername(username);
	}
}
