package org.vinksel.ultimateprojectofdoom3000lesdeuxtours.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.vinksel.ultimateprojectofdoom3000lesdeuxtours.entities.Course;
import org.vinksel.ultimateprojectofdoom3000lesdeuxtours.entities.Location;

@RestController
public class LocationController {
	@RequestMapping("/locations") 
	public ArrayList<Location> locations(@RequestParam(value="id", defaultValue="all") String id, 
									 @RequestParam(value="city", defaultValue="all") String city)
	{
		return null;
	}
}
