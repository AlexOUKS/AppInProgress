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
		List<Course> listCourse;
		try {
			Query qry = session.createQuery("from Course");
			listCourse =qry.list();
			
		} finally {
			session.close();
		}
		
		return listCourse;
	}

}
