package com.dbs.training.service.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dbs.training.exception.ObjectNotFound;
import com.dbs.training.model.Clss;
import com.dbs.training.repository.ClssRepository;
import com.dbs.training.service.ClssService;

@Service
public class ClssServiceImpl implements ClssService {

	@Resource
	private ClssRepository	clssRepository;

	@Override
	@Transactional
	public Clss create(Clss clss) {
		Clss createdClss = clss;
		return clssRepository.save(createdClss);
	}

	@Override
	@Transactional
	public Clss findById(int id) {
		return clssRepository.findOne(id);
	}

	@Override
	@Transactional(rollbackFor = ObjectNotFound.class)
	public Clss delete(int id) throws ObjectNotFound {
		Clss deletedClss = clssRepository.findOne(id);

		if (deletedClss == null)
			throw new ObjectNotFound();

		clssRepository.delete(deletedClss);
		return deletedClss;
	}

	@Override
	@Transactional
	public List<Clss> findAll() {
		return clssRepository.findAll();
	}

	@Override
	@Transactional(rollbackFor = ObjectNotFound.class)
	public Clss update(Clss clss) throws ObjectNotFound {
		Clss updatedClss = clssRepository.save(clss);
		return updatedClss;
	}

	@Override
	@Transactional(readOnly = true)
	public Map<String, String> getDropDownList() {
		List<Clss> clssList = clssRepository.findAll();

		Map<String, String> clss = new LinkedHashMap<String, String>();
		for (Clss c : clssList) {
			clss.put(c.getId().toString(), c.getName());
		}
		return clss;
	}

}
