package com.mportal.ec.services;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mportal.ec.exception.ExceptionFactory;
import com.mportal.ec.exception.ExceptionType;
import com.mportal.ec.model.Role;
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
	
	public User create(String username, String email,String password,Integer[] roleIds) throws Exception {
		
		Optional<User> user = userRepository.findByusername(username);
		
		if(user.isPresent()){
			throw ExceptionFactory.create(ExceptionType.ENTITY_EXISTS, "Entity found in database.");
		}
		
		User newUser = new User(username, email, encoder.encode(password));
		
		List<Role> userRole= roleRepository.findAll();
		
		Set<Role> roles = new HashSet<Role>(userRole);
		
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

	public User update(Integer userId, String username, String email, String password, Integer[] roleIds) {
		
		Optional<User> user = userRepository.findByusername(username);
		
		if(!user.isPresent()){
			throw ExceptionFactory.create(ExceptionType.ENTITY_EXISTS, "Entity not found in database.");
		}

		User newUser = new User(username, email, encoder.encode(password));
		
		List<Role> userRole= roleRepository.findAll(Arrays.asList(roleIds));
		
		Set<Role> roles = new HashSet<Role>(userRole);
		
		newUser.setRoles(roles);
		
		return userRepository.save(newUser);
	}
}
