package com.project.assignment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.assignment.services.BorrowingRecordService;

@RestController
@RequestMapping("/api")
public class BorrowingRecordController {
	
	@Autowired
	BorrowingRecordService borrowingRecordService;
	
	@PostMapping(path="/borrow/{bookId}/patron/{patronId}")
	public ResponseEntity<Integer> borrowABook(@PathVariable("bookId") int bookId,
			@PathVariable("patronId") int patronId){
		return new ResponseEntity<>(borrowingRecordService.borrowABook(bookId,patronId), HttpStatus.OK);
	}
	
	
	@PutMapping(path="/return/{bookId}/patron/{patronId}")
	public ResponseEntity<Integer> returnABook(@PathVariable("bookId") int bookId,
			@PathVariable("patronId") int patronId){
		return new ResponseEntity<>(borrowingRecordService.returnABook(bookId,patronId), HttpStatus.OK);
	}

}
