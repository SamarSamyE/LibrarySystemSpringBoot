package com.project.assignment.utils.exceptions;

import java.util.Map;
import java.util.List;

public class BusinessLogicViolationException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8225223447282998076L;
	private List<Map<String, String>> details;

	public BusinessLogicViolationException(String message) {
		super(message);
	}

	public BusinessLogicViolationException(String message, List<Map<String, String>> details) {
		super(message);
		this.setDetails(details);
	}

	public List<Map<String, String>> getDetails() {
		return details;
	}

	public void setDetails(List<Map<String, String>> details) {
		this.details = details;
	}
}
