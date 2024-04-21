package com.project.assignment.services.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.assignment.entities.Book;
import com.project.assignment.entities.BorrowingRecord;
import com.project.assignment.entities.Patron;
import com.project.assignment.models.request.BookReqModel;
import com.project.assignment.repositories.BookRepository;
import com.project.assignment.repositories.BorrowingRecordRepositroy;
import com.project.assignment.repositories.PatronRepository;
import com.project.assignment.services.BorrowingRecordService;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class DefaultBorrowingRecordServiceTests {

	@Mock
    private BorrowingRecordRepositroy borrowingRecordRepository;

    @Mock
    private BookRepository bookRepository;

    @Mock
    private PatronRepository patronRepository;

    @InjectMocks
    private DefaultBorrowingRecordService borrowingRecordService;

    @Test
    public void testBorrowABook() {
        int bookId = 1;
        int patronId = 2;
        Book book = new Book();
        Patron patron = new Patron();

        when(bookRepository.findById(bookId)).thenReturn(Optional.of(book));
        when(patronRepository.findById(patronId)).thenReturn(Optional.of(patron));
        when(borrowingRecordRepository.save(any(BorrowingRecord.class))).thenReturn(new BorrowingRecord());
        int borrowingRecordId = borrowingRecordService.borrowABook(bookId, patronId);
        verify(bookRepository).findById(bookId);
        verify(patronRepository).findById(patronId);
        verify(borrowingRecordRepository).save(any(BorrowingRecord.class));
        assertEquals(borrowingRecordId, 0); // Assuming id is 0 for new record
    }

    @Test
    public void testReturnABook() {
        int bookId = 1;
        int patronId = 1;
        BorrowingRecord borrowedRecord = new BorrowingRecord();
        borrowedRecord.setId(1);
        when(borrowingRecordRepository.findByBookIdAndPatronId(bookId, patronId)).thenReturn(borrowedRecord);
        when(borrowingRecordRepository.save(borrowedRecord)).thenReturn(borrowedRecord);
        int borrowingRecordId = borrowingRecordService.returnABook(bookId, patronId);
        verify(borrowingRecordRepository).findByBookIdAndPatronId(bookId, patronId);
        verify(borrowingRecordRepository).save(borrowedRecord);
        assertEquals(1, borrowingRecordId); 
    }
}
