package com.project.assignment.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Book implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6974749556240452936L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 250,nullable=false)
	private String author;
	
	@Column(length = 250,nullable=false)
	private String title;
	
	@Column(length = 13,unique = true,nullable=false)
	private String isbn;
	
	@Column(nullable=false)
	private int publicationYear;
	

}