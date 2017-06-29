package com.mportal.ec.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mportal.ec.model.User;

@RestController
@RequestMapping(path="/users")
public class UserController {
	
	@RequestMapping(method= RequestMethod.GET, path="/create" )
	public User createUser(){
		
		
		
		return null;
	}
}
