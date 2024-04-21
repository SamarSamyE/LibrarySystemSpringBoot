package com.project.assignment.security.models.response;

import java.io.Serializable;

import lombok.Data;

@Data
public class LoginResModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3076427081846383050L;
	private String accessToken;
	
}