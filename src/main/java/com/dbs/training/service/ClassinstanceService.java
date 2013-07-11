package com.dbs.training.service;

import java.util.List;
import java.util.Map;
import com.dbs.training.exception.ObjectNotFound;
import com.dbs.training.model.Classinstance;

public interface ClassinstanceService {

	public Classinstance create(Classinstance classinstance);

	public Classinstance delete(int id) throws ObjectNotFound;

	public List<Classinstance> findAll();

	public Classinstance update(Classinstance classinstance) throws ObjectNotFound;

	public Classinstance findById(int id);

	public Map<String, String> getDropDownList();

}
