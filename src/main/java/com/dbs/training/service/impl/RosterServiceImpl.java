package com.dbs.training.service.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dbs.training.exception.ObjectNotFound;
import com.dbs.training.model.Classcomment;
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

	@Override
	@Transactional(readOnly = true)
	public Map<String, String> getDropDownList() {
		final String TEMPLATE = "%s %s %s";
		List<Roster> rosterList = rosterRepository.findAll();

		Map<String, String> roster = new LinkedHashMap<String, String>();
		for (Roster c : rosterList) {
			String enrolledOrAttended = (c.isAttendanceIndicator()) ? "attended" : "enrolled";
			roster.put(c.getId().toString(),
					String.format(TEMPLATE, c.getStudent().getUsername(), enrolledOrAttended, c.getClassinstance().getClss().getName()));
		}
		return roster;
	}

	@Override
	@Transactional(rollbackFor = ObjectNotFound.class)
	public Roster addComment(int id, Classcomment classcomment) throws ObjectNotFound {
		Roster roster = rosterRepository.findOne(id);
		roster.addClasscomments(classcomment);
		return rosterRepository.save(roster);
	}

}
