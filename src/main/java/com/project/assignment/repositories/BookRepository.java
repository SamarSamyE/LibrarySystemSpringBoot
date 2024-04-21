package com.project.assignment.repositories;

import org.springframework.data.repository.CrudRepository;

import com.project.assignment.entities.Book;


public interface BookRepository extends CrudRepository<Book, Integer>{
    Book findByIsbn(String isbn);
}
