package com.mportal.ec.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mportal.ec.model.Review;

@RepositoryRestResource(exported = false)
public interface ReviewRepository extends JpaRepository<Review, Integer> {

}
