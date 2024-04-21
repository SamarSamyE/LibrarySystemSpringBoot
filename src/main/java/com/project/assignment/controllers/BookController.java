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

import com.project.assignment.models.request.BookReqModel;
import com.project.assignment.models.response.BookResModel;
import com.project.assignment.services.BookService;


@RestController
@RequestMapping("/api/books")
public class BookController {

	@Autowired
	BookService bookService;
	
	@PostMapping
	public ResponseEntity<Integer> createBook(
		     @RequestBody @Valid BookReqModel bookReqModel) {
		return new ResponseEntity<>(bookService.createBook(bookReqModel), HttpStatus.OK);
	}
	
	@PutMapping(path ="/{id}")
	public ResponseEntity<Integer> updateBook(@PathVariable("id") int bookId,
		     @RequestBody @Valid BookReqModel bookReqModel) {
		return new ResponseEntity<>(bookService.updateBook(bookId,bookReqModel), HttpStatus.OK);
	}
	
	
	@GetMapping(path ="/{id}")
	public ResponseEntity<BookResModel> getBookById(@PathVariable("id") int bookId) {
		return new ResponseEntity<>(bookService.getBookById(bookId), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<BookResModel>> getAllBooks() {
		return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<Void> deleteBookById(@PathVariable("id") int bookId){
		bookService.deleteBookById(bookId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	
}
