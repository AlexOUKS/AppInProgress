package org.vinksel.ultimateprojectofdoom3000lesdeuxtours.controllers;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.vinksel.ultimateprojectofdoom3000lesdeuxtours.entities.Course;

import com.google.gson.Gson;

@RestController

public class SessionController {
	@RequestMapping("/sessions")
	public ResponseEntity<String> courses(@RequestBody String body){		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Query qry = session.createQuery("from course c");
		List l =qry.list();
		String json = new Gson().toJson(l );
		return new ResponseEntity<>(
			      "Your age is ", 
			      HttpStatus.OK);
	}
	
}
