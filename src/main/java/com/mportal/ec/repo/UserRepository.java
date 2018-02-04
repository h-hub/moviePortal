package com.mportal.ec.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mportal.ec.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findByusername(String username);
	Boolean deleteByusername(String username);
}
