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
 * The persistent class for the CLASSCOMMENT database table.
 * 
 * @author John T Day
 */
@Entity
@Table(name = "CLASSCOMMENT")
public class Classcomment implements Serializable {
	private static final long	serialVersionUID	= 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CLASSCOMMENT_ID", unique = true, nullable = false)
	private Integer				id;

	// @Column(name = "ROSTER_ID", nullable = false, updatable = false)
	// private Integer rosterId;

	@Column(name = "CLASSCOMMENT_TX", nullable = false, length = 1024)
	private String				comment;

	@Column(name = "SCORE_INT")
	private Integer				score;

	public Classcomment() {
	}

	@Override
	public String toString() {
		return new ToStringCreator(this).append("id", this.id).append("score", this.score).append("comment", this.comment).toString();
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
	 * @return the comment
	 */
	public String getComment() {
		return this.comment;
	}

	/**
	 * @param comment
	 *            the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * @return the score
	 */
	public Integer getScore() {
		return this.score;
	}

	/**
	 * @param score
	 *            the score to set
	 */
	public void setScore(Integer score) {
		this.score = score;
	}

}