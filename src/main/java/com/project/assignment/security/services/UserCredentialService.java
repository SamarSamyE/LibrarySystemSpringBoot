package com.project.assignment.security.services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.project.assignment.security.entites.UserCredential;
import com.project.assignment.security.models.response.CurrentUserResModel;

public interface UserCredentialService extends UserDetailsService {

	CurrentUserResModel getUserById(long id);
	CurrentUserResModel getUserByUserName(String userName);
	UserCredential createUser(UserCredential userCredential);
	List<CurrentUserResModel> findAllUsers();

}