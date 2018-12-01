package org.vinksel.ultimateprojectofdoom3000lesdeuxtours.controllers;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.vinksel.ultimateprojectofdoom3000lesdeuxtours.entities.Course;
import org.vinksel.ultimateprojectofdoom3000lesdeuxtours.entities.User;
import org.vinksel.ultimateprojectofdoom3000lesdeuxtours.exceptions.ResponseEntityUtil;
import org.vinksel.ultimateprojectofdoom3000lesdeuxtours.repositories.CourseRepository;
import org.vinksel.ultimateprojectofdoom3000lesdeuxtours.repositories.UserRepository;
import org.vinksel.ultimateprojectofdoom3000lesdeuxtours.validators.Validators;

import com.google.gson.Gson;

@RestController
public class UserController {
	@RequestMapping("/mycourses")
	public String courses(){
		return null; 
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/login")
	public ResponseEntity<?> courses(@RequestParam(value="login", required = true) String login,
										@RequestParam(value="password", required = true) String password) throws UnsupportedEncodingException, NoSuchAlgorithmException{	
		
		if (!Validators.isStringEmpty(login) && !Validators.isStringEmpty(password)) {
			
			User user = (User) UserRepository.getInstance().getUser(login);
			
			if (Validators.isNull(user)) {
				return new ResponseEntity<>("Utilisateur inexistant", HttpStatus.BAD_REQUEST);
			}
			
			String PasswordGrainsel = password+user.getGrainsel();
			byte[] byteChaine = PasswordGrainsel.getBytes("UTF-8");
			String hash = DigestUtils.md5DigestAsHex(byteChaine);
			
			if (user.getPassword().toLowerCase().equals(hash.toLowerCase())) {
				
				SecureRandom random = new SecureRandom();
				byte bytes[] = new byte[50];
				random.nextBytes(bytes);
				String token = DigestUtils.md5DigestAsHex(bytes);
				
				user.setToken(token);
				try {
					UserRepository.getInstance().update(user);
				} catch (Exception e) {
					return ResponseEntityUtil.modifiedElement();
				}
			
	
				return new ResponseEntity<Object>(token, HttpStatus.OK); 
			} else {
				return new ResponseEntity<>("Mauvais identifiants", HttpStatus.BAD_REQUEST);
			} 
			
		} else {
			return new ResponseEntity<>("Login/password vide", HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@RequestMapping("/profile/{id}")
	public User see_profile(@PathVariable String id){ //To see other user profile
		return null;
	}
}
