package com.project.assignment.security.models.response;

import java.io.Serializable;

import lombok.Data;

@Data
public class RoleResModel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -682731049675463956L;
	private long id;
	private String name;
	

}
