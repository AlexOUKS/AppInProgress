package org.vinksel.ultimateprojectofdoom3000lesdeuxtours.controllers;

import java.util.ArrayList;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.vinksel.ultimateprojectofdoom3000lesdeuxtours.entities.Course;
import org.vinksel.ultimateprojectofdoom3000lesdeuxtours.repositories.CourseRepository;

@RestController
public class CourseController {
	@RequestMapping("/courses") 
	public ArrayList<Course> courses(@RequestParam(value="code", defaultValue="all") String code, 
									 @RequestParam(value="name", defaultValue="all") String name)
	{
		return CourseRepository.getInstance().getAllCourses();
	}
	
	@RequestMapping("/course/delete/{id}") 
	public boolean deleteCourse(@PathVariable String id)
	{
		return false;
	}
	
	@RequestMapping("/course/edit/") 
	public boolean editCourse(@RequestParam(value="code", defaultValue="null") String code,
			@RequestParam(value="title", defaultValue="null") String title,
			@RequestParam(value="desc", defaultValue="null") String description)
	{
		return false;
	}
	
	@RequestMapping("/courses/add") 
	public boolean createCourse(@RequestParam(value="code", defaultValue="null") String code,
			@RequestParam(value="title", defaultValue="null") String title,
			@RequestParam(value="desc", defaultValue="null") String description
		)	
	{
		if(title == null)
			return false;
			
		if(description == null)
			return false;
			
		if(code == null)
			return false;
		
		return true;
	}
}
