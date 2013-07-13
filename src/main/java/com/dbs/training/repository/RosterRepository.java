package com.dbs.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dbs.training.model.Roster;

public interface RosterRepository extends JpaRepository<Roster, Integer> {

}
