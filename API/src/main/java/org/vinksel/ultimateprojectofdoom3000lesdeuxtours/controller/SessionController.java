package org.vinksel.ultimateprojectofdoom3000lesdeuxtours.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.vinksel.ultimateprojectofdoom3000lesdeuxtours.entity.Course;
import org.vinksel.ultimateprojectofdoom3000lesdeuxtours.entity.Session;

@RestController
public class SessionController {
	@RequestMapping("/sessions") 
	public ArrayList<Session> sessions(@RequestParam(value="code", defaultValue="all") String code, 
									 @RequestParam(value="name", defaultValue="all") String name,
									 @RequestParam(value="id", defaultValue="all") String id){
		return null;
	}

}
