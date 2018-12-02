package org.vinksel.ultimateprojectofdoom3000lesdeuxtours.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.vinksel.ultimateprojectofdoom3000lesdeuxtours.entities.Course;
import org.vinksel.ultimateprojectofdoom3000lesdeuxtours.repositories.CourseRepository;
import org.vinksel.ultimateprojectofdoom3000lesdeuxtours.responses.ResponseEntityUtil;
import org.vinksel.ultimateprojectofdoom3000lesdeuxtours.validators.Validators;

@RestController
public class CourseController {
	@RequestMapping("/courses") 
	public ResponseEntity<?> courses()
	{
		List<Object> courses = new ArrayList<Object>();
		try {
			courses = CourseRepository.getInstance().getAll();
		} catch (Exception e) {
			return ResponseEntityUtil.responseForException(e);
		}
        if (Validators.isArrayEmpty(courses)) {
            return ResponseEntityUtil.voidList();
        } else {
            return ResponseEntityUtil.objectList(courses);
        }
	}
	
	@RequestMapping("/course/view/{id}")
	public ResponseEntity<?> getCourse(@PathVariable String id)
	{
		Course course;
        try {
        	course = CourseRepository.getInstance().get(id);
		} catch (Exception e) {
			return ResponseEntityUtil.responseForException(e);
		}
		return ResponseEntityUtil.viewObject(course);
	}
	
	@RequestMapping("/course/delete/{id}") 
	public ResponseEntity<?> deleteCourse(@PathVariable String id)
	{
        try {
			CourseRepository.getInstance().remove(id);
		} catch (Exception e) {
			return ResponseEntityUtil.responseForException(e);
		}
		return ResponseEntityUtil.deletedElement();
	}
	
	@RequestMapping("/course/edit/{id}") 
	public ResponseEntity<?> editCourse(@PathVariable String id, @RequestParam(value="code", defaultValue="null") String code,
			@RequestParam(value="title", defaultValue="null") String title,
			@RequestParam(value="desc", defaultValue="null") String description)
	{
		try {
			Course course = CourseRepository.getInstance().get(id);
			
			if(code != null)
				course.setCode(code);
			if(title != null)
				course.setTitle(title);
			if(description != null)
				course.setDescription(description);
			
			CourseRepository.getInstance().update(course);
			
		} catch (Exception e) {
			return ResponseEntityUtil.responseForException(e);
		}
        return ResponseEntityUtil.modifiedElement();
	}
	
	@RequestMapping("/course/add") 
	public ResponseEntity<?> createCourse(@RequestParam(value="code", defaultValue="null") String code,
			@RequestParam(value="title", defaultValue="null") String title,
			@RequestParam(value="desc", defaultValue="null") String description
		)	
	{
		if(code == null || title == null || description == null)
			return ResponseEntityUtil.badValues();
		
		Course course = new Course(code, title, description);
		
		try {
			CourseRepository.getInstance().save(course);
		} catch (Exception e) {
			return ResponseEntityUtil.responseForException(e);
		}
		
        return ResponseEntityUtil.createdElement();
	}
}
