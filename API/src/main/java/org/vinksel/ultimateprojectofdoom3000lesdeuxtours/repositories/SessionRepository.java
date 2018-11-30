package org.vinksel.ultimateprojectofdoom3000lesdeuxtours.repositories;

import org.vinksel.ultimateprojectofdoom3000lesdeuxtours.entities.Session;

public class SessionRepository extends UtilRepository {
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
}
