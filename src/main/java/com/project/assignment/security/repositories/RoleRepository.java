package com.project.assignment.security.repositories;

import org.springframework.data.repository.CrudRepository;

import com.project.assignment.security.entites.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
	Role findByName(String name);
}
