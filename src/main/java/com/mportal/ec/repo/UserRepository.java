package com.mportal.ec.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mportal.ec.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByusername(String username);
}
