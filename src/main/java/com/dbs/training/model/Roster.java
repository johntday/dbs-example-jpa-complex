package com.dbs.training.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the ROSTER database table.
 * 
 * @author John T Day
 * 
 */
@Entity
@Table(name = "ROSTER")
public class Roster implements Serializable {
	private static final long	serialVersionUID	= 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ROSTER_ID", unique = true, nullable = false)
	private Integer				id;

	@Column(name = "ATTEND_IND", nullable = false)
	private boolean				attendanceIndicator;

	// uni-directional one-to-many association to Classcomment
	@OneToMany(mappedBy = "ROSTER", fetch = FetchType.EAGER)
	private List<Classcomment>	classcomments;

	// uni-directional many-to-one association to Classinstance
	@ManyToOne
	@JoinColumn(name = "CLASSINSTANCE_ID", nullable = false)
	private Classinstance		classinstance;

	// uni-directional many-to-one association to Person
	@ManyToOne
	@JoinColumn(name = "PERSON_ID", nullable = false)
	private Person				student;

	public Roster() {
	}

	public List<Classcomment> getClasscomments() {
		return this.classcomments;
	}

	public void setClasscomments(List<Classcomment> classcomments) {
		this.classcomments = classcomments;
	}

	public Classcomment addClasscomments(Classcomment classcomments) {
		getClasscomments().add(classcomments);
		return classcomments;
	}

	public Classcomment removeClasscomments(Classcomment classcomments) {
		getClasscomments().remove(classcomments);
		return classcomments;
	}

	public Classinstance getClassinstance() {
		return this.classinstance;
	}

	public void setClassinstance(Classinstance classinstance) {
		this.classinstance = classinstance;
	}

	/**
	 * @return the student
	 */
	public Person getStudent() {
		return this.student;
	}

	/**
	 * @param student
	 *            the student to set
	 */
	public void setStudent(Person student) {
		this.student = student;
	}

	/**
	 * @return the attendanceIndicator
	 */
	public boolean isAttendanceIndicator() {
		return this.attendanceIndicator;
	}

	/**
	 * @param attendanceIndicator
	 *            the attendanceIndicator to set
	 */
	public void setAttendanceIndicator(boolean attendanceIndicator) {
		this.attendanceIndicator = attendanceIndicator;
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

}