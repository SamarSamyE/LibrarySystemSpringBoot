package com.project.assignment.repositories;

import org.springframework.data.repository.CrudRepository;

import com.project.assignment.entities.BorrowingRecord;



public interface BorrowingRecordRepositroy extends CrudRepository<BorrowingRecord, Integer>{
	
	BorrowingRecord findByBookIdAndPatronId(int bookId,int patronId);
}
