package com.mportal.ec.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.mportal.ec.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
