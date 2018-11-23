package org.vinksel.ultimateprojectofdoom3000lesdeuxtours.repositories;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.SQLQuery;
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
	
	public List<Course> getAllCourses(){
		
		Session session = SessionFactoryUtil.getSessionFactory().openSession();
		
		List<Course> ok;
		try {
<<<<<<< HEAD
                        SQLQuery query = session.createSQLQuery("SELECT * FROM course");
                        
                        query.addEntity(Course.class);
			ok = query.getResultList();
                        
=======
			Query query = session.createQuery("from Course");
			Iterator courses = query.iterate();
			while (courses.hasNext()) {
				response.add((Course) courses.next());
			}
>>>>>>> 5516275f32684b37c5c78da9a2d18e1fd307c99b
		} finally {
			session.close();
		}
		return ok;
	}

}
