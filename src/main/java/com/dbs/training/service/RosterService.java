package com.dbs.training.service;

import java.util.List;
import com.dbs.training.exception.ObjectNotFound;
import com.dbs.training.model.Roster;

public interface RosterService {

	public Roster create(Roster roster);

	public Roster delete(int id) throws ObjectNotFound;

	public List<Roster> findAll();

	public Roster update(Roster roster) throws ObjectNotFound;

	public Roster findById(int id);

}
