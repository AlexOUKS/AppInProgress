package org.vinksel.ultimateprojectofdoom3000lesdeuxtours.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class SessionFactoryUtil {

	private static SessionFactory sessionFactory;
	
	private static SessionFactory buildSessionFactory() {
        try {
        	Configuration configuration = new Configuration();
        	configuration.configure("hibernate.cfg.xml");
        	configuration.addAnnotatedClass(org.vinksel.ultimateprojectofdoom3000lesdeuxtours.entities.Course.class);
        	configuration.addAnnotatedClass(org.vinksel.ultimateprojectofdoom3000lesdeuxtours.entities.Location.class);
        	configuration.addAnnotatedClass(org.vinksel.ultimateprojectofdoom3000lesdeuxtours.entities.User.class);
        	configuration.addAnnotatedClass(org.vinksel.ultimateprojectofdoom3000lesdeuxtours.entities.Session.class);
        	/*configuration.addResource("User.hbm.xml");
        	configuration.addResource("Location.hbm.xml");
        	configuration.addResource("Course.hbm.xml");
        	configuration.addResource("Session.hbm.xml");*/
        	ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        	
        	SessionFactory sessionFactory = configuration
        						.buildSessionFactory(serviceRegistry);
        	
            return sessionFactory;
        }
        catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
	
	public static SessionFactory getSessionFactory() {
		if(sessionFactory == null) sessionFactory = buildSessionFactory();
        return sessionFactory;
    }
}
