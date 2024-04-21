package com.project.assignment.models.request;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class BookReqModel  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3433263391929030149L;
	@NotNull
	private String author;
	@NotNull
	private String title;
	@Size(max = 13)
	private String isbn;
	@Min(1)
	private int publicationYear;

}
