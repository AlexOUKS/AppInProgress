package org.vinksel.ultimateprojectofdoom3000lesdeuxtours.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.vinksel.ultimateprojectofdoom3000lesdeuxtours.entities.Course;
import org.vinksel.ultimateprojectofdoom3000lesdeuxtours.entities.Location;
import org.vinksel.ultimateprojectofdoom3000lesdeuxtours.entities.Session;
import org.vinksel.ultimateprojectofdoom3000lesdeuxtours.repositories.LocationRepository;
import org.vinksel.ultimateprojectofdoom3000lesdeuxtours.responses.ResponseEntityUtil;
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
			return ResponseEntityUtil.responseForException(e);
		}
        if (Validators.isArrayEmpty(locations)) {
            return ResponseEntityUtil.voidList();
        } else {
            return ResponseEntityUtil.objectList(locations);
        }
	}
	
	@RequestMapping("/location/{id}/sessions") 
	public ResponseEntity<?> locations(@PathVariable Integer id)
	{
		Location location;
		try {
			location = (Location) LocationRepository.getInstance().get(id);
		} catch (Exception e) {
			return ResponseEntityUtil.responseForException(e);
		}

		System.out.println(location.getSessions());
		Hibernate.initialize(location.getSessions()); //TODO
		
		System.out.println(location.getSessions());
		
		if(location == null)
			return ResponseEntityUtil.viewObject(location);
		
		HashMap response = new HashMap<Location, Set<Session>>();
		response.put(location, location.getSessions());
		
		return ResponseEntityUtil.viewObject(response);
	}
}
