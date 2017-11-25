package com.mportal.ec.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.ScriptAssert;

@ScriptAssert(lang = "javascript", script = "_this.password===_this.passwordRepeat && _this.email===_this.emailRepeat")
public class UserDto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Length(min=6)
	@NotNull
	private String username;
	
	@NotNull
	@Email
	private String email;
	
	@NotNull
	private String emailRepeat;
	
	@Length(min=8)
	@NotNull
	private String password;
	
	@Length(min=8)
	@NotNull
	private String passwordRepeat;
	
	@NotNull
	private Integer roleId;
	
	public UserDto() {
    }

	public UserDto(String username, String email, String emailRepeat, String password, String passwordRepeat,Integer roleId) {
		this.username = username;
		this.email = email;
		this.emailRepeat = emailRepeat;
		this.password = password;
		this.passwordRepeat = passwordRepeat;
		this.roleId = roleId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmailRepeat() {
		return emailRepeat;
	}

	public void setEmailRepeat(String emailRepeat) {
		this.emailRepeat = emailRepeat;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordRepeat() {
		return passwordRepeat;
	}

	public void setPasswordRepeat(String passwordRepeat) {
		this.passwordRepeat = passwordRepeat;
	}
	
	public Integer getRoleId() {
		return roleId;
	}
	
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	
	@Override
	public String toString() {
		return "UserDto [username=" + username + ", email=" + email + ", emailRepeat=" + emailRepeat + ", password="
				+ password + ", passwordRepeat=" + passwordRepeat + "]";
	}
}
