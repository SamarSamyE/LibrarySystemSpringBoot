package com.project.assignment.security.models.response;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CurrentUserResModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6099158787106385471L;
	private long id;
	private String username;
//	private Set<RoleResModel> roles;
	
	


}