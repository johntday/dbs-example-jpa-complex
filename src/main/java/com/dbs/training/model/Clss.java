package com.dbs.training.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.core.style.ToStringCreator;

/**
 * Class JPA entity.
 * 
 * @author John T Day
 */
@Entity
@Table(name = "CLASS")
public class Clss implements Serializable {
	private static final long	serialVersionUID	= 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CLASS_ID", unique = true, nullable = false, updatable = true, insertable = true)
	private Integer				id;

	@Column(name = "CLASS_CD", unique = true, nullable = false, length = 45, updatable = true, insertable = true)
	private String				code;

	@Column(name = "CLASS_DESC", length = 512, updatable = true, insertable = true)
	private String				description;

	@Column(name = "CLASS_NM", nullable = false, length = 45, updatable = true, insertable = true)
	private String				name;

	// uni-directional many-to-one association to Course
	@ManyToOne
	@JoinColumn(name = "COURSE_ID", nullable = false, updatable = true, insertable = true)
	private Course				course;

	@Override
	public String toString() {
		return new ToStringCreator(this).append("id", this.id).append("code", this.code).append("name", this.name).append("description", this.description)
				.append("course", course).toString();
	}

	public Clss() {
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

	/**
	 * @return the description
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
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
	 * @return the course
	 */
	public Course getCourse() {
		return this.course;
	}

	/**
	 * @param course
	 *            the course to set
	 */
	public void setCourse(Course course) {
		this.course = course;
	}

}
