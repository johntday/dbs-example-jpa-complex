package com.dbs.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dbs.training.model.Roster;

public interface RosterRepository extends JpaRepository<Roster, Integer> {

	// @Query("select r from RosterT r where r. = ?1")
	// User findByEmailAddress(String emailAddress);

}
