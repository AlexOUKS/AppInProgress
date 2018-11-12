package org.vinksel.ultimateprojectofdoom3000lesdeuxtours.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.vinksel.ultimateprojectofdoom3000lesdeuxtours.entity.Course;
import org.vinksel.ultimateprojectofdoom3000lesdeuxtours.entity.CourseSession;

@RestController
public class CourseSessionController {
	
	@PostMapping("/subscribeSession")
	public CourseSession courses(@RequestBody CourseSession newEmployee){		
		
		return null;
	}
}
