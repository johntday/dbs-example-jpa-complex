package com.dbs.training.service.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dbs.training.exception.ObjectNotFound;
import com.dbs.training.model.Classinstance;
import com.dbs.training.repository.ClassinstanceRepository;
import com.dbs.training.service.ClassinstanceService;

@Service
public class ClassinstanceServiceImpl implements ClassinstanceService {

	@Resource
	private ClassinstanceRepository	classinstanceRepository;

	@Override
	@Transactional
	public Classinstance create(Classinstance classinstance) {
		Classinstance createdClassinstance = classinstance;
		return classinstanceRepository.save(createdClassinstance);
	}

	@Override
	@Transactional
	public Classinstance findById(int id) {
		return classinstanceRepository.findOne(id);
	}

	@Override
	@Transactional(rollbackFor = ObjectNotFound.class)
	public Classinstance delete(int id) throws ObjectNotFound {
		Classinstance deletedClassinstance = classinstanceRepository.findOne(id);

		if (deletedClassinstance == null)
			throw new ObjectNotFound();

		classinstanceRepository.delete(deletedClassinstance);
		return deletedClassinstance;
	}

	@Override
	@Transactional
	public List<Classinstance> findAll() {
		return classinstanceRepository.findAll();
	}

	@Override
	@Transactional(rollbackFor = ObjectNotFound.class)
	public Classinstance update(Classinstance classinstance) throws ObjectNotFound {
		Classinstance updatedClassinstance = classinstanceRepository.save(classinstance);
		return updatedClassinstance;
	}

	@Override
	@Transactional(readOnly = true)
	public Map<String, String> getDropDownList() {
		final String TEMPLATE = "%s on %s (%d minutes), instructor %s";
		List<Classinstance> classinstanceList = classinstanceRepository.findAll();

		Map<String, String> classinstance = new LinkedHashMap<String, String>();
		for (Classinstance c : classinstanceList) {
			classinstance.put(c.getId().toString(),
					String.format(TEMPLATE, c.getClss().getName(), c.getDateTime(), c.getDurationMinutes(), c.getInstructor().getUsername()));
		}
		return classinstance;
	}

}
