package com.project.assignment.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.assignment.entities.Book;
import com.project.assignment.models.mapinterface.BookMapper;
import com.project.assignment.models.request.BookReqModel;
import com.project.assignment.models.response.BookResModel;
import com.project.assignment.repositories.BookRepository;
import com.project.assignment.services.BookService;
import com.project.assignment.utils.exceptions.ApiErrorMessageKeyEnum;
import com.project.assignment.utils.exceptions.BusinessLogicViolationException;

@Service
public class DefaultBookService implements BookService{
	
	@Autowired
	BookRepository bookRepository;

	@Autowired
	BookMapper bookMapper;

	
	@Override
	@Transactional
	@CacheEvict(value= {"getBookById","getAllBooks"},key="#root.methodName",allEntries=true)
	public int createBook(BookReqModel bookReqModel) {
		validateBookIsbnUniqueness(bookReqModel.getIsbn(),0);
		Book book=new Book();
		mapBookReqModelToBook(book,bookReqModel);
		bookRepository.save(book);
		return book.getId();
	}
	
	
	@Override
	@Transactional
	@CacheEvict(value= {"getBookById","getAllBooks"},key="#root.methodName",allEntries=true)
	public int updateBook(int bookId,BookReqModel bookReqModel) {
		validateBookIsbnUniqueness(bookReqModel.getIsbn(),bookId);
		Book updatedBook=bookRepository.findById(bookId).get();
		mapBookReqModelToBook(updatedBook,bookReqModel);
		bookRepository.save(updatedBook);
		return updatedBook.getId();
	}
	
	@Override
	@Cacheable(value="getBookById", key="#bookId")
	public BookResModel getBookById(int bookId) {
		Book updatedBook=bookRepository.findById(bookId).get();
		return bookMapper.mapToBookResModel(updatedBook);
	}
	
	@Override
	@Cacheable(value="getAllBooks", key="#root.methodName")
	public List<BookResModel> getAllBooks () {
		return bookMapper.mapToBookResModel(bookRepository.findAll());
	}
	
	@Override
	@Transactional
	@CacheEvict(value= {"getBookById","getAllBooks"},key="#root.methodName",allEntries=true)
	public void deleteBookById (int bookId) {
		bookRepository.deleteById(bookId);		
	}

	private void mapBookReqModelToBook(Book book,BookReqModel bookReqModel) {
		book.setAuthor(bookReqModel.getAuthor());
		book.setIsbn(bookReqModel.getIsbn());
		book.setTitle(bookReqModel.getTitle());
		book.setPublicationYear(bookReqModel.getPublicationYear());
	}
	
	private void validateBookIsbnUniqueness(String isbn,int bookId) {
		Book book = bookRepository.findByIsbn(isbn.trim());
       if(book!=null &&book.getId()!=bookId )
    	   throw new BusinessLogicViolationException(ApiErrorMessageKeyEnum.U_BOOK_ISBN.name());
	}


}
