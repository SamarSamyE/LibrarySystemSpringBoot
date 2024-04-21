package com.project.assignment.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.assignment.security.entites.UserCredential;

public interface UserRepository extends JpaRepository<UserCredential, Long> {
	
	@org.springframework.data.jpa.repository.EntityGraph(attributePaths = "roles")
    UserCredential findByUsername(String username);
}
