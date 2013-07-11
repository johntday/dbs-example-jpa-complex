package com.dbs.training.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.core.style.ToStringCreator;

/**
 * The persistent class for the ROLE database table.
 * 
 * @author John T Day
 * 
 */
@Entity
@Table(name = "ROLE")
public class Role implements Serializable {
	private static final long	serialVersionUID	= 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ROLE_ID", unique = true, nullable = false)
	private Integer				id;

	@Column(name = "ROLE_NM", nullable = false, length = 128)
	private String				name;

	@Column(name = "ROLE_CD", nullable = false, length = 45)
	private String				code;

	@Override
	public String toString() {
		return new ToStringCreator(this).append("id", this.id).append("code", this.code).append("name", name).toString();
	}

	public Role() {
	}

}