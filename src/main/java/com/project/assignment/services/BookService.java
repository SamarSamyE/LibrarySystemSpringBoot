package com.project.assignment.services;

import java.util.List;

import com.project.assignment.models.request.BookReqModel;
import com.project.assignment.models.response.BookResModel;

public interface BookService {

	int createBook(BookReqModel bookReqModel);
	int updateBook(int bookId,BookReqModel bookReqModel);
	BookResModel getBookById(int bookId);
	List<BookResModel> getAllBooks();
	void deleteBookById(int bookId);
	
}
