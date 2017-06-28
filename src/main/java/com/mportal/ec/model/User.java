package com.mportal.ec.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class User implements Serializable{
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String username;
	
	@OneToMany(fetch=FetchType.EAGER)
    @JoinColumn(name="APP_USER_ID", referencedColumnName="id")
    private List<UserRole> roles;
	
	@Column
	private String email;
	
	@Column
	private String password;
	
	protected User(){
		
	}
	
	public User(String username, String email, String password){
		this.username = username;
		this.email= email;
		this.password= password;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<UserRole> getRoles() {
		return roles;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
