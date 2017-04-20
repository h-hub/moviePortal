package com.mportal.ec.model;

import javax.persistence.*;

public class Review {
	
	@Column
	private Integer userId;
	
	@Column
	private Integer movieId;
	
	@Column( length = 2000 )
	private String review;
	
	@Column
	private String vote;
	
	@ManyToOne
	private Movie movie;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getMovieId() {
		return movieId;
	}

	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getVote() {
		return vote;
	}

	public void setVote(String vote) {
		this.vote = vote;
	}
	
}
