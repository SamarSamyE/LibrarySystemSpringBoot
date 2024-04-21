package com.project.assignment.models.response;

import java.io.Serializable;
import lombok.Data;

@Data
public class PatronResModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4196968793221651075L;
	private int id;
	private String name;
	private String email;
	private String mobile;

}
