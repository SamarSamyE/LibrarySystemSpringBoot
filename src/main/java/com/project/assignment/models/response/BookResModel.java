package com.project.assignment.models.response;

import java.io.Serializable;

import lombok.Data;

@Data
public class BookResModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8177678754409501046L;
	private int id;
	private String author;
	private String title;
	private String isbn;
	private int publicationYear;

}
