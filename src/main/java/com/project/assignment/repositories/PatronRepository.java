package com.project.assignment.repositories;

import org.springframework.data.repository.CrudRepository;

import com.project.assignment.entities.Patron;

public interface PatronRepository extends CrudRepository<Patron, Integer>{

}
