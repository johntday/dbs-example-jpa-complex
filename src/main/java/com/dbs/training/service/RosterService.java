package com.dbs.training.service;

import com.dbs.training.exception.ObjectNotFound;
import com.dbs.training.model.Classcomment;
import com.dbs.training.model.Roster;

public interface RosterService extends CrudService<Roster> {

	public Roster addComment(int id, Classcomment classcomment) throws ObjectNotFound;

}