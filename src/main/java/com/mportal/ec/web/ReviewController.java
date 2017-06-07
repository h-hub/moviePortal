package com.mportal.ec.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/reviews")
public class ReviewController {
	
	@RequestMapping(method= RequestMethod.GET)
	public String getReviews(){
		return "reviews";
	}
}

