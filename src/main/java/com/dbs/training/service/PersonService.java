package com.dbs.training.service;

import java.util.List;
import java.util.Map;
import com.dbs.training.exception.ObjectNotFound;
import com.dbs.training.model.Person;

public interface PersonService {

	public Person create(Person person);

	public Person delete(int id) throws ObjectNotFound;

	public List<Person> findAll();

	public Person update(Person person) throws ObjectNotFound;

	public Person findById(int id);

	public Map<String, String> getDropDownList();

}
