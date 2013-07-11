package com.dbs.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dbs.training.model.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}
