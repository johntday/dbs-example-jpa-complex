package com.dbs.training.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.core.style.ToStringCreator;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * The persistent class for the CLASSINSTANCE database table.
 * 
 * @author John T Day
 */
@Entity
@Table(name = "CLASSINSTANCE")
public class Classinstance implements Serializable {
	private static final long	serialVersionUID	= 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CLASSINSTANCE_ID", unique = true, nullable = false)
	private Integer				id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CLASSINSTANCE_DT", nullable = false)
	@DateTimeFormat(style = "SS")
	private Date				dateTime;

	@Column(name = "CLASSINSTANCE_MINS", nullable = false)
	private int					durationMinutes;

	@Column(name = "CLASSINSTANCE_NOTE", length = 512)
	private String				note;

	// uni-directional many-to-one association to Class
	@ManyToOne
	@JoinColumn(name = "CLASS_ID", nullable = false)
	private Clss				clss;

	// uni-directional many-to-one association to Person
	@ManyToOne
	@JoinColumn(name = "INSTRUCTOR_ID", nullable = false)
	private Person				instructor;

	// uni-directional many-to-one association to Room
	@ManyToOne
	@JoinColumn(name = "ROOM_ID", nullable = false)
	private Room				room;

	/* 1-to-many ROSTER is not included here */

	@Override
	public String toString() {
		return new ToStringCreator(this).append("id", this.id).append("dateTime", this.dateTime).append("durationMinutes", this.durationMinutes)
				.append("note", this.note).append("clss", clss).append("instructor", instructor).append("room", room).toString();
	}

	public Classinstance() {
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
	 * @return the dateTime
	 */
	public Date getDateTime() {
		return this.dateTime;
	}

	/**
	 * @param dateTime
	 *            the dateTime to set
	 */
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	/**
	 * @return the durationMinutes
	 */
	public int getDurationMinutes() {
		return this.durationMinutes;
	}

	/**
	 * @param durationMinutes
	 *            the durationMinutes to set
	 */
	public void setDurationMinutes(int durationMinutes) {
		this.durationMinutes = durationMinutes;
	}

	/**
	 * @return the note
	 */
	public String getNote() {
		return this.note;
	}

	/**
	 * @param note
	 *            the note to set
	 */
	public void setNote(String note) {
		this.note = note;
	}

	/**
	 * @return the clss
	 */
	public Clss getClss() {
		return this.clss;
	}

	/**
	 * @param clss
	 *            the clss to set
	 */
	public void setClss(Clss clss) {
		this.clss = clss;
	}

	/**
	 * @return the instructor
	 */
	public Person getInstructor() {
		return this.instructor;
	}

	/**
	 * @param instructor
	 *            the instructor to set
	 */
	public void setInstructor(Person instructor) {
		this.instructor = instructor;
	}

	/**
	 * @return the room
	 */
	public Room getRoom() {
		return this.room;
	}

	/**
	 * @param room
	 *            the room to set
	 */
	public void setRoom(Room room) {
		this.room = room;
	}

}