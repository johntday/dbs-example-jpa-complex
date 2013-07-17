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
import javax.persistence.OrderBy;
import javax.persistence.Table;
import org.springframework.core.style.ToStringCreator;

/**
 * The persistent class for the ROSTER database table.
 * 
 * @author John T Day
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
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "ROSTER_ID")
	@OrderBy("CLASSCOMMENT_ID asc")
	private List<Classcomment>	comments;

	// uni-directional many-to-one association to Classinstance
	@ManyToOne
	@JoinColumn(name = "CLASSINSTANCE_ID", nullable = false)
	private Classinstance		classinstance;

	// uni-directional many-to-one association to Person
	@ManyToOne
	@JoinColumn(name = "PERSON_ID", nullable = false)
	private Person				student;

	@Override
	public String toString() {
		return new ToStringCreator(this).append("id", this.id).append("attendanceIndicator", this.attendanceIndicator).append("comments", this.comments)
				.append("classinstance", this.classinstance).append("student", student).toString();
	}

	public Roster() {
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
	 * @return the comments
	 */
	public List<Classcomment> getComments() {
		return this.comments;
	}

	/**
	 * @param comments
	 *            the comments to set
	 */
	public void setComments(List<Classcomment> comments) {
		this.comments = comments;
	}

	/**
	 * @return the classinstance
	 */
	public Classinstance getClassinstance() {
		return this.classinstance;
	}

	/**
	 * @param classinstance
	 *            the classinstance to set
	 */
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

	public Classcomment addClasscomments(Classcomment classcomments) {
		getComments().add(classcomments);
		return classcomments;
	}

	public Classcomment removeClasscomments(Classcomment classcomments) {
		getComments().remove(classcomments);
		return classcomments;
	}

}