package com.project.assignment.security.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.assignment.security.entites.Role;
import com.project.assignment.security.models.mapinterface.RoleMapper;
import com.project.assignment.security.models.response.RoleResModel;
import com.project.assignment.security.repositories.RoleRepository;
import com.project.assignment.security.services.RoleService;

@Service
public class DefaultRoleService implements RoleService{

	@Autowired
	RoleMapper roleMapper;
	@Autowired
	RoleRepository roleRepository;
	@Override
	public List<RoleResModel> findAllRoles() {
		return  roleMapper.mapToRoleResModel(roleRepository.findAll());
	}

	@Override
	public RoleResModel findRoleById(long roleId) {
		Role role=roleRepository.findById(roleId).get();
		return roleMapper.mapToRoleResModel(role);
	}

	@Override
	public Role createRole(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public Role findRoleByName(String name) {
		Role role=roleRepository.findByName(name);
		return role;
	}

}
