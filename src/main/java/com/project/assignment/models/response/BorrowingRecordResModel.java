package com.project.assignment.models.response;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class BorrowingRecordResModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5603377093921057655L;
	private String comment;
	private int rating;
	private LocalDateTime reviewDate;
	private BookResModel story;

}
