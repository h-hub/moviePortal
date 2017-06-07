package com.mportal.ec.services;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mportal.ec.model.Movie;
import com.mportal.ec.model.User;
import com.mportal.ec.repo.MovieRepository;
import com.mportal.ec.repo.UserRepository;

@Service
public class MovieService {
	private MovieRepository movieRepository;
	private UserRepository userRepository;

	@Autowired
	public MovieService(MovieRepository movieRepository,UserRepository userRepository) {
		this.movieRepository = movieRepository;
		this.userRepository = userRepository;
	}
	
	public Movie createMovie(String name, Date year, String director,String genre, 
			String description, String wallpaper,Integer author){
		User user = userRepository.findOne(author);
		if(user == null){
			throw new RuntimeException("User doen not exists :"+author);
		}
		
		return movieRepository.save( new Movie(name,year,director,genre,description,wallpaper,author));
	}
	
	public Iterable<Movie> lookUp(){
		return movieRepository.findAll();
	}
}
