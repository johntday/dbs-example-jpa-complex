package com.dbs.training.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.dbs.training.model.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

	@Query("select p from Person p, Personrole pr, Role r where p.id=pr.personId and r.id=pr.roleId and r.code = ?1")
	List<Person> findByRoleCode(String roleCode);

}
