package org.vinksel.ultimateprojectofdoom3000lesdeuxtours.repositories;

import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.vinksel.ultimateprojectofdoom3000lesdeuxtours.entities.Course;
import org.vinksel.ultimateprojectofdoom3000lesdeuxtours.hibernate.SessionFactoryUtil;

public class CourseRepository {
	static private CourseRepository instance;
	
	private CourseRepository(){
	};
	
	static public CourseRepository getInstance(){
		if(instance == null)
			instance = new CourseRepository();
		return instance;
	}
	
	public ArrayList<Course> getAllCourses(){
		Session session = SessionFactoryUtil.getSessionFactory().openSession();
		ArrayList<Course> response = new ArrayList<Course>();
		
		try {
			Query query = session.createQuery("from course");
			Iterator courses = query.iterate();
			while (courses.hasNext()) {
				response.add((Course) courses.next());
			}
		} finally {
			session.close();
		}
		return response;
	}

}
