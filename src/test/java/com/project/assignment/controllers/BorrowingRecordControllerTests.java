package com.project.assignment.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.project.assignment.services.BorrowingRecordService;

@ExtendWith(MockitoExtension.class)
public class BorrowingRecordControllerTests {

    @Mock
    private BorrowingRecordService borrowingRecordService;

    @InjectMocks
    private BorrowingRecordController borrowingRecordController;

    @Test
    public void testBorrowABook() {
        when(borrowingRecordService.borrowABook(anyInt(), anyInt())).thenReturn(1);
        ResponseEntity<Integer> response = borrowingRecordController.borrowABook(1,1);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody());
    }

    @Test
    public void testReturnABook() {
        when(borrowingRecordService.returnABook(anyInt(), anyInt())).thenReturn(1);
        ResponseEntity<Integer> response = borrowingRecordController.returnABook(1,1);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody());
    }
}