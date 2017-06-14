package com.mportal.ec.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mportal.ec.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findByusername(String username);
}
