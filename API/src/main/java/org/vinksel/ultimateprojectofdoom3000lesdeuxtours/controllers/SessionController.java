package org.vinksel.ultimateprojectofdoom3000lesdeuxtours.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.vinksel.ultimateprojectofdoom3000lesdeuxtours.entities.Course;
import org.vinksel.ultimateprojectofdoom3000lesdeuxtours.entities.Location;
import org.vinksel.ultimateprojectofdoom3000lesdeuxtours.entities.Session;
import org.vinksel.ultimateprojectofdoom3000lesdeuxtours.entities.User;
import org.vinksel.ultimateprojectofdoom3000lesdeuxtours.helpers.ResponseEntityHelper;
import org.vinksel.ultimateprojectofdoom3000lesdeuxtours.repositories.CourseRepository;
import org.vinksel.ultimateprojectofdoom3000lesdeuxtours.repositories.LocationRepository;
import org.vinksel.ultimateprojectofdoom3000lesdeuxtours.repositories.SessionRepository;
import org.vinksel.ultimateprojectofdoom3000lesdeuxtours.repositories.UserRepository;
import org.vinksel.ultimateprojectofdoom3000lesdeuxtours.validators.Validators;

@RestController

public class SessionController {
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping("/session/register") 
	public ResponseEntity<?> register(@RequestParam(value="idSession", required = true) String idSession,
			@RequestParam(value="idUser", required = true) String idUser)
	{
		Session session;
		User user;
		try {
			session = (Session) SessionRepository.getInstance().get(Integer.parseInt(idSession));
			user = (User) UserRepository.getInstance().get(Integer.parseInt(idUser));
			
			session.addUser(user);
 
			UserRepository.getInstance().update(user); 

		} catch (Exception e) {
			return ResponseEntityHelper.responseForException(e);
		}
		
		return ResponseEntityHelper.createdElement();
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping("/session/unregister") 
	public ResponseEntity<?> unregister(
			@RequestParam(value="idSession", required = true) Integer idSession,
			@RequestParam(value="idUser", required = true) Integer idUser)
	{
		Session session;
		User user;
		System.out.println("ok");
		try {
			session = (Session) SessionRepository.getInstance().get(idSession);
			user = (User) UserRepository.getInstance().get(idUser);

			session.rmUser(user);
			
			SessionRepository.getInstance().update(user); 
		} catch (Exception e) {
			return ResponseEntityHelper.responseForException(e);
		}
		
		return ResponseEntityHelper.createdElement();
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping("/sessions") 
	public ResponseEntity<?> sessions()
	{
		List<Object> sessions;
		try {
			sessions = SessionRepository.getInstance().getAll();
		} catch (Exception e) {
			return ResponseEntityHelper.responseForException(e);
		}
		
        if (Validators.isArrayEmpty(sessions)) {
            return ResponseEntityHelper.voidList();
        } else {
        	
        	for (int i = 0; i < sessions.size() ; i++) {
        		Session tmpSession = (Session) sessions.get(i);
        		List<User> users = UserRepository.getInstance().getUsersFromSession(tmpSession.getId());
        		if (!Validators.isNull(users)) {
            		tmpSession.setStudents(users);
        		}
        		
        	}
            return ResponseEntityHelper.objectList(sessions);
        }
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping("/session/{id}/") 
	public ResponseEntity<?> getSession(@PathVariable Integer id)
	{
		Session session;
		
		try {
			session = (Session) SessionRepository.getInstance().get(id);
		} catch (Exception e) {
			return ResponseEntityHelper.responseForException(e);
		}

		return ResponseEntityHelper.viewObject(session);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping("/session/add")
	public ResponseEntity<?> createSession(
			@RequestParam(value="courseID", defaultValue="null") String courseID,
			@RequestParam(value="locationID", defaultValue="null") Integer locationID,
			@RequestParam(value="start_date", defaultValue="null") Date start_date,
			@RequestParam(value="end_date", defaultValue="null") Date end_date,
			@RequestParam(value="max_student", defaultValue="null") Integer max_student
		)	
	{
		if(!Validators.isNull(courseID) || !Validators.isNull(locationID) || !Validators.isNull(start_date) || !Validators.isNull(end_date) || !Validators.isNull(max_student))
			return ResponseEntityHelper.badValues();
		
		Session session = new Session();
		session.setStart_date(start_date);
		session.setEnd_date(end_date);
		session.setMax_students(max_student);

		try {

			session.setCourse(CourseRepository.getInstance().get(courseID));
			session.setLocation((Location) LocationRepository.getInstance().get(locationID));
			SessionRepository.getInstance().save(session);
		} catch (Exception e) {
			return ResponseEntityHelper.responseForException(e);
		}
		
        return ResponseEntityHelper.createdElement();
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping("/session/edit/{id}") 
	public ResponseEntity<?> editSession(
			@PathVariable Integer id, 
			@RequestParam(value="courseID", defaultValue="null") String courseID,
			@RequestParam(value="locationID", defaultValue="null") Integer locationID,
			@RequestParam(value="start_date", defaultValue="null") Date start_date,
			@RequestParam(value="end_date", defaultValue="null") Date end_date,
			@RequestParam(value="max_student", defaultValue="null") Integer max_student
		)
	{
		try {
			Session session = (Session) SessionRepository.getInstance().get(id);
			
			if(!Validators.isNull(courseID))
				session.setCourse(CourseRepository.getInstance().get(courseID));
			if(!Validators.isNull(locationID))
				session.setLocation((Location) LocationRepository.getInstance().get(locationID));
			if(!Validators.isNull(start_date))
				session.setStart_date(start_date);
			if(!Validators.isNull(end_date))
				session.setEnd_date(end_date);
			if(!Validators.isNull(max_student))
				session.setMax_students(max_student);
			
			SessionRepository.getInstance().update(session);
			
		} catch (Exception e) {
			return ResponseEntityHelper.responseForException(e);
		}
        return ResponseEntityHelper.modifiedElement();
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping("/session/delete/{id}") 
	public ResponseEntity<?> deleteSession(@PathVariable Integer id)
	{
        try {
			SessionRepository.getInstance().remove(id);
		} catch (Exception e) {
			return ResponseEntityHelper.responseForException(e);
		}
		return ResponseEntityHelper.deletedElement();
	}
}
