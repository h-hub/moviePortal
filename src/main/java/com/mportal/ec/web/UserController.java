package com.mportal.ec.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mportal.ec.model.User;
import com.mportal.ec.model.UserDto;
import com.mportal.ec.services.UserService;

@RestController
@RequestMapping(path="/users")
public class UserController {
	
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(method= RequestMethod.POST, path="/create" )
	@ResponseStatus(HttpStatus.CREATED)
	public void createUser(@RequestBody @Validated UserDto userDto ){
		
		userService.createUser(userDto.getUsername(), userDto.getEmail(), userDto.getPassword());
		
//		return null;
	}
}
