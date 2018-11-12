package org.vinksel.ultimateprojectofdoom3000lesdeuxtours.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.vinksel.ultimateprojectofdoom3000lesdeuxtours.entities.Course;
import org.vinksel.ultimateprojectofdoom3000lesdeuxtours.entities.User;

@RestController
public class UserController {
	@RequestMapping("/mycourses")
	public ArrayList<Course> courses(){ //List of the user's courses
		return null;
	}
	
	@RequestMapping("/account")
	public User user(){ //Data of the account's settings of the connected user
		return null;
	}
	
	@RequestMapping("/profile/{id}")
	public User see_profile(@PathVariable String id){ //To see other user profile
		return null;
	}
}
