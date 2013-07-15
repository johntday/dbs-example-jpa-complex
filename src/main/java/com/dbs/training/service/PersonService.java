package com.dbs.training.service;

import java.util.Map;
import com.dbs.training.model.Person;

public interface PersonService extends CrudService<Person> {

	public Map<String, String> getDropDownList();

}
