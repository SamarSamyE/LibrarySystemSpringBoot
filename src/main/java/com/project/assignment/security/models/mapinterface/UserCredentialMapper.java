package com.project.assignment.security.models.mapinterface;

import java.util.List;

import org.mapstruct.Mapper;

import com.project.assignment.security.entites.UserCredential;
import com.project.assignment.security.models.response.CurrentUserResModel;

@Mapper(componentModel = "spring")
public interface UserCredentialMapper {
	CurrentUserResModel mapToCurrentUserResModel(UserCredential user); 
	List<CurrentUserResModel> mapToCurrentUserResModel(Iterable<UserCredential> user); 

}