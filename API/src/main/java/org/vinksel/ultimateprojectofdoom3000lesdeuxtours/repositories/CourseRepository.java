package org.vinksel.ultimateprojectofdoom3000lesdeuxtours.repositories;

import java.io.IOException;

import org.vinksel.ultimateprojectofdoom3000lesdeuxtours.entities.Course;

public class CourseRepository extends UtilRepository {
	public static Class className = Course.class;
	private static CourseRepository instance;

	public static CourseRepository getInstance() {
		if(instance == null)
			instance = new CourseRepository();
		return instance;
	}

	@Override
	protected Class getClassName()
	{
		return className;
	}
}
