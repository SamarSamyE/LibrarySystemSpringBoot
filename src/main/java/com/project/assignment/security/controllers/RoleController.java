package com.project.assignment.security.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.assignment.security.models.response.RoleResModel;
import com.project.assignment.security.services.RoleService;

@RestController
@RequestMapping("/api/roles")
public class RoleController {
	@Autowired
	RoleService roleService;
	
	@GetMapping(path ="/{id}")
	public ResponseEntity<RoleResModel> findRoleById(@PathVariable("id") int roleId) {
		return new ResponseEntity<>(roleService.findRoleById(roleId), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<RoleResModel>> findAllRoles() {
		return new ResponseEntity<>(roleService.findAllRoles(), HttpStatus.OK);
	}
	

}
