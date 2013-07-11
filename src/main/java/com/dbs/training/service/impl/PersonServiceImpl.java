package com.dbs.training.service.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dbs.training.exception.ObjectNotFound;
import com.dbs.training.model.Person;
import com.dbs.training.repository.PersonRepository;
import com.dbs.training.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

	@Resource
	private PersonRepository	personRepository;

	@Override
	@Transactional
	public Person create(Person person) {
		Person createdPerson = person;
		return personRepository.save(createdPerson);
	}

	@Override
	@Transactional
	public Person findById(int id) {
		return personRepository.findOne(id);
	}

	@Override
	@Transactional(rollbackFor = ObjectNotFound.class)
	public Person delete(int id) throws ObjectNotFound {
		Person deletedPerson = personRepository.findOne(id);

		if (deletedPerson == null)
			throw new ObjectNotFound();

		personRepository.delete(deletedPerson);
		return deletedPerson;
	}

	@Override
	@Transactional
	public List<Person> findAll() {
		return personRepository.findAll();
	}

	@Override
	@Transactional(rollbackFor = ObjectNotFound.class)
	public Person update(Person person) throws ObjectNotFound {
		Person updatedPerson = personRepository.findOne(person.getId());

		if (updatedPerson == null)
			throw new ObjectNotFound();
		BeanUtils.copyProperties(person, updatedPerson);
		return updatedPerson;
	}

	@Override
	@Transactional(readOnly = true)
	public Map<String, String> getDropDownList() {
		List<Person> personList = personRepository.findAll();

		Map<String, String> person = new LinkedHashMap<String, String>();
		for (Person c : personList) {
			person.put(c.getId().toString(), c.getUsername());
		}
		return person;
	}

}
