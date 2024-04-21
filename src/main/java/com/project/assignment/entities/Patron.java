package com.project.assignment.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(uniqueConstraints = @UniqueConstraint(name = "U_Patron_Params",columnNames = {"name", "email", "mobile"}))

public class Patron implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2802918903475695856L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable=false)
	private String name;
	
	@Column(length = 50,nullable=false)
	private String email;
	
	@Column(length = 11,nullable=false)
	private String mobile;

}
