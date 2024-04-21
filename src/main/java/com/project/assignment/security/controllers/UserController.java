package com.project.assignment.security.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.assignment.security.models.response.CurrentUserResModel;
import com.project.assignment.security.services.UserCredentialService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	UserCredentialService userCredentialService;
	
	@GetMapping(path ="/{id}")
	public ResponseEntity<CurrentUserResModel> getUserById(@PathVariable("id") int userId) {
		return new ResponseEntity<>(userCredentialService.getUserById(userId), HttpStatus.OK);
	}
	
	
	@GetMapping(path ="/{username}")
	public ResponseEntity<CurrentUserResModel> getUserByUserName(@PathVariable("username") String username) {
		return new ResponseEntity<>(userCredentialService.getUserByUserName(username), HttpStatus.OK);
	}
	
	
	@GetMapping
	public ResponseEntity<List<CurrentUserResModel>> findAllUsers() {
		return new ResponseEntity<>(userCredentialService.findAllUsers(), HttpStatus.OK);
	}
	



}