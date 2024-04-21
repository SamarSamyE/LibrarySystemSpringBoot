package com.project.assignment.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.*;

import com.project.assignment.models.request.BookReqModel;
import com.project.assignment.models.response.BookResModel;
import com.project.assignment.services.BookService;

@ExtendWith(MockitoExtension.class)
public class BookControllerTests {

    @Mock
    private BookService bookService;

    @InjectMocks
    private BookController bookController;

    @Test
    public void testCreateBook() {
        when(bookService.createBook(any(BookReqModel.class))).thenReturn(1);
        ResponseEntity<Integer> response = bookController.createBook(new BookReqModel());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody());
    }

    @Test
    public void testUpdateBook() {
        when(bookService.updateBook(anyInt(), any(BookReqModel.class))).thenReturn(1);
        ResponseEntity<Integer> response = bookController.updateBook(1, new BookReqModel());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody());
    }

    @Test
    public void testGetBookById() {
        when(bookService.getBookById(anyInt())).thenReturn(new BookResModel());
        ResponseEntity<BookResModel> response = bookController.getBookById(1);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(new BookResModel(), response.getBody());
    }

    @Test
    public void testGetAllBooks() {
         when(bookService.getAllBooks()).thenReturn(List.of(new BookResModel(), new BookResModel()));
        ResponseEntity<List<BookResModel>> response = bookController.getAllBooks();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(2, response.getBody().size());
    }

    @Test
    public void testDeleteBookById() {
        ResponseEntity<Void> response = bookController.deleteBookById(1);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}