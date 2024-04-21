package com.project.assignment.services.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.*;

import com.project.assignment.entities.Book;
import com.project.assignment.models.mapinterface.BookMapper;
import com.project.assignment.models.request.BookReqModel;
import com.project.assignment.models.response.BookResModel;
import com.project.assignment.repositories.BookRepository;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class DefaultBookServiceTests {

    @Mock
    private BookRepository bookRepository;

    @Mock
    private BookMapper bookMapper;

    @InjectMocks
    private DefaultBookService bookService;

    @Test
    public void testCreateBook() {
        BookReqModel bookReqModel = new BookReqModel();
        bookReqModel.setIsbn("1234567890"); // Set a unique ISBN for testing
        when(bookRepository.findByIsbn(anyString())).thenReturn(null);
        when(bookRepository.save(any(Book.class))).thenAnswer(invocation -> {
            Book bookArgument = invocation.getArgument(0);
            bookArgument.setId(1); 
            return bookArgument;
        });
        int bookId = bookService.createBook(bookReqModel);
        assertNotNull(bookId);
        assertEquals(1, bookId); 
    }

    @Test
    public void testUpdateBook() {
        int bookId = 1;
        BookReqModel bookReqModel = new BookReqModel();
        bookReqModel.setIsbn("1234567890");
        when(bookRepository.findByIsbn(anyString())).thenReturn(null); 
        when(bookRepository.findById(bookId)).thenReturn(Optional.of(new Book())); 
        when(bookRepository.save(any(Book.class))).thenAnswer(invocation -> {
            Book updatedBook = invocation.getArgument(0);
            updatedBook.setId(bookId);
            return updatedBook;
        });

        int updatedBookId = bookService.updateBook(bookId, bookReqModel);
        assertNotNull(updatedBookId);
        assertEquals(bookId, updatedBookId); 
    }

    @Test
    public void testGetBookById() {
        int bookId = 1;
        when(bookRepository.findById(bookId)).thenReturn(Optional.of(new Book()));
        when(bookMapper.mapToBookResModel(any(Book.class))).thenReturn(new BookResModel());
        BookResModel bookResModel = bookService.getBookById(bookId);
        assertNotNull(bookResModel);
    }

    @Test
    public void testGetAllBooks() {
        when(bookRepository.findAll()).thenReturn(Collections.singletonList(new Book()));
        when(bookMapper.mapToBookResModel(anyList())).thenReturn(Collections.singletonList(new BookResModel()));
        List<BookResModel> bookResModels = bookService.getAllBooks();
        assertNotNull(bookResModels);
    }

    @Test
    public void testDeleteBookById() {
        int bookId = 1;
        assertDoesNotThrow(() -> bookService.deleteBookById(bookId));
        verify(bookRepository, times(1)).deleteById(bookId);
    }
}