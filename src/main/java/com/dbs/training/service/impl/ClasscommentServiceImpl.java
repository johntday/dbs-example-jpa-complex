package com.dbs.training.service.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dbs.training.exception.ObjectNotFound;
import com.dbs.training.model.Classcomment;
import com.dbs.training.repository.ClasscommentRepository;
import com.dbs.training.service.ClasscommentService;

@Service
public class ClasscommentServiceImpl implements ClasscommentService {

	@Resource
	private ClasscommentRepository	classcommentRepository;

	@Override
	@Transactional
	public Classcomment create(Classcomment classcomment) {
		// see RosterServiceImpl to create Classcomment
		throw new RuntimeException("Method not valid.  see RosterServiceImpl to create Classcomment");
	}

	@Override
	@Transactional
	public Classcomment findById(int id) {
		return classcommentRepository.findOne(id);
	}

	@Override
	@Transactional(rollbackFor = ObjectNotFound.class)
	public Classcomment delete(int id) throws ObjectNotFound {
		Classcomment deletedClasscomment = classcommentRepository.findOne(id);

		if (deletedClasscomment == null)
			throw new ObjectNotFound();

		classcommentRepository.delete(deletedClasscomment);
		return deletedClasscomment;
	}

	@Override
	@Transactional
	public List<Classcomment> findAll() {
		return classcommentRepository.findAll();
	}

	@Override
	@Transactional(rollbackFor = ObjectNotFound.class)
	public Classcomment update(Classcomment classcomment) throws ObjectNotFound {
		Classcomment updatedClasscomment = classcommentRepository.save(classcomment);
		return updatedClasscomment;
	}

	@Override
	@Transactional(readOnly = true)
	public Map<String, String> getDropDownList() {
		List<Classcomment> classcommentList = classcommentRepository.findAll();

		Map<String, String> classcomment = new LinkedHashMap<String, String>();
		for (Classcomment c : classcommentList) {
			classcomment.put(c.getId().toString(), c.getComment().substring(0, 49));
		}
		return classcomment;
	}

}
