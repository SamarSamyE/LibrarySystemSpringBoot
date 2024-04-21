package com.project.assignment.security.entites;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 3452955178774260598L;

	@Id
	private long id;

	@Column
	private String name;
	

}
