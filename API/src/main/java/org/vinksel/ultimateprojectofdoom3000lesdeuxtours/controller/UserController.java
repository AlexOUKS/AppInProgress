package org.vinksel.ultimateprojectofdoom3000lesdeuxtours.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.vinksel.ultimateprojectofdoom3000lesdeuxtours.entity.Course;
import org.vinksel.ultimateprojectofdoom3000lesdeuxtours.entity.User;

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
	
	@RequestMapping("/profile")
	public User see_profil(@RequestParam(value="id", defaultValue="null") String id){
		if(id == null) //return the profil of the connected user
			return user();
		return null;
	}
}
