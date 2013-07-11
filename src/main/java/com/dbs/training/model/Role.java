package com.dbs.training.model;

import java.io.Serializable;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.core.style.ToStringCreator;

/**
 * The persistent class for the ROLE database table. IMMUTABLE.
 * 
 * @author John T Day
 * 
 */
@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "ROLE")
public class Role implements Serializable {
	private static final long	serialVersionUID	= 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ROLE_ID", unique = true, nullable = false, updatable = false, insertable = false)
	private Integer				id;

	@Column(name = "ROLE_NM", nullable = false, length = 128, updatable = false, insertable = false)
	private String				name;

	@Column(name = "ROLE_CD", nullable = false, length = 45, updatable = false, insertable = false)
	private String				code;

	@Override
	public String toString() {
		return new ToStringCreator(this).append("id", this.id).append("code", this.code).append("name", name).toString();
	}

	public Role() {
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return this.code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

}