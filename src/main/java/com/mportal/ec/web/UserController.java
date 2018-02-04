package com.mportal.ec.web;

import java.util.Optional;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mportal.ec.model.User;
import com.mportal.ec.model.UserDto;
import com.mportal.ec.services.UserService;

@RestController
@RequestMapping(path="/users")
public class UserController {
	
	private UserService userService;
	
	private ModelMapper modelmapper;
	
	@Autowired
	public UserController(UserService userService,ModelMapper modelmapper) {
		this.userService = userService;
		this.modelmapper = modelmapper;
	}

	@RequestMapping(method= RequestMethod.POST, path="/create" )
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public User createUser( @RequestBody @Validated UserDto userDto){
		return userService.createUser(userDto.getUsername(), userDto.getEmail(), userDto.getPassword(),userDto.getRoleIds());
	}
	
	@RequestMapping(method= RequestMethod.GET, path="/get/{username}" )
	@ResponseStatus(HttpStatus.FOUND)
	@ResponseBody
	public User getUserByUsername( @PathVariable("username") String username){
		return userService.getByUsername(username).get();
	}
	
	
}
