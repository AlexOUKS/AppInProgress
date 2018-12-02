package org.vinksel.ultimateprojectofdoom3000lesdeuxtours.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.vinksel.ultimateprojectofdoom3000lesdeuxtours.entities.Course;
import org.vinksel.ultimateprojectofdoom3000lesdeuxtours.entities.Location;
import org.vinksel.ultimateprojectofdoom3000lesdeuxtours.entities.Session;
import org.vinksel.ultimateprojectofdoom3000lesdeuxtours.helpers.ControllerHelper;
import org.vinksel.ultimateprojectofdoom3000lesdeuxtours.helpers.ResponseEntityHelper;
import org.vinksel.ultimateprojectofdoom3000lesdeuxtours.helpers.SessionFactoryHelper;
import org.vinksel.ultimateprojectofdoom3000lesdeuxtours.repositories.CourseRepository;
import org.vinksel.ultimateprojectofdoom3000lesdeuxtours.repositories.LocationRepository;
import org.vinksel.ultimateprojectofdoom3000lesdeuxtours.repositories.SessionRepository;
import org.vinksel.ultimateprojectofdoom3000lesdeuxtours.validators.Validators;

@RestController
public class LocationController {
	@RequestMapping("/locations") 
	public ResponseEntity<?> locations()
	{
		List<Object> locations;
		try {
			locations = LocationRepository.getInstance().getAll();
		} catch (Exception e) {
			return ResponseEntityHelper.responseForException(e);
		}
        if (Validators.isArrayEmpty(locations)) {
            return ResponseEntityHelper.voidList();
        } else {
            return ResponseEntityHelper.objectList(locations);
        }
	}
	
	@RequestMapping("/location/{id}/") 
	public ResponseEntity<?> getLocation(@PathVariable Integer id)
	{
		Location location;
		List<Session> sessions = new ArrayList<Session>();
		
		try {
			location = (Location) LocationRepository.getInstance().get(id);
		} catch (Exception e) {
			return ResponseEntityHelper.responseForException(e);
		}
		
		try {
			sessions = SessionRepository.getInstance().sessionsForLocation(location);
		} catch (Exception e) {
			return ResponseEntityHelper.responseForException(e);
		}
		ArrayList finalResponse = new ArrayList();
		finalResponse.add(location);
		finalResponse.add(sessions);
		return ResponseEntityHelper.viewObject(finalResponse);
	}
	
	@RequestMapping("/location/add")
	public ResponseEntity<?> createLocation(@RequestParam(value="name", defaultValue="null") String name)	
	{
		if(name == null)
			return ResponseEntityHelper.badValues();
		
		Location location = new Location();
		location.setCity(name);

		try {
			LocationRepository.getInstance().save(location);
		} catch (Exception e) {
			return ResponseEntityHelper.responseForException(e);
		}
		
        return ResponseEntityHelper.createdElement();
	}
	
	@RequestMapping("/location/edit/{id}") 
	public ResponseEntity<?> editLocation(@PathVariable Integer id, @RequestParam(value="name", defaultValue="null") String name)
	{
		try {
			Location location = (Location) LocationRepository.getInstance().get(id);
			
			if(name != null)
				location.setCity(name);
			
			LocationRepository.getInstance().update(location);
			
		} catch (Exception e) {
			return ResponseEntityHelper.responseForException(e);
		}
        return ResponseEntityHelper.modifiedElement();
	}
	
	@RequestMapping("/location/delete/{id}") 
	public ResponseEntity<?> deleteLocation(@PathVariable Integer id)
	{
        try {
			LocationRepository.getInstance().remove(id);
		} catch (Exception e) {
			return ResponseEntityHelper.responseForException(e);
		}
		return ResponseEntityHelper.deletedElement();
	}
}
