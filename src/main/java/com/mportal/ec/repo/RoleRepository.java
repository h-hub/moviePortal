package com.mportal.ec.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mportal.ec.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
	
	Role findByid(Integer id);
	
}
