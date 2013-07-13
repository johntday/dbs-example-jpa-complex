package com.dbs.training.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dbs.training.exception.ObjectNotFound;
import com.dbs.training.model.Roster;
import com.dbs.training.repository.RosterRepository;
import com.dbs.training.service.RosterService;

@Service
public class RosterServiceImpl implements RosterService {

	@Resource
	private RosterRepository	rosterRepository;

	@Override
	@Transactional
	public Roster create(Roster roster) {
		Roster createdRoster = roster;
		return rosterRepository.save(createdRoster);
	}

	@Override
	@Transactional
	public Roster findById(int id) {
		return rosterRepository.findOne(id);
	}

	@Override
	@Transactional(rollbackFor = ObjectNotFound.class)
	public Roster delete(int id) throws ObjectNotFound {
		Roster deletedRoster = rosterRepository.findOne(id);

		if (deletedRoster == null)
			throw new ObjectNotFound();

		rosterRepository.delete(deletedRoster);
		return deletedRoster;
	}

	@Override
	@Transactional
	public List<Roster> findAll() {
		return rosterRepository.findAll();
	}

	@Override
	@Transactional(rollbackFor = ObjectNotFound.class)
	public Roster update(Roster roster) throws ObjectNotFound {
		Roster updatedRoster = rosterRepository.save(roster);
		return updatedRoster;
	}

}
