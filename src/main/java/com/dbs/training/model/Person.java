package com.dbs.training.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.core.style.ToStringCreator;

/**
 * The persistent class for the person database table.
 * 
 * @author John T Day
 */
@Entity
@Table(name = "PERSON")
public class Person implements Serializable {
	private static final long	serialVersionUID	= 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Integer				id;

	@Column(name = "ACTIVE_IND", nullable = false)
	private int					activeIndicator;

	@Column(unique = true, nullable = false, length = 128)
	private String				email;

	@Column(nullable = false, length = 45)
	private String				firstname;

	@Column(nullable = false, length = 45)
	private String				lastname;

	@Column(nullable = false, length = 45)
	private String				password;

	@Column(name = "PHONE_SMS", precision = 10)
	private BigDecimal			phoneSms;

	@Column(unique = true, nullable = false, length = 45)
	private String				username;

	@Override
	public String toString() {
		return new ToStringCreator(this).append("id", this.id).append("username", this.username).append("password", this.password)
				.append("firstname", this.firstname).append("email", email).append("phoneSms", phoneSms).append("activeIndicator", activeIndicator).toString();
	}

	public Person() {
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
	 * @return the activeIndicator
	 */
	public int getActiveIndicator() {
		return this.activeIndicator;
	}

	/**
	 * @param activeIndicator
	 *            the activeIndicator to set
	 */
	public void setActiveIndicator(int activeIndicator) {
		this.activeIndicator = activeIndicator;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return this.firstname;
	}

	/**
	 * @param firstname
	 *            the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return this.lastname;
	}

	/**
	 * @param lastname
	 *            the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the phoneSms
	 */
	public BigDecimal getPhoneSms() {
		return this.phoneSms;
	}

	/**
	 * @param phoneSms
	 *            the phoneSms to set
	 */
	public void setPhoneSms(BigDecimal phoneSms) {
		this.phoneSms = phoneSms;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return this.username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

}