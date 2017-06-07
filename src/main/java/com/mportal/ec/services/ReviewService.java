package com.mportal.ec.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mportal.ec.model.Movie;
import com.mportal.ec.model.Review;
import com.mportal.ec.model.User;
import com.mportal.ec.repo.MovieRepository;
import com.mportal.ec.repo.ReviewRepository;
import com.mportal.ec.repo.UserRepository;

@Service
public class ReviewService {
	private ReviewRepository reviewRepository;
	private MovieRepository movieRepository;
	private UserRepository userRepository;
	
	@Autowired
	public ReviewService(ReviewRepository reviewRepository,MovieRepository movieRepository) {
		this.reviewRepository = reviewRepository;
		this.reviewRepository = reviewRepository;
	}
	
	public Review createReview(Integer movieId,Integer userId, String review, String vote){
		User user = userRepository.findOne(userId);
		Movie moview = movieRepository.findOne(movieId);
		if(user == null){
			throw new RuntimeException("User doen not exists :"+userId);
		}
		if(moview == null){
			throw new RuntimeException("Movie doen not exists :"+movieId);
		}
		
		return reviewRepository.save( new Review(movieId,userId,review,vote));
	}
}
