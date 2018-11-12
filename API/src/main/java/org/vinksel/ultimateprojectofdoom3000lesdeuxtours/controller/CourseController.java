package org.vinksel.ultimateprojectofdoom3000lesdeuxtours.controller;

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
import org.vinksel.ultimateprojectofdoom3000lesdeuxtours.entity.Course;

@RestController
public class CourseController {
	@RequestMapping("/courses")
	public ArrayList<Course> courses(@RequestBody String body){		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Query qry = session.createQuery("from course c");
		List l =qry.list();
		return null;
	}
}
