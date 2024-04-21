package com.project.assignment.models.mapinterface;

import java.util.List;

import org.mapstruct.Mapper;

import com.project.assignment.entities.Book;
import com.project.assignment.models.response.BookResModel;


@Mapper(componentModel = "spring")
public interface BookMapper {
	BookResModel mapToBookResModel(Book book); 
	List<BookResModel> mapToBookResModel(Iterable<Book> books); 

}