package org.vinksel.ultimateprojectofdoom3000lesdeuxtours.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.vinksel.ultimateprojectofdoom3000lesdeuxtours.entities.Course;
import org.vinksel.ultimateprojectofdoom3000lesdeuxtours.helpers.ResponseEntityHelper;
import org.vinksel.ultimateprojectofdoom3000lesdeuxtours.repositories.CourseRepository;
import org.vinksel.ultimateprojectofdoom3000lesdeuxtours.validators.Validators;

@RestController
public class CourseController {
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping("/courses") 
	public ResponseEntity<?> courses()
	{
		List<Object> courses = new ArrayList<Object>();
		try {
			courses = CourseRepository.getInstance().getAll();
		} catch (Exception e) {
			return ResponseEntityHelper.responseForException(e);
		}
        if (Validators.isArrayEmpty(courses)) {
            return ResponseEntityHelper.voidList();
        } else {
            return ResponseEntityHelper.objectList(courses);
        }
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping("/course/view/")
	public ResponseEntity<?> getCourse(@RequestParam(value="id", defaultValue="null") String id)
	{
		Course course;
        try {
        	course = CourseRepository.getInstance().get(id);
		} catch (Exception e) {
			return ResponseEntityHelper.responseForException(e);
		}
		return ResponseEntityHelper.viewObject(course);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping("/course/delete/") 
	public ResponseEntity<?> deleteCourse(@RequestParam(value="id", defaultValue="null") String id)
	{
        try {
			CourseRepository.getInstance().remove(id);
		} catch (Exception e) {
			return ResponseEntityHelper.responseForException(e);
		}
		return ResponseEntityHelper.deletedElement();
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping("/course/edit/") 
	public ResponseEntity<?> editCourse(
			@RequestParam(value="id", defaultValue="null") String id, 
			@RequestParam(value="code", defaultValue="null") String code,
			@RequestParam(value="title", defaultValue="null") String title,
			@RequestParam(value="desc", defaultValue="null") String description)
	{
		try {
			Course course = CourseRepository.getInstance().get(id);
			
			if(!Validators.isNull(code))
				course.setCode(code);
			if(!Validators.isNull(title))
				course.setTitle(title);
			if(!Validators.isNull(description))
				course.setDescription(description);
			
			CourseRepository.getInstance().update(course);
			
		} catch (Exception e) {
			return ResponseEntityHelper.responseForException(e);
		}
        return ResponseEntityHelper.modifiedElement();
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping("/course/add") 
	public ResponseEntity<?> createCourse(@RequestParam(value="code", defaultValue="null") String code,
			@RequestParam(value="title", defaultValue="null") String title,
			@RequestParam(value="desc", defaultValue="null") String description
		)	
	{
		if(Validators.isNull(code) || Validators.isNull(title) || Validators.isNull(description))
			return ResponseEntityHelper.badValues();
		
		Course course = new Course(code, title, description);
		
		try {
			CourseRepository.getInstance().save(course);
		} catch (Exception e) {
			return ResponseEntityHelper.responseForException(e);
		}
		
        return ResponseEntityHelper.createdElement();
	}
}
