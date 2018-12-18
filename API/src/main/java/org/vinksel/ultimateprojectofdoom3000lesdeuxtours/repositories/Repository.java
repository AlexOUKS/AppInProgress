package org.vinksel.ultimateprojectofdoom3000lesdeuxtours.repositories;

import java.io.IOException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.vinksel.ultimateprojectofdoom3000lesdeuxtours.helpers.SessionFactoryHelper;

public class Repository {

	private static Class className;
	private static Repository instance;
	protected Repository(){};
	
	static public Repository getInstance(){
		if(instance == null)
			instance = new Repository();
		return instance;
	};
	
	public void persist(Object obj) throws Exception{
		Session session = SessionFactoryHelper.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.persist(obj);
			session.getTransaction().commit();
		}
		catch(HibernateException e){throw e;}
		finally {session.close();}
	}
	
	public void update(Object obj) throws Exception{
		Session session = SessionFactoryHelper.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.update(obj);
			session.getTransaction().commit();
		}
		catch(HibernateException e){throw e;}
		finally {session.close();}
	}

	public void save(Object obj) throws Exception{
		Session session = SessionFactoryHelper.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.save(obj);
			session.getTransaction().commit();
		}
		catch(Exception e){throw e;}
		finally {session.close();}
	}

	public void remove(Object obj) throws Exception{
		Session session = SessionFactoryHelper.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.delete(obj);
			session.getTransaction().commit();
		}
		catch(Exception e){
            session.getTransaction().rollback();
            throw e;
        } finally {
			session.close();
		}
	}
	public Object get(Integer id) throws Exception{
		classNameIsDefined();
		Session session = SessionFactoryHelper.getSessionFactory().openSession();
		Object obj = null;
		
		try {
			
			obj =  session.get(getClassName(), id);
		} catch(Exception e){throw e;}
		finally {
			session.close();
		}
		
		return obj;
	}
	
	protected void classNameIsDefined() throws Exception
	{
		if(getClassName() == null)
			throw new IllegalArgumentException("ClassName of the repository must be defined !");
	}
	
	public List<Object> getAll() throws Exception{
		classNameIsDefined();
		Session session = SessionFactoryHelper.getSessionFactory().openSession();
		List<Object> listObject = null;
		
		try {
			
			Query<Object> qry = session.createQuery("from " + getClassName().getName());
			listObject = qry.list();
		} catch(Exception e){throw e; }
		finally {
			session.close();
		}
		
		return listObject;
	}

	protected Class getClassName() {
		return className;
	}
}
