package com.project.assignment.models.mapinterface;

import java.util.List;

import org.mapstruct.Mapper;

import com.project.assignment.entities.Patron;
import com.project.assignment.models.response.PatronResModel;



@Mapper(componentModel = "spring")
public interface PatronMapper {
	PatronResModel mapToPatronResModel(Patron patron); 
	List<PatronResModel> mapToPatronResModel(Iterable<Patron> patron); 
}
