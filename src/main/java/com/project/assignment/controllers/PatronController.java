package com.project.assignment.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.assignment.models.request.PatronReqModel;
import com.project.assignment.models.response.PatronResModel;
import com.project.assignment.services.PatronService;


@RestController
@RequestMapping("/api/patrons")
public class PatronController {

	@Autowired
	PatronService patronService;
	
	@PostMapping
	public ResponseEntity<Integer> createPatron(
		    @RequestBody @Valid PatronReqModel patronReqModel) {
		return new ResponseEntity<>(patronService.createPatron(patronReqModel), HttpStatus.OK);
	}
	
	
	@PutMapping(path ="/{id}")
	public ResponseEntity<Integer> updatePatron(@PathVariable("id") int patronId,
		     @RequestBody @Valid PatronReqModel patronReqModel) {
		return new ResponseEntity<>(patronService.updatePatron(patronId,patronReqModel), HttpStatus.OK);
	}
	
	@GetMapping(path ="/{id}")
	public ResponseEntity<PatronResModel> getPatronById(@PathVariable("id") int patronId) {
		return new ResponseEntity<>(patronService.getPatronById(patronId), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<PatronResModel>> getAllPatrons() {
		return new ResponseEntity<>(patronService.getAllPatrons(), HttpStatus.OK);
	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<Void> deletePatronById(@PathVariable("id") int patronId){
		patronService.deletePatronById(patronId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
