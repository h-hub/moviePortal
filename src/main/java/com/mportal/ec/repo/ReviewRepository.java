package com.mportal.ec.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.mportal.ec.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

}
