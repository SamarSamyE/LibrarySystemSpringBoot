package com.project.assignment.security.services;

import java.util.List;

import com.project.assignment.security.entites.Role;
import com.project.assignment.security.models.response.RoleResModel;

public interface RoleService {
	List<RoleResModel> findAllRoles();
	RoleResModel findRoleById(long roleId);
	Role createRole (Role role);
	Role findRoleByName (String name);
}
