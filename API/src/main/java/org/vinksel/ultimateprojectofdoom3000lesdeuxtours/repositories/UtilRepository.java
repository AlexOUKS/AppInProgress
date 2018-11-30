package org.vinksel.ultimateprojectofdoom3000lesdeuxtours.repositories;

import java.io.IOException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.vinksel.ultimateprojectofdoom3000lesdeuxtours.hibernate.SessionFactoryUtil;

public class UtilRepository {

	private static Class className;
	private static UtilRepository instance;
	protected UtilRepository(){};
	
	static public UtilRepository getInstance(){
		if(instance == null)
			instance = new UtilRepository();
		return instance;
	};
	
	public void update(Object obj) {
		Session session = SessionFactoryUtil.getSessionFactory().openSession();
		try {session.update(obj);}
		catch(Exception e){e.printStackTrace();}
		finally {session.close();}
	}

	public void save(Object obj){
		Session session = SessionFactoryUtil.getSessionFactory().openSession();
		try {session.save(obj);}
		catch(Exception e){e.printStackTrace();}
		finally {session.close();}
	}

	public void remove(Object obj){
		Session session = SessionFactoryUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.delete(obj);
			session.getTransaction().commit();
		}
		catch(Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
			session.close();
		}
	}
	public Object get(Integer id) throws IOException{
		classNameIsDefined();
		Session session = SessionFactoryUtil.getSessionFactory().openSession();
		Object obj = null;
		
		try {
			
			obj =  session.get(getClassName(), id);
		} catch(Exception e){
            e.printStackTrace();
		}finally {
			session.close();
		}
		
		return obj;
	}
	
	protected void classNameIsDefined() throws IOException
	{
		if(getClassName() == null)
			throw new IOException("ClassName of the repository must be defined !");
	}
	
	public List<Object> getAll() throws IOException{
		classNameIsDefined();
		Session session = SessionFactoryUtil.getSessionFactory().openSession();
		List<Object> listObject = null;
		
		try {
			
			Query<Object> qry = session.createQuery("from " + getClassName().getName());
			listObject = qry.list();
		} catch(Exception e){
            e.printStackTrace();
		}finally {
			session.close();
		}
		
		return listObject;
	}

	protected Class getClassName() {
		return className;
	}
}
