package org.vinksel.ultimateprojectofdoom3000lesdeuxtours.repositories;

import java.io.IOException;

import org.hibernate.Session;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.vinksel.ultimateprojectofdoom3000lesdeuxtours.entities.Course;
import org.vinksel.ultimateprojectofdoom3000lesdeuxtours.hibernate.SessionFactoryUtil;

public class CourseRepository extends Repository {
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


	public Course get(String id) throws Exception{
		classNameIsDefined();
		Session session = SessionFactoryUtil.getSessionFactory().openSession();
		Course obj = null;
		
		try {
			obj =  session.get(Course.class, id);
		} catch(Exception e){
            throw e;
		}finally {
			session.close();
		}
		return obj;
	}
}
