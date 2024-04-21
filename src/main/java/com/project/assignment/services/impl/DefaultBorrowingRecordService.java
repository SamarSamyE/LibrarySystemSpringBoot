package com.project.assignment.services.impl;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.assignment.entities.Book;
import com.project.assignment.entities.BorrowingRecord;
import com.project.assignment.entities.Patron;
import com.project.assignment.repositories.BookRepository;
import com.project.assignment.repositories.BorrowingRecordRepositroy;
import com.project.assignment.repositories.PatronRepository;
import com.project.assignment.services.BorrowingRecordService;
@Service
public class DefaultBorrowingRecordService implements BorrowingRecordService {

	@Autowired
	PatronRepository patronRepository;
	@Autowired
	BookRepository bookRepository;
	@Autowired
	BorrowingRecordRepositroy borrowingRecordRepositroy;
	
	
	@Override
	public int borrowABook(int bookId, int patronId) {
		BorrowingRecord borrowingRecord=new  BorrowingRecord();
		mapToBorrowingRecord(borrowingRecord,bookId,patronId);
		borrowingRecordRepositroy.save(borrowingRecord);
		return borrowingRecord.getId();
	}

	@Override
	@Transactional
	public int returnABook(int bookId, int patronId) {
		BorrowingRecord borrowedBook =borrowingRecordRepositroy.findByBookIdAndPatronId(bookId,patronId);
		borrowedBook.setReturnDate(LocalDate.now());
		borrowingRecordRepositroy.save(borrowedBook);
		return borrowedBook.getId();
	}
	
	private void mapToBorrowingRecord(BorrowingRecord borrowingRecord,int bookId, int patronId) {
		Book book = bookRepository.findById(bookId).get();
		Patron patron = patronRepository.findById(patronId).get();
		borrowingRecord.setPatron(patron);
		borrowingRecord.setBook(book);
		borrowingRecord.setBorrowingDate(LocalDate.now());		
	}




}
