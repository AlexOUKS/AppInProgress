package org.vinksel.ultimateprojectofdoom3000lesdeuxtours.repositories;

import java.util.List;

import org.hibernate.Session;
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
	
	static public List<Course> getAll(){
		
		Session session = SessionFactoryUtil.getSessionFactory().openSession();
		List<Course> listCourse = null;
		try {
			
			Query<Course> qry = session.createQuery("from Course");
			listCourse =qry.list();
			System.out.println("ok");
		} catch(Exception e){
            e.printStackTrace();
		}finally {
			session.close();
		}
		
		return listCourse;
	}
	static public void remove(String id){
		Session session = SessionFactoryUtil.getSessionFactory().openSession();
		try {
			Course course = (Course)session.load(Course.class,id);
			session.beginTransaction();
			session.delete(course);
			session.getTransaction().commit();
		}
		catch(Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
			session.close();
		}
	}
	static public void save(Course course){
		Session session = SessionFactoryUtil.getSessionFactory().openSession();
		try {session.save(course);}
		catch(Exception e){e.printStackTrace();}
		finally {session.close();}
	}
	static public void update(Course course) {
		Session session = SessionFactoryUtil.getSessionFactory().openSession();
		try {session.update(course);}
		catch(Exception e){e.printStackTrace();}
		finally {session.close();}
	}
	static public List<Course> forUser(Long idUser)
	{
		Session session = SessionFactoryUtil.getSessionFactory().openSession();
		List<Course> listCourse = null;
		try{
			Query qry = session.createQuery("from Course where code in ()");
			listCourse =qry.list();
		} catch(Exception e){
            e.printStackTrace();
		} finally{
			session.close();
		}
		return listCourse;
	}
}
