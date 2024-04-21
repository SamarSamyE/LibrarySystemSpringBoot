package com.project.assignment.security.entites;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(name = "U_UserCredential_username", columnNames = { "username" }) })
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCredential implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -612787191251599016L;

	@Id
	private long id;

	@Column(nullable = false, length = 50)
	private String username;

	@Column(nullable = false, length = 100)
	private String password;
	
	@ManyToMany
	@JoinTable(name = "ROLE_AUTHORITY", joinColumns = @JoinColumn(name = "USER_ID", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID"))
	private Set<Role> roles;


}