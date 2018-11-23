package org.vinksel.ultimateprojectofdoom3000lesdeuxtours.repositories;

import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.vinksel.ultimateprojectofdoom3000lesdeuxtours.entities.Course;

public class CourseRepository {
	static private CourseRepository instance;
	static private Session session;
	static private SessionFactory sessionFactory;
	static private Configuration configuration;
	
	private CourseRepository(){
		configuration = new Configuration();
		configuration.addClass(Course.class);
		sessionFactory = configuration.buildSessionFactory();
	};
	
	static public Session openSession(){
		return sessionFactory.openSession();
	}
	
	static public CourseRepository getInstance(){
		if(instance == null)
			instance = new CourseRepository();
		return instance;
	}
	
	public ArrayList<Course> getAllCourses(){
		Session session = openSession();
		ArrayList<Course> response = new ArrayList<Course>();
		
		try {
			Query query = session.createQuery("select * from Course");
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
