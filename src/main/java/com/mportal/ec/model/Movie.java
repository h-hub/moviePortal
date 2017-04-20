package com.mportal.ec.model;

import java.util.Collection;
import java.util.Date;

import javax.persistence.*;

@Entity
public class Movie {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column
	private String name;
	
	@Column
	private Date year;
	
	@Column
	private String director;
	
	@Column
	private String genre;
	
	@Column(length = 2000)
	private String description;
	
	@Column
	private String wallpaper;
	
	@OneToMany
	private Collection<Review> reviews;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getYear() {
		return year;
	}

	public void setYear(Date year) {
		this.year = year;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getWallpaper() {
		return wallpaper;
	}

	public void setWallpaper(String wallpaper) {
		this.wallpaper = wallpaper;
	}
	
	
}
