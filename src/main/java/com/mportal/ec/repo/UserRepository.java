package com.mportal.ec.repo;

import org.springframework.data.repository.CrudRepository;

import com.mportal.ec.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
