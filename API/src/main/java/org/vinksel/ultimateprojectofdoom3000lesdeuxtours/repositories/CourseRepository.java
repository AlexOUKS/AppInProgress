package org.vinksel.ultimateprojectofdoom3000lesdeuxtours.repositories;

import java.util.ArrayList;

import org.vinksel.ultimateprojectofdoom3000lesdeuxtours.entities.Course;

public class CourseRepository {
	static private CourseRepository instance;
	
	private CourseRepository(){};
	
	static public CourseRepository getInstance(){
		if(instance == null)
			instance = new CourseRepository();
		return instance;
	}
	
	public ArrayList<Course> getAllCourses(){
		return null;
	}
}
