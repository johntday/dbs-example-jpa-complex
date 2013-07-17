package com.dbs.training.service;

import java.util.List;
import java.util.Map;
import com.dbs.training.model.Person;

public interface PersonService extends CrudService<Person> {

	List<Person> findByRoleCode(String roleCode);

	Map<String, String> findByRoleCodeDropDown(String roleCode);

	public Person findByIdFull(int id);
}
