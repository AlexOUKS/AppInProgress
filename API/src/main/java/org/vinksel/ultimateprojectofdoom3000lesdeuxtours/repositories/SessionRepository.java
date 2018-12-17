package org.vinksel.ultimateprojectofdoom3000lesdeuxtours.repositories;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.query.Query;
import org.vinksel.ultimateprojectofdoom3000lesdeuxtours.entities.Course;
import org.vinksel.ultimateprojectofdoom3000lesdeuxtours.entities.Location;
import org.vinksel.ultimateprojectofdoom3000lesdeuxtours.entities.Session;
import org.vinksel.ultimateprojectofdoom3000lesdeuxtours.entities.User;
import org.vinksel.ultimateprojectofdoom3000lesdeuxtours.helpers.SessionFactoryHelper;

public class SessionRepository extends Repository {
	private static Class className = Session.class;
	private static SessionRepository instance;

	public static SessionRepository getInstance() {
		if(instance == null)
			instance = new SessionRepository();
		return instance;
	}
	

	@Override
	protected Class getClassName()
	{
		return className;
	}
	
	public void registerSessionUser(Integer userId, Integer sessionId) {
		org.hibernate.Session session = SessionFactoryHelper.getSessionFactory().openSession();
		

		Query query = session.createSQLQuery("INSERT INTO user_session (session_id,user_id) VALUES(:val1,:val2)");
		query.setParameter("val1", sessionId);
		query.setParameter("val2", userId);
		query.executeUpdate();
		
		
	}
	public List<Session> sessionsForLocation(Location location)
	{
		org.hibernate.Session session = SessionFactoryHelper.getSessionFactory().openSession();
		List<Session> listSession = new ArrayList<Session>();

		try {
			Query<Session> qry = session.createQuery("from Session where location_id = ?");
			qry.setParameter(0, location.getId());
			listSession = qry.list();
		} catch(Exception e){throw e; }
		finally {
			session.close();
		}
		return listSession;
	}
}
