package org.vinksel.ultimateprojectofdoom3000lesdeuxtours.controllers;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.vinksel.ultimateprojectofdoom3000lesdeuxtours.entities.Course;
import org.vinksel.ultimateprojectofdoom3000lesdeuxtours.entities.Session;

@RestController
<<<<<<< HEAD:API/src/main/java/org/vinksel/ultimateprojectofdoom3000lesdeuxtours/controller/CourseController.java
public class CourseController {
	@RequestMapping("/courses")
	public ArrayList<Course> courses(@RequestBody String body){		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Query qry = session.createQuery("from course c");
		List l =qry.list();
=======
public class SessionController {
	@RequestMapping("/sessions") 
	public ArrayList<Session> sessions(@RequestParam(value="code", defaultValue="all") String code, 
									 @RequestParam(value="name", defaultValue="all") String name,
									 @RequestParam(value="id", defaultValue="all") String id){
>>>>>>> 2acf67bd2c9b6149e58c9728831ef17097057127:API/src/main/java/org/vinksel/ultimateprojectofdoom3000lesdeuxtours/controllers/SessionController.java
		return null;
	}

}
