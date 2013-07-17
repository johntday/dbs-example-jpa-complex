package com.dbs.training.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.dbs.training.model.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

	@Query(value = "SELECT P.* FROM PERSON P, PERSONROLE PR, ROLE R WHERE P.PERSON_ID=PR.PERSON_ID AND R.ROLE_ID=PR.ROLE_ID AND R.ROLE_CD=?1 ORDER BY USERNAME", nativeQuery = true)
	// @Query("select p from Person p, Personrole pr, Role r where p.id=pr.personId and r.id=pr.roleId and r.code = ?1")
	List<Person> findByRoleCode(String roleCode);

}
