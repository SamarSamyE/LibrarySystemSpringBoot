package com.project.assignment;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.project.assignment.security.entites.Role;
import com.project.assignment.security.entites.UserCredential;
import com.project.assignment.security.services.RoleService;
import com.project.assignment.security.services.UserCredentialService;

@Component
public class StartUpApplication implements CommandLineRunner {

	@Autowired
	RoleService roleService;
	@Autowired
	UserCredentialService userCredentialService;
	
	@Override
	public void run(String... args) throws Exception {
		if(roleService.findAllRoles().isEmpty()) {
			roleService.createRole(new Role(1,"admin"));
			roleService.createRole(new Role(2,"employee"));
		}
		
		
		
		if(userCredentialService.findAllUsers().isEmpty()) {
			Set<Role> adminRoles=new HashSet<>();
			adminRoles.add(roleService.findRoleByName("admin"));
			adminRoles.add(roleService.findRoleByName("employee"));
			Set<Role> empRoles=new HashSet<>();
			empRoles.add(roleService.findRoleByName("employee"));
			userCredentialService.createUser(new UserCredential(1,"admin","123456",adminRoles));
			userCredentialService.createUser(new UserCredential(2,"employee","123456",empRoles));
		}
		
	}

}
