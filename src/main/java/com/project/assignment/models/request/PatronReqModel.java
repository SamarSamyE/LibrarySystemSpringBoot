package com.project.assignment.models.request;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class PatronReqModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8535382673465097552L;
	
	@NotNull
	@Email
	@Size(max = 50)
	@Pattern(regexp = "^$|^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
	private String email;
	@NotNull
	private String name;
	@NotNull
	@Size(max=11)
	@Pattern(regexp = "^$|^01[0-9]{9}$")
	private String mobile;
	

}
