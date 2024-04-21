package com.project.assignment.services;

public interface BorrowingRecordService {
	
	int borrowABook (int bookId,int patronId);
	int returnABook (int bookId,int patronId);

}
