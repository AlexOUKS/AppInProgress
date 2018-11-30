package org.vinksel.ultimateprojectofdoom3000lesdeuxtours.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.vinksel.ultimateprojectofdoom3000lesdeuxtours.entities.Course;
import org.vinksel.ultimateprojectofdoom3000lesdeuxtours.repositories.CourseRepository;
import org.vinksel.ultimateprojectofdoom3000lesdeuxtours.validators.Validators;

@RestController
public class CourseController {
	@RequestMapping("/courses") 
	public ResponseEntity<?> courses()
	{
		List<Course> courses = CourseRepository.getAll();
            if (Validators.isArrayEmpty(courses)) {
                return new ResponseEntity<String>("Liste vide", HttpStatus.OK);
            } else {
                return new ResponseEntity<List<Course>>(courses, HttpStatus.OK);
                
            }
	}
	
	@RequestMapping("/course/delete/{id}") 
	public ResponseEntity<?> deleteCourse(@PathVariable String id)
	{
		CourseRepository.remove(id);
        return new ResponseEntity<String>("Elément supprimé", HttpStatus.OK);
	}
	
	@RequestMapping("/course/edit/") 
	public ResponseEntity<?> editCourse(@RequestParam(value="code", defaultValue="null") String code,
			@RequestParam(value="title", defaultValue="null") String title,
			@RequestParam(value="desc", defaultValue="null") String description)
	{
        return new ResponseEntity<String>("Elément modifié", HttpStatus.OK);
	}
	
	@RequestMapping("/courses/add") 
	public ResponseEntity<?> createCourse(@RequestParam(value="code", defaultValue="null") String code,
			@RequestParam(value="title", defaultValue="null") String title,
			@RequestParam(value="desc", defaultValue="null") String description
		)	
	{
        return new ResponseEntity<String>("Elément créé", HttpStatus.OK);
	}
}
