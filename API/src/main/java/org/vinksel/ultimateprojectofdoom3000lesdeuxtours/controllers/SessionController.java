package org.vinksel.ultimateprojectofdoom3000lesdeuxtours.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class SessionController {
	@PostMapping("/sessions")
	public ResponseEntity<String> courses(@RequestParam(value="idSession", required = true) String idSession,
			@RequestParam(value="rezrz", required = true) String body){		
		return new ResponseEntity<>(
			      body, 
			      HttpStatus.OK);
	}
	
}
