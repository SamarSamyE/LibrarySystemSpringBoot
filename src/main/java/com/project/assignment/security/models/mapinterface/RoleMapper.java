package com.project.assignment.security.models.mapinterface;

import java.util.List;

import org.mapstruct.Mapper;

import com.project.assignment.security.entites.Role;
import com.project.assignment.security.models.response.RoleResModel;

@Mapper(componentModel = "spring")
public interface RoleMapper {
	RoleResModel mapToRoleResModel(Role role); 
	List<RoleResModel> mapToRoleResModel(Iterable<Role> roles); 

}