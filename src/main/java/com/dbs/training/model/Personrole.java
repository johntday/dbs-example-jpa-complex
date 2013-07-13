package com.dbs.training.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import org.springframework.core.style.ToStringCreator;
import com.dbs.training.model.Personrole.PersonrolePK;

/**
 * The persistent class for the PERSONROLE database table.
 * 
 * @author John T Day
 * 
 */
@IdClass(PersonrolePK.class)
@Entity
// @Table(name = "PERSONROLE", uniqueConstraints = {
// @UniqueConstraint(columnNames = { "PERSON_ID", "ROLE_ID" }) })
@Table(name = "PERSONROLE")
public class Personrole implements Serializable {
	private static final long	serialVersionUID	= 1L;

	// @GeneratedValue(strategy = GenerationType.AUTO)
	// @Column(name = "PERSONROLE_ID", unique = true, nullable = false)
	// private Integer id;

	@Id
	@Column(name = "PERSON_ID", nullable = false)
	private Integer				personId;

	@Id
	@Column(name = "ROLE_ID", nullable = false)
	private Integer				roleId;

	@Override
	public String toString() {
		return new ToStringCreator(this).append("personId", this.personId).append("roleId", roleId).toString();
	}

	public Personrole() {
	}

	/**
	 * @return the personId
	 */
	public Integer getPersonId() {
		return this.personId;
	}

	/**
	 * @param personId
	 *            the personId to set
	 */
	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

	/**
	 * @return the roleId
	 */
	public Integer getRoleId() {
		return this.roleId;
	}

	/**
	 * @param roleId
	 *            the roleId to set
	 */
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	/**
	 * Primary Key.
	 * 
	 * @author John T Day
	 * 
	 */
	public class PersonrolePK implements Serializable {
		private Integer	personId;
		private Integer	roleId;

		public PersonrolePK() {
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == this)
				return true;
			if (obj == null)
				return false;
			if (!(obj instanceof PersonrolePK))
				return false;
			PersonrolePK pk = (PersonrolePK) obj;
			return pk.personId == personId && pk.personId == personId;
		}

		/**
		 * @return the personId
		 */
		public Integer getPersonId() {
			return this.personId;
		}

		/**
		 * @param personId
		 *            the personId to set
		 */
		public void setPersonId(Integer personId) {
			this.personId = personId;
		}

		/**
		 * @return the roleId
		 */
		public Integer getRoleId() {
			return this.roleId;
		}

		/**
		 * @param roleId
		 *            the roleId to set
		 */
		public void setRoleId(Integer roleId) {
			this.roleId = roleId;
		}

	}
}