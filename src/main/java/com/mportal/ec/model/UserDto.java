package com.mportal.ec.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.ScriptAssert;

@ScriptAssert(lang = "javascript", script = "_this.password===_this.passwordRepeat")
public class UserDto {
	
	@Min(6)
	private String username;
	
	@NotNull
	private String email;
	
	@NotNull
	private String emailRepeat;
	
	@NotNull
	private String password;
	
	@NotNull
	private String passwordRepeat;
}
