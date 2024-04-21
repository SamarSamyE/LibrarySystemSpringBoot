package com.project.assignment.security.models.request;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class UserReqModel {

	@NotBlank
	private String username;

	@NotBlank
	private String password;
}