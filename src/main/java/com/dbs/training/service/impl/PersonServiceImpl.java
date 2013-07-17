package com.dbs.training.service.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dbs.training.exception.ObjectNotFound;
import com.dbs.training.model.Person;
import com.dbs.training.model.Role;
import com.dbs.training.repository.PersonRepository;
import com.dbs.training.service.PersonService;

/**
 * This implementation of the PersonService interface communicates with the
 * database by using a Spring Data JPA repository.
 * 
 * @author John T Day
 */
@Service
public class PersonServiceImpl implements PersonService {
	private static final Logger	logger	= Logger.getLogger(PersonServiceImpl.class);

	@Resource
	private PersonRepository	personRepository;

	@Override
	@Transactional
	public Person create(Person person) {
		logger.debug("create: person=" + person);
		Set<Role> roles = person.getRoles();
		person.setRoles(null);
		Person createdPerson = personRepository.save(person);

		createdPerson.setRoles(roles);
		return personRepository.save(createdPerson);
	}

	@Override
	@Transactional(readOnly = true)
	public Person findById(int id) {
		logger.debug("findById: id=" + id);
		return personRepository.findOne(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Person findByIdFull(int id) {
		logger.debug("findByIdFull: id=" + id);
		Person person = personRepository.findOne(id);
		Set<Role> roles = person.getRoles();
		logger.debug("findByIdFull: roles=" + roles);
		return person;
	}

	@Override
	@Transactional(rollbackFor = ObjectNotFound.class)
	public Person delete(int id) throws ObjectNotFound {
		logger.debug("delete: id=" + id);
		Person deletedPerson = personRepository.findOne(id);

		if (deletedPerson == null) {
			logger.debug("delete: No person found with id=" + id);
			throw new ObjectNotFound();
		}

		personRepository.delete(deletedPerson);
		return deletedPerson;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Person> findAll() {
		logger.debug("findAll: ");
		return personRepository.findAll();
	}

	@Override
	@Transactional(rollbackFor = ObjectNotFound.class)
	public Person update(Person person) throws ObjectNotFound {
		logger.debug("update: person=" + person);

		Person updatedPerson = personRepository.findOne(person.getId());

		if (updatedPerson == null) {
			logger.debug("update: No person found with id=" + person.getId());
			throw new ObjectNotFound();
		}

		// do merge... BeanUtils.copyProperties(person, updatedPerson);
		// Person updatedPerson = personRepository.save(person);
		return personRepository.save(person);
	}

	@Override
	@Transactional(readOnly = true)
	public Map<String, String> getDropDownList() {
		logger.debug("getDropDownList: ");
		List<Person> personList = personRepository.findAll();

		Map<String, String> person = new LinkedHashMap<String, String>();
		for (Person c : personList) {
			person.put(c.getId().toString(), c.getUsername());
		}
		return person;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Person> findByRoleCode(String roleCode) {
		logger.debug("findByRoleCode: roleCode=" + roleCode);
		List<Person> personList = personRepository.findByRoleCode(roleCode);
		return personList;
	}

	@Override
	@Transactional(readOnly = true)
	public Map<String, String> findByRoleCodeDropDown(String roleCode) {
		logger.debug("findByRoleCodeDropDown: roleCode=" + roleCode);
		List<Person> personList = personRepository.findByRoleCode(roleCode);

		Map<String, String> person = new LinkedHashMap<String, String>();
		for (Person c : personList) {
			person.put(c.getId().toString(), c.getUsername());
		}
		return person;
	}

}
